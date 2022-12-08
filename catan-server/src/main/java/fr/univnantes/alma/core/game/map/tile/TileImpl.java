package fr.univnantes.alma.core.game.map.tile;

import fr.univnantes.alma.core.game.building.Building;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.harbor.Harbor;
import fr.univnantes.alma.core.game.resource.Resource;

public class TileImpl implements Tile {
	private final Coordinates coords;
	private boolean robber = false;
	private final Tiles type;

	private Edge[] edges;
	private Vertice[] vertices;

	public TileImpl(Coordinates coords, Tiles type) {
		this.coords = coords;
		this.type = type;

		this.edges = new Edge[6];
		this.vertices = new Vertice[6];
	}

	@Override
	public Resource getResource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coordinates getCoordinates() {
		return this.coords;
	}

	@Override
	public boolean containsRobber() {
		// TODO Auto-generated method stub
		return this.robber;
	}

	@Override
	public void setBuilding(Building building) {
		// TODO Auto-generated method stub

	}

	@Override
	public void placeHarbor(Harbor harbor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void placeRobber() {
		this.robber = true;

	}

	@Override
	public void removeRobber() {
		this.robber = false;

	}

	@Override
	public Edge getEdge(Coordinates coords) {
		return edges[coords.getEnd()];
	}

	@Override
	public Vertice getVertice(Coordinates coords) {
		return vertices[coords.getEnd()];
	}

	@Override
	public Edge setEdge(Edge edge, Coordinates coords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vertice setVertice(Vertice vertice, Coordinates coords) {
		// TODO Auto-generated method stub
		return null;
	}

}
