package fr.univnantes.alma.core.game.map.harbor;

import java.util.ArrayList;
import java.util.List;

import fr.univnantes.alma.core.game.resource.Resource;
import fr.univnantes.alma.core.game.resource.ResourceImpl;

public class HarborImpl implements Harbor {
	private final HarborTrades type;
	private final boolean random;
	private final List<Resource> require;
	private final List<Resource> given;

	public HarborImpl(HarborTrades type, List<Resource> require, List<Resource> given) {
		this.type = type;
		this.require = require;
		this.given = given;
		this.random = type.isRandom();
	}

	@Override
	public List<Resource> getRequireResources() {
		List<Resource> result = new ArrayList<Resource>();
		if (require == null)
			return result;
		for (Resource r : require) {
			result.add(new ResourceImpl(r));
		}
		return result;
	}

	@Override
	public List<Resource> getGivenResources() {
		List<Resource> result = new ArrayList<Resource>();
		if (given == null)
			return result;
		for (Resource r : given) {
			result.add(new ResourceImpl(r));
		}
		return result;
	}

	@Override
	public boolean isRandomTrade() {
		return random;
	}

	@Override
	public HarborTrades getType() {
		return type;
	}

}