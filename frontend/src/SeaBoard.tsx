import React from "react";

const SeaBoard = () => {
  const letters = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];

  return (
    <>
      <h1 className="text-indigo-800 text-4xl font-bold flex justify-center p-24">
        BOARD
      </h1>
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

          {letters.map((letter) => (
            <>
              <div
                key={letter}
                className="w-12 h-12 border border-black flex items-center justify-center"
              >
                {letter}
              </div>

              {letters.map((letter, index) => (
                <div
                  key={letter + index}
                  className="w-12 h-12 border border-black"
                ></div>
              ))}
            </>
          ))}
        </section>
      </div>
    </>
  );
};

export default SeaBoard;
