package fr.univnantes.alma.core.game;

import fr.univnantes.alma.core.commands.Command;
import fr.univnantes.alma.core.game.dice.Dice;
import fr.univnantes.alma.core.game.dice.DiceImpl;
import fr.univnantes.alma.core.game.entity.NotEnoughResourcesException;
import fr.univnantes.alma.core.game.entity.Player;
import fr.univnantes.alma.core.game.entity.PlayerImpl;
import fr.univnantes.alma.core.game.exception.GameException;
import fr.univnantes.alma.core.game.map.CatanMapImpl;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.resource.Resource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameControllerImpl implements GameController {

	private final ExecutorService commandExecutor = Executors.newSingleThreadExecutor();
	private final GameFacade facade = new GameFacadeImpl(this);

	private final Set<Player> players = new HashSet<>();
	private int currentplayer = 0;
	private static final int MAX_PLAYERS = 4;

	private final CatanMapImpl map;
	private final Dice dice;

	public GameControllerImpl() {
		this.map = new CatanMapImpl();
		this.dice = new DiceImpl();
	}

	@Override
	public Player addPlayer() {
		PlayerImpl player = new PlayerImpl(this, "player" + players.size());
		players.add(player);
		return player;
	}

	@Override
	public GameFacade getFacade() {
		return facade;
	}

	@Override
	public boolean isFull() {
		return players.size() < MAX_PLAYERS;
	}

	@Override
	public void submit(Command command) {
		commandExecutor.submit(command);
	}

	@Override
	public void start() throws GameException {
		// TODO Send commande de démarage

		this.endPlayerTurn();

	}

	@Override
	public void end() {
		// TODO Send command de victoire de player X

	}

	@Override
	public void endPlayerTurn() {
		this.currentplayer++;
		this.currentplayer %= this.players.size();
		this.dice.roll();
		// TODO Envoyer une commande de changement de tour avec le résultat du dé pour
		// le nouveau joueur actif
	}

	@Override
	public void addRessource(Player player, List<Resource> resources) {
		player.addResources(resources);

		// TODO Commande d'ajout de resource

	}

	@Override
	public void removeResources(Player player, List<Resource> resources) {
		try {
			player.removeResources(resources);
		} catch (NotEnoughResourcesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Commande de retrait de resource

	}

	@Override
	public void moveRobber(Coordinates coordinates) {
		this.map.placeRobber(coordinates);

		// TODO Commande de déplacement de robber

	}

}