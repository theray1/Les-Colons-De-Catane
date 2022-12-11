package fr.univnantes.alma.core.commands;

import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.Set;

import fr.univnantes.alma.core.game.entity.Player;


public abstract class CommandWithContext implements Command {

    protected final Set<Player> recipient;

    protected CommandContext context;

    protected CommandWithContext(Set<Player> recipient) {
        if(recipient.size() > 4)
            throw new  InvalidParameterException("A game cannot have more than 4 players");

        this.recipient = recipient;
    }

    @Override
    public CommandContext getContext() {
        return context;
    }

    @Override
    public void setContext(CommandContext context) {
        this.context = context;
    }

    @Override
    public Collection<Player> getRecipents() {
        return recipient;
    }

    @Override
    public abstract void run();
}
