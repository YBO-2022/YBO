import React, {useState, useEffect} from "react";
import axios from '../request';
import "../css/War.css";
import "../font/font.css";


function War(props) {

    const id = Number(props.id);
    const team_id = Number(props.team_id);
    const titles =["WAR TOP 5","WAR WORST 5"]
    const table_titles =["순위","이름","WAR" ]
  
    const [Data, setData] = useState(null);
    const [Loading, setLoading] = useState(false);
    const [error, setError] = useState(null);
  
    useEffect(()=>{
        const fetchTeam = async () => {
            try {
                setError(null);
                setData(null);
                setLoading(false);
                const URL =  "/teams/" + props.team_id + "/war"
                const response = await axios.get(URL);
                if(id===0){setData(response.data.data.warTop5)}else{setData(response.data.data.warLow5)}

            } catch(e){
                setError(e);
      
            }
            setLoading(false);
        };
        
        fetchTeam()
    }
  
    ,[team_id]);
  
    if (Loading) return <div>로딩중..</div>;
    if (error) return <div>에러가 발생했습니다</div>;
    if (!Data) return null;
  

return (
    <div>
         <span className="war_title" style={{fontFamily:"MICEGothic Bold"}}>{titles[id]}</span>
        <table className="war_table">
        {table_titles.map((title)=><th style={{verticalAlign:"middle", borderBottom:"2px solid gray",paddingBottom:"0.8vh", fontSize:"17px", fontWeight:"bold"}}>{title}</th>)}
  
            {Data.map((dt,idx)=>
                  <tr style={{textAlign: "center", fontWeight:"bold"}}>
            <td>{idx+1}</td>
            <td>{dt.name}</td>
            <td>{dt.war}</td>

            </tr>
            )}
        </table>
        <br></br><br></br>
    </div>
  );
}

export default War;