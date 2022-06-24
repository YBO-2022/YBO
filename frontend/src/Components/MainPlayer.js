import React from "react";
import Nav from "./Nav";
import ServiceList from "./ServiceList";
import "../css/MainPlayer.css";
import "../font/font.css";


function MainPlayer() {
  return (
    <div>
      <Nav/>
      <div className="Player_Main_Title">
        <h1 className="Big_Title" style={{fontFamily:"MICEGothic Bold"}}>선수 랭킹 확인</h1>
        <h4 className="Small_Content" style={{fontFamily:"NanumBarunGothic"}}>선수들의 현재, 예상 정규 시즌 순위를 확인합니다.</h4>
      </div>
      <div className="service_container">
      <ServiceList id="0" title="OPS"></ServiceList>
      <ServiceList id="2" title="Golden Glove"></ServiceList>
      <ServiceList id="1" title="ERA"></ServiceList>
      </div>
    </div>
  );
}

export default MainPlayer;