import { Component } from '@angular/core';
import { Building } from 'src/app/building';
import { Tile } from 'src/app/tile';
import { Vertex } from 'src/app/vertex';
import { CityComponent } from '../city/city.component';

@Component({
  selector: 'app-vertex',
  templateUrl: './vertex.component.html',
  styleUrls: ['./vertex.component.css']
})
export class VertexComponent implements Vertex{


  id: number = -1;
  neighborTiles?: Tile[];
  building?: Building;

  constructor(){}

  getId(): number{
    return this.id;
  }

  getTiles(): Tile[]|undefined{
    return this.neighborTiles;
  }

}
