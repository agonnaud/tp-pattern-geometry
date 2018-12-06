package org.acme.geometry;

import java.util.HashMap;
import java.util.Map;

public class GeometryWriterFactory {

	private Map<String,GeometryWriter> prototypes = new HashMap<>();
	
	public GeometryWriterFactory() {
		register(new WktWriter());
		register(new GeoJSONWriter());		
	}
	
	public void register(GeometryWriter prototype) {
		prototypes.put(prototype.getName(), prototype);
	}

	/**
	 * Création d'un format
	 * @param format
	 * @return
	 */
	public GeometryWriter createGeometryWriter(String format) {
		GeometryWriter prototype = prototypes.get(format);
		if ( prototype == null ) {
			throw new RuntimeException("Format not found : "+format);
		}
		return prototype.clone();
	}
	
}
