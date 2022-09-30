import React from "react";
import { Link } from 'react-router-dom';
import styled from "styled-components";

export default function Sidebar() {
    return (
        <SidebarContainer>
            <p>사이드바입니다</p>
            <section className="socialBtn">
                <button><Link to='/login'>로그인</Link></button>
                <button><Link to='/signup'>회원가입</Link></button>
            </section>
            <Link to='/favorite'>즐겨찾기</Link>
        </SidebarContainer>
    )
}

const SidebarContainer = styled.div`
font-size: 2rem;
border: 1px solid black;
display: flex;
flex-direction: column;
width: 30rem;

a{
    text-decoration: none;
    color: black;
}
`