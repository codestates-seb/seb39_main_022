import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

import styled from "styled-components";

const AddReview = () => {
  const navigate = useNavigate();
  // // const location = useLocation();

  // // AddReview delete-----------------------------
  const handleDeleteReview = () => {
    console.log("후기 삭제");

    navigate(-1);
  };
  const handleDeleteReview2 = () => {
    navigate(-1);
  };
  const [modalOpen, setModalOpen] = useState(false);
  const [modalOpen2, setModalOpen2] = useState(false);

  const showModal = () => {
    setModalOpen(true);
    //setNavBoxOpen(false);
  };
  // delete modal-----------------------------
  // const [deleteModal, setDeleteModal] = useState(false);
  const handleShowModal = () => {
    setModalOpen2(true);
  };
  const handleShowModalX = () => {
    setModalOpen2(false);
  };
  // const handleDeleteModal = () => {
  //   setDeleteModal(false);

  // };
  // // AddReview delete-----------------------------
  // const handleDeleteReview = async () => {
  //     try {
  //         const response = await axios.delete(`http://localhost:4000/comments/${location.state.commentId}`)
  //         if (true) {
  //             console.log('후기 삭제')
  //             navigate(-1)
  //         }
  //     } catch (error) {
  //         console.log('error:', error)
  //     }
  // };

  return (
    <Review>
      <main className="newReview">
        <h2>후기작성</h2>
        {/* <form className="newReviewForm" onSubmit={handleSubmit}> */}
        <div className="newReviewForm">
          <label htmlFor="reviewTitle">{`< 청담동 주민센터 >`}</label>
          <textarea
            id="reviewBody"
            required
            placeholder="후기를 작성해주세요."
          />

          {/* <Link to={`/favorite/${Review.id}`}></Link> */}
          {/* <Link to={"http://localhost:3000/favorite/0"}></Link> */}
          <button
            className="b1"
            type="submit"
            onClick={() => {
              showModal();
            }}>
            등록하기
          </button>
          <button
            className="b1"
            style={{ backgroundColor: "#f05d4d" }}
            onClick={() => {
              handleShowModal();
            }}>
            취소하기
          </button>
          {modalOpen && (
            <div
              onClick={() => {
                handleDeleteReview2();
              }}
              className="modalOpen1">
              <h2> 후기가 등록되었습니다.</h2>
            </div>
          )}
          {modalOpen2 && (
            <div className="modalOpen2">
              <p>후기작성을 취소하시겠습니까?</p>
              <button
                className="b2"
                onClick={() => {
                  handleShowModalX();
                }}>
                계속 작성하기
              </button>
              <button
                className="b2"
                style={{ backgroundColor: "#f05d4d" }}
                onClick={() => {
                  handleDeleteReview();
                }}>
                나가기
              </button>
            </div>
          )}
        </div>
        {/* 
        {deleteModal && (
          <div className="modal">

            <p>후기작성을 취소하시겠습니까?</p>
            <button onClick={handleShowModal()}>계속 작성하기</button>
            <button  onClick={handleDeleteReview}>작성하지 않기</button>
          </div>
          
        )}  */}
      </main>
    </Review>
  );
};

export default AddReview;

const Review = styled.div`
  width: 100vw;
  height: 100vh;
  background-color: rgb(255, 243, 243);
    textarea {
    height: 30%;
    text-align: center;
    padding: 1rem;
    margin-bottom: 2rem;
  }
  label {
    margin: 2rem 0;
    font-size: larger;
    color: white;
  }
  .newReview {
    width: 50%;
    height: 100%;
    margin: auto;
    display: flex;
    flex-direction: column;
    text-align: center;
    align-items: center;
    justify-content: center;
    h2 {
      margin: 0 2rem;
      margin-bottom: 2rem;
    }
  }
  .newReviewForm {
    width: 50vw;
    height: 50%;
    border-radius: 1rem;
    background-color: #238f51;
    display: flex;
    flex-direction: column;
  }
  .modalOpen1,
  .modalOpen2 {
    border: solid 2px white;  

    width: 50%;
    height: 50vh;
    margin: 0%;
    text-align: center;
    border-radius: 1rem;
    position: absolute;
    background-color: #fec126;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }
  .b1 {
    background-color: #fec126;
    color: white;
    font-size: 1rem;
    height: 2.5rem;
    width: 70%;
    margin: 5px auto;
  }
  .b2 {
    margin-top: 1rem;
    height: 2.5rem;
    width: 70%;    font-size: 1rem;

  }
  p {
background-color: white;
border-radius:5px;
padding: 1rem;
    margin: 3.5rem 0;
  }
  button {
    border-radius: 0.5rem;
    padding: 0.5rem;
    font-size: 1vmax;
    background-color: #238f51;
    border: ridge 2px white;  
    color: white;
    &:hover {
      box-shadow: rgba(0, 0, 0, 0.09) 0px 2px 1px, rgba(0, 0, 0, 0.09) 0px 4px 2px, rgba(0, 0, 0, 0.09) 0px 8px 4px, rgba(0, 0, 0, 0.09) 0px 16px 8px, rgba(0, 0, 0, 0.09) 0px 32px 16px;         }
  }
`;

