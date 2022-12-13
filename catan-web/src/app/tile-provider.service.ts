import { Injectable } from '@angular/core';
import { Tile } from './tile';

@Injectable({
  providedIn: 'root'
})
export class TileProviderService {
  constructor() { }

  getTiles(): Tile[][]{
    return [];
  }

}
