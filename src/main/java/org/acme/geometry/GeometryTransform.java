package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * Transformation sur une géométrie
 * 
 * Remarque : on renverra systématiquement une copie
 * 
 * @author formation
 *
 */
public class GeometryTransform implements GeometryVisitor<Geometry>{
	
	private MathTransform mathTransform ;
	
	public GeometryTransform(MathTransform mathTransform) {
		this.mathTransform = mathTransform;
	}
	
	/**
	 * Facade pour simplifier la transformation d'une géométrie
	 * @param transform
	 * @param geometry
	 * @return
	 */
	public static Geometry transform(
		MathTransform transform, 
		Geometry geometry
	) {
		return geometry.accept(new GeometryTransform(transform));
	}

	@Override
	public Point visit(Point point) {
		return new Point(mathTransform.transform(
			point.getCoordinate()
		));
	}

	@Override
	public LineString visit(LineString lineString) {
		List<Point> points = new ArrayList<>(lineString.getNumPoints());
		for ( int i = 0; i < lineString.getNumPoints(); i++ ) {
			points.add(visit(lineString.getPointN(i)));
		}
		return new LineString(points);
	}

	@Override
	public GeometryCollection visit(GeometryCollection gc) {
		List<Geometry> geometries = new ArrayList<>(gc.getNumGeometries());
		for ( int i = 0; i < gc.getNumGeometries(); i++ ) {
			geometries.add(gc.getGeometryN(i).accept(this));
		}
		return new GeometryCollection(geometries);
	}

}
