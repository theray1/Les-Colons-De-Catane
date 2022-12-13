import { Component, OnInit } from '@angular/core';
import { Tile } from 'src/app/tile';
import { TileImageProviderService } from 'src/app/tile-image-provider.service';
import { TileProviderService } from 'src/app/tile-provider.service';
import { TileType } from 'src/app/tiletype';
import { TileComponent } from './tile/tile.component';

@Component({
  selector: 'app-gameview',
  templateUrl: './gameview.component.html',
  styleUrls: ['./gameview.component.css']
})
export class GameviewComponent implements OnInit {

  constructor(private tiledProvider: TileProviderService){}

  ngOnInit(): void {
    this.getBoard()
  }

  board: Tile[][] = [];

  getBoard(){
    this.board = this.tiledProvider.getTiles()
  }
  

}
