import React, {useState, useEffect} from "react";
import axios from '../request';
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip} from "recharts";
 
function Graph(props) {

  const team_id = Number(props.team_id);
  const color = ["#C70125","#002955","#074CA1","#131230" ,"#C30452","#FF0000","#FF6600","#820024","#315288","#000000"];
  const [Data, setData] = useState(null);
  const [Loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  
  useEffect(()=>{

    const fetchTeam = async () => {
        try {
            setError(null);
            setData(null);
            setLoading(false);
            const URL = "/teams/" + team_id + "/rankingHistory"
            const response = await axios.get(URL);
            setData(response.data.data)

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
    <div style={{width:"70vw", marginLeft:"250px",position:"relative", top:"-70vh"}}>
      <p style={{clear:"both", marginLeft:"250px", color:"black",fontWeight:"bold", textAlign:"center", fontSize:"20px"}}>역대 팀 순위</p>
    <LineChart style={{position:"relative", marginLeft:"250px"}}
      width={1200}
      height={300}
      data={Data}>
      <CartesianGrid strokeDasharray="3 3" />
      <XAxis dataKey="year"/>
      <YAxis reversed="True" interval={0} domain={[1,10]}/>
      <Tooltip />
      <Line type="monotone" dataKey="ranking" stroke={color[team_id]} />
    </LineChart>
    </div>
  );
}


export default Graph;