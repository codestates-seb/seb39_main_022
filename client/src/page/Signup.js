import React from "react";
import { Link } from 'react-router-dom';
import styled from "styled-components";

export default function Signup() {
    return (
        <SignupContainer>
            <Link to='/main'>구르미</Link>
            <form onSubmit={(e) => e.preventDefault()} className='signup-form'>
                <label htmlFor='userName'>Display name</label>
                <input
                    type='text'
                    id='userName'
                    autoComplete='off'
                    required
                >
                </input>
                <label htmlFor='userEmail'>Email</label>
                <input
                    type='text'
                    id='userEmail'
                    autoComplete='off'
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
                <button>Sign up</button>
            </form>
        </SignupContainer>
    )
}

const SignupContainer = styled.div`
border: 1px solid black;
height: 100vh;
display: flex;
flex-direction: column;
justify-content: center;
align-items: center;

.signup-form{
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