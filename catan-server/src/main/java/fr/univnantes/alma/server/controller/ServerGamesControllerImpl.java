package fr.univnantes.alma.server.controller;

import fr.univnantes.alma.core.controler.ServerGameController;
import fr.univnantes.alma.core.game.Game;
import fr.univnantes.alma.core.game.GameImpl;
import org.springframework.stereotype.Component;

import java.util.*;


@Component("Default Server Game Controller")
public class ServerGamesControllerImpl implements ServerGameController {

    private final LinkedList<Game> gameList = new LinkedList<>();

    @Override
    public List<Game> getAllGames() {
        return gameList;
    }

    @Override
    public Game getGameWithSlot(){
        Game lastGame = gameList.getLast();
        if(lastGame == null || lastGame.isFull()) {
           return addNewGame();
        }
        return lastGame;
    }

    private Game addNewGame() {
        Game game= new GameImpl(this);
        gameList.addLast(game);
        return game;

    }
}
