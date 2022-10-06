import { Link } from "react-router-dom";
import styled from "styled-components";
import React, { useState } from "react";

const Nav = ({ search, setSearch, showModal  }) => {
  // 모달창 노출 여부 state
  const [navOpen, setNavOpen] = useState(false);
  const showNav = () => {
    setNavOpen(true);
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
          type="text"
          placeholder="장소를 입력하세요."
          value={search || ""}
          onChange={(event) => setSearch(event.target.value)}
        />
        {navOpen && (
          <ul>
            <li>
              <Link to="/main">Home</Link>
            </li>
            <li>
              <Link to="/about">사용법</Link>
            </li>
            <li>
              <Link to="/favorite">즐겨찾기</Link>
            </li>
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
  border: 1px solid red;
  input {
    height: 3rem;
    width: 100%;
    margin: auto;
  }

  ul,
  li {
    list-style-type: none;
    float: left;
    margin-right: 1rem;
  }
`;
