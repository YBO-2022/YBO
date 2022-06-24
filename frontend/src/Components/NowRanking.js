import React, {useState, useEffect} from "react";
import axios from '../request';

function NowRanking() {
  const [ranking, setRanking] = useState(null);
  const [Loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  
  useEffect(()=>{
      const fetchTeam = async () => {
          try {
              setError(null);
              setRanking(null);
              setLoading(false)
              const response = await axios.get("/realtime-ranking");

            setRanking(response.data.data);
          } catch(e){
              setError(e);
          }
          setLoading(false);
      };
      
      fetchTeam()
  }

  ,[]);

  const table_title = ["순위","팀","경기","승 - 패 - 무","승률","게임 차","연속"]

  if (Loading) return <div>로딩중..</div>;
  if (error) return <div>에러가 발생했습니다</div>;
  if (!ranking) return null;

  return (
    <div className="Ranking" style={{width: "100px", height: "620px"}}>
        { <table className="Home_Table" style={{backgroundColor: "white", marginlLeft:"auto", marginRight:"auto", borderRadius: "10px 10px", width: "620px",height: "72vh", paddingTop: "5px"}}>
           {table_title.map((title)=>(
               <th className="Home_Table_Title">{title}</th>
           ))}
            {ranking.map((rank)=>(
               <tr className="Table_Content" style={{textAlign: "center"}}>
                   <td>{rank.ranking}</td>
                   <td>{rank.team}</td>
                   <td>{rank.gameNumber}</td>
                   <td>{rank.winNumber} <span>-</span> {rank.loseNumber} <span>-</span> {rank.drawNumber}  </td>
                   <td>{rank.winRate}</td>
                   <td>{rank.gameDiff}</td>
                   <td>{rank.continuity}</td>
               </tr> 
            ))}
        </table> }
    </div>
  );
}

export default NowRanking;