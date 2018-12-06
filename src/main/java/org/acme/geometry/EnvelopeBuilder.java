package org.acme.geometry;

/**
 * Calcul d'une bbox
 * 
 * @author MBorne
 *
 */
public class EnvelopeBuilder implements GeometryVisitor<Void> {
	private Interval boundsX = new Interval();
	private Interval boundsY = new Interval();
	
	public void insert(Coordinate c) {
		this.boundsX.expandToInclude(c.getX());
		this.boundsY.expandToInclude(c.getY());
	}

	public Envelope build() {
		Coordinate bottomLeft = new Coordinate(
			boundsX.getLower(),
			boundsY.getLower()
		);
		Coordinate topRight = new Coordinate(
			boundsX.getUpper(),
			boundsY.getUpper()
		);		
		return new Envelope(bottomLeft,topRight);
	}

	@Override
	public Void visit(Point point) {
		insert(point.getCoordinate());
		return null;
	}

	@Override
	public Void visit(LineString lineString) {
		for ( int i = 0; i < lineString.getNumPoints(); i++ ) {
			visit(lineString.getPointN(i));
		}
		return null;
	}

	@Override
	public Void visit(GeometryCollection geometryCollection) {
		for ( int i = 0; i < geometryCollection.getNumGeometries(); i++ ) {
			geometryCollection.getGeometryN(i).accept(this);
		}
		return null;
	}


}
