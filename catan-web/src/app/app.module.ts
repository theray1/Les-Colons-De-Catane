import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GameboardComponent } from './gameboard/gameboard.component';
import { BoardComponent } from './gameboard/board/board.component';
import { PlayerinterfaceComponent } from './gameboard/playerinterface/playerinterface.component';
import { OpponentinterfaceComponent } from './gameboard/opponentinterface/opponentinterface.component';
import { TileComponent } from './gameboard/board/tile/tile.component';
import { TestcompComponent } from './testcomp/testcomp.component';
import { InterfaceComponent } from './interface/interface.component';
import { GameviewComponent } from './interface/gameview/gameview.component';
import { PlayerviewComponent } from './interface/playerview/playerview.component';
import { GlobalviewComponent } from './interface/globalview/globalview.component';

@NgModule({
  declarations: [
    AppComponent,
    GameboardComponent,
    BoardComponent,
    PlayerinterfaceComponent,
    OpponentinterfaceComponent,
    TileComponent,
    TestcompComponent,
    InterfaceComponent,
    GameviewComponent,
    PlayerviewComponent,
    GlobalviewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
