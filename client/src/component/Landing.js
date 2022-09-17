import React from 'react';
import img from '../asset/landing_img.png';
import '../App.css';
import { Link } from 'react-router-dom';

function Landing() {
    return (
        <>
            <div className="Landing">
                <p>구르미</p>
                <img src={img} alt='landing_img' />
            </div>
            <Link to='/maptest'>충전소 찾으러가기</Link>
        </>
    );
}

export default Landing;