import { Injectable } from '@angular/core';
import { Edge } from './edge';
import { CityComponent } from './interface/gameview/city/city.component';
import { VertexComponent } from './interface/gameview/vertex/vertex.component';
import { Tile } from './tile';
import { TileType } from './tiletype';
import { Vertex } from './vertex';

@Injectable({
  providedIn: 'root'
})
export class VerticesGeneratorService {

  constructor() { }

  

  numberOfVertices: number = 52;
  board: Tile[][] = [];
  vertices: Vertex[] = [];

  /**
   * Creates the vertices of a board of Catane
   * @param tiles the 2d array representing a initialized board of Catane
   * @returns 
   */
  generate(tiles: Tile[][]): Vertex[]{

    this.board = tiles;
    this.vertices = [];

    for(var i = 0; i < this.numberOfVertices; i++) {
      var currentVertex: Vertex;

      currentVertex = {
        id: i,
        building: new CityComponent()
      }

      this.vertices.push(currentVertex);
    }

    for(var i = 0; i < tiles.length; i++){
      for(var j = 0; j < tiles[i].length; j++){
        var currentTile: Tile = tiles[i][j];

        if(false && currentTile.type == TileType.WATER){

        } else {
          currentTile.vertices = [
            this.vertices[0],
            this.vertices[1],
            this.vertices[2],
            this.vertices[3],
            this.vertices[4],
            this.vertices[5],
          ]
        }
      }
    }

    return this.vertices;
  }

}
