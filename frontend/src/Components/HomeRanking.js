import React, {useState, useEffect} from "react";
import axios from '../request';
import "../css/Home.css";

function HomeRanking(props) {

  
 const [game, setGame] = useState(null);
 const [Loading, setLoading] = useState(false);
 const [error, setError] = useState(null);
const RealTitle= ["< 타자 랭킹 >", "< 투수 랭킹 >"]

  const id = Number(props.id);
  const title = [["항목","타율","출루율","장타율","타점","득점","홈런","도루"],
                ["항목","다승","세이브","홀드","삼진","방어율"]] 

                useEffect(()=>{
                  const fetchTeam = async () => {
                      try {
                          setError(null);
                          setGame(null);
                          setLoading(false)
                          const response = await axios.get("/realtime-ranking");
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
            <tr className="Home_Player_Ranking_Table_Content"><td style={{padding:"10px 10px 10px 10px"}}>1</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td></tr>
            <tr className="Home_Player_Ranking_Table_Content"><td style={{padding:"10px 10px 10px 10px"}}>1</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td></tr>
            <tr className="Home_Player_Ranking_Table_Content"><td style={{padding:"10px 10px 10px 10px"}}>1</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td></tr>
            </>
            )
      }else{
          return(
            <>
            <tr className="Home_Player_Ranking_Table_Content"><td style={{padding:"10px 10px 10px 10px"}}>1</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td></tr>
            <tr className="Home_Player_Ranking_Table_Content"><td style={{padding:"10px 10px 10px 10px"}}>1</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td></tr>
            <tr className="Home_Player_Ranking_Table_Content"><td style={{padding:"10px 10px 10px 10px"}}>1</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td><td>김광현(0.789)</td></tr>
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