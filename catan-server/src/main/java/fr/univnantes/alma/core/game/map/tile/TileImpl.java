package fr.univnantes.alma.core.game.map.tile;

import fr.univnantes.alma.core.game.building.Building;
import fr.univnantes.alma.core.game.building.Buildings;
import fr.univnantes.alma.core.game.entity.Robber;
import fr.univnantes.alma.core.game.map.CatanMap;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.coordinates.CoordinatesImpl;
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
	private int number;
	private final CatanMap catanMap;

	private final Edge[] edges;
	private final Vertice[] vertices;

	public TileImpl(Coordinates coords, Tiles type, CatanMap catanMap) {
		this.coords = coords;
		this.type = type;
		this.catanMap = catanMap;
		this.resource = switch (type) {
		case FOREST -> new ResourceImpl(Resources.WOOD);
		case MOUNTAIN -> new ResourceImpl(Resources.STONE);
		case PASTURE -> new ResourceImpl(Resources.WOOL);
		case FIELD -> new ResourceImpl(Resources.WHEAT);
		case HILL -> new ResourceImpl(Resources.BRICK);
		default -> new ResourceImpl(Resources.NOTHING);
		};

		this.edges = new Edge[6];
		this.vertices = new Vertice[6];

	}

	@Override
	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public Resource getResource() {
		if (containsRobber()) {
			return new ResourceImpl(Resources.NOTHING);
		} else
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
	public void setBuilding(Building building) throws IllegalStateException {
		switch (building.getType()) {
			case VERTICE -> this.getVertice(building.getCoordinates()).setBuilding(building);
			case EDGE -> this.getEdge(building.getCoordinates()).setBuilding(building);
			default -> throw new IllegalStateException("Building must have a type (Vertice or Edge)");
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
		return edges[coords.getEnd() - 1];
	}

	@Override
	public Vertice getVertice(Coordinates coords) {
		return vertices[coords.getEnd() - 1];
	}

	@Override
	public void setEdge(Edge edge, Coordinates coords) {
		edges[coords.getEnd() - 1] = edge;
	}

	@Override
	public void setVertice(Vertice vertice, Coordinates coords) {
		vertices[coords.getEnd() - 1] = vertice;
	}

	@Override
	public Tiles getType() {
		return this.type;
	}

	@Override
	public void placeHarbor(Harbor har) throws IllegalStateException {
		if (this.type != Tiles.SEA)
			throw new IllegalStateException("A harbor can only be placed on an ocean tile");

		this.harbor = har;
	}

	@Override
	public boolean containsHarbor() {
		return this.harbor != null;
	}

	@Override
	public Harbor getHarbor() {
		return this.harbor;
	}

	@Override
	public boolean isComplete() {
		Tile t, t2;

		Coordinates[] neighbors = new Coordinates[6];

		// Call the up left tile
		neighbors[0] = new CoordinatesImpl(this.coords.getRow() - 1, this.coords.getColumn() - 1);
		// Call the up right tile
		neighbors[1] = new CoordinatesImpl(this.coords.getRow() - 1, this.coords.getColumn());
		// Call the right tile
		neighbors[2] = new CoordinatesImpl(this.coords.getRow(), this.coords.getColumn() + 1);
		// Call the down right tile
		neighbors[3] = new CoordinatesImpl(this.coords.getRow() + 1, this.coords.getColumn() + 1);
		// Call the down left tile
		neighbors[4] = new CoordinatesImpl(this.coords.getRow() + 1, this.coords.getColumn());
		// Call the left tile
		neighbors[5] = new CoordinatesImpl(this.coords.getRow(), this.coords.getColumn() - 1);

		for (int i = 1; i <= 6; i++) {
			if (!catanMap.isValidCoordinates(neighbors[i - 1])) {
				continue;
			}

			t = this.catanMap.getTile(neighbors[i - 1]);
			if (edges[i - 1] == null) {
				if (!this.type.equals(Tiles.SEA)) {
					return false;
				} else if (!t.getType().equals(Tiles.SEA)) {
					return false;
				}
			}

			if (!t.getType().equals(Tiles.SEA) || !this.type.equals(Tiles.SEA)) {
				if (vertices[i - 1] == null) {
					return false;
				}

			} else if (catanMap.isValidCoordinates(neighbors[i - 1])
					&& !this.catanMap.getTile(neighbors[i - 1]).getType().equals(Tiles.SEA)) {
				if (vertices[i - 1] == null) {
					return false;
				}
			}

		}
		return true;
	}

	@Override
	public boolean canBuild(Building b) {
		Coordinates coords = b.getCoordinates();
		Buildings bType = b.getType();
		if (!this.getLocation(bType, coords).isFree())
			return false;

		if (bType == Buildings.EDGE) {
			switch (coords.getEnd()) {
			case 1:
				if (!this.getEdge(new CoordinatesImpl(coords.getRow(), coords.getColumn(), 6)).isFree())
					return false;
				if (!this.getEdge(new CoordinatesImpl(coords.getRow(), coords.getColumn(), 2)).isFree())
					return false;

				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			}
		}
		return false;
	}

	@Override
	public Location getLocation(Buildings type, Coordinates coords) {
		if (type == Buildings.EDGE) {
			return this.getEdge(coords);
		} else {
			return this.getVertice(coords);
		}
	}

}
