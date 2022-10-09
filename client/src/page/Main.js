import React from "react";
import { Map } from "react-kakao-maps-sdk";
import styled from "styled-components";

import Sidebar from "../component/Sidebar";

export default function Main({ isLogin }) {

    console.log(isLogin)
    return (
        <MainContainer>
            <Sidebar
                isLogin={isLogin}
            />
            <Map
                center={{ lat: 33.452613, lng: 126.570888 }}
                level={3}
                className='map'
            >
            </Map>
        </MainContainer>
    )
}

const MainContainer = styled.div`
display: flex;

.map{
    width: 100vw;
    height: 100vh;
}
`