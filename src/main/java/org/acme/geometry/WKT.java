package org.acme.geometry;

public class WKT {

	/**
	 * Convertion de la géométrie en WKT
	 * @param geometry
	 * @return
	 */
	public static String asText(Geometry geometry) {
		WktVisitor visitor = new WktVisitor();
		geometry.accept(visitor);
		return visitor.getResult();
	}

}
