package fr.univnantes.alma.server.commandsimpl;

import fr.univnantes.alma.core.commands.CommandContext;
import fr.univnantes.alma.core.game.GameController;

public record ImmutableCommandContext(GameController gameControllerControler) implements CommandContext {


}
