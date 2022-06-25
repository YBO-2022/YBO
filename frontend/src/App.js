import './App.css';
import Home from "./Components/Home";
import MainPlayer from "./Components/MainPlayer";
import Player from "./Components/Player";
import MainTeam from "./Components/MainTeam";
import GoldenGlove from "./Components/GoldenGlove";
import Team from "./Components/Team";
import { Route, Routes } from 'react-router-dom';


function App() {

  return (
    <div className="App">
      <Routes>
      <Route path="/" element={<Home/>}/>
      <Route path="/MainPlayer/*" element={<MainPlayer/>}/>
      <Route path="/Player/*" element={<Player/>}/>
      <Route path="/Team/*" element={<Team/>}/>
      <Route path="/MainTeam/*" element={<MainTeam/>}/>
      <Route path="/GoldenGlove" element={<GoldenGlove/>}/>
      <Route path="*" element={"Not Found"}/>
      </Routes>
    </div>
  );
}

export default App;
