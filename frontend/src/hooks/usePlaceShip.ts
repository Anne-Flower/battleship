import { useState } from "react";

function usePlaceShip() {
  const [status, setStatus] = useState<"ready" | "loading" | "error">("ready");
  const [error, setError] = useState<string | null>(null);

  const placeShip = async (startCoord: string, endCoord: string) => {
    try {
      setStatus("loading");
      setError(null);

      const response = await fetch("http://localhost:8080/placeShip", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({start: startCoord, end: endCoord}),
      });

      if (!response.ok) {
        throw new Error("Error");
      }

      setStatus("ready");
    } catch (err: any) {
      setStatus("error");
      setError(err.message);
    }
  };

  return { placeShip, status, error };
}

export default usePlaceShip;