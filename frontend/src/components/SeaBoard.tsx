import React from "react";
import type {Coordinates, Missile, ShipInfo} from '../types/SeaBoardTypes'

type SeaBoardProps = {
  name: string,
  missiles: Missile[],
  ships: ShipInfo[]
}

function isShip= (coord: Coordinates, ships: ShipInfo[]) => {return true;};
function isMissile= (coord: Coordinates, missiles: Missile[]) => {return true;};

const SeaBoard = ({ name, missiles, ships }: SeaBoardProps) => {
  const letters = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];

  return (
    <>
      <div>
        <h1 className="text-indigo-800 text-2xl font-semibold pb-4">{name}</h1>
        <div className="flex justify-center">
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

                {letters.map((letter, j) => (
                  <div
                    key={letter + j}
                    className="w-12 h-12 border border-black"
                  >{i} {j}</div>
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
