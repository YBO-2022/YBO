import React, {useState, useEffect} from "react";
import axios from '../request';
import Nav from "./Nav";
import { useLocation } from 'react-router-dom';
import {NavLink} from "react-router-dom";
import "../css/Player.css";

function Player() {

 const location = useLocation();
 const id = Number(location.pathname.split("/")[2]);

 const [game, setGame] = useState(null);
 const [Loading, setLoading] = useState(false);
 const [error, setError] = useState(null);

  const Player_Arr = ["OPS","ERA"];
  const Player_Arr_ = ["ops","era"];
  const title = ["OPS (출루율 + 장타율)", "ERA (평균 자책점)"]
  const desc = ["'On-Base Plus Slugging' \n출루율과 장타율을 더한 값으로, 득점에 많이 공헌하는 타자를 알 수 있습니다. \n\n출루율은 (안타 + 볼넷 + 몸에 맞는 공) / (타수 + 볼넷 + 몸에 맞는 공 + 희생플라이) 로 정의되고, \n장타율 = (단타 + 2루타X2 +3루타X3 + 홈런X4) 를 타수로 나눈 값입니다.",
  "투수를 평가하는 지표 중 하나, '방어율'이라고 한다. 1경기당 9이닝으로 볼때의 1경기에서 얼마나 점수를 내줄 수 있느냐를 판단할 수 있다.\n투수의 9이닝 당 자책점으로 나타내며 (9 * 자책점) / 투구이닝 으로 계산한다. \n\n만약 투수가 아웃 카운트를 한 번도 잡지 못한 채 자책점만 내준다면 그 선수의 평균자책점은 원칙적으로 다음 경기에서 투구 이닝이 추가될 때까지 계산이 유보되어 \n해당 투수의 평균자책점 자체가 정의되지 않거나 무한대(∞)가 되지만  경기장 전광판이나 기록에서는 편의상 0.00으로 기록된다."]

  const move_id = ((id+1) % 2)
  const ranking_titles =[["", "이름", "팀", "OPS", "게임수", "타석", "타율","안타", "홈런", "타점", "도루", "삼진" ,"병살" ,"WAR"],
  ["","이름", "팀", 'ERA', '승', '패', '이닝', '실점', '자책','피안타','홈런', '볼넷', '삼진', 'WAR']]

  useEffect(()=>{
    const fetchTeam = async () => {
        try {
            setError(null);
            setGame(null);
            setLoading(false)
            const Url = "/players/" + Player_Arr_[id]
            const response = await axios.get(Url);
            console.log(Url)
            setGame(response.data.data);
        } catch(e){
        
            setError(e);
  
        }
        setLoading(false);
    };
    
    fetchTeam()
}

,[id]);


if (Loading) return <div>로딩중..</div>;
if (error) return <div>에러가 발생했습니다</div>;
if (!game) return null;

function content(id){
  if(id===0){
    return(<>
    {game.map((rank,idx)=>(
         <tr style={{textAlign: "center", verticalAlign: "middle", lineHeight:"300%", fontSize:"18px"}}>
          <td className="Player_Table_Content">{idx+1}</td>
          <td className="Player_Table_Content">{rank.name}</td>
          <td className="Player_Table_Content">{rank.team}</td>
          <td className="Player_Table_Content">{rank.ops}</td>
          <td className="Player_Table_Content">{rank.games}</td>
          <td className="Player_Table_Content">{rank.pa}</td>
          <td className="Player_Table_Content">{rank.ba}</td>
          <td className="Player_Table_Content">{rank.hit}</td>
          <td className="Player_Table_Content">{rank.homerun}</td>
          <td className="Player_Table_Content">{rank.rbi}</td>
          <td className="Player_Table_Content">{rank.steal}</td>
          <td className="Player_Table_Content">{rank.strikeout}</td>
          <td className="Player_Table_Content">{rank.dp}</td>
          <td className="Player_Table_Content">{rank.war}</td>
            </tr> 
    ))} </>);}
  else{
    return(
      <>
      {game.map((rank,idx)=>(
       <tr style={{textAlign: "center", verticalAlign: "middle", lineHeight:"300%", fontSize:"18px"}}>
       <td className="Player_Table_Content">{idx+1}</td>
       <td className="Player_Table_Content">{rank.name}</td>
       <td className="Player_Table_Content">{rank.team}</td>
       <td className="Player_Table_Content">{rank.era}</td>
       <td className="Player_Table_Content">{rank.win}</td>
       <td className="Player_Table_Content">{rank.lose}</td>
       <td className="Player_Table_Content">{rank.inning}</td>
       <td className="Player_Table_Content">{rank.runs}</td>
       <td className="Player_Table_Content">{rank.earnedRun}</td>
       <td className="Player_Table_Content">{rank.hit}</td>   
       <td className="Player_Table_Content">{rank.homerun}</td>
       <td className="Player_Table_Content">{rank.bb}</td>
       <td className="Player_Table_Content">{rank.strikeout}</td>
       <td className="Player_Table_Content">{rank.war}</td>
 
                        </tr> 
                ))} </>
    );
  }
}


  return (
    <div style={{backgroundColor:"#EBEFF7", backgroundSize:"cover", height:"100%"}}>
      <Nav/>
        <div className="Page_Player">
          <div className="player_info">
            <span className="other_player" style={{fontSize:"18px"}}><NavLink to={`/Player/${move_id}`} className="linktootherside" style={{textDecoration:"None", fontSize: "18px", color:"black"}} > {Player_Arr[move_id]} 보러가기</NavLink> </span>
            <p style={{position:"relative", top:"8px"}}>
            <p className="player_title" style={{fontFamily:"MICEGothic Bold"}}>{title[id]}</p>
            <p style={{whiteSpace: "pre-wrap" , lineHeight:"150%", fontFamily:"MICEGothic Bold"}}>{desc[id]}</p>
          </p>
          </div>
          <div>
          {
            <table  style={{backgroundColor: "white", marginlLeft:"auto", marginRight:"auto", borderRadius: "10px 10px", width: "80vw", paddingTop: "15px", borderCollapse:"collapse", position:"relative", left:"7.6vw", top:"2.3vh", marginBottom: "6vh"}}>
              <thead>
          {ranking_titles[id].map((title) => (
              <th className="Player_Table_Title">{title}</th>
          ))}</thead> <tbody>
               {content(id)}
                </tbody>
            </table>
          }
          <br/>
          </div>
          </div>
    </div>
  );
}

export default Player