import React, {useState, useEffect} from "react";
import axios from '../request';

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
  
console.log(Data)

return (
    <div>
        <span>{titles[id]}</span>
        <table>
        {table_titles.map((title)=><th>{title}</th>)}
  
            {Data.map((dt,idx)=>
                  <tr>
            <td>{idx+1}</td>
            <td>{dt.name}</td>
            <td>{dt.war}</td>

            </tr>
            )}
        

        </table>
    </div>
  );
}

export default War;