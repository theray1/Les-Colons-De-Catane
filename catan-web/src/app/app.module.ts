import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GameboardComponent } from './gameboard/gameboard.component';
import { BoardComponent } from './gameboard/board/board.component';
import { PlayerinterfaceComponent } from './gameboard/playerinterface/playerinterface.component';
import { OpponentinterfaceComponent } from './gameboard/opponentinterface/opponentinterface.component';
import { TileComponent } from './gameboard/board/tile/tile.component';

@NgModule({
  declarations: [
    AppComponent,
    GameboardComponent,
    BoardComponent,
    PlayerinterfaceComponent,
    OpponentinterfaceComponent,
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
