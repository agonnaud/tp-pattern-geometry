package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class WktTest {

	@Test
	public void testEmptyPoint() {
		Geometry g = new Point();
		Assert.assertEquals("POINT EMPTY", WKT.asText(g));
	}

	@Test
	public void testPointOrigin() {
		String wkt = WKT.asText(TestGeometryFactory.createSamplePointA());
		Assert.assertEquals("POINT(0.0 0.0)", wkt);
	}

	@Test
	public void testPointB() {
		String wkt = WKT.asText(TestGeometryFactory.createSamplePointB());
		Assert.assertEquals("POINT(3.0 4.0)", wkt);
	}

	@Test
	public void testEmptyLineString() {
		String wkt = WKT.asText(new LineString());
		Assert.assertEquals("LINESTRING EMPTY", wkt);
	}

	@Test
	public void testLineStringAB() {
		String wkt = WKT.asText(TestGeometryFactory.createLineStringAB());
		Assert.assertEquals("LINESTRING(0.0 0.0,3.0 4.0)", wkt);
	}

	@Test
	public void testEmptyCollection() {
		String wkt = WKT.asText(new GeometryCollection());
		Assert.assertEquals("GEOMETRYCOLLECTION EMPTY", wkt);
	}

	@Test
	public void testCollectionA() {
		String wkt = WKT.asText(TestGeometryFactory.createCollectionA());
		Assert.assertEquals("GEOMETRYCOLLECTION(POINT(3.0 4.0),LINESTRING(0.0 0.0,3.0 4.0))", wkt);
	}
}
