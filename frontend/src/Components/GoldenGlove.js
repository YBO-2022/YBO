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

      </div>
    </div>
  );
}

export default GoldenGlove;