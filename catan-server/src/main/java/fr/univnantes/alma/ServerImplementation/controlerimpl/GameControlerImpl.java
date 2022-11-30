package fr.univnantes.alma.ServerImplementation.controlerimpl;

import fr.univnantes.alma.core.controler.GameControler;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class GameControlerImpl implements GameControler {

    private final Executor commandExecutor = Executors.newSingleThreadExecutor();




}
