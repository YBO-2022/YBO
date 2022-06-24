import React from "react";
import "../css/Home.css";
import Nav from "./Nav";
import NowRanking from "./NowRanking"
import {NavLink} from "react-router-dom";
import { Button} from 'react-bootstrap';
import Graph from "../img/MainPageGraph.jpg";
import Live from "./Live"
import HomeRanking from "./HomeRanking";
import "../css/Team.css";
import "../font/font.css";

function Home() {
  const Team_Arr = ["KIA","롯데","삼성","두산","LG","SSG","한화","키움","NC","kt"];

  return (
    <div  style={{overflowX: 'hidden'}}>
     <div className="intro" style={{overflowX: 'hidden'}}>
      <Nav/>                 
       <div className="intro_text_top">
          <h1 style={{fontFamily:"MICEGothic Bold"}}>KBO 정규리그 <br/> 현재 순위</h1>
          <h4 style={{fontFamily:"LeferiPoint-WhiteObliqueA"}}>2022 KBO 정규리그 10개 팀의 승률입니다. <br /> 각 팀을 누르면 팀별 페이지로 이동합니다.</h4>

          <h4 style={{fontFamily:"LeferiPoint-WhiteObliqueA"}}>팀 페이지에서 원하는 TEAM의 기간별 언급량 및 <br /> 예측 순위를 확인할 수 있습니다.</h4>

          <h4 style={{fontFamily:"LeferiPoint-WhiteObliqueA"}}>☞ MY TEAM으로 이동해 보세요</h4>
          <div className="teamcontainer">
              {Team_Arr.map((team,idx)=> (
            
                  <NavLink to={`/Team/${idx}`} key={idx} style={{ textDecoration: 'none'}}>
                     <Button className="teamselect" style={{fontFamily:""}}> {team} </Button>
                  </NavLink>
           
            ))}</div>
            <div className="Home_Ranking">
            <NowRanking/>
            </div>
      </div>    
    </div>
    <Live/>
    <div className="Home_Player_Ranking_Page">
          <HomeRanking id="0"/>
          <HomeRanking id="1"/>
    </div>
    <div className="intro_Container">
        <div className="intro_text">
            <h1>KBO 리그 순위 예측</h1>
            <h4>팀별 정규시즌 순위 예측과 <br/>선수별 OPS, ERA를 예측합니다</h4>
            <NavLink to="/MainTeam">
                <Button className="to_team">Team</Button>
            </NavLink>
            <NavLink to="/MainPlayer">
                <Button className="to_player">Player</Button>
            </NavLink>
        </div>
        <div className="intro_img">
            <img className="MainPageGraph" src={Graph} alt="graph"/>
        </div>
    </div>
 
    </div>
  );
}

export default Home;