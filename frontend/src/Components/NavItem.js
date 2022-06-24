import React from "react";
import '../css/HomeNav.css';

function NavItem({menu, isActive}) {
    return isActive === true ? (
        <div className="nav-item-active"  font-size= "15px" color= "#3C64B1" font-weight = "400" margin-right = "80px">
            <p>{menu.name}</p>
        </div>
    ) : (
        <div className="nav-item">
            <p>{menu.name}</p>
        </div>
    )
}

export default NavItem