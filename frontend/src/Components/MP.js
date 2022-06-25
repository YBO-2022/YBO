import React, {useState, useEffect} from "react";
import axios from '../request';

function MP(props){

    const id = Number(props.id);
    const [Data, setData] = useState(null);
    const [Loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

  useEffect(()=>{

      const fetchTeam = async () => {
          try {
              setError(null);
              setData(null);
              setLoading(false);
              const URL = "/teams/" + props.team_id + "/teamInfo"
              const response = await axios.get(URL);
              setData(response.data.data)

          } catch(e){
              setError(e);
    
          }
          setLoading(false);
      };
      
      fetchTeam()
  }

  ,[Number(props.team_id)]);

  if (Loading) return <div>로딩중..</div>;
  if (error) return <div>에러가 발생했습니다</div>;
  if (!Data) return null;

    const title = ["역대 우승 횟수", "현재 순위", "시즌 최고 순위","시즌 최저 순위"];
    const URL = ["트로피","현재순위","최고","최저"];
    const desc =[Data.victory_num.victoryNum,Data.realtime_ranking,Data.season_high_low.seasonHigh,Data.season_high_low.seasonLow]

    return(
            <div className="Team_First_Info_Container">
            <div className="Team_First_logo_container">
            <img className="Team_First_logo" src={require("../img/" + URL[id] + ".png")} style={{width:"4.5vh", height:"4.5vh"}} alt=""/>
            </div>
            <div className="Team_First_Info" style={{fontFamily:"NanumBarunGothic"}}>{title[id]} <br/> <span style={{color: "#3C64B1", lineHeight:"3.5vh",fontFamily:"NanumBarunGothic"}}>{desc[id]}</span> </div>
            </div>
        )
    }export default MP;