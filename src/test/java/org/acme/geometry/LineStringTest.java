package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructorBehavior(){
		LineString g = new LineString();
		Assert.assertEquals(0, g.getNumPoints());
	}

	@Test
	public void testGetType() {
		LineString g = new LineString();
		Assert.assertEquals("LineString",g.getType());
	}
	
	@Test
	public void testTranslate() {
		List<Point> points = new ArrayList<>();
		points.add(new Point(new Coordinate(0.0,0.0)));
		points.add(new Point(new Coordinate(3.0,4.0)));
		
		LineString g = new LineString(points);
		g.translate(2.0, 3.0);

		{
			Point p = g.getPointN(0);
			Assert.assertEquals(2.0,p.getX(),EPSILON);
			Assert.assertEquals(3.0,p.getY(),EPSILON);
		}
		
		{
			Point p = g.getPointN(1);
			Assert.assertEquals(5.0,p.getX(),EPSILON);
			Assert.assertEquals(7.0,p.getY(),EPSILON);
		}

	}
}
