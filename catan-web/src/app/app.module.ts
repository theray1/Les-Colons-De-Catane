import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InterfaceComponent } from './interface/interface.component';
import { GameviewComponent } from './interface/gameview/gameview.component';
import { PlayerviewComponent } from './interface/playerview/playerview.component';
import { GlobalviewComponent } from './interface/globalview/globalview.component';
import { TileComponent } from './interface/gameview/tile/tile.component';
import { PlayerresourcesviewComponent } from './interface/playerview/playerresourcesview/playerresourcesview.component';
import { PlayeractionsviewComponent } from './interface/playerview/playeractionsview/playeractionsview.component';
import { EventlistviewComponent } from './interface/globalview/eventlistview/eventlistview.component';
import { PlayerstateviewComponent } from './interface/globalview/playerstateview/playerstateview.component';
import { EdgeComponent } from './interface/gameview/tile/edge/edge.component';
import { VertexComponent } from './interface/gameview/tile/vertex/vertex.component';


@NgModule({
  declarations: [
    AppComponent,
    InterfaceComponent,
    GameviewComponent,
    PlayerviewComponent,
    GlobalviewComponent,
    TileComponent,
    PlayerresourcesviewComponent,
    PlayeractionsviewComponent,
    EventlistviewComponent,
    PlayerstateviewComponent,
    EdgeComponent,
    VertexComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
