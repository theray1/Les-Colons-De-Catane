package fr.univnantes.alma.core.commands;

import fr.univnantes.alma.core.game.entity.Player;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.resource.Resource;

public interface CommandGameFactory {
    Command ActivateThieve(Player[] players);
    Command MoveThieve(Player[] players, Coordinates coordinates);
    Command Ping(Player[] players);

    //Building not added yet
    //Command Build(Player[] players, Building building);

    //Card not added yet
    //Command ActiveCard(Player[] players, Card card);

    //Card not added yet
    //Command AddCard(Player[] players, Card card);
    Command BuyCard(Player[] players, Resource[] resources);
    Command EndTurn(Player[] players, Player player);
    Command StartTurn(Player[] players, Player player);

    Command Win(Player[] players);
    Command SetResources(Player player);

    //Unsure what the Integer is supposed to be, might be something else than resourceId
    Command AddResources(Player[] players, Player player, Integer resourceId);
    Command TradeWithNonPlayerEntity(Player player, Resource[] given, Resource[] received);
    Command TradeWithPlayer(Player player1, Resource[] p1offer, Player player2, Resource[] p2offer);
    Command DenyTrade(Player[] players);
    Command AcceptTrade(Player player1, Player player2);
    Command LoginComplete(Player player);
    Command SetGame(Player[] players);
    Command SetPlayer(Player player);

}
