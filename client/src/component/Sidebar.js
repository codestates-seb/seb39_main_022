import React from "react";
import { Link } from 'react-router-dom';
import styled from "styled-components";

import Search from "./Search";

export default function Sidebar({ isLogin }) {
    // true 여부에 따라 로그인 버튼과 유저 정보로 메인 화면 다르게 렌더링하기...

    return (
        <SidebarContainer>
            <p className="logo">구르미</p>
            <Search />
            <section className="socialBtn">
                {isLogin ?
                    (
                        <Link to=''>userInfo</Link>
                    ) : (
                        <>
                            <Link to='/login'>로그인</Link>
                            <Link to='/signup'>회원가입</Link>
                        </>
                    )
                }
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

.logo{
color: #238f51;
margin-bottom: 1rem;
font-size: 2vmax;
}

.socialBtn{
    margin: 1rem 0;
    /* border: 1px solid black; */
    display: flex;
    justify-content: space-between;

    a{
        width: 9.5rem;
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
    width: 9rem;
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