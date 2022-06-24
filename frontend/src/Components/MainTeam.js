import React from "react";
import SideBar from "./sidebar";
import TeamPrediction from "./TeamPrediction";
import Nav from "./Nav"
import NowRanking from "./NowRanking";

function MainTeam() {
  return (
    <div>
      <Nav/>
      <TeamPrediction/>
    </div>
  );
}

export default MainTeam;