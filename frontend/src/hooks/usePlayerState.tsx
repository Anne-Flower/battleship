import React, { useState, useEffect } from "react";

function usePlayerState() {
  const [missiles, setMissiles] = useState(null);
  const [ships, setShips] = useState(null);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const abortController = new AbortController();

    const fetchData = async () => {
      try {
        setIsLoading(true);
        setError(null);

        const response = await fetch(`http://localhost:8080/player-state/{id}`, {
          signal: abortController.signal,
        });

        if (!response.ok) {
          throw new Error("Error");
        }

        const data = await response.json();
        setMissiles(data.missiles);
        setShips(data.ships);
      } catch (err: any) {
        if (err.name === "AbortError") return;
        setError(err.message);
      } finally {
        setIsLoading(false);
      }
    };

    fetchData();

    return () => {
      abortController.abort();
    };
  }, []);

  if (isLoading) return <div></div>;
  if (error) return <div>Error : {error}</div>;

  return <div>blo:  {missiles} {ships}</div>;
}

export default usePlayerState;
