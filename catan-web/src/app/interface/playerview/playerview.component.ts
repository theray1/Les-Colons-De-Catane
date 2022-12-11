import {Component, OnInit} from '@angular/core';
import {PlayerResources} from "../../playerResources";

@Component({
  selector: 'app-playerview',
  templateUrl: './playerview.component.html',
  styleUrls: ['./playerview.component.css']
})
export class PlayerviewComponent implements OnInit {
  resources: PlayerResources = {
    wood : 1,
    stone : 2,
    brick : 3,
    wool : 4,
    wheat : 6,
    knights : 1,
    victory_points : 1,
    roads : 2,
    settlements : 3,
    cities : 4
  };

  constructor() { }

  ngOnInit(): void {
  }

}
