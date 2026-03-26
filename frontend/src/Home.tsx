import { useNavigate } from "react-router";

function Home() {
  let navigate = useNavigate();
  return (
    <div className="bg-indigo-900 h-screen">
      <header className="App-header">
        <h1 className="font-bold text-4xl pb-12">BATTLESHIP GAME</h1>
        <button className="border border-white p-2 m-2 bg-indigo-950 hover:bg-indigo-100 hover:text-indigo-950" onClick={() => navigate("/board")}>Player 1</button>
        <button className="border border-white p-2 m-2 bg-indigo-950 hover:bg-indigo-100 hover:text-indigo-950" onClick={() => navigate("/board")}>Player 2</button>
      </header>
    </div>
  );
}

export default Home;