import { TileType } from "./tiletype";
import { Edge } from "./edge";
import { Vertex } from "./vertex";

export interface Tile {
    id: number;
    type: TileType;
    edges: Edge[];
    vertices: Vertex[];
}