package org.acme.geometry.transform;

import org.acme.geometry.Coordinate;
import org.acme.geometry.MathTransform;

/**
 * 
 * Inversion coordonnées XY
 * 
 * @author formation
 *
 */
public class FlipXY implements MathTransform {

	@Override
	public Coordinate transform(Coordinate coordinate) {
		return new Coordinate(
			coordinate.getY(), 
			coordinate.getX()
		);
	}

}
