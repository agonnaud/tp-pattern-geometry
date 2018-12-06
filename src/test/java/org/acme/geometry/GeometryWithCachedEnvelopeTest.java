package org.acme.geometry;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.Invocation;

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
		Collection<Invocation> invocations = Mockito.mockingDetails(original).getInvocations();
		Assert.assertEquals(
			"original.getEnvelope() doit être appelé une seule fois",
			1,
			invocations.size()
		);
		//Mockito.verify(original,Mockito.times(1));		
	}
	
}
