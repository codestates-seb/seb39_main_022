import React from "react";
import { Link } from 'react-router-dom';
import styled from "styled-components";

export default function Login() {
    return (
        <LoginContainer>
            <Link to='/main'>구르미</Link>
            <form onSubmit={(event) => event.preventDefault()} className='login-form'>
                <label htmlFor='userEmail'>Email</label>
                <input
                    type='text'
                    id='userEmail'
                    // 자동완성 기능 해제
                    autoComplete='off'
                    // 입력 안 했을 때 경고창
                    required
                >
                </input>
                <label htmlFor='userPassword'>password</label>
                <input
                    type='password'
                    id='userPassword'
                    autoComplete='off'
                    required
                >
                </input>
                <button className="login_btn">Log in</button>
            </form>
        </LoginContainer>
    )
}

const LoginContainer = styled.div`
border: 1px solid black;
height: 100vh;
display: flex;
flex-direction: column;
justify-content: center;
align-items: center;

.login-form{
    border: 1px solid black;
    display: flex;
    flex-direction: column;
    justify-content: space-around;

    width: 20rem;
    height: 15rem;

    input{
        height: 2rem;
    }
}
`