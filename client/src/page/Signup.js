import React, { useState } from "react";
import { Link, useNavigate } from 'react-router-dom';
import axios from "axios";
import styled from "styled-components";

export default function Signup() {
    // 회원가입 유효성 관련
    // 이메일 중복
    // 비밀번호 10글자 이상
    // 전화번호 000-0000-000 형식

    const [userName, setUserName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [phoneNumber, setPhoneNumber] = useState("");

    const navigate = useNavigate();

    const signupUrl = 'http://ec2-3-38-101-126.ap-northeast-2.compute.amazonaws.com/members/signup'

    const handleUserName = (event) => {
        setUserName(event.target.value);
    }

    const handleEmail = (event) => {
        setEmail(event.target.value);
    }

    const handlePassword = (event) => {
        setPassword(event.target.value);
    }

    const handlePhoneNumber = (event) => {
        setPhoneNumber(event.target.value);
    }

    // post signup
    const handleSignup = (event) => {
        event.preventDefault();

        axios.post(signupUrl,
            {
                email: email,
                nickName: userName,
                password: password,
                phoneNumber: phoneNumber
            },
            {
                headers: {
                    "Content-Type": "application/json",
                    Accept: "application/json",
                    withCredentials: true,
                    "Access-Control-Allow-Origin": "*"
                }
            })
            .then(response => {
                navigate('/login')
                console.log('회원가입 성공', response);
            })
            .catch(error =>
                console.log('error:', error)
            )
        // navigate('/login')
    }

    return (
        <SignupContainer>
            <Link to='/main' className="logo">구르미</Link>
            <form onSubmit={(event) => event.preventDefault()} className='signup-form'>
                <label>user name</label>
                <input
                    type='text'
                    id='userName'
                    autoComplete='off'
                    required
                    value={userName}
                    onChange={handleUserName}
                >
                </input>
                <label>email</label>
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
                <label>phone number</label>
                <input
                    type='text'
                    id='userPhoneNumber'
                    autoComplete='off'
                    required
                    value={phoneNumber}
                    onChange={handlePhoneNumber}
                >
                </input>
                <button className="signup_btn" onClick={handleSignup}>Sign up</button>
            </form>
        </SignupContainer>
    )
}

const SignupContainer = styled.div`
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

.signup-form{
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    width: 20rem;
    height: 20rem;

    input, .signup_btn{
        height: 2rem;
        border-radius: .5rem;
        border: 1px solid black;
        outline-color: #238f51;
        padding: 0 .5rem;
    }

    .signup_btn{
        height: 2.5rem;
        border: none;
        background-color: #238f51;
        color: white;
        font-size: 1vmax;
    }

    .signup_btn:hover{
        font-size: 1.1vmax;
    }
}
`