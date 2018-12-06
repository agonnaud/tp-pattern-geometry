package org.acme.geometry;

/**
 * 
 * Permet d'appliquer un traitement 
 * 
 * @author formation
 *
 */
public interface GeometryVisitor {

	public void visit(Point point);
	
	public void visit(LineString lineString);

}
