import React, {useState, useEffect} from "react";
import axios from '../request';

function RankingPrediction() {
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

  const table_title = ["순위","팀","승률"]

  if (Loading) return <div>로딩중..</div>;
  if (error) return <div>에러가 발생했습니다</div>;
  if (!ranking) return null;

  return (
    <div>
        { <table style={{backgroundColor: "white", marginlLeft:"30vw", marginRight:"auto", borderRadius: "10px 10px 10px 10px", width: "400px",height: "72vh", paddingTop: "5px"}}>
           {table_title.map((title)=>(
               <th className="Prediction_Table_Title" style={{verticalAlign:"middle"}}>{title}</th>
           ))}
            {ranking.map((rank)=>(
               <tr className="Prediction_Table_Content" style={{textAlign: "center"}}>
                   <td>{rank.ranking}</td>
                   <td>{rank.team}</td>
                   <td>{rank.winRate}</td>

               </tr> 
            ))}
        </table> }
    </div>
  );
}

export default RankingPrediction;