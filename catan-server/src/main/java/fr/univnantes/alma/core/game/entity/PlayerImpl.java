package fr.univnantes.alma.core.game.entity;

import fr.univnantes.alma.core.game.Game;

public class PlayerImpl implements Player{

    private final Game game;

    private final String name;

    @Override
    public String getName() {
        return name;
    }

    public PlayerImpl(Game game, String name) {
        this.game = game;
        this.name = name;
    }

    @Override
    public Game getGame() {
        return game;
    }
}