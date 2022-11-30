package fr.univnantes.alma.core.commands;

import fr.univnantes.alma.core.game.Player;

import java.security.InvalidParameterException;
import java.util.Collection;

public abstract class AbstractCommand {

    protected final Collection<Player> recipient;

    protected AbstractCommand(Collection<Player> recipient) {
        if(recipient.size() > 4)
            throw new  InvalidParameterException("A game cannot have more than 4 players");

        this.recipient = recipient;
    }
}
