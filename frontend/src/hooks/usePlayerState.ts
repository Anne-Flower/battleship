import React, { useState, useEffect } from "react";
import { Missile, Ship, ShipInfo } from "../types/SeaBoardTypes";

export type PlayerState = {
  status: "loading" | "error" | "success"
  missiles: Missile[]
  ships: ShipInfo[]
  error?: string
  shipToPlace?: Ship
  gameState: "PLACE_SHIP" | "PLAYER_ONE_TURN" | "PLAYER_TWO_TURN" | "GAME_END" | "ERROR "
}

function usePlayerState(refresh: number): PlayerState {

  const [missiles, setMissiles] = useState([]);
  const [ships, setShips] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState(false);
  const [gameState, setGameState] = useState<PlayerState["gameState"]>("PLACE_SHIP");
  const [shipToPlace, setShipToPlace] = useState();


  useEffect(() => {
    const abortController = new AbortController();

    const fetchData = async () => {
      try {
        setIsLoading(true);
        setError(false);

        const response = await fetch(
          `http://localhost:8080/player-state/1`,
          {
            signal: abortController.signal,
          },
        );

        if (!response.ok) {
          throw new Error("Error");
        }

        const data = await response.json();
        
        setMissiles(data.missiles);
        setShips(data.ships);
        setGameState(data.gameState);
        setShipToPlace(data.shipToPlace);
      } catch (err: any) {
        if (err.name === "AbortError") return;
        setError(true);
      } finally {
        setIsLoading(false);
      }
    };

    fetchData();

    return () => {
      abortController.abort();
    };
  }, [refresh]);

  if (error) {
    return { status: "error",missiles: [], ships: [], error: "An error occured", gameState: "ERROR " };
  } else {
    return {
      status: isLoading ? "loading" : "success",
      missiles: missiles,
      ships: ships,
      gameState,
      shipToPlace,
    };
  }
}

export default usePlayerState;
