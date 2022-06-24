import React from "react";
import GGRanking from "./GGRanking";
import Nav from "./Nav";
import "../css/GoldenGlove.css";

function GoldenGlove() {

  return (
    <div>
      <Nav/>
      <div className="glove_part">
      <p className="glove_title">Golden Glove</p>
      <GGRanking id="1"/>
      <GGRanking id="0"/>
      <GGRanking id="2"/>
      <div className="glove_img">
          <div className="g_one"><span style={{paddingRight: "15%"}}>좌익수</span> <span style={{paddingRight: "15%"}}>중견수</span> 우익수</div>
          <div className="g_two"><span style={{paddingRight: "5%"}}>유격수</span> 2루수</div>
          <div className="g_three"><span style={{paddingRight: "30%"}}>3루수</span> 1루수</div>
          <div className="g_four">투수</div>
          <div className="g_five"><span style={{paddingRight: "10%"}}>포수</span> 지명타자</div>
      </div>
      </div>
    </div>
  );
}

export default GoldenGlove;