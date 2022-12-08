package fr.univnantes.alma.core.game.map.harbor;

import java.util.Collection;

import fr.univnantes.alma.core.game.resource.Resource;

public class HarborImpl implements Harbor {
	private final HarborTrades type;

	public HarborImpl(HarborTrades type) {
		this.type = type;
	}

	@Override
	public Collection<Resource> getRequireResources() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Resource> getGivenResources() {
		// TODO Auto-generated method stub
		return null;
	}

}