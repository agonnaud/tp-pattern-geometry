package org.acme.geometry;

public class GeoJSONVisitor implements GeometryVisitor {

	private StringBuilder s ;
	
	public GeoJSONVisitor() {
		this.s = new StringBuilder();
	}

	public void visit(Point point) {
		s.append("{");
		s.append("\"type\": \""+point.getType()+"\",");
		s.append("\"coordinate\": ");
		write(point.getCoordinate());
		s.append("}");
	}

	/**
	 * Ecriture d'une LineString
	 * @param s
	 * @param g
	 */
	public void visit(LineString lineString) {
		s.append("{");
		s.append("\"type\": \""+lineString.getType()+"\",");
		s.append("\"coordinate\": [");
		for ( int i = 0; i < lineString.getNumPoints(); i++ ){
			if ( i != 0 ) {
				s.append(",");
			}
			write(lineString.getPointN(i).getCoordinate());
		}
		s.append("]}");
	}


	@Override
	public void visit(GeometryCollection geometryCollection) {
		s.append("{");
		s.append("\"type\": \""+geometryCollection.getType()+"\",");
		s.append("\"geometries\": [");
		for ( int i = 0; i < geometryCollection.getNumGeometries(); i++ ){
			if ( i != 0 ) {
				s.append(",");
			}
			geometryCollection.getGeometryN(i).accept(this);
		}
		s.append("]}");
	}

	/**
	 * Ecriture d'une coordonnées
	 * @param s
	 * @param coordinate
	 */
	private void write(Coordinate coordinate) {
		if ( coordinate.isEmpty() ) {
			s.append("null");
			return;
		}
		s.append("[");
		s.append(coordinate.getX());
		s.append(",");
		s.append(coordinate.getY());
		s.append("]");		
	}
	
	/**
	 * Renvoie le résultat
	 * @return
	 */
	public String getResult(){
		return s.toString();
	}

	

}
