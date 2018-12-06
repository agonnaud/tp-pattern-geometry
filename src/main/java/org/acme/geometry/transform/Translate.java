package org.acme.geometry.transform;

import org.acme.geometry.Coordinate;
import org.acme.geometry.MathTransform;

/**
 * Translation suivant un dx,dy
 * @author formation
 *
 */
public class Translate implements MathTransform {

	private double dx ;
	private double dy ;
	
	public Translate(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}

	@Override
	public Coordinate transform(Coordinate coordinate) {
		return new Coordinate(
			coordinate.getX()+dx, 
			coordinate.getY()+dy
		);
	}

}
