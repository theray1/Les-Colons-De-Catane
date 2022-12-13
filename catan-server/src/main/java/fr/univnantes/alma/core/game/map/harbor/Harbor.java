package fr.univnantes.alma.core.game.map.harbor;

import java.util.List;

import fr.univnantes.alma.core.game.resource.Resource;

public interface Harbor {
	public List<Resource> getRequireResources();

	public List<Resource> getGivenResources();

	public boolean isRandomTrade();

	public HarborTrades getType();
}