package fr.univnantes.alma.core.game.building;

import fr.univnantes.alma.core.game.entity.Player;
import fr.univnantes.alma.core.game.map.Coordinates;
import fr.univnantes.alma.core.game.map.Edge;
import fr.univnantes.alma.core.game.map.Vertice;

public interface Building {
	public Vertice getVertice();

	public Edge getEdge();

	public Player getOwner();

	public Coordinates getCoordinates();
}