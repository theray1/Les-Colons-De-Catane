import { Injectable } from '@angular/core';
import { Edge } from './edge';
import { Tile } from './tile';

@Injectable({
  providedIn: 'root'
})
export class EdgesGeneratorService {

  constructor() { }

  /**
   * Creates the edges of a board of Catane and makes 
   * @param tiles the 2d array representing a initialized board of Catane
   * @returns 
   */
  generate(tiles: Tile[][]): Edge[]{

    

    return [];
  }

  

}
