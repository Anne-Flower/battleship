import { useState } from "react";
import SeaBoard from "./components/SeaBoard";
import usePlaceMissile from "./hooks/usePlaceMissile";
import usePlaceShip from "./hooks/usePlaceShip";
import usePlayerState from "./hooks/usePlayerState";
import Instructions from "./components/Instructions";

const Board = () => {
  const { placeMissile } = usePlaceMissile();
  const { placeShip } = usePlaceShip();
  const [refresh, setRefresh] = useState(0);
  const state = usePlayerState(refresh);

  const handlePlaceMissile = async (coord: string) => {
    await placeMissile(coord);
    setRefresh((r) => r + 1);
  };
  const handlePlaceShip = async (startCoord: string, endCoord: string) => {
    await placeShip(startCoord, endCoord);
    setRefresh((r) => r + 1);
  };

  if (state.status === "error") {
    return <div>There is an error</div>;
  } else {
    return (
      <section className="bg-gradient-to-r flex flex-col from-sky-100 to-indigo-200 py-10 h-screen">
        {/* <h1 className="text-indigo-800 text-4xl font-bold flex justify-center p-24">
        BOARD
      </h1> */}
        <div className="text-indigo-800 flex flex-1 justify-center items-center">
          <Instructions playerState={state} />
        </div>

        <div className="flex flex-row gap-12 justify-center">
          {" "}
          <SeaBoard
            name={"Enemy board"}
            missiles={[]}
            ships={[]}
            onPlaceMissile={handlePlaceMissile}
            onPlaceShip={handlePlaceShip}
          />
          <SeaBoard
            name={"Your board"}
            missiles={state.missiles!}
            ships={state.ships!}
            onPlaceMissile={handlePlaceMissile}
            shipToPlace={state.shipToPlace}
            onPlaceShip={handlePlaceShip}
          />
        </div>
      </section>
    );
  }
};

export default Board;
