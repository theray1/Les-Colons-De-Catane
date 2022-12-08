package fr.univnantes.alma.core.game.map;

public class CoordinatesImpl implements Coordinates {
	private final int line;
	private final int column;
	private final int end;

	public CoordinatesImpl(int line, int column, int end) {
		this.line = line;
		this.column = column;
		this.end = end;
	}

	@Override
	public int getLine() {
		return line;
	}

	@Override
	public int getColumn() {
		return column;
	}

	@Override
	public int getEnd() {
		return end;
	}

}
