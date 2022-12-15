import { Injectable } from '@angular/core';
import { TileComponent } from './interface/gameview/tile/tile.component';
import { Tile } from './tile';
import { TileType } from './tiletype';
import { Vertex } from './vertex';

@Injectable({
  providedIn: 'root'
})
export class TileProviderService {
  constructor() {}

  totalNumberOfVertices: Number = 96;
  vertices: Vertex[] = [];

  getVertices(){
    
    for(var i = 0; i < this.totalNumberOfVertices; i ++){
      this.vertices.push({id: i})
    }

  }

  getTiles(): Tile[][]{

    var tileBoard: Tile[][] = []; 
    var currentRow: Tile[] = [];

    for(var i = 0; i < 4; i++) {
      var current: Tile = new TileComponent();
      current.image = "assets/water.png";
      current.type = TileType.WATER;
      currentRow.push(current);
    }
    tileBoard.push(currentRow);
    currentRow = [];

    for(var i = 0; i < 5; i++) {
      var current: Tile = new TileComponent();
      current.image = (i==0 || i==4)? "assets/water.png" : "assets/empty.png";
      current.type = (i==0 || i==4)? TileType.WATER : TileType.DESERT;
      currentRow.push(current)
    }
    tileBoard.push(currentRow);
    currentRow = [];

    for(var i = 0; i < 6; i++) {
      var current: Tile = new TileComponent();
      current.image = (i==0 || i==5)? "assets/water.png" : "assets/empty.png";
      current.type = (i==0 || i==5)? TileType.WATER : TileType.DESERT;
      currentRow.push(current)
    }
    tileBoard.push(currentRow);
    currentRow = [];
    
    for(var i = 0; i < 7; i++) {
      var current: Tile = new TileComponent();
      current.image = (i==0 || i==6)? "assets/water.png" : "assets/empty.png";
      current.type = (i==0 || i==6)? TileType.WATER : TileType.DESERT;
      currentRow.push(current)
    }
    tileBoard.push(currentRow);
    currentRow = [];

    for(var i = 0; i < 6; i++) {
      var current: Tile = new TileComponent();
      current.image = (i==0 || i==5)? "assets/water.png" : "assets/empty.png";
      current.type = (i==0 || i==5)? TileType.WATER : TileType.DESERT;
      currentRow.push(current)
    }
    tileBoard.push(currentRow);
    currentRow = [];

    for(var i = 0; i < 5; i++) {
      var current: Tile = new TileComponent();
      current.image = (i==0 || i==4)? "assets/water.png" : "assets/empty.png";
      current.type = (i==0 || i==4)? TileType.WATER : TileType.DESERT;
      currentRow.push(current)
    }
    tileBoard.push(currentRow);
    currentRow = [];

    for(var i = 0; i < 4; i++) {
      var current: Tile = new TileComponent();
      current.image = "assets/water.png";
      current.type = TileType.WATER;
      currentRow.push(current)
    }
    tileBoard.push(currentRow);
    currentRow = [];

    return tileBoard;
  }

}
