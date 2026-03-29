package com.example.battleship;

import java.util.ArrayList;
import java.util.List;

enum GameState {
  PLACE_SHIP, PLAYER_ONE_TURN, PLAYER_TWO_TURN, GAME_END
}

public class PlayerState {
  GameState gameState = GameState.PLACE_SHIP;
  SeaBoard seaBoard;
  ArrayList<Ship> shipsToPlace = new ArrayList<>();

  public PlayerState() {
    this.seaBoard = new SeaBoard();
    // shipsToPlace.add( new Ship(5, "Aircraft Carrier"));
    // shipsToPlace.add( new Ship(4, "Battleship"));
    // shipsToPlace.add( new Ship(3, "Submarine"));
    shipsToPlace.add( new Ship(3, "Cruiser"));
    shipsToPlace.add( new Ship(2, "Destroyer"));

  }

  public GameState getGameState() {
    return this.gameState;
  }

  public Ship getShipToPlace() {
    if (shipsToPlace.size() == 0) {
      return null;
    }
    return shipsToPlace.getFirst();
  }

  public void placeShip( int[] coordStart, int[] coordEnd) {
    Ship ship = shipsToPlace.getFirst();
    this.seaBoard.placeShip(ship, coordStart, coordEnd);
    shipsToPlace.removeFirst();
    if (shipsToPlace.size() == 0) {
      this.gameState = GameState.PLAYER_ONE_TURN;
    }
  }

  public ArrayList<int[]> getMissiles() {
    return this.seaBoard.missiles;
  }

  public List<ShipInfo> getShips() {
    return this.seaBoard.ships;
  }
}
