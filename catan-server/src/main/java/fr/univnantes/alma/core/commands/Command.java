package fr.univnantes.alma.core.commands;

import fr.univnantes.alma.core.game.Player;

import java.util.Collection;

public interface Command extends Runnable {
    Collection<Player> getRecipents();
}
