import React, {useState, useEffect} from "react";
import axios from '../request';
import GGRanking from "./GGRanking";
import Nav from "./Nav";
import "../css/GoldenGlove.css";
import "../font/font.css";


function GoldenGlove() {
  const [Data, setData] = useState(null);
  const [Loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  useEffect(()=>{
      const fetchTeam = async () => {
          try {
              setError(null);
              setData(null);
              setLoading(false);
              const URL =  "/goldenglove/squad" 
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

  return (
    <div>
      <Nav/>
      <div className="glove_part">
      <p className="glove_title" style={{fontFamily:"MICEGothic Bold"}}>Golden Glove</p>
      <GGRanking id="1"/>
      <GGRanking id="0"/>
      <GGRanking id="2"/>
      <div className="glove_img">
          <div className="g_one" style={{fontFamily:"NanumBarunGothic"}}><span style={{paddingRight: "20%"}}>{Data[6].name}</span> <span style={{paddingRight: "20%"}}>{Data[4].name}</span> {Data[8].name}</div>
          <div className="g_two" style={{fontFamily:"NanumBarunGothic"}}><span style={{paddingRight: "3%"}}>{Data[9].name}</span>{Data[1].name}</div>
          <div className="g_three" style={{fontFamily:"NanumBarunGothic"}}><span style={{paddingRight: "31%"}}>{Data[2].name}</span> {Data[0].name}</div>
          <div className="g_four" style={{fontFamily:"NanumBarunGothic"}}>{Data[7].name}</div>
          <div className="g_five" style={{fontFamily:"NanumBarunGothic"}}><span style={{paddingRight: "10%"}}>{Data[3].name}</span> {Data[5].name}</div>
      </div>
      <br></br><br></br>
      </div>
    </div>
  );
}

export default GoldenGlove;