import React, {useState, useEffect} from "react";
import axios from '../request';
import "../css/Home.css";

function HomeRanking(props) {

  
 const [game, setGame] = useState(null);
 const [Loading, setLoading] = useState(false);
 const [error, setError] = useState(null);
const RealTitle= ["< 타자 랭킹 >", "< 투수 랭킹 >"]

  const id = Number(props.id);

  const title = [["항목","타율","출루율","장타율","타점","홈런","도루"],
                ["항목","다승","방어율","자책", "세이브","홀드","삼진"]] 

                useEffect(()=>{
                  const URL_link= ["hitter","pitcher"]
                  const fetchTeam = async () => {
                      try {
                          setError(null);
                          setGame(null);
                          setLoading(false)
                          const URL = "/players/" + URL_link[id] + "Ranking"
                          const response = await axios.get(URL);
                          setGame(response.data.data);
                      } catch(e){
                      
                          setError(e);
                
                      }
                      setLoading(false);
                  };
                  
                  fetchTeam()
              }
              
              ,[]);
  function content(id){
      if(id===0){
          return(
          <>
            <tr className="Home_Player_Ranking_Table_Content"><td style={{padding:"10px 10px 10px 10px"}}>1</td><td>{game.top3_Ba[0].name} ({game.top3_Ba[0].ba})</td><td>{game.top3_Obp[0].name} ({game.top3_Obp[0].obp})</td><td>{game.top3_Slg[0].name} ({game.top3_Slg[0].slg})</td><td>{game.top3_Rbi[0].name} ({game.top3_Rbi[0].rbi})</td><td>{game.top3_Homerun[0].name} ({game.top3_Homerun[0].homerun})</td><td>{game.top3_Steal[0].name} ({game.top3_Steal[0].steal})</td></tr>
            <tr className="Home_Player_Ranking_Table_Content"><td style={{padding:"10px 10px 10px 10px"}}>2</td><td>{game.top3_Ba[1].name} ({game.top3_Ba[1].ba})</td><td>{game.top3_Obp[1].name} ({game.top3_Obp[1].obp})</td><td>{game.top3_Slg[1].name} ({game.top3_Slg[1].slg})</td><td>{game.top3_Rbi[1].name} ({game.top3_Rbi[1].rbi})</td><td>{game.top3_Homerun[1].name} ({game.top3_Homerun[1].homerun})</td><td>{game.top3_Steal[1].name} ({game.top3_Steal[1].steal})</td></tr>
            <tr className="Home_Player_Ranking_Table_Content"><td style={{padding:"10px 10px 10px 10px"}}>3</td><td>{game.top3_Ba[2].name} ({game.top3_Ba[2].ba})</td><td>{game.top3_Obp[2].name} ({game.top3_Obp[2].obp})</td><td>{game.top3_Slg[2].name} ({game.top3_Slg[2].slg})</td><td>{game.top3_Rbi[2].name} ({game.top3_Rbi[2].rbi})</td><td>{game.top3_Homerun[2].name} ({game.top3_Homerun[2].homerun})</td><td>{game.top3_Steal[2].name} ({game.top3_Steal[2].steal})</td></tr>
          </>
            )
      }else{
          return(
            <>
            <tr className="Home_Player_Ranking_Table_Content"><td style={{padding:"10px 10px 10px 10px"}}>1</td><td>{game.top3_Win[0].name} ({game.top3_Win[0].win})</td><td>{game.top3_Era[0].name} ({game.top3_Era[0].era})</td><td>{game.top3_Earned_run[0].name} ({game.top3_Earned_run[0].earnedRun})</td><td>{game.top3_Save[0].name} ({game.top3_Save[0].save})</td><td>{game.top3_Hold[0].name} ({game.top3_Hold[0].hold})</td><td>{game.top3_Strikeout[0].name} ({game.top3_Strikeout[0].strikeout})</td></tr>
            <tr className="Home_Player_Ranking_Table_Content"><td style={{padding:"10px 10px 10px 10px"}}>2</td><td>{game.top3_Win[1].name} ({game.top3_Win[1].win})</td><td>{game.top3_Era[1].name} ({game.top3_Era[1].era})</td><td>{game.top3_Earned_run[1].name} ({game.top3_Earned_run[1].earnedRun})</td><td>{game.top3_Save[1].name} ({game.top3_Save[1].save})</td><td>{game.top3_Hold[1].name} ({game.top3_Hold[1].hold})</td><td>{game.top3_Strikeout[1].name} ({game.top3_Strikeout[1].strikeout})</td></tr>
            <tr className="Home_Player_Ranking_Table_Content"><td style={{padding:"10px 10px 10px 10px"}}>3</td><td>{game.top3_Win[2].name} ({game.top3_Win[2].win})</td><td>{game.top3_Era[2].name} ({game.top3_Era[2].era})</td><td>{game.top3_Earned_run[2].name} ({game.top3_Earned_run[2].earnedRun})</td><td>{game.top3_Save[2].name} ({game.top3_Save[2].save})</td><td>{game.top3_Hold[2].name} ({game.top3_Hold[2].hold})</td><td>{game.top3_Strikeout[2].name} ({game.top3_Strikeout[2].strikeout})</td></tr>
            </>
          )
      }
  }
              
  if (Loading) return <div>로딩중..</div>;
  if (error) return <div>에러가 발생했습니다</div>;
  if (!game) return null;
              
        

  return (
    <div>
    <div className="Home_Player_Ranking_Page_Title" style={{fontFamily:"MICEGothic Bold"}}>{RealTitle[id]}</div>
    <div>
      <table style={{borderCollapse:"collapse"}}>
      <div className="Home_Player_Ranking_Table_Total">
      {title[id].map((title) => (
          <th className="Home_Player_Ranking_Table_Title" style={{borderBottom:"2px solid gray",paddingBottom:"0.8vh"}}>{title}</th>
      ))}{content(id)}   </div>
     </table><br></br>
    </div>
    </div>
  );
}

export default HomeRanking;