package org.acme.geometry;

public class Point extends AbstractGeometry {

	public static final String TYPE = "Point";

	private Coordinate coordinate ;
	
	public Point() {
		this.coordinate = new Coordinate();
	}
	
	public Point(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public double getX() {
		return coordinate.getX();
	}

	public double getY() {
		return coordinate.getY();
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public boolean isEmpty() {
		return this.coordinate.isEmpty();
	}

	@Override
	public Point clone() {
		// Remarque : coordinate est immuable
		return new Point(coordinate);
	}
	
	@Override
	public <T> T accept(GeometryVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
