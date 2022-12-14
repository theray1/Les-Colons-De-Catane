import {Component, OnInit} from '@angular/core';
import {ReserveResources} from "../../../reserve-resources";


@Component({
  selector: 'app-reserveview',
  templateUrl: './reserveview.component.html',
  styleUrls: ['./reserveview.component.css']
})
export class ReserveviewComponent implements OnInit {
  resources : ReserveResources = {
    development : 2,
    wood : 18,
    stone : 17,
    brick : 15,
    wool : 12,
    wheat : 14
  }

  constructor() {
  }

  ngOnInit(): void {
  }
}
