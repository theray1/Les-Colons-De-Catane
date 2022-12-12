package fr.univnantes.alma.core.game;

import fr.univnantes.alma.core.commands.Command;
import fr.univnantes.alma.core.gamemager.ServerGameController;
import fr.univnantes.alma.core.game.entity.Player;
import fr.univnantes.alma.core.game.entity.PlayerImpl;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameControllerImpl implements GameController {

    private final ExecutorService commandExecutor = Executors.newSingleThreadExecutor();

    private final ServerGameController serverGameController;

    private final Set<Player> players = new HashSet<>();
    private static final int MAX_PLAYERS = 4;

    public GameControllerImpl(ServerGameController serverGameController) {
        this.serverGameController = serverGameController;
    }

    @Override
    public Player joinPlayer(Command command) {
        PlayerImpl player = new PlayerImpl(this, "placeHolder");
        players.add(player);
        return player;
    }

    @Override
    public boolean isFull() {
        return players.size() < MAX_PLAYERS;
    }

    @Override
    public ServerGameController getGameController() {
        return serverGameController;
    }

    @Override
    public void submit(Command command) {
        commandExecutor.submit(command);
    }
}