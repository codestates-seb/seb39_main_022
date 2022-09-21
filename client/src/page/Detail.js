import React, { useState } from "react";
import { useNavigate } from 'react-router-dom';
import styled from "styled-components";

export default function Detail() {
    const navigate = useNavigate();
    const moveFavorite = () => {
        navigate(`/favorite`);
    }

    const [modal, setModal] = useState({
        text: '',
        isOpen: false
    })

    const addFavorite = () => {
        setModal(() => ({
            text: '즐겨찾기에 저장되었습니다',
            isOpen: true
        }))
    }

    return (
        <DetailContainer>
            <img
                src='https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon3/mt-cancel.svg'
                alt='cancle'
                onClick={moveFavorite}
            />
            <section>
                <button onClick={addFavorite}>즐겨찾기</button>
                {modal.isOpen && (<div className='modal' onClick={() => setModal(false)}>{modal.text}</div>)}
            </section>
        </DetailContainer >
    )
}

const DetailContainer = styled.div`
img{
    width: 5rem;
}

.modal{
    position: absolute;
    border: 1px solid black;
    background-color: yellow;
    width: 15rem;
    height: 10rem;
}
`