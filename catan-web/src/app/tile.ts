import { TileType } from "./tiletype";
import { Edge } from "./edge";
import { Vertex } from "./vertex";
import { VertexComponent } from "./interface/gameview/vertex/vertex.component";

export interface Tile {
    id: number;
    type: TileType;
    edges: (Edge|null)[];
    vertices: (Vertex|null)[];
    image: String;
    testFunction():void;
}    