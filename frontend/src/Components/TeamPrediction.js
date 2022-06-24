import React from "react";
import "../css/MainTeam.css";
import NowRanking from "./NowRanking"
import RankingPrediction from "./RankingPrediction";
import SideBar from "./sidebar";

function TeamPredicion() {
  return (
    <div className="mainteam">
      <div className="mainteam_sidebar">
        <SideBar/>
      </div>
      <div className="mainteam_title">
         KBO 정규리그 현재 & 예측 순위
      </div>
      <div className="mainteam_ranking_title" style={{fontWeight: "bold", color:"white", fontSize: "20px", marginLeft: "35vw", marginTop: "3.5vh"}}>현재 순위<div className="mainteam_ranking_prediction_title" style={{display:"inline-block", fontWeight: "bold", color:"white", fontSize: "20px", marginLeft: "37vw", marginTop: "3.5vh"}}>예측 순위</div></div>
      <div className="mainteam_ranking">
        <NowRanking/>
      </div>
      <div className="mainteam_ranking_prediction">
        <RankingPrediction/>
      </div>
    </div>
  );
}

export default TeamPredicion;