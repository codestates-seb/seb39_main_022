import React, { useState } from 'react'
import axios from "axios";
import styled from "styled-components";

function LikeDislike() {
    const [like, setLike] = useState(false);
    const [dislike, setDislike] = useState(false);

    const handelLike = () => {
        setLike(pre => !pre)
    }

    const handelDislike = () => {
        setDislike(pre => !pre)
    }

    return (
        <LikeDislikeContainer>
            <img
                src={like ? 'https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon4/mt-thumb_up.svg' : 'https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon4/ul-thumbs-up.svg'}
                alt='like'
                onClick={handelLike}
            />
            <span>{like ? 1 : 0}</span>
            <img
                src={dislike ? 'https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon4/mt-thumb_down.svg' : 'https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon4/ul-thumbs-down.svg'}
                alt='dislike'
                onClick={handelDislike}
            />
            <span>{dislike ? 1 : 0}</span>
        </LikeDislikeContainer>
    )
}

export default LikeDislike;

const LikeDislikeContainer = styled.div`
/* border: 1px solid black; */
display: flex;
margin-top: 1rem;
margin-left: -.5rem;

img, span{
    /* border: 1px solid black; */
    width: 3rem;
    height: 2rem;
    line-height: 2rem;
    margin-right: .5rem;
}

span{
    /* border: 1px solid black; */
}
`