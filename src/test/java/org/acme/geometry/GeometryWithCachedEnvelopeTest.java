package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GeometryWithCachedEnvelopeTest {

	@Test
	public void testUseCache() {
		Geometry original = Mockito.mock(Geometry.class);
		Envelope bbox = new Envelope();
		Mockito.when(original.getEnvelope()).thenReturn(bbox);

		GeometryWithCachedEnvelope cached = new GeometryWithCachedEnvelope(original);
		Assert.assertSame( bbox, cached.getEnvelope() );
		Assert.assertSame( bbox, cached.getEnvelope() );
		
		// On vérifie que getEnvelope a été appelé une seule fois
		Mockito.verify(original, Mockito.times(1)).getEnvelope();	
	}

	/**
	 * Test fonctionnel en cas de notification de changement
	 */
	@Test
	public void testGeometryChange() {
		Geometry original = TestGeometryFactory.createLineStringAB();
		GeometryWithCachedEnvelope geometry = new GeometryWithCachedEnvelope(original);
		Envelope bboxA = geometry.getEnvelope();
		geometry.triggerChange();
		Envelope bboxB = geometry.getEnvelope();
		Assert.assertNotSame(bboxA, bboxB);
	}

	
}
