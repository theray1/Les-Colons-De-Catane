import {Component, Inject, OnInit} from '@angular/core';
import {PlayerStateInformations} from "../../../player-state-informations";

@Component({
  selector: 'app-playerstateview',
  templateUrl: './playerstateview.component.html',
  styleUrls: ['./playerstateview.component.css']
})
export class PlayerstateviewComponent implements OnInit{
  informations : PlayerStateInformations = {
   //name : `jj`,
   developments : 2,
   knights: 0,
   biggestArmy: true,
   longestRoad: false,
   resources : 4,
   victory_points : 3
  };
  //name:string;
    name:string = "test";

  constructor(/*@Inject(String) n : string*/) {
      //this.name = n;
  }

  ngOnInit(): void {

  }
}
