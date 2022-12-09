package fr.univnantes.alma.core.game.map.tile;

import fr.univnantes.alma.core.game.building.Building;
import fr.univnantes.alma.core.game.entity.Robber;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.harbor.Harbor;
import fr.univnantes.alma.core.game.resource.Resource;
import fr.univnantes.alma.core.game.resource.ResourceImpl;
import fr.univnantes.alma.core.game.resource.Resources;

public class TileImpl implements Tile {
	private final Coordinates coords;
	private Robber robber;
	private final Tiles type;
	private final Resource resource;
	private Harbor harbor;

	private Edge[] edges;
	private Vertice[] vertices;

	public TileImpl(Coordinates coords, Tiles type) {
		this.coords = coords;
		this.type = type;
		this.resource = switch (type) {
		case FOREST -> new ResourceImpl(Resources.WOOD);
		case MOUNTAIN -> new ResourceImpl(Resources.STONE);
		case PASTURE -> new ResourceImpl(Resources.WOOL);
		case FIELD -> new ResourceImpl(Resources.BRICK);
		default -> new ResourceImpl(Resources.NOTHING);
		};

		this.edges = new Edge[6];
		this.vertices = new Vertice[6];

	}

	@Override
	public Resource getResource() {
		return this.resource;
	}

	@Override
	public Coordinates getCoordinates() {
		return this.coords;
	}

	@Override
	public boolean containsRobber() {
		return this.robber != null;
	}

	@Override
	public void setBuilding(Building building, Coordinates coords) throws IllegalStateException {
		switch (building.getType()) {
		case VERTICE:
			this.getVertice(coords).setBuilding(building);
			break;
		case EDGE:
			this.getEdge(coords).setBuilding(building);
			break;
		default:
			throw new IllegalStateException("Building must have a type (Vertice or Edge)");
		}
	}

	@Override
	public void placeRobber(Robber rob) {
		if (this.type == Tiles.SEA) {
			return;
		}
		this.robber = rob;

	}

	@Override
	public Robber removeRobber() {
		return this.robber;

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
		return edges[coords.getEnd()] = edge;
	}

	@Override
	public Vertice setVertice(Vertice vertice, Coordinates coords) {
		return vertices[coords.getEnd()] = vertice;
	}

	@Override
	public Tiles getType() {
		return this.type;
	}

	@Override
	public void placeHarbor(Harbor har) {
		this.harbor = har;
	}

	@Override
	public boolean containsHarbor() {
		return this.harbor != null;
	}

}
