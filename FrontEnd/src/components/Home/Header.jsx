import React from 'react';
import style from './Header.module.css';

const Header = () => {
  return (
    <div className={style.header}>
      <div className="menuicon">
        <img src="./images/menu.png" alt="" className={style.menuicon} />
      </div>
      <div/>
      <div className="noticon">
        <img src="./images/notifications.png" alt="" className={style.noticon}/>
      </div>
    </div>
  );
};

export default Header;