package fr.univnantes.alma.core.game;

import java.util.List;

import fr.univnantes.alma.core.game.entity.NotEnoughResourcesException;
import fr.univnantes.alma.core.game.entity.Player;
import fr.univnantes.alma.core.game.exception.GameException;
import fr.univnantes.alma.core.game.map.Map;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.resource.Resource;

public class GameFacadeImpl implements GameFacade {
	private List<Player> players;
	private Map map;
	private int currentPlayer;

	@Override
	public void start() throws GameException {
		if (!(players.size() >= 3 && players.size() <= 4))
			throw new GameException("Player number is not correct");

		currentPlayer = 0;

	}

	@Override
	public void end() {
		// TODO Auto-generated method stub

	}

	@Override
	public void endPlayerTurn() {
		currentPlayer++;
		currentPlayer %= players.size();
	}

	@Override
	public void addRessource(Player player, List<Resource> resources) {
		player.addResources(resources);

	}

	@Override
	public void removeResources(Player player, List<Resource> resources) throws GameException {
		try {
			player.removeResources(resources);
		} catch (NotEnoughResourcesException e) {
			throw new GameException("Player havent resources");
		}

	}

	@Override
	public void moveRobber(Coordinates coordinates) {

	}
}