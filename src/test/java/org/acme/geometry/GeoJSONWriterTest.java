package org.acme.geometry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GeoJSONWriterTest {

	private GeoJSONWriter writer ;
	
	@Before
	public void setUp() {
		this.writer = new GeoJSONWriter();
	}
	
	@Test
	public void testEmptyPoint() {
		String result = writer.write(new Point());
		Assert.assertEquals("{\"type\": \"Point\",\"coordinate\": null}", result);
	}

	@Test
	public void testPointOrigin() {
		String result = writer.write(TestGeometryFactory.createSamplePointA());
		Assert.assertEquals("{\"type\": \"Point\",\"coordinate\": [0.0,0.0]}", result);
	}

	@Test
	public void testPointB() {
		String result = writer.write(TestGeometryFactory.createSamplePointB());
		Assert.assertEquals("{\"type\": \"Point\",\"coordinate\": [3.0,4.0]}", result);
	}

	@Test
	public void testEmptyLineString() {
		String result = writer.write(new LineString());
		Assert.assertEquals("{\"type\": \"LineString\",\"coordinate\": []}", result);
	}

	@Test
	public void testLineStringAB() {
		String result = writer.write(TestGeometryFactory.createLineStringAB());
		Assert.assertEquals("{\"type\": \"LineString\",\"coordinate\": [[0.0,0.0],[3.0,4.0]]}", result);
	}

	@Test
	public void testCollectionA() {
		String result = writer.write(TestGeometryFactory.createCollectionA());
		Assert.assertEquals("{\"type\": \"GeometryCollection\",\"geometries\": [{\"type\": \"Point\",\"coordinate\": [3.0,4.0]},{\"type\": \"LineString\",\"coordinate\": [[0.0,0.0],[3.0,4.0]]}]}", result);
	}
	
}
