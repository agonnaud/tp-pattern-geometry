package org.acme.geometry;

/**
 * 
 * Représente une transformation mathématique sur une
 * coordonnées
 * 
 * @author formation
 *
 */
public interface MathTransform {
	
	/**
	 * @param coordinate
	 * @return
	 */
	public Coordinate transform(Coordinate coordinate);

}
