import React from "react";

import type { PlayerState } from "../hooks/usePlayerState";

type InstructionsProps = {
  playerState: PlayerState;
};

const Instructions = ({ playerState }: InstructionsProps) => {
  if (playerState.gameState === "PLACE_SHIP") {
    return (
      <section className="flex flex-col gap-2 font-bold">
        <h1 className="text-4xl">Place your ship ⛵️</h1>
        <div className="text-2xl">Type : {playerState.shipToPlace?.name}</div>
        <div className="text-2xl">Size : {playerState.shipToPlace?.cells}</div>
      </section>
    );
  }
  return (
    <section className="flex flex-col gap-2">
      <h1 className="text-4xl font-bold">Place your missile 🚀</h1>
    </section>
  );
};

export default Instructions;
