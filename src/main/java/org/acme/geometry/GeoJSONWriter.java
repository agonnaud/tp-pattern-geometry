package org.acme.geometry;

/**
 * 
 * Classe d'écriture de la géométrie au format WKT
 * 
 * @author formation
 *
 */
public class GeoJSONWriter implements GeometryWriter {

	public static final String FORMAT_NAME = "GeoJSON";

	@Override
	public String getName() {
		return FORMAT_NAME;
	}

	/**
	 * Convertion d'une géométrie en texte
	 * 
	 * @param geometry
	 * @return
	 */
	public String write(Geometry geometry) {
		GeoJSONVisitor visitor = new GeoJSONVisitor();
		geometry.accept(visitor);
		return visitor.getResult();
	}

}
