import React, { useEffect, useRef, useState } from 'react';
import styled from 'styled-components';

import Sidebar from '../component/Sidebar';
import Slide from '../component/About';

const TOTAL_SLIDES = 2; // 전체 슬라이드 개수(총3개. 배열)

export default function AboutSlider() {
  const [currentSlide, setCurrentSlide] = useState(0);
  const slideRef = useRef(null);
  const img1 = '..asset/1.png';
  const img2 = '..asset/1.png';
  const img3 = '..asset/1.png';

  // Next 버튼 클릭 시
  const NextSlide = () => {
    if (currentSlide >= TOTAL_SLIDES) {
      // 더 이상 넘어갈 슬라이드가 없으면,
      setCurrentSlide(0); // 1번째 사진으로 넘어감.
      // return;  // 클릭이 작동하지 x.
    } else {
      setCurrentSlide(currentSlide + 1);
    }
  };
  // Prev 버튼 클릭 시
  const PrevSlide = () => {
    if (currentSlide === 0) {
      setCurrentSlide(TOTAL_SLIDES); // 마지막 사진으로 넘어감.
      // return;  // 클릭이 작동하지 x.
    } else {
      setCurrentSlide(currentSlide - 1);
    }
  };

  useEffect(() => {
    slideRef.current.style.transition = 'all 0.5s ease-in-out';
    slideRef.current.style.transform = `translateX(-${currentSlide}00%)`; 
  }, [currentSlide]);

  return (
    <>
    <Container>
    <Sidebar />
    <div className='aboutContainer'>

      <Text>
        <h1>사용방법</h1>
        <p>{currentSlide + 1}번 째 설명</p>
      </Text>
      <SliderContainer ref={slideRef}>
        <Slide img={img1} />
        <Slide img={img2} />
        <Slide img={img3} />
      </SliderContainer>
      <Center>
        <Button onClick={PrevSlide}>Prev</Button>
        <Button onClick={NextSlide}>Next</Button>
      </Center>
    </div>
    </Container>
    </>
  );
}
const Container = styled.div`
display: flex;
  .aboutContainer{
    width: 500px;
    margin: auto;
    height: 1000px;
    overflow: hidden; 

  }
`;
const Button = styled.div`
  all: unset;
  padding: 1em 2em;
  margin: 2em 2em;
  color: burlywood;
  border-radius: 10px;
  border: 1px solid burlywood;
  cursor: pointer;
  &:hover {
    background-color: burlywood;
    color: #fff;
  }
`;
const SliderContainer = styled.div`
  margin: 0 auto;
  margin-bottom: 2em;
  display: flex; 
`;
const Text = styled.div`
  text-align: center;
  color: burlywood;
  p {
    color: #fff;
    font-size: 20px;
    background-color: burlywood;
    display: inline-block;
    border-radius: 50px;
    padding: 0.5em 1em;
  }
`;
const Center = styled.div`
  text-align: center;
`;