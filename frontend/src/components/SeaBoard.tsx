import { useState } from "react";
import type {
  Coordinates,
  Missile,
  Ship,
  ShipInfo,
} from "../types/SeaBoardTypes";

type SeaBoardProps = {
  name: string;
  missiles: Missile[];
  ships: ShipInfo[];
  onPlaceMissile: (coord: string) => void;
  shipToPlace?: Ship;
  onPlaceShip: (startCoord: string, endCoord: string) => void;
};

type SeaBoardState = "PLACE_SHIP_START" | "PLACE_SHIP_END" | "PLACE_MISSILE";

function isShip(coord: Coordinates, ships: ShipInfo[]) {
  for (const shipInfo of ships) {
    for (const part of shipInfo.parts) {
      if (part[0] === coord[0] && part[1] === coord[1]) {
        return true;
      }
    }
  }
  return false;
}

function isMissile(coord: Coordinates, missiles: Missile[]) {
  for (const missile of missiles) {
    if (missile[0] === coord[0] && missile[1] === coord[1]) {
      return true;
    }
  }
  return false;
}

function coordEqual(a: Coordinates, b: Coordinates) {
  return a[0] === b[0] && a[1] === b[1];
}
function isCoule(ship: ShipInfo, missiles: Missile[]) {
  for (const part of ship.parts) {
    if (!isMissile(part, missiles)) {
      return false
    }
  }
  return true;
}

const colors = {
  touche: "bg-red-500",
  coule: "bg-black",
  missed: "bg-sky-500",
  startCoord: "bg-gray-600",
};

function getCaseColor(
  coord: Coordinates,
  stringCoord: string,
  ships: ShipInfo[],
  missiles: Missile[],
  startCoord?: string
) {
  if (startCoord === stringCoord) {
    return colors.startCoord;
  } else if (isMissile(coord, missiles) && isShip(coord, ships)) {
    return colors.touche;
  } else if (isMissile(coord, missiles) && !isShip(coord, ships)) {
    return colors.missed;
  } else if (isShip(coord, ships)) {
    return "";
  }
}

// function placeMissile( letter: string, num: number ) {
//   const coord = letter + num;
//   console.log(coord);
// }

const boatImage = `${process.env.PUBLIC_URL}/images/boat.png`;
const skullImage = `${process.env.PUBLIC_URL}/images/skull.png`;

function getShipImage(coord: Coordinates, ships: ShipInfo[], missiles: Missile[]) {
  const _ship = ships.find(ship => ship.parts.some(part => coordEqual(part, coord)))!
  if (isCoule(_ship, missiles)) {
    return skullImage
  }
  return boatImage
}


function getInternalState({
  shipToPlace,
  startCoord,
}: {
  shipToPlace?: Ship;
  startCoord?: string;
}) {
  if (shipToPlace) {
    if (startCoord) {
      return "PLACE_SHIP_END";
    }
    return "PLACE_SHIP_START";
  }
  return "PLACE_MISSILE";
}

const SeaBoard = ({
  name,
  missiles,
  ships,
  onPlaceMissile,
  shipToPlace,
  onPlaceShip,
}: SeaBoardProps) => {
  const [startCoord, setStartCoord] = useState<string>();

  const letters = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
  const internalState = getInternalState({ shipToPlace, startCoord });

  function onCellClick(coord: string) {
    if (internalState === "PLACE_MISSILE") {
      return onPlaceMissile(coord);
    } else if (internalState === "PLACE_SHIP_START") {
      setStartCoord(coord);
    } else if (internalState === "PLACE_SHIP_END") {
      onPlaceShip(startCoord!, coord);
      setStartCoord(undefined);
    }
  }

  return (
    <>
      <div className="pt-16">
        <h1 className="text-indigo-800 text-2xl font-semibold pb-4">{name}</h1>
        <div className="flex justify-center bg-violet-50">
          <section className="grid grid-cols-11 w-[510px]">
            <div className="w-12 h-12"></div>

            {letters.map((letter, index) => (
              <div
                key={index}
                className="w-12 h-12 border border-black flex items-center justify-center"
              >
                {index + 1}
              </div>
            ))}

            {letters.map((letter, i) => (
              <>
                <div
                  key={letter}
                  className="w-12 h-12 border border-black flex items-center justify-center"
                >
                  {letter}
                </div>

                {letters.map((_, j) => (
                  <div
                    key={letter + j}
                    className={`w-12 h-12 border border-black hover:bg-gray-400 ${getCaseColor([i, j], letter + (j + 1), ships, missiles, startCoord)}`}
                    onClick={() => onCellClick(letter + (j + 1))}
                  >
                    {isShip([i, j], ships) ? (
                      <img alt="boat" src={getShipImage([i,j], ships, missiles)}></img>
                    ) : (
                      <div></div>
                    )}
                  </div>
                ))}
              </>
            ))}
          </section>
        </div>
      </div>
    </>
  );
};

export default SeaBoard;
