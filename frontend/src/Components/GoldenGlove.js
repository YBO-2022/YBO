import React from "react";
import GGRanking from "./GGRanking";
import Nav from "./Nav";
import "../css/GoldenGlove.css";
import "../font/font.css";


function GoldenGlove() {

  return (
    <div>
      <Nav/>
      <div className="glove_part">
      <p className="glove_title" style={{fontFamily:"MICEGothic Bold"}}>Golden Glove</p>
      <GGRanking id="1"/>
      <GGRanking id="0"/>
      <GGRanking id="2"/>
      <div className="glove_img">
          <div className="g_one" style={{fontFamily:"NanumBarunGothic"}}><span style={{paddingRight: "20%"}}>좌익수</span> <span style={{paddingRight: "20%"}}>중견수</span> 우익수</div>
          <div className="g_two" style={{fontFamily:"NanumBarunGothic"}}><span style={{paddingRight: "3%"}}>유격수</span> 2루수</div>
          <div className="g_three" style={{fontFamily:"NanumBarunGothic"}}><span style={{paddingRight: "31%"}}>3루수</span> 1루수</div>
          <div className="g_four" style={{fontFamily:"NanumBarunGothic"}}>투수</div>
          <div className="g_five" style={{fontFamily:"NanumBarunGothic"}}><span style={{paddingRight: "10%"}}>포수</span> 지명타자</div>
      </div>
      <br></br><br></br>
      </div>
    </div>
  );
}

export default GoldenGlove;