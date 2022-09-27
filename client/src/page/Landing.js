import React from 'react';
import { Link } from 'react-router-dom';
import '../App.css';

import img from '../asset/landing_img.png';

function Landing() {
    return (
        <>
            <div className="Landing">
                <p className='title'>구르미</p>
                <img src={img} alt='landing_img' />
            </div>
            <Link to='/favorite'>즐겨찾기</Link>
        </>
    );
}

export default Landing;