import React, { useState, useEffect } from "react";
import { Link, useNavigate, useLocation } from 'react-router-dom';
import axios from "axios";
import styled from "styled-components";

export default function Detail() {
    const [modal, setModal] = useState({
        text: '',
        isUrlOpen: false,
        isFavoriteOpen: false,
        isFormOpen: false
    })

    const [commentList, setCommentList] = useState([])

    const [like, setLike] = useState(false)

    const navigate = useNavigate();

    const location = useLocation();

    const likeImage = like ? 'https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon5/mt-favorite_border.svg' : 'https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon5/mt-favorite.svg'

    const handleMoveFavoritePage = () => {
        navigate(`/favorite`);
    }

    const handleCopyUrl = () => {
        setModal(() => ({
            text: 'url이 복사되었습니다',
            isUrlOpen: true
        }))
    }

    const handleOpenChangeInfoForm = () => {
        setModal(() => ({
            isFormOpen: true
        }))
    }

    const handleLikeImage = () => {
        setLike(previous => !previous)
    }

    // get
    useEffect(() => {
        const getReviewList = async () => {
            const response = await axios.get('http://localhost:4000/comments');

            setCommentList(response.data)
        }
        getReviewList();
    }, []);

    // post
    const handleAddFavorite = () => {
        setModal(() => ({
            text: '즐겨찾기에 저장되었습니다',
            isFavoriteOpen: true
        }))

        const addFavoriteList = async () => {
            try {
                const response = await axios.post('http://localhost:4000/favoriteList');
                if (response) {
                    console.log('즐겨찾기 저장 성공')
                }
            } catch (err) {
                console.log('error:', err)
            }
        }

        addFavoriteList();
    }

    return (
        <DetailContainer>
            <section className='exitIcon_container'>
                <img
                    src='https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon3/mt-cancel.svg'
                    alt='exitIcon'
                    onClick={handleMoveFavoritePage}
                    className='exitIcon'
                />
            </section>
            <div className="img"></div>
            <section className="button_container">
                <button>길찾기</button>
                <button onClick={handleCopyUrl}>공유하기</button>
                {modal.isUrlOpen && (<div className='modal' onClick={() => setModal(false)}>{modal.text}</div>)}
                <button onClick={handleAddFavorite}>즐겨찾기</button>
                {modal.isFavoriteOpen && (<div className='modal' onClick={() => setModal(false)}>{modal.text}</div>)}
                <button><Link to='/addReview'>후기작성</Link></button>
            </section>
            <section className='placeName'>
                <button onClick={handleOpenChangeInfoForm}>정보수정요청</button>
                <p>{location.state.place.시설명}</p>
                <p>{location.state.place.소재지지번주소}</p>
                <p>운영시간<br />{location.state.place.평일운영시작시각}~{location.state.place.평일운영종료시각}</p>
                <p>{location.state.place.관리기관전화번호}</p>
            </section>
            {modal.isFormOpen &&
                <form>
                    <p className="changeInfo">정보수정
                        <span>
                            <img
                                src='https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon3/mt-cancel.svg'
                                alt='exitIcon'
                                onClick={() => setModal(false)}
                                className='exitIcon'
                            />
                        </span>
                    </p>
                    <label>장소명</label>
                    <input
                        type='text'
                        required
                    />
                    <label>위치</label>
                    <input
                        type='text'
                        required
                    />
                    <label>운영시간</label>
                    <input
                        type='text'
                        required
                    />
                    <label>전화번호</label>
                    <input
                        type='text'
                        required
                    />
                    <label>기타 수정사항</label>
                    <input
                        type='text'
                        required
                    />
                    <button>수정 요청하기</button>
                </form>}
            <section>
                <p>전체 {commentList.length}</p>
                <ul>
                    {commentList.map(({ commentId, memberId, comment }) => {
                        return (
                            <div key={commentId}>
                                < li className="commentList" >
                                    <p>{memberId}</p>
                                    <p>{comment}</p>
                                    <img
                                        src={likeImage}
                                        alt='likeImage'
                                        onClick={handleLikeImage}
                                        className="likeImage"
                                    />
                                </li>
                                <hr></hr>
                            </div>
                        )
                    })}
                </ul>
            </section >
        </DetailContainer >
    )
}

const DetailContainer = styled.div`
display: flex;
flex-direction: column;
justify-content: center;
align-items: center;

.img{
    border: 1px solid black;
    width: 10rem;
    height: 10rem;
    margin: 3rem;
}

.exitIcon_container{
    width: 100vw;
    height: 2rem;
    display: flex;
    flex-direction: row-reverse;
    /* border: 1px solid black; */
}

.exitIcon, .likeImage{
    width: 2rem;
    margin: 0;
}

.modal{
    position: absolute;
    /* border: 1px solid black; */
    width: 20rem;
    height: 20rem;
    background-color: whitesmoke;
    text-align: center;
    line-height: 20rem;
}

.button_container{
    /* border: 1px solid black; */
    width: 30rem;
    margin: 0 auto;
    display: flex;
    justify-content: space-around;
}

.placeName{
    border: 1px solid black;
    width: 25rem;
    padding: 2rem;
    margin:2rem;
}

form{
    border: 1px solid black;
    display: flex;
    flex-direction: column;
    padding: 1rem;
    position: absolute;
    top: 15rem;
    background-color: whitesmoke;
}


.changeInfo{
    text-align: center;
}

.commentList{
    /* border: 1px solid black; */
    list-style: none;
    width: 25rem;
    padding: 2rem;
}
`