package fr.univnantes.alma.core.game;

public class MapImpl implements Map {
	private final int SIZE = 6;
	private Tile[][] tiles;

	public MapImpl() {
		// Creating the tile array
		for (int i = 0; i <= SIZE; i++) {
			this.tiles = new Tile[(i < SIZE/2 ? i + 4 : SIZE - i + 4)];
		}
		// Map generation
		generateTiles();
		placeHarbor();
	}

	private void generateTiles() {
		  boolean desertBuild = false;
		  boolean validate = false;
		  Tiles type;
		  for(Tile[] line : tiles) {
			  //First and last line
			  if(line.size() == 4) {
				  line[1] = new Tile(Tiles.SEA);
				  line[2] = new Tile(Tiles.SEA);
			  } else {
				  //Course of non-ocean tiles
				  for(int i = 1;i<=line.size()-2;i++) {
					  validate = false;
					  while(!validate) {
						  validate = true;
						  switch((int) Math.random() * Tiles.getMaxTypeOfTiles() - 1) {
							  case 0:type = Tiles.HILL; break;
							  case 1:type = Tiles.FOREST; break;
							  case 2:type = Tiles.MOUNTAIN; break;
							  case 3:type = Tiles.PASTURE; break;
							  case 4:type = Tiles.FIELD; break; 
							  case 5: if(!desertBuild) {type = Tiles.DESERT; desertBuild = true;} else {validate = false}; break;
						  }
					  }
				  }
			  }
			  
			  //The first and last tile of this line
			  line[0] = new Tile(Tiles.SEA);
			  line[line.size()-1] = new Tile(Tiles.SEA);
		  }
	  }
}