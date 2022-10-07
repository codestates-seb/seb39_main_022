import React from "react";
import { Link } from 'react-router-dom';
import styled from "styled-components";

export default function Sidebar() {
    return (
        <SidebarContainer>
            <input type='text' className="search-bar" placeholder="충전소를 검색해주세요" />
            <section className="socialBtn">
                <Link to='/login'>로그인</Link>
                <Link to='/signup'>회원가입</Link>
            </section>
            <section className="moveBtn">
                <Link>사용법</Link>
                <Link to='/favorite'>즐겨찾기</Link>
            </section>

        </SidebarContainer>
    )
}

const SidebarContainer = styled.div`
font-size: 2rem;
/* border: 1px solid black; */
display: flex;
flex-direction: column;
width: 28rem;
padding: 1.5rem 1rem;

.search-bar{
    height: 2.5rem;
    padding: .5rem;
    border-radius: 0.5rem;
    border: 1px solid #238f51;
    outline-color: #238f51;
}

.socialBtn{
    margin: 1rem 0;
    /* border: 1px solid black; */
    display: flex;
    justify-content: space-between;

    a{
        width: 8.5rem;
        height: 2rem;
        line-height: 2rem;
        border-radius: 0.5rem;
        border: none;
        background-color: #238f51;
        text-decoration: none;
        text-align: center;
        font-size: 1rem;
        color: white;
    }
}

button{
    width: 8rem;
    height: 2rem;
    border-radius: 0.5rem;
    border: none;
    background-color: #238f51;
}

.moveBtn{
    /* border: 1px solid black; */
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    height: 3rem;

    a{
        text-decoration: none;
        font-size: 1rem;
        color: #238f51;
    }
}

`