package org.acme.geometry;

/**
 * 
 * Classe d'écriture de la géométrie au format WKT
 * 
 * @author formation
 *
 */
public class WktWriter implements GeometryWriter {

	public static final String FORMAT_NAME = "WKT";

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
		WktVisitor visitor = new WktVisitor();
		geometry.accept(visitor);
		return visitor.getResult();
	}
	
	@Override
	public WktWriter clone() {
		// Serait réellement utile avec des paramètres
		return new WktWriter();
	}	

}
