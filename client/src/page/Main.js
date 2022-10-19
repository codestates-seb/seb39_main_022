import React, { useState } from "react";
import { Map } from "react-kakao-maps-sdk";
import styled from "styled-components";

import Sidebar from "../component/Sidebar";

export default function Main({ isLogin }) {

    const [latitude, setLatitude] = useState("");
    const [longitude, setLongitude] = useState("");

    // 현재위치 나타내기
    function locationSuccess(position) {
        setLatitude(position.coords.latitude)
        setLongitude(position.coords.longitude)
    }

    function locationError() {
        alert("Can't find you");
    }

    navigator.geolocation.getCurrentPosition(locationSuccess, locationError)

    // console.log(latitude, longitude)
    return (
        <MainContainer>
            <Sidebar
                isLogin={isLogin}
            />
            <Map
                // 현재위치 구현 아직 못함
                center={{ lat: 33.450701, lng: 126.570667 }}
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