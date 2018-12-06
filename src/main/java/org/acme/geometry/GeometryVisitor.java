package org.acme.geometry;

/**
 * 
 * Permet d'appliquer un traitement 
 * 
 * @author formation
 *
 */
public interface GeometryVisitor<T> {

	public T visit(Point point);
	
	public T visit(LineString lineString);

	public T visit(GeometryCollection geometryCollection);

}
