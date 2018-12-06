package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LengthGeometryVisitorTest {
	public static final double EPSILON = 1.0e-15;
	
	
	private LengthGeometryVisitor visitor ;
	
	@Before
	public void setUp() {
		this.visitor = new LengthGeometryVisitor();
	}
	
	@Test
	public void testLengthPoint() {
		Assert.assertEquals(
			0.0, 
			TestGeometryFactory.createSamplePointB().accept(visitor), 
			EPSILON
		);
	}
	
	@Test
	public void testLengthLineStringAB() {
		Assert.assertEquals(
			5.0, 
			TestGeometryFactory.createLineStringAB().accept(visitor), 
			EPSILON
		);
	}
	
	@Test
	public void testLengthIllegalLineString() {
		List<Point> points = new ArrayList<>();
		points.add(TestGeometryFactory.createSamplePointA());
		LineString lineString = new LineString(points);
		Assert.assertEquals(
			0.0, 
			lineString.accept(visitor), 
			EPSILON
		);
	}
	

	@Test
	public void testLengthCollectionA() {
		Assert.assertEquals(
			5.0, 
			TestGeometryFactory.createCollectionA().accept(visitor), 
			EPSILON
		);
	}
	
}
