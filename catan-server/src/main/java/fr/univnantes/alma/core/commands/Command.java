package fr.univnantes.alma.core.commands;

import fr.univnantes.alma.core.game.entity.Player;

import java.util.Collection;

public interface Command extends Runnable {
    CommandContext getContext();

    void setContext(CommandContext context);

    Collection<Player> getRecipents();

}
