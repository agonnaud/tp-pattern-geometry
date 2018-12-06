package org.acme.geometry;

public class LengthGeometryVisitor implements GeometryVisitor<Double> {

	@Override
	public Double visit(Point point) {
		return 0.0;
	}

	@Override
	public Double visit(LineString lineString) {
		double length = 0.0 ;
		for ( int i = 0; i < lineString.getNumPoints()-1; i++ ) {
			Coordinate a = lineString.getPointN(i).getCoordinate();
			Coordinate b = lineString.getPointN(i+1).getCoordinate();
			
			double nAB2 = Math.pow( b.getX() - a.getX(), 2.0 ) + Math.pow( b.getY() - a.getY(), 2.0 );
			length += Math.sqrt(nAB2) ;
		}
		return length;
	}

	@Override
	public Double visit(GeometryCollection geometryCollection) {
		double sum = 0.0;
		for ( int i = 0; i < geometryCollection.getNumGeometries(); i++ ) {
			sum += geometryCollection.getGeometryN(i).accept(this);
		}
		return sum ;
	}

	
}
