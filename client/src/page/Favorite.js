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

  // get favorite
  useEffect(() => {
    const getFavoriteList = async () => {
      const response = await axios.get('http://localhost:4000/favoriteList');
      // const response = await axios.get('http://ec2-43-201-22-41.ap-northeast-2.compute.amazonaws.com:8080/favorite-places');
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
      <Link to='/main'>
        <img
          src='https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon4/mt-keyboard_backspace.svg'
          alt='move_main_icon'
          className="move_main_icon"
        />
      </Link>
      <section className="favoriteList">
        <p className="logo"><Link to='/main'>구르미</Link></p>
        <input type='text' className="search-bar" placeholder="충전소를 검색해주세요" />
        <ul>
          {currentFavoriteList.map(({ id, 시설명, 공기주입가능여부, 휴대전화충전가능여부 }) => {
            return (
              <li key={id} className="favorite_list">
                {/* click event */}
                <button value={id} onClick={handleMove} className="favorite_list_title">
                  {시설명}
                </button>
                <p className="open">운영중</p>
                <section className="whether_section">
                  <p>
                    {공기주입가능여부 === "Y" ? '바퀴 공기 주입' : ""}
                  </p>
                  <p>
                    {휴대전화충전가능여부 === "Y" ? '휴대폰 충전' : ""}
                  </p>
                </section>

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
        <CustomOverlayMap position={place.center} className='modal'>
          {place.id && <div style={{ width: "200px", padding: "20px", backgroundColor: "#fff", color: "#000" }} className='modal_container'>
            <p className="modal_title">{place.시설명}</p>
            <p>운영중</p>
            <span>{place.공기주입가능여부 === "Y" ? '공기주입' : ""}</span>
            <span>{place.휴대전화충전가능여부 === "Y" ? '충전' : ""}</span>
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

.logo{

margin-bottom: 1rem;
font-size: 2vmax;

a{
    text-decoration: none;
    color: #238f51;
}
}

.move_main_icon{
    position: absolute;
    left: 93%;
    top: 1rem;
    z-index: 99999;
    background-color: white;
    width: 5rem;
}

.favoriteList{
    display: flex;
    flex-direction: column;
    width: 28rem;
    padding: 1rem 1rem;

    .search-bar{
        height: 2.5rem;
        padding: .5rem;
        border-radius: 0.5rem;
        border: 1px solid #238f51;
        outline-color: #238f51;
    }

    ul{
        .favorite_list{
            margin: 1rem 0;
            height: 6.5rem;
            list-style: none;
            border-radius: 0.5rem;
            border: 1px solid #238f51;
            padding: .5rem;

            .favorite_list_title{
                border: none;
                background-color: white;
                font-size: 1.5vmax;
                margin-bottom: .3rem;
                cursor: pointer;
            }

            .favorite_list_title:hover{
                color: #238f51;
            }

            .open{
                margin-bottom: .5rem;
            }

            .whether_section{
                display: flex;

                p{
                    border-radius: .5rem;
                    padding: .5rem;
                    margin: 0 .5rem 0 0;
                    font-size: 1vmax;
                    background-color: #238f51;
                    color: white;
                }

                span{
                    
                }
            }
        }
    }
}

.map{
    width: 100vw;
    height: 100vh;

    .modal_title{
        font-size: 1.5vmax;
    }
}

.modal_container{

a{
    text-decoration: none;
    color: #238f51;
}

a:hover{
    color: #f05d4d;
}

}
`



