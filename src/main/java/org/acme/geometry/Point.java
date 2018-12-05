package org.acme.geometry;

public class Point implements Geometry {

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

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public boolean isEmpty() {
		return this.coordinate.isEmpty();
	}

}
