import { Component, OnInit } from '@angular/core';
import { Tile } from 'src/app/tile';
import { TileImageProviderService } from 'src/app/tile-image-provider.service';
import { TileProviderService } from 'src/app/tile-provider.service';
import { TileType } from 'src/app/tiletype';
import { TileComponent } from './tile/tile.component';
import { Edge } from 'src/app/edge';
import { Vertex } from 'src/app/vertex';
import { EdgesGeneratorService } from 'src/app/edges-generator.service';
import { VerticesGeneratorService } from 'src/app/vertices-generator.service';

@Component({
  selector: 'app-gameview',
  templateUrl: './gameview.component.html',
  styleUrls: ['./gameview.component.css']
})
export class GameviewComponent implements OnInit {

  constructor(
    private tileProvider: TileProviderService,
    private edgesGenerator: EdgesGeneratorService,
    private verticesGenerator: VerticesGeneratorService
  ){}

  boardTiles: Tile[][] = [];

  boardEdges: Edge[] = [];
  boardVertices: Vertex[] = [];
  
  ngOnInit(): void {
    this.getBoardTiles();
    this.generateVertices();
  }

  getBoardTiles(){
    this.boardTiles = this.tileProvider.getTiles();
  }
  
  generateEdges(){
    this.boardEdges = this.edgesGenerator.generate(this.boardTiles);
  }

  generateVertices(){
    this.boardVertices = this.verticesGenerator.generate(this.boardTiles);
  }

  test(){
    this.boardTiles.push([new TileComponent()]);
  }

}
