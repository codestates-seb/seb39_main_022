import React, { useState } from 'react'
import styled from "styled-components";

function LikeDislike({ uniqueId, memberEmail }) {
    const [like, setLike] = useState(false);
    const [dislike, setDislike] = useState(false);

    const likeEmptyImage = 'https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon4/ul-thumbs-up.svg';
    const likgFullImage = 'https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon4/mt-thumb_up.svg';
    const dislikeEmptyImage = 'https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon4/ul-thumbs-down.svg';
    const dislikeFullImage = 'https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon4/mt-thumb_down.svg';

    return (
        <>
            {memberEmail === uniqueId &&
                (<LikeDislikeContainer>
                    <img
                        src={like ? likgFullImage : likeEmptyImage}
                        alt='like'
                    />
                    <span>추천</span>
                    <img
                        src={dislike ? dislikeFullImage : dislikeEmptyImage}
                        alt='dislike'
                    />
                    <span>비추천</span>
                </LikeDislikeContainer>)
            }
        </>
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
`