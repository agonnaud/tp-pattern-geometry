package org.acme.geometry;

public class GeoJSONVisitor implements GeometryVisitor<Void> {

	private StringBuilder s;

	public GeoJSONVisitor() {
		this.s = new StringBuilder();
	}

	public Void visit(Point point) {
		s.append("{");
		s.append("\"type\": \"" + point.getType() + "\",");
		s.append("\"coordinate\": ");
		write(point.getCoordinate());
		s.append("}");
		return null;
	}

	/**
	 * Ecriture d'une LineString
	 * 
	 * @param s
	 * @param g
	 */
	public Void visit(LineString lineString) {
		s.append("{");
		s.append("\"type\": \"" + lineString.getType() + "\",");
		s.append("\"coordinate\": [");
		for (int i = 0; i < lineString.getNumPoints(); i++) {
			if (i != 0) {
				s.append(",");
			}
			write(lineString.getPointN(i).getCoordinate());
		}
		s.append("]}");
		return null;
	}

	@Override
	public Void visit(GeometryCollection geometryCollection) {
		s.append("{");
		s.append("\"type\": \"" + geometryCollection.getType() + "\",");
		s.append("\"geometries\": [");
		for (int i = 0; i < geometryCollection.getNumGeometries(); i++) {
			if (i != 0) {
				s.append(",");
			}
			geometryCollection.getGeometryN(i).accept(this);
		}
		s.append("]}");
		return null;
	}

	/**
	 * Ecriture d'une coordonnées
	 * 
	 * @param s
	 * @param coordinate
	 */
	private Void write(Coordinate coordinate) {
		if (coordinate.isEmpty()) {
			s.append("null");
			return null;
		}
		s.append("[");
		s.append(coordinate.getX());
		s.append(",");
		s.append(coordinate.getY());
		s.append("]");
		return null;
	}

	/**
	 * Renvoie le résultat
	 * 
	 * @return
	 */
	public String getResult() {
		return s.toString();
	}

}
