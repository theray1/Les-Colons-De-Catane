package fr.univnantes.alma.core.game.map.harbor;

import java.util.List;

import fr.univnantes.alma.core.game.resource.Resource;

public interface Harbor {
	List<Resource> getRequireResources();

	List<Resource> getGivenResources();

	boolean isRandomTrade();

	HarborTrades getType();
}