import React from "react";


import styled from "styled-components";


const AddReview =({
 
  handleSubmit,
  
  reviewDescription,
  setReviewDescription,
}) => {
    


  return (
    <Review>
      <main className="newReview">
        <h2>후기작성</h2>
        <form className="newReviewForm" onSubmit={handleSubmit}>
          <label htmlFor="reviewTitle">제목:</label>
          <label htmlFor="ReviewBody">내용:</label>
          <textarea
            id="reviewBody"
            required
            value={reviewDescription}
            onChange={(e) => setReviewDescription(e.target.value)}
          />
         
          {/* <Link to={`/favorite/${Review.id}`}></Link> */}
         <button type="submit">등록하기</button>
          <button>삭제하기</button>
        </form>
      </main>
    </Review>
  );
};


export default AddReview;

const Review = styled.div`
    width:100vw;
    height: 100vh;

  .newReview{
    width: 50%;
    height: 100%;
    margin: auto;
      display: flex;
       flex-direction:column;
       text-align: center;
align-items: center;
justify-content: center;
h2{
    margin-bottom: 2rem;
}
}
.newReviewForm{
    width: 50%;
    height: 50%;
    border-radius: 1rem;
      background-color: #238f51;
    display: flex;
       flex-direction:column;
  }
`;
