package fr.univnantes.alma.core.game;

import java.util.List;

import fr.univnantes.alma.core.commands.Command;
import fr.univnantes.alma.core.game.entity.Player;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.resource.Resource;

public class GameFacadeImpl implements GameFacade {

	private final GameController controller;

	GameFacadeImpl(GameController controller) {
		this.controller = controller;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void end() {
		// TODO Auto-generated method stub

	}

	@Override
	public void endPlayerTurn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRessource(Player player, Resource[] resources) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeResources(Player player, Resource[] resources) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveRobber(Coordinates coordinates) {
		// TODO Auto-generated method stub

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