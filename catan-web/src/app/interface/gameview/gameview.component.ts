import { Component, OnInit } from '@angular/core';
import { Tile } from 'src/app/tile';

@Component({
  selector: 'app-gameview',
  templateUrl: './gameview.component.html',
  styleUrls: ['./gameview.component.css']
})
export class GameviewComponent implements OnInit {

  constructor(){}

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  board: Tile[] = [];

  

}
