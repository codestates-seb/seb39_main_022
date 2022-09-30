import styled from "styled-components";

const Footer = () => {
    const today = new Date();
    return (
        <FooterBox>
        <footer className='Footer'>
            <p>Copyright &copy; {today.getFullYear()}{` <Tearm 22> 굴러굴러`} </p>
        </footer>
        </FooterBox>
    )
}

export default Footer
const FooterBox =styled.div`
display: none;
    /* position : relative;
    transform : translateY(0) */
`
