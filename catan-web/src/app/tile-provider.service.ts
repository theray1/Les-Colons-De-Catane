import { Injectable } from '@angular/core';
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
    return [
      [{id: 0, type: TileType.DESERT, edges: [this.vertices[0] , this.vertices[1], this.vertices[2], this.vertices[3], this.vertices[4], this.vertices[5]], vertices: [], image: "assets/desert.png"}, 
      {id: 0, type: TileType.DESERT, edges: [], vertices: [], image: "assets/desert.png"}, 
      {id: 0, type: TileType.DESERT, edges: [], vertices: [], image: "assets/desert.png"}], 

      [{id: 0, type: TileType.DESERT, edges: [], vertices: [], image: "assets/desert.png"}, 
      {id: 0, type: TileType.DESERT, edges: [], vertices: [], image: "assets/desert.png"}, 
      {id: 0, type: TileType.DESERT, edges: [], vertices: [], image: "assets/desert.png"}, 
      {id: 0, type: TileType.DESERT, edges: [], vertices: [], image: "assets/desert.png"}], 

      [{id: 0, type: TileType.DESERT, edges: [], vertices: [], image: "assets/desert.png"}, 
      {id: 0, type: TileType.DESERT, edges: [], vertices: [], image: "assets/desert.png"}, 
      {id: 0, type: TileType.DESERT, edges: [], vertices: [], image: "assets/desert.png"}, 
      {id: 0, type: TileType.DESERT, edges: [], vertices: [], image: "assets/desert.png"},
      {id: 0, type: TileType.DESERT, edges: [], vertices: [], image: "assets/desert.png"}], 

      [{id: 0, type: TileType.DESERT, edges: [], vertices: [], image: "assets/desert.png"}, 
      {id: 0, type: TileType.DESERT, edges: [], vertices: [], image: "assets/desert.png"}, 
      {id: 0, type: TileType.DESERT, edges: [], vertices: [], image: "assets/desert.png"}, 
      {id: 0, type: TileType.DESERT, edges: [], vertices: [], image: "assets/desert.png"},], 

      [{id: 0, type: TileType.DESERT, edges: [], vertices: [], image: "assets/desert.png"}, 
      {id: 0, type: TileType.DESERT, edges: [], vertices: [], image: "assets/desert.png"}, 
      {id: 0, type: TileType.DESERT, edges: [], vertices: [], image: "assets/desert.png"}],
    ];
  }

}
