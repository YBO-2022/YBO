import React from "react";
import {NavLink, useLocation} from "react-router-dom";
import '../css/HomeNav.css';
import logo from "../img/ybo_logo.png";
import NavItem from "./NavItem";
import "../font/font.css";

function Nav() {
    
    const pathName = useLocation().pathname;

    // URL의 path값 받기
    // eslint-disable-next-line react-hooks/rules-of-hooks
    const Menu = [
        {name: "Home", path: "/" ,path_name:["/"]},,
        {name: "구단랭킹", path: "/MainTeam",path_name:["/MainTeam", "/Team/0","/Team/1","/Team/2","/Team/3","/Team/4","/Team/5","/Team/6","/Team/7","/Team/8","/Team/9"]},
        {name: "선수랭킹", path: "/MainPlayer",path_name:["/MainPlayer", "/Player/0","/Player/1"]},
        {name: "골든글러브", path: "/GoldenGlove", path_name:["/GoldenGlove"]}
    ]
    return (
        <div className = "navheader">
        <div className="navlogo">
              <div>
                <img className="nav_logo"  src={logo}  alt="logo"/>
              </div>
              <div className="navcomment" style={{fontFamily:"Vitro_core"}}>YBO</div>

        </div>
        <div className="nav">
            {Menu.map((menu, index) => {
                return (
                    <NavLink to={menu.path} key={index} className="navbutton">
                    <NavItem    menu={menu} isActive={menu.path_name.includes(pathName) ? true : false}/>
                     </NavLink>
                )
            })
            }
        </div>
        </div>
    )
}

export default Nav