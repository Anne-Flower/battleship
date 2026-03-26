export type Missile= [number, number];
 
export type Coordinates = [number, number];

export type Ship = {
  cells: number,
  name: string
};

export type ShipInfo = {
  ship: Ship,
  parts: Coordinates[]
}
