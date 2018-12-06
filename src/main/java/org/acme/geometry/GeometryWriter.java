package org.acme.geometry;

/**
 * 
 * Interface pour l'écriture des géométries dans 
 * différents formats textes
 * 
 * @author formation
 *
 */
public interface GeometryWriter {

	/**
	 * Renvoie le nom du format
	 * @return
	 */
	public String getName();
	
	/**
	 * Ecriture de la géométrie
	 * @param geometry
	 * @return
	 */
	public String write(Geometry geometry);
	
	/**
	 * Copie
	 * @return
	 */
	public GeometryWriter clone();
	
}
