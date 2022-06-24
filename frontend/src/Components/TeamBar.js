import React from "react";
import MP from "./MP"


function MainPlayer(props) {

    const team_id = Number(props.team_id);

    return (
      
    <div className="Team_First">
        <MP id="0" team_id={team_id}/>
        <MP id="1"  team_id={team_id}/>
        <MP id="2"  team_id={team_id}/>
        <MP id="3"  team_id={team_id}/>
    </div>
   
    );
  }
  
export default MainPlayer;

