import React, {useState, useEffect} from "react";
import axios from '../request';
import "../css/GoldenGlove.css";
import "../font/font.css";

function GGRanking(props) {
  const id = Number(props.id);
  const titles =["ERA","골든글러브","OPS"]
  const table_titles =[["순위","이름","팀","ERA","예측 ERA"],["포지션","이름","팀"],["순위", "이름", "팀","OPS","예측 OPS" ]]

  const [Data, setData] = useState(null);
  const [Loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  useEffect(()=>{
    const URL_Link = ["era","squad","ops"]
      const fetchTeam = async () => {
          try {
              setError(null);
              setData(null);
              setLoading(false);
              const URL =  "/goldenglove/" + URL_Link[id]
              const response = await axios.get(URL);
              setData(response.data.data)

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
  if (!Data) return null;

  function content(id){
    if(id===0){
        return(<>
        {Data.map((data,idx)=>(
             <tr style={{textAlign: "center"}}>
                 <td>{idx +1 }</td>
                 <td>{data.name}</td>
                 <td>{data.team}</td>
                 <td>{data.era}</td>
                 <td>{data.predictEra}</td>
                </tr> 
        ))} </>);}else if(id===1){
            return(
                <>  {Data.map((data)=>(
                    <tr style={{textAlign: "center"}}>
                        <td>{data.position}</td>
                        <td>{data.name}</td>
                        <td>{data.team}</td>
                       </tr> 
               ))}
 </>
            )
        } else {
            return(
                <>  {Data.map((data, idx)=>(
                    <tr style={{textAlign: "center"}}>
                     <td>{idx +1}</td>
                        <td>{data.name}</td>
                        <td>{data.team}</td>
                        <td>{data.ops}</td>
                        <td>{data.predictOps}</td>
                       </tr> 
               ))} </>
            )
        }
  }


  return (
    
        <div>
            <div className="GGRankingTable_title" style={{fontFamily:"NanumBarunGothic"}}>
                {titles[id]}
            </div>
            <table className="GGRankingTable">
                {table_titles[id].map((title)=>(
                    <th style={{verticalAlign:"middle"}}>{title}</th>
                ))}{content(id)}
            </table>
    </div>

  );
}

export default GGRanking;