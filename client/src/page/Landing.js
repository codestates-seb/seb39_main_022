import React from 'react';
import { Link } from 'react-router-dom';
import styled from "styled-components";
import '../App.css';

import img from '../asset/landing_img.png';

function Landing() {
    return (
        <LandingContainer>
            <div className="landing">
                <p className='title'>구르미</p>
                <Link to='/main'>충전소 찾으러 가기</Link>
            </div>
            <img src={img} alt='landing_img' />


        </LandingContainer>
    );
}

export default Landing;

const LandingContainer = styled.div`
font-family: 'Gowun Dodum', sans-serif;
font-family: 'Nanum Gothic', sans-serif;

.title{
    color: #238f51;
}

a{
    color: rgba(89,155,108, 0.8)
}

a:hover{
    color: #238f51;
    transition: 0.2s;
    transform: scale(1.1);
}

// desktop
@media all and (min-width: 992px) and (max-width: 2000px) {
height: 100vh;
text-align: center;
display: flex;
justify-content: space-around;
align-items: center;

    .landing {
        border: 1px solid black;
        width: 40%;
        height: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }

    .title {
        font-size: 8vmax;
    }

    a{
        margin: 2rem;
        padding: 1rem;
        font-size: 3vmax;
        text-decoration: none;
    }

    img {
        border: 1px solid black;
        width: 60%;
    }
}

// tablet
@media all and (min-width: 480px) and (max-width: 991px){
/* border: 1px solid black; */
height: 100vh;
display: flex;
flex-direction: column-reverse;
justify-content: center;
align-items: center;

    .landing{
        width: 100%;
        margin: 1rem 0;
        display: flex;
        align-items: center;
        justify-content: space-around;
    }

    .title {
        border: 1px solid black;
        font-size: 7vmax;
    }

    a{
        border: 1px solid black;
        font-size: 3vmax;
        text-decoration: none;
    }

    img {
        border: 1px solid black;
        width: 90%;
    }
}

// mobile
@media (max-width: 479px){
height: 100vh;
display: flex;
flex-direction: column-reverse;
justify-content: center;
align-items: center;

    img {
        width: 100%
    }

    .landing{
        width: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .title {
        border: 1px solid black;
        font-size: 7vmax;
        margin-bottom: 1rem;
    }

    a{
        border: 1px solid black;
        font-size: 3vmax;
        text-decoration: none;
    }
}
`