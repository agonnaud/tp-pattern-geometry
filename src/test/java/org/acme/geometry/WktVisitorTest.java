package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class WktVisitorTest {

	@Test
	public void testEmptyPoint() {
		WktVisitor writer = new WktVisitor();
		Geometry g = new Point();
		g.accept(writer);
		Assert.assertEquals("POINT EMPTY", writer.getResult());
	}
//
//	@Test
//	public void testPointOrigin() {
//		WktWriter writer = new WktWriter();
//		String wkt = writer.write(TestGeometryFactory.createSamplePointA());
//		Assert.assertEquals("POINT(0.0 0.0)", wkt);
//	}
//
//	@Test
//	public void testPointB() {
//		WktWriter writer = new WktWriter();
//		String wkt = writer.write(TestGeometryFactory.createSamplePointB());
//		Assert.assertEquals("POINT(3.0 4.0)", wkt);
//	}
//
//	@Test
//	public void testEmptyLineString() {
//		WktWriter writer = new WktWriter();
//		String wkt = writer.write(new LineString());
//		Assert.assertEquals("LINESTRING EMPTY", wkt);
//	}
//
//	@Test
//	public void testLineStringAB() {
//		WktWriter writer = new WktWriter();
//		String wkt = writer.write(TestGeometryFactory.createLineStringAB());
//		Assert.assertEquals("LINESTRING(0.0 0.0,3.0 4.0)", wkt);
//	}

}
