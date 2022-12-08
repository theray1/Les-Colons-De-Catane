package fr.univnantes.alma.core.game.map.coordinates;

public class CoordinatesImpl implements Coordinates {
	private final int row;
	private final int column;
	private final int end;

	public CoordinatesImpl(int row, int column, int end) {
		this.row = row;
		this.column = column;
		this.end = end;
	}

	@Override
	public int getRow() {
		return row;
	}

	@Override
	public int getColumn() {
		return column;
	}

	@Override
	public int getEnd() {
		return end;
	}

	@Override
	public boolean equalsTile(Coordinates other) {
		return this.row == other.getRow() && this.column == other.getColumn();
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof CoordinatesImpl)) {
			return false;
		}

		CoordinatesImpl coords = (CoordinatesImpl) o;

		return this.equalsTile(coords) && this.end == coords.getEnd();
	}
}
