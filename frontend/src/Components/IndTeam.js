import "../css/Team.css";
import React, {useState, useEffect} from "react";
import axios from '../request';
import SideBar from "./sidebar";
import War from "./War";
import Graph from "./Graph";
import TeamBar from "./TeamBar";
import "../font/font.css";

function IndTeam(props) {
  const id = Number(props.id);
  const Team_Arr = ["KIA","롯데","삼성","두산","LG","SSG","한화","키움","NC","kt" ];
  const [Data, setData] = useState(null);
  const [Loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  useEffect(()=>{

    const fetchTeam = async () => {
        try {
            setError(null);
            setData(null);
            setLoading(false);
            const URL = "/teams/" + id + "/firstTeam"
            const response = await axios.get(URL);
            setData(response.data.data)

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
if (!Data) return null;

  function wordcloud(){
    const imgURL = require("../img/WC/" + Team_Arr[id] + ".png")
    return(
      <>
      <img src={imgURL} style={{width:"445px", height:"450px"}} alt={Team_Arr[id]}/>
      </>
    );
  }

  function mention(){
    const imgURL = require("../img/그래프/" + Team_Arr[id] + ".png")
    return(
      <>
      <img src={imgURL} alt={Team_Arr[id]} style={{width:"1200px",position:"relative", marginLeft:"250px"}}/>
      </>
    );
  }
  return (
    <div className="IndTeam_part">
      <div className="IndTeam_sidebar">
        <SideBar/>
      </div>
      <TeamBar team_id={id}/>
      <Graph team_id={id}/>
      <div className="mention_container">
      <div className="mention_title" style={{fontFamily:"MICEGothic Bold"}}>
        팀별 언급량
      </div>

        {mention()}
      </div>
      <div className="main_player_container">
       
      <div className="main_player_title" style={{fontFamily:"MICEGothic Bold"}}>
         주전
      </div>
        <div className="main_player_img_box">
          <div className="one" style={{fontFamily:"NanumBarunGothic"}}><span style={{paddingRight: "15%"}}>{Data.lf}</span> <span style={{paddingRight: "15%"}}>{Data.cf}</span> {Data.rf}</div>
          <div className="two" style={{fontFamily:"NanumBarunGothic"}}><span style={{paddingRight: "5%"}}>{Data.ss}</span>{Data.sb}</div>
          <div className="three" style={{fontFamily:"NanumBarunGothic"}}><span style={{paddingRight: "30%"}}>{Data.tb}</span>{Data.fb}</div>
          <div className="four" style={{fontFamily:"NanumBarunGothic"}}>{Data.p}</div>
          <div className="five" style={{fontFamily:"NanumBarunGothic"}}><span style={{paddingRight: "10%"}}>{Data.c}</span> {Data.dh}</div>
        </div>
      </div>

      <div className="wordcloud_title" style={{fontFamily:"MICEGothic Bold"}}>
        팀별 여론
      </div>
      <div className="wordcloud_container">
        {wordcloud()}
      </div>
      <War id="0" team_id={id}/>
      <War id="1" team_id={id}/>
    </div>
    
  );
}

export default IndTeam;