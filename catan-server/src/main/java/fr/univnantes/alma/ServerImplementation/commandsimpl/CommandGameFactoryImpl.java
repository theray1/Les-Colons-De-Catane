package fr.univnantes.alma.ServerImplementation.commandsimpl;

import fr.univnantes.alma.core.commands.Command;
import fr.univnantes.alma.core.commands.CommandGameFactory;
import fr.univnantes.alma.core.game.entity.Player;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.resource.Resource;

public class CommandGameFactoryImpl implements CommandGameFactory {
    @Override
    public Command ActivateThieve(Player[] players) {
        //TODO: implement method
        return null;
    }

    @Override
    public Command MoveThieve(Player[] players, Coordinates coordinates) {
        //TODO: implement method
        return null;
    }

    @Override
    public Command Ping(Player[] players) {
        //TODO: implement method
        return null;
    }

    @Override
    public Command BuyCard(Player[] players, Resource[] resources) {
        //TODO: implement method
        return null;
    }

    @Override
    public Command EndTurn(Player[] players, Player player) {
        //TODO: implement method
        return null;
    }

    @Override
    public Command StartTurn(Player[] players, Player player) {
        //TODO: implement method
        return null;
    }

    @Override
    public Command Win(Player[] players) {
        //TODO: implement method
        return null;
    }

    @Override
    public Command SetResources(Player player) {
        //TODO: implement method
        return null;
    }

    @Override
    public Command AddResources(Player[] players, Player player, Integer resourceId) {
        //TODO: implement method
        return null;
    }

    @Override
    public Command TradeWithNonPlayerEntity(Player player, Resource[] given, Resource[] received) {
        //TODO: implement method
        return null;
    }

    @Override
    public Command TradeWithPlayer(Player player1, Resource[] p1offer, Player player2, Resource[] p2offer) {
        //TODO: implement method
        return null;
    }

    @Override
    public Command DenyTrade(Player[] players) {
        //TODO: implement method
        return null;
    }

    @Override
    public Command AcceptTrade(Player player1, Player player2) {
        //TODO: implement method
        return null;
    }

    @Override
    public Command LoginComplete(Player player) {
        //TODO: implement method
        return null;
    }

    @Override
    public Command SetGame(Player[] players) {
        //TODO: implement method
        return null;
    }

    @Override
    public Command SetPlayer(Player player) {
        //TODO: implement method
        return null;
    }
}
