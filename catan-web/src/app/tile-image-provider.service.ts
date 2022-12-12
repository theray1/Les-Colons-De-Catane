import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TileType } from './tiletype';

@Injectable({
  providedIn: 'root'
})
export class TileImageProviderService {
  constructor() { }

  getImage(tile: TileType): String{
    return "../../../../assets/desert.png";
  }

}
