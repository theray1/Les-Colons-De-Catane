import {Component, OnInit} from '@angular/core';
import {EventList} from "../../../event-list";

@Component({
  selector: 'app-eventlistview',
  templateUrl: './eventlistview.component.html',
  styleUrls: ['./eventlistview.component.css']
})
export class EventlistviewComponent implements OnInit {
  events = EventList;

  constructor() { }

  ngOnInit(): void {
  }

}
