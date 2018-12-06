package org.acme.geometry.transform;

import org.acme.geometry.Coordinate;
import org.acme.geometry.MathTransform;
import org.junit.Assert;
import org.junit.Test;

public class TranslateTest {
	
	@Test
	public void testTranslate() {
		MathTransform transform = new Translate(1.0,2.0);
		Coordinate input  = new Coordinate(3.0,4.0);
		Coordinate output = transform.transform(input);
		Assert.assertEquals(4.0, output.getX(),1.0e-15);
		Assert.assertEquals(6.0, output.getY(),1.0e-15);		
	}

}
