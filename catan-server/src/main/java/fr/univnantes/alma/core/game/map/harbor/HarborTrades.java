package fr.univnantes.alma.core.game.map.harbor;

public enum HarborTrades {

	TWOTOONE(false, 2, 1), FOURTOONE(false, 4, 1), ONETOONE(false, 1, 1), RANDOM4TO1(true, 4, 1),
	RANDOM2TO1(true, 2, 1), RANDOM1TO1(true, 1, 1);

	HarborTrades(boolean code, int require, int given) {
		this.code = code;
		this.require = require;
		this.given = given;
	}

	private final boolean code;

	private final int require, given;

	public boolean isRandom() {
		return this.code;
	}

	public int getRequire() {
		return require;
	}

	public int getGiven() {
		return given;
	}

}