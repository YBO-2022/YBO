import React from 'react'
import { NavLink } from 'react-router-dom'
import "../css/MainPlayer.css";
import era from "../img/ERA.png";
import glove from "../img/GLOVE.png";
import ops from "../img/OPS.png";
import "../font/font.css";



function ServiceList(props) {
  const img=[ops, era, glove]
  const id = Number(props.id)
  const title = ["OPS","ERA","Golden Glove"]
  const desc =["출루율 + 장타율","평균 자책점","선수들의 예상 순위 확인"]

  function content(){
    if(id !== 2){
      return(
        <NavLink to={`/Player/${id}`} key={id} style={{ textDecoration: 'none'}}>
        <img className='Service_Img' src={img[id]} alt={title[id]}/>
        <div className='Service_Name'>{title[id]}</div>
        <div className='Service_Info' >{desc[id]}</div>
        </NavLink>
      );}else{
        return(
          <NavLink to={`/GoldenGlove`} key={id} style={{ textDecoration: 'none'}}>
          <img className='Service_Img' src={img[id]} alt={title[id]}/>
          <div className='Service_Name'>{title[id]}</div>
          <div className='Service_Info'>{desc[id]}</div>
          </NavLink>
        );
      }
    }
  

  return (
 
      <div className='Service_List'>
        <span>
          {content()}
        </span>
      </div>
  )
}


export default ServiceList