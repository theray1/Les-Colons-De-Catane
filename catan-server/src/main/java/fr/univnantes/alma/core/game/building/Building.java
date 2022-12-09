package fr.univnantes.alma.core.game.building;

import fr.univnantes.alma.core.game.entity.Player;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.tile.Edge;
import fr.univnantes.alma.core.game.map.tile.Vertice;

public interface Building {
	public Vertice getVertice();

	public Edge getEdge();

	public Player getOwner();

	public Coordinates getCoordinates();

	public Buildings getType();
}