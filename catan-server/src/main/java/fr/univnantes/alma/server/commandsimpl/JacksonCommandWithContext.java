package fr.univnantes.alma.server.commandsimpl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.univnantes.alma.core.commands.Command;
import fr.univnantes.alma.core.commands.CommandWithContext;
import fr.univnantes.alma.core.game.entity.Player;

import java.util.Set;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.WRAPPER_OBJECT, property = "command")
public abstract class JacksonCommandWithContext extends CommandWithContext implements Command {
    protected JacksonCommandWithContext(Set<Player> recipient) {
        super(recipient);
    }

    @Override
    public abstract void run();
}
