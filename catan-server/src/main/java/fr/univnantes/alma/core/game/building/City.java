package fr.univnantes.alma.core.game.building;

import fr.univnantes.alma.core.game.entity.Player;
import fr.univnantes.alma.core.game.map.Coordinates;
import fr.univnantes.alma.core.game.map.Edge;
import fr.univnantes.alma.core.game.map.Vertice;

public class City extends VerticeBuilding {
	protected City(Coordinates coords, Player owner) {
		super(coords, owner);
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