import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InterfaceComponent } from './interface/interface.component';
import { GameviewComponent } from './interface/gameview/gameview.component';
import { PlayerviewComponent } from './interface/playerview/playerview.component';
import { GlobalviewComponent } from './interface/globalview/globalview.component';
import { TileComponent } from './interface/gameview/tile/tile.component';


@NgModule({
  declarations: [
    AppComponent,
    InterfaceComponent,
    GameviewComponent,
    PlayerviewComponent,
    GlobalviewComponent,
    TileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
