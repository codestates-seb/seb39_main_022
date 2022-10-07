import { Link } from "react-router-dom";
import styled from "styled-components";
import React, { useState } from "react";

const Nav = ({ search, showModal, onChange }) => {
  // 모달창 노출 여부 state
  const [navOpen, setNavOpen] = useState(false);
  const showNav = () => {
    setNavOpen(true);
  };  const showNavX = () => {
    setNavOpen(false);
  };
  return (
    <NavBar>
      <form className="searchForm" onSubmit={(event) => event.preventDefault()}>
        <input
          onClick={() => {
            showModal();
            showNav();
          }}
          id="search"
          autocomplete='off'
          type="text"
          placeholder="장소를 입력하세요."
          value={search || ""}
          onChange={onChange}
        />
        {navOpen && (
          <ul  >
            <li >
              <Link style={{textDecoration: "none", color: "black",}} to="/main">Home</Link>
            </li>
            <li>
              <Link style={{textDecoration: "none", color: "black",}}  to="/about">사용법</Link>
            </li>
            <li>
              <Link style={{textDecoration: "none", color: "black",}}  to="/favorite">즐겨찾기</Link>
            </li>
            <li onClick={() => {
            showNavX();
            showModal(true);
          }}> X</li>
          </ul>
        )}
      </form>
    </NavBar>
  );
};

export default Nav;

const NavBar = styled.div`

  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: flex-start;
  margin: 1rem 0;
  input {
    padding-left: 1rem;
    height: 3rem;
    width: 17rem;
    margin: auto;
    margin-bottom: 1rem;
  }

  ul,
  li {
    list-style-type: none;
    float: left;
    margin-right: 1rem;
  }

`;
