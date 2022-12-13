package fr.univnantes.alma.core.game;

import java.util.List;

import fr.univnantes.alma.core.game.entity.Player;
import fr.univnantes.alma.core.game.exception.GameException;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.resource.Resource;

public interface GameFacade {
	void start() throws GameException;

	void end();

	void endPlayerTurn();

	void addRessource(Player player, List<Resource> resources);

	void removeResources(Player player, List<Resource> resources) throws GameException;

	void moveRobber(Coordinates coordinates);

}
