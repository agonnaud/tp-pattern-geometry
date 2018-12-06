package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class GeometryWriterFactoryTest {

	@Test
	public void testWkt() {
		Geometry g = new Point(new Coordinate(3.0,4.0));
		GeometryWriterFactory writerFactory = new GeometryWriterFactory();
		GeometryWriter writer = writerFactory.createGeometryWriter("WKT");
		Assert.assertEquals("POINT(3.0 4.0)", writer.write(g));
	}
	
}
