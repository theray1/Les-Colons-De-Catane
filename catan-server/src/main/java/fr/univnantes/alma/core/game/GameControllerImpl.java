package fr.univnantes.alma.core.game;

import fr.univnantes.alma.core.commands.Command;
import fr.univnantes.alma.core.game.entity.Player;
import fr.univnantes.alma.core.game.entity.PlayerImpl;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameControllerImpl implements GameController {

    private final ExecutorService commandExecutor = Executors.newSingleThreadExecutor();
    private final GameFacade facade = new GameFacadeImpl(this);

    private final Set<Player> players = new HashSet<>();
    private static final int MAX_PLAYERS = 4;


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
}