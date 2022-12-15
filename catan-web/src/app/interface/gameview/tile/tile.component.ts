import { Component, Input, OnInit } from '@angular/core';
import { Edge } from 'src/app/edge';
import { Tile } from 'src/app/tile';
import { TileImageProviderService } from 'src/app/tile-image-provider.service';
import { TileType } from 'src/app/tiletype';
import { Vertex } from 'src/app/vertex';

@Component({
  selector: 'app-tile',
  templateUrl: './tile.component.html',
  styleUrls: ['./tile.component.css']
})
export class TileComponent implements Tile, OnInit{

  constructor(){}
  testFunction(): void {
    throw new Error('Method not implemented.');
  }

  @Input() id: number = 0;
  @Input() type: TileType = TileType.DESERT;
  @Input() edges: Edge[] = [];
  @Input() vertices: Vertex[] = [];

  @Input() image: String = "";

  getType(): TileType{
    return this.type
  }

  ngOnInit(){
    
  }

}
