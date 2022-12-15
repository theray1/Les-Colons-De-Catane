import { Component, Input } from '@angular/core';
import { Building } from 'src/app/building';
import { Color } from 'src/app/color';

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent implements Building{
  color: Color | null = null;
  @Input() buildingType: String = "";

  constructor(){}

  
}
