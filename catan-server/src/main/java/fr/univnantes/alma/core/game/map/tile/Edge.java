package fr.univnantes.alma.core.game.map.tile;

import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.harbor.Harbor;

public class Edge extends AbstractLocation {

	public Edge(Coordinates coords, Harbor harbor) {
		super(coords, harbor);
	}

	public Edge(Coordinates coords) {
		super(coords, null);
	}

}
