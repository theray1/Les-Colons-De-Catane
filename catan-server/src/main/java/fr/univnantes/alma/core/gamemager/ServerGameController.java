package fr.univnantes.alma.core.gamemager;

import fr.univnantes.alma.core.game.GameController;

import java.util.List;

public interface ServerGameController {
    List<GameController> getAllGames();

    GameController getGameWithSlot();
}
