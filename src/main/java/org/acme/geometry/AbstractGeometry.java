package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry {
	
	@Override
	public String asText() {
		WktVisitor visitor = new WktVisitor();
		accept(visitor);
		return visitor.getResult();
	}
	
	@Override
	public Envelope getEnvelope() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		accept(builder);
		return builder.build();
	}

	public abstract Geometry clone() ;

}
