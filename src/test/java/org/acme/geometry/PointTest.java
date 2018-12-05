package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructorBehavior(){
		Point g = new Point();
		Assert.assertNotNull(g.getCoordinate());
		Assert.assertTrue(Double.isNaN(g.getCoordinate().getX()));
		Assert.assertTrue(Double.isNaN(g.getCoordinate().getY()));
	}

	@Test
	public void testGetType() {
		Point g = new Point();
		Assert.assertEquals("Point",g.getType());
	}

}
