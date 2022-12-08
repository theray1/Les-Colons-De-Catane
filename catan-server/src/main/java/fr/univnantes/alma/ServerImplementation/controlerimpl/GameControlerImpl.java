package fr.univnantes.alma.ServerImplementation.controlerimpl;

import fr.univnantes.alma.core.commands.Command;
import fr.univnantes.alma.core.controler.GameControler;
import fr.univnantes.alma.core.game.entity.Player;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class GameControlerImpl implements GameControler {

    private final Executor commandExecutor = Executors.newSingleThreadExecutor();


    @Override
    public void receiveCommand(Command command) {

    }

    @Override
    public void addPlayer(Player player) {

    }
}
