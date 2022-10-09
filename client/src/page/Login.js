import React, { useState } from "react";
import { Link, useNavigate } from 'react-router-dom';
import axios from "axios";
import styled from "styled-components";

export default function Login({ setUniqueId, setIsLogin }) {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const navigate = useNavigate();

    const loginUrl = '/members/login'

    const handleEmail = (event) => {
        setEmail(event.target.value);
    }

    const handlePassword = (event) => {
        setPassword(event.target.value);
    }

    // post login
    // jwt  > session
    const handleLogin = async () => {
        await axios.post(loginUrl,
            ({
                email: email,
                password: password,
            }))
            .then(response => {
                console.log('로그인 성공', response);
                setUniqueId(response.data.data.email)
                setLocalStorage(response.data.data.email)
                setIsLogin(true)
                navigate('/main')
            })
            .catch(error =>
                console.log('error:', error)
            )
    }

    // 로컬스토리지에 이메일을 저장 >>> 실제로는 토큰
    const setLocalStorage = async (email) => {
        if (!email) return false

        // 값 / 키
        await localStorage.setItem("id", email)
    }

    // 자동 로그인
    // 1번 크롬탭 켜져있을 때만
    // 2번 콤푸타 껐다 켜도 >>> 로그아웃 <<< 이거


    // 세션이었따...
    // const accessToken = response.headers.authorization;
    // const refreshToken = response.headers.refresh;
    // setLocalStorage('access_token', accessToken);
    // setLocalStorage('refresh_token', refreshToken);
    // // 헤더에 토큰 담아서 요청마다 보내기
    // axios.defaults.headers.common['Authorization'] = `${accessToken}`;

    return (
        <LoginContainer>
            <Link to='/main' className="logo">구르미</Link>
            <form onSubmit={(event) => event.preventDefault()} className='login-form'>
                <label>Email</label>
                <input
                    type='email'
                    id='userEmail'
                    autoComplete='off'
                    required
                    value={email}
                    onChange={handleEmail}
                >
                </input>
                <label>password</label>
                <input
                    type='password'
                    id='userPassword'
                    autoComplete='off'
                    required
                    value={password}
                    onChange={handlePassword}
                >
                </input>
                <button type='submit' className="login_btn" onClick={handleLogin}>Log in</button>
            </form>
            <Link to='/signup'>회원가입하러 가기</Link>
        </LoginContainer>
    )
}

const LoginContainer = styled.div`
height: 100vh;
display: flex;
flex-direction: column;
justify-content: center;
align-items: center;

.logo{
    text-decoration: none;
    font-size: 2vmax;
    color: #238f51;
    padding: 1rem;
    margin-top: -10rem;
    margin-bottom: 3rem;
    }

.login-form{
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    width: 20rem;
    height: 13rem;

    
    input, .login_btn{
        height: 2rem;
        border-radius: .5rem;
        border: 1px solid black;
        outline-color: #238f51;
        padding: 0 .5rem;
    }

    .login_btn{
        height: 2.5rem;
        border: none;
        background-color: #238f51;
        color: white;
        font-size: 1vmax;
    }

    .login_btn:hover{
        font-size: 1.1vmax;
    }
}

a{
    margin: 1rem;
    text-decoration: none;
    color: gray;
}

a:hover{
    color: #238f51;
}
`