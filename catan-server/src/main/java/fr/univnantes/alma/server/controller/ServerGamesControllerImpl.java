package fr.univnantes.alma.server.controller;

import fr.univnantes.alma.core.gamemager.ServerGameController;
import fr.univnantes.alma.core.game.GameController;
import fr.univnantes.alma.core.game.GameControllerImpl;
import org.springframework.stereotype.Component;

import java.util.*;


@Component("Default Server Game Controller")
public class ServerGamesControllerImpl implements ServerGameController {

    private final LinkedList<GameController> gameControllerList = new LinkedList<>();

    @Override
    public List<GameController> getAllGames() {
        return gameControllerList;
    }

    @Override
    public GameController getGameWithSlot(){
        GameController lastGameController = gameControllerList.getLast();
        if(lastGameController == null || lastGameController.isFull()) {
           return addNewGame();
        }
        return lastGameController;
    }

    private GameController addNewGame() {
        GameController gameController = new GameControllerImpl(this);
        gameControllerList.addLast(gameController);
        return gameController;

    }
}
