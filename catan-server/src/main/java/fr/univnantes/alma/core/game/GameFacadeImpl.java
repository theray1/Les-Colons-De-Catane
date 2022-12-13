package fr.univnantes.alma.core.game;

import java.util.List;

import fr.univnantes.alma.core.commands.Command;
import fr.univnantes.alma.core.game.entity.Player;
import fr.univnantes.alma.core.game.exception.GameException;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.resource.Resource;

public class GameFacadeImpl implements GameFacade {

	private final GameController controller;

	GameFacadeImpl(GameController controller) {
		this.controller = controller;
	}

	@Override
	public void start() throws GameException {
		controller.start();

	}

	@Override
	public void end() {
		controller.end();

	}

	@Override
	public void endPlayerTurn() {
		controller.endPlayerTurn();

	}

	@Override
	public void addRessource(Player player, List<Resource> resources) {
		controller.addRessource(player, resources);

	}

	@Override
	public void removeResources(Player player, List<Resource> resources) {
		controller.removeResources(player, resources);

	}

	@Override
	public void moveRobber(Coordinates coordinates) {
		controller.moveRobber(coordinates);

	}

	@Override
	public boolean isFull() {
		return controller.isFull();
	}

	@Override
	public void submit(Command command) {
		controller.submit(command);
	}

	@Override
	public Player addPlayer() {
		return controller.addPlayer();
	}
}
