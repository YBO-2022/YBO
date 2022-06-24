import React from "react";
import "../css/Team.css";
import SideBar from "./sidebar";
import win from "../img/트로피.png";
import top from "../img/최고.png"
import worst from "../img/최저.png"
import now from "../img/현재순위.png"

function IndTeam(props) {

  const Team_Arr = ["KIA","롯데","삼성","두산","LG","SSG","한화","키움","NC","kt" ]
  function wordcloud(){
    const imgURL = require("../img/WC/" + Team_Arr[Number(props.id)] + ".png")
    return(
      <>
      <img src={imgURL} style={{width:"445px", height:"430px"}}alt={Team_Arr[Number(props.id)]}/>
      </>
    );
  }

  function mention(){
    const imgURL = require("../img/그래프/" + Team_Arr[Number(props.id)] + ".png")
    return(
      <>
      <img src={imgURL} alt={Team_Arr[Number(props.id)]} style={{width:"70vw", marginLeft:"7vw"}}/>
      </>
    );
  }
  return (
    <div className="IndTeam_part">
      <div className="IndTeam_sidebar">
        <SideBar/>
      </div>
      <div className="Team_First">

        <div className="Team_First_Info_Container">
        <div className="Team_First_logo_container">
         <img className="Team_First_logo" src={win} style={{width:"4.5vh", height:"4.5vh"}} alt=""/>
        </div>
        <div className="Team_First_Info">역대 우승 횟수 <br/> <span style={{color: "#3C64B1", lineHeight:"3.5vh"}}>8</span> </div>
        </div>

        <div className="Team_First_Info_Container">
        <div className="Team_First_logo_container">
          <img className="Team_First_logo" src={now} style={{width:"4.5vh", height:"4.5vh"}} alt=""/>
        </div>
        <div className="Team_First_Info">현재 순위 <br/> <span style={{color: "#3C64B1", lineHeight:"3.5vh"}}>1 </span></div>
        </div>

        <div className="Team_First_Info_Container">
        <div className="Team_First_logo_container">
          <img className="Team_First_logo" src={top} style={{width:"4.5vh", height:"4.5vh"}} alt=""/>
        </div>
        <div className="Team_First_Info">시즌 최고 순위 <br/> <span style={{color: "#3C64B1", lineHeight:"3.5vh"}}>1</span> </div>
        </div>

        <div className="Team_First_Info_Container">
        <div className="Team_First_logo_container">
          <img className="Team_First_logo" src={worst} style={{width:"4.5vh", height:"4.5vh"}} alt=""/>
        </div>
        <div className="Team_First_Info">시즌 최하 순위 <br/> <span style={{color: "#3C64B1", lineHeight:"3.5vh"}}>1 </span></div>
        </div>

      </div>
      <div className="mention_title">
        팀별 언급량
      </div>
      <div className="mention_container">
        {mention()}
      </div>
       
      <div className="main_player_title">
         주전
      </div>
      <div className="main_player_container">
        <div className="main_player_img_box">
          <div className="one"><span style={{paddingRight: "15%"}}>좌익수</span> <span style={{paddingRight: "15%"}}>중견수</span> 우익수</div>
          <div className="two"><span style={{paddingRight: "5%"}}>유격수</span> 2루수</div>
          <div className="three"><span style={{paddingRight: "30%"}}>3루수</span> 1루수</div>
          <div className="four">투수</div>
          <div className="five"><span style={{paddingRight: "10%"}}>포수</span> 지명타자</div>
        </div>
      </div>

      <div className="wordcloud_title">
        팀별 여론
      </div>
      <div className="wordcloud_container">
        {wordcloud()}
      </div>
    </div>
  );
}

export default IndTeam;