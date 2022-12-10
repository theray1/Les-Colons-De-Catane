package fr.univnantes.alma.core.game.map.tile;

import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.harbor.Harbor;

public class Vertice extends AbstractLocation {

	public Vertice(Coordinates coords, Harbor harbor) {
		super(coords, harbor);
	}

	public Vertice(Coordinates coords) {
		super(coords, null);
	}

}
