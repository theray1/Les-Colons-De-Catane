package fr.univnantes.alma.core.controler;

import fr.univnantes.alma.core.game.Game;

import java.util.List;

public interface ServerGameController {
    List<Game> getAllGames();

    Game getGameWithSlot();
}
