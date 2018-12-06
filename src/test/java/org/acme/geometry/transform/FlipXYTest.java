package org.acme.geometry.transform;

import org.acme.geometry.Coordinate;
import org.acme.geometry.MathTransform;
import org.junit.Assert;
import org.junit.Test;

public class FlipXYTest {
	
	@Test
	public void testFlipXY() {
		MathTransform transform = new FlipXY();
		Coordinate input  = new Coordinate(3.0,4.0);
		Coordinate output = transform.transform(input);
		Assert.assertEquals(input.getY(), output.getX(),1.0e-15);
		Assert.assertEquals(input.getX(), output.getY(),1.0e-15);		
	}

}
