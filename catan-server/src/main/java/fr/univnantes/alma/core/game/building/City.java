package fr.univnantes.alma.core.game.building;

import fr.univnantes.alma.core.game.entity.Player;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.tile.Edge;
import fr.univnantes.alma.core.game.map.tile.Vertice;

public class City extends VerticeBuilding {
	protected City(Coordinates coords, Buildings type, Player owner) {
		super(coords, type, owner);
		// TODO Auto-generated constructor stub
	}

	public static final int MAX_ENTITY = 8; // The city number limit

	@Override
	public Vertice getVertice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Edge getEdge() {
		// TODO Auto-generated method stub
		return null;
	}
}