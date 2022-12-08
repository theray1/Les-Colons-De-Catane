package fr.univnantes.alma.core.commands;

import java.util.Collection;

import fr.univnantes.alma.core.game.entity.Player;

public interface Command extends Runnable {
    Collection<Player> getRecipents();
}
