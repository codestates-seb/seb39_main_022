import React, { useState, useEffect } from "react";
import { Link } from 'react-router-dom';
import { Map, MapMarker, CustomOverlayMap } from "react-kakao-maps-sdk";
import axios from "axios";
import styled from 'styled-components';

import Pagination from "../component/Pagenation";

export default function Favorite() {
    const [favoriteList, setFavoriteList] = useState([]);

    // pagenation
    // 페이지당 게시물 수(pagenationLimit) pageSize
    const [pagenationLimit, setPagenationLimit] = useState(5)
    // 현재 페이지 번호(currentPageNumber)
    const [currentPageNumber, setCurrentPageNumber] = useState(1)

    // click event
    const [markers, setMarkers] = useState()
    const [place, setPlace] = useState({
        // 지도의 초기 위치
        center: { lat: 33.452613, lng: 126.570888 },
        시설명: ''
    })

    // 첫 게시물의 위치(firstOffset)
    const firstOffset = (currentPageNumber - 1) * pagenationLimit

    const currentFavoriteList = favoriteList.slice(firstOffset, firstOffset + pagenationLimit)

    const handleMove = (event) => {
        const id = event.target.value
        const targetMarker = markers.find(marker => {
            return marker.id === id
        })

        setPlace({
            ...targetMarker,
            id: targetMarker.id,
            center: targetMarker.latlng,
        })
    }

    // get
    useEffect(() => {
        const getFavoriteList = async () => {
            const response = await axios.get('http://localhost:4000/favoriteList');
            setFavoriteList(response.data)

            const favorites = response.data;
            const marker = favorites.map(favorite => {
                return {
                    ...favorite,
                    id: favorite.id,
                    latlng: { lat: Number(favorite.위도), lng: Number(favorite.경도) }
                }
            })
            setMarkers(marker)
        }

        getFavoriteList();
    }, []);

    return (
        <FavoritePage>
            <section className="favoriteList">
                <ul>
                    {currentFavoriteList.map(({ id, 시설명, 공기주입가능여부, 휴대전화충전가능여부 }) => {
                        return (
                            <li key={id} className="list">
                                {/* click event */}
                                <button value={id} onClick={handleMove} className="list_title">
                                    {시설명}
                                </button>
                                <p>
                                    {공기주입가능여부 === "Y" ? '공기주입' : ""}
                                </p>
                                <p>
                                    {휴대전화충전가능여부 === "Y" ? '충전' : ""}
                                </p>
                            </li>
                        )
                    })}
                </ul>
                <Pagination
                    total={favoriteList?.length}
                    pagenationLimit={pagenationLimit}
                    currentPageNumber={currentPageNumber}
                    setCurrentPageNumber={setCurrentPageNumber}
                />
            </section>
            <Map
                center={place.center}
                level={3}
                className='map'
            >
                <CustomOverlayMap position={place.center}>
                    {place.id && <div style={{ width: "200px", padding: "20px", backgroundColor: "#fff", color: "#000" }}>
                        <p>{place.시설명}</p>
                        <p>운영중 <span>{place.공기주입가능여부 === "Y" ? '공기주입' : ""}</span> <span>{place.휴대전화충전가능여부 === "Y" ? '충전' : ""}</span></p>
                        <p>{place.관리기관전화번호}</p>
                        <Link
                            to={`/favorite/${place.id}`}
                            state={{ place }}
                        >더보기+
                        </Link>
                    </div>}
                </CustomOverlayMap>
                <MapMarker
                    position={place.center}
                    clickable={true}
                />
            </Map>
        </FavoritePage >
    )
}

const FavoritePage = styled.div`
display: flex;

.favoriteList{
    width: 30rem;
}

.map{
    width: 100vw;
    height: 100vh;
}
ul{
    li{
        list-style: none;
        border: 1px solid black;
        margin: 1rem;
        height: 6rem;
    }
}

.list_title{
    cursor: pointer;
}
`



