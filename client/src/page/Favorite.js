import React, { useEffect, useState } from "react";
import { Link } from 'react-router-dom';
import axios from "axios";
import { Map, MapMarker } from "react-kakao-maps-sdk";
import styled from 'styled-components';
import Pagination from "../component/Pagenation";

export default function Favorite() {
    const [state, setState] = useState({
        favoriteList: []
    });

    // pagenation
    // 페이지당 게시물 수(limit)
    const [limit, setLimit] = useState(5)
    // 현재 페이지 번호(page)
    const [page, setPage] = useState(1)
    // 첫 게시물의 위치(offset)
    const offset = (page - 1) * limit

    // click event
    const [markers, setMarkers] = useState([])
    // console.log(markers)

    // list click event
    const [place, setPlace] = useState({
        // 지도의 초기 위치
        center: { lat: 33.452613, lng: 126.570888 },
        // 지도 위치 변경시 panto를 이용할지에 대해서 정의
    })

    const move = () => {
        setPlace({
            center: {
                lat: markers.forEach(e => Number(e.lat)),
                lng: markers.forEach(e => Number(e.lng))
            }
            ,
            isPanto: false,
        })
    }
    // console.log(place.center)


    // infoWindow
    const [isOpen, setIsOpen] = useState(false)

    // get
    useEffect(() => {
        const getList = async () => {
            const response = await axios.get('http://localhost:4000/favoriteList');
            setState({
                ...state,
                favoriteList: response.data
            })
            // console.log(response.data[0].위도)

            // click event info
            const markers = [];
            // console.log(markers)
            for (let i = 0; i < response.data.length; i++) {
                markers.push({
                    lat: response.data[i].경도,
                    lng: response.data[i].위도,
                })
            }

            setMarkers(markers)
            // console.log(markers)
        }
        getList();
    }, []);

    let { favoriteList } = state;

    // let key = Object.keys(state.favoriteList[0])
    // console.log(key)

    const [good, setGood] = React.useState({
        isGood: false
    })

    const choice = good.isGood ? "https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon5/mt-star.svg" : "https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon5/mt-star_border.svg"

    const click = () => {
        setGood(e => ({
            isGood: !e.isGood
        }))
    }

    return (
        <FavoritePage>
            <section className="favoriteList">
                <ul>
                    {/* <label>
                    즐겨찾기 보기:&nbsp;
                    <select
                        type="number"
                        value={limit}
                        onChange={({ target: { value } }) => setLimit(Number(value))}
                    >
                        <option value="5">5</option>
                        <option value="10">10</option>
                    </select>
                </label> */}
                    {/* get */}
                    {favoriteList.slice(offset, offset + limit).map(favoriteItem => {
                        return (
                            <li key={favoriteItem.id} className="list">
                                {/* click event */}
                                <p onClick={move}>
                                    {favoriteItem.시설명}
                                </p>
                                <span>
                                    {favoriteItem.공기주입가능여부 === "Y" ? '공기주입' : ""}
                                </span>
                                <span>
                                    {favoriteItem.휴대전화충전가능여부 === "Y" ? '충전' : ""}
                                </span>
                            </li>
                        )
                    })}
                </ul>
                <Pagination
                    total={state.favoriteList.length}
                    limit={limit}
                    page={page}
                    setPage={setPage}
                />
                <img
                    className="img"
                    src={choice}
                    alt="icon"
                    onClick={click}
                />
            </section>
            <Map
                center={place.center}
                isPanto={place.isPanto}
                style={{
                    width: "40rem",
                    height: "40rem",
                }}
                level={3}

            >
                <MapMarker
                    position={place.center}
                    // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
                    clickable={true}
                    onClick={() => setIsOpen(true)}
                />
                {isOpen && (
                    <div className="hi">
                        <div
                            onClick={() => setIsOpen(false)}>
                            {favoriteList.map(favoriteItem => {
                                return (
                                    <p key={favoriteItem.id}>{favoriteItem.시설명}</p>
                                )
                            })}
                        </div>
                        <Link to='/detail'>더보기+</Link>
                    </div>
                )}
            </Map>
        </FavoritePage >
    )
}

const FavoritePage = styled.div`
display: flex;

ul{
    li{
        list-style: none;
        border: 1px solid black;
        margin: 1rem;
        width: 15rem;
        height: 6rem;
    }
}

.hi{
    border: 1px solid black;
    padding: 1rem;
    height: 10rem;
    position: absolute;
    top: 12rem;
    left: 27rem;
    background-color: white;
    z-index: 1;
}

.img{
    width: 5rem;
}
`



