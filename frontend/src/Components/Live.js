import React, {useState, useEffect} from "react";
import axios from '../request';
import "../css/Live.css";
import "../font/font.css";

function Live() {

  const [game, setGame] = useState(null);
  const [Loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [code, setCode] = useState(null);

  let now = new Date();
  let today_month = now.getMonth() + 1;
  let today_date =  now.getDate();
  const week = ["일","월","화","수","목","금","토"];
  let dayOfWeek = week[now.getDay()];

  useEffect(()=>{
      const fetchTeam = async () => {
          try {
              setError(null);
              setGame(null);
              setLoading(false)
              const response = await axios.get("/realtime-game");
              setCode(response.data.statusCode)
              setGame(response.data.data);
          } catch(e){
              setError(e);
    
          }
          setLoading(false);
      };
      
      fetchTeam()
  }

  ,[]);

  if (Loading) return <div>로딩중..</div>;
  if (error) return <div>에러가 발생했습니다</div>;
  if (!game) return null;


  function returnLogo(team){
    if(['LG', 'SSG', 'KT'].includes(team)){
      const imgUrl = require("../img/logo/" + team +".png");
      return (<img src={imgUrl} alt={team} style={{height:"40px", width:"80px", marginTop:"1vh"}}/>);
    } else{
      const imgUrl = require("../img/logo/" + team +".jpg");
      return (<img src={imgUrl} alt={team} style={{height:"40px", width:"80px", marginTop:"1vh"}}/>);
    }
  }

  function ShowScore(score){
    if(!score){
      return(
        <>0</>
      ); } else{
        return (
          <>{score}</>
        )
      }
    
  }
  

  function content(){
    if(code === 204){
      return(
        <div className="monday_box">
            <div className="monday">오늘은 경기가 없습니다</div>
        </div>
      );}else{
        return(
         <div>
           {game.map((game,idx)=>(
            <div className="Live_Each">
              <div className="Live_Content">
                <div className="Left_Team">
                  {game.leftTeam} - {game.leftPitcher}
                <div className="left_logo">
                   {returnLogo(game.leftTeam)}
                </div>
                </div>
                <div className="Score_Total">
                  <div className="State">
                    {game.gameState}
                  </div>
                  <div className="Score">
                    {ShowScore(Number(game.leftScore))} : {ShowScore(Number(game.rightScore))}
                  </div>
                </div>
                <div className="Right_Team">
                  {game.rightTeam} - {game.rightPitcher}
                <div className="right_logo">
                  {returnLogo(game.rightTeam)}
                </div>
                </div>
              </div>
            </div>

           ))}
         </div>
        );
      }
    }

  return (
    <div className="Live_Page">
      <div className="Live_Container">
        <h1 style={{fontFamily:"MICEGothic Bold"}}>KBO 정규리그 경기 결과</h1>
        <div className="Live_table">
        <p className="Date"> {today_month}.{today_date} ({dayOfWeek})</p>
        {content()}
        </div>
      </div>
    </div>
  );
}

export default Live;