import React from "react";
import "../App.css";
import { Link } from "react-router-dom";

import img from "../asset/landing_img.png";


function Landing() {
  return (
    <>
      <div className="Landing">
        <p className="title">구르미</p>
        <img src={img} alt="landing_img" />
      </div>
      <Link to="/maptest">충전소 찾으러가기</Link>
      <br />
      <Link to="/searchsss">검색</Link>
      <br />
      <Link to="/writeReview">리뷰작성</Link>
      <br />
      <Link to="/guide">사용법</Link>
      <Link to='/sideBar'>SideBar</Link>
    </>
  );
}

export default Landing;
