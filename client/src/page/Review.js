import React from "react";
import { Link, useNavigate, useLocation } from 'react-router-dom';
import axios from "axios";
import styled from "styled-components";

export default function Review() {
    const navigate = useNavigate();

    const location = useLocation();

    const handleMoveFavoriteDetailPage = () => {
        navigate(-1)
    };

    // comment delete
    // delete error
    const handleDeleteReview = async () => {
        try {
            // const response = await axios.delete(`http://localhost:4000/comments/${location.state.commentId}`)
            if (true) {
                console.log('후기 삭제')

                // 서버 연동되면 제대로 해보기
                navigate(-1)
            }
        } catch (error) {
            console.log('error:', error)
        }
    };

    // 데이터 삭제 >>> 반영
    // 리스트로 돌아가기 <<< 현재 / 삭제가 완료되었습니다 모달 생성 후 돌아가기
    // 댓글이 없습니다

    return (
        <ReviewContainer>
            <section className="reviewTop">
                <p>{location.state.memberId}</p>
                <img
                    src='https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon3/mt-cancel.svg'
                    alt='exitIcon'
                    onClick={handleMoveFavoriteDetailPage}
                    className='exitIcon'
                />
            </section>
            <section className="review">
                <p>{location.state.comment}</p>
                <button><Link to='/addReview'>후기 수정</Link></button>
                <button onClick={handleDeleteReview}>후기 삭제</button>
            </section>
        </ReviewContainer>
    )
}

const ReviewContainer = styled.div`
border: 1px solid black;
padding: 10rem;
height: 100vh;

.reviewTop{
    display: flex;
    justify-content: space-between;

    p{
        margin: 1rem;
    }
}
.review{
    margin: 1rem;
}

.exitIcon{
    width: 2rem;
    margin: 0;
}
`