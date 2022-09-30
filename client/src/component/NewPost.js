
const NewPost = ({ // 후기는 리뷰!!! (기억해- 이름바꾸기)
  handleSubmit,
  reviewTitle,
  setReviewTitle,
  reviewDescription,
  setReviewDescription,
}) => {
  return (
    <main className="NewPost">
      <h2>후기작성</h2>
      <form className="newPostForm" onSubmit={handleSubmit}>
        <label htmlFor="postTitle">제목:</label>
        <input
          id="postTitle"
          type="text"
          required
          value={reviewTitle}
          onChange={(e) => setReviewTitle(e.target.value)}
        />
        <label htmlFor="postBody">내용:</label>
        <textarea
          id="postBody"
          required
          value={reviewDescription}
          onChange={(e) => setReviewDescription(e.target.value)}
        />
        <button type="submit">등록하기</button>
        {/* <Link to={`/favorite/${post.id}`}></Link> */}
        <button> Delete Post</button>
      </form>
    </main>
  );
};

export default NewPost;
