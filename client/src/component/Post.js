import styled from "styled-components";

// 로딩이 있는이유는 데이터가 아직 pending상태일때 잠시 뭐라도 보여주는 것
// 즉 데이터를 호출하는 곳에서 로딩컴포넌트가 있으면 된다.

const Post = ({ post }) => {
  return (
    <Container>
      <article className="post">
        <ul>
          <li key={post.id}>
            <button id={post.id}>
              <h2>{post.title}</h2>
            </button>
            <p className="postBody">
              {post.body.length >= 0 ? post.body : `주소 미등록...`}
            </p>
            <p style={{color:"gray"}}>∙ 구 주소: {post.소재지지번주소}</p>
            <div className="fliterBox">
              <span>
                {post.공기주입가능여부 === "Y"
                  ? "공기주입 O"
                  : "공기주입 X"}
              </span>

              <span>
                {post.휴대전화충전가능여부 === "Y"
                  ? "휴대전화 충전 O"
                  : "휴대전화 충전 X"}
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
  padding: 0.5rem 0;

  font-size: 1rem;
  border-bottom: solid 2px lightcoral;
  
  button {
    margin-bottom: .5rem;
    margin-top: .5rem;

    background-color: lightgray;
    color: #000;
  }
  li {
    font-size: smaller;
    line-height: 1rem;
    display: list-item;
    list-style: none;
  }
p{    margin-bottom: 3px;
}
span{
  color: white;
background-color: #f05d4d;
border-radius: 5px;
padding: .3rem;
margin-right: 1rem;
}
.fliterBox{
  margin-top: 12px;
  margin-bottom: 5px;

}
`;
