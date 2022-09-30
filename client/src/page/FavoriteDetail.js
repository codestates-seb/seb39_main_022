import React, { useState, useEffect } from "react";
import { Link, useNavigate, useLocation } from 'react-router-dom';
import axios from "axios";
import styled from "styled-components";

export default function FavoriteDetail() {
    const [modal, setModal] = useState({
        text: '',
        isUrlOpen: false,
        isFavoriteOpen: false,
        isFormOpen: false,
    });

    const [commentList, setCommentList] = useState([]);

    const navigate = useNavigate();

    const location = useLocation();

    // isLike = false >>> like 값이 안 들어왔을 때도 흰색으로 표시
    const likeImage = (isLike = false) => isLike ? 'https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon5/mt-favorite.svg' : 'https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon5/mt-favorite_border.svg'

    const copyUrl = `http://localhost:3000${location.pathname}`;


    const handleMoveFavoritePage = () => {
        navigate(`/favorite`)
    };

    const handleCopyModal = () => {
        setModal(() => ({
            text: 'url이 복사되었습니다',
            isUrlOpen: true
        }))
    };

    const handleCopyUrl = () => {
        setModal(false)
        window.navigator.clipboard.writeText(copyUrl).then(() => {
            console.log('복사 완료')
        })
    };

    const handleOpenChangeInfoForm = () => {
        setModal(() => ({
            isFormOpen: true
        }))
    };

    const handleSubmitInfo = () => {
        alert('정보수정요청 되었습니다')
        setModal(false)
    }

    // 같은 동작을 해도 각각 해당되는 동작을 넣어주기 객체안에 데이터를 넣어주는 !
    // 요소마다 like 이벤트를 개별로
    // setLike Boolean 변경 >>> 새로운 배열 생성
    // data 속성을 이용해서 img id 값을 받아왔다
    // 실무에서 다른 점 >>> 서버로 날아간다

    // 개별 like 반영
    const handleLikeImage = (event) => {
        // tag data-## >>> dataset 객체에 data 저장 / data-id >>> id 라는 객체에 저장
        const { id } = event.target.dataset

        // 몇번째 요소 like 인지 확인
        const targetIndex = commentList.findIndex(comment => comment.commentId === id)

        // targetIndex 해당 되는 요소만 true 로 변경
        const updatedComment = {
            ...commentList[targetIndex],
            isLike: true
        }

        // 얕은 복사로 새로운 배열 생성 targetIndex 번째를 제외하고 만든다 0부터 그 전까지
        // ...을 붙인 이유 >>> 타겟 되는 것을 제외하고 그대로 false 상태이다 / 타겟만 true
        const newCommentList = [...commentList.slice(0, targetIndex), updatedComment, ...commentList.slice(targetIndex + 1)]

        // 실제로 서버에 먼저
        setCommentList(newCommentList)
    };

    // get
    useEffect(() => {
        const getReviewList = async () => {
            const response = await axios.get('http://localhost:4000/comments');

            const newCommentList = response.data.map(commentInfo => {
                return {
                    ...commentInfo,
                    isLike: false
                }
            })

            setCommentList(newCommentList)
        }
        getReviewList();
    }, []);

    // post
    // 임시로 시설명만 저장한다 >>> 어떤 데이터 저장할지 의논 /// 내 생각엔 위도, 경도 필요하다
    const handleAddFavorite = () => {
        setModal(() => ({
            text: '즐겨찾기에 저장되었습니다',
            isFavoriteOpen: true
        }))

        const addFavoriteList = async () => {
            try {
                const response = await axios.post('http://localhost:4000/favoriteList', {
                    시설명: location.state.place.시설명
                });
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
                <button onClick={handleCopyModal}>공유하기</button>
                {modal.isUrlOpen && (<div className='modal' onClick={handleCopyUrl}>{modal.text}</div>)}
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
                    <input
                        type='submit'
                        value='수정사항 요청하기'
                        onClick={handleSubmitInfo}
                    />
                </form>}
            {modal.isFormSubmitOpen && (<div className='modal' onClick={() => setModal(false)}>{modal.text}</div>)}
            <section>
                <p>전체 {commentList.length}</p>
                <ul>
                    {commentList.map(({ commentId, memberId, comment, isLike }) => {
                        return (
                            <div key={commentId}>
                                < li className="commentList" >
                                    <button value={commentId}>
                                        <Link
                                            to={`/review/${commentId}`}
                                            state={{ commentId, memberId, comment }}
                                        >
                                            {memberId}
                                        </Link>
                                    </button>
                                    <p>{comment}</p>
                                    <img
                                        src={likeImage(isLike)}
                                        alt='likeImage'
                                        onClick={handleLikeImage}
                                        className="likeImage"
                                        data-id={commentId}
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