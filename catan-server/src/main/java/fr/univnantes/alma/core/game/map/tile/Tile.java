package fr.univnantes.alma.core.game.map.tile;

import fr.univnantes.alma.core.game.building.Building;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.harbor.Harbor;
import fr.univnantes.alma.core.game.resource.Resource;

public interface Tile {
	public Resource getResource();

	public Coordinates getCoordinates();

	public boolean containsRobber();

	public void setBuilding(Building building);

	public void placeHarbor(Harbor harbor);

	public void placeRobber();

	public void removeRobber();

	public Edge getEdge(Coordinates coords);

	public Vertice getVertice(Coordinates coords);

	public Edge setEdge(Edge edge, Coordinates coords);

	public Vertice setVertice(Vertice vertice, Coordinates coords);
}