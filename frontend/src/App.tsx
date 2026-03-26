import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Board from "./Board";
import Home from "./Home";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/board" element={<Board />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
