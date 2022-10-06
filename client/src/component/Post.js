import styled from "styled-components";

const Post = ({ post, loading }) => {
  return (
    <Container>
      <article className="post">
        {loading && <div style={{
          position:"fixed",
          top:"50%",
          left:"50%",
          zIndex:"999",
        }}> loading... </div>}

        <ul>
          <li key={post.id}>
            <button id={post.id}>
              <h2>{post.title}</h2>
            </button>
            <p className="postBody">
              {post.body.length >= 0 ? post.body : `주소 미등록...`}
            </p>
            <p>구 주소: {post.소재지지번주소}</p>
            <div className="fliterBox">
              <span>
                {post.공기주입가능여부 === "Y"
                  ? "공기주입 가능 "
                  : "공기주입 불가능"}
              </span>

              <span>
                {post.휴대전화충전가능여부 === "Y"
                  ? "휴대전화 충전가능"
                  : "휴대전화 충전 불가능"}
              </span>
            </div>
          </li>
        </ul>
      </article>
    </Container>
  );
};

export default Post;

export const Container = styled.ul`
  margin: auto;

  background-color: aqua;
  font-size: 1rem;
  li {
    display: list-item;
    list-style: none;
    border-bottom: solid 2px lightcoral;
  }
`;
