import { useParams, Link } from "react-router-dom";

const CommentList = ({ posts }) => {
  const { id } = useParams();
  const review = posts.find((review) => review.id.toString() === id);
  return (
    <main className="CommentList">
      <article className="review">
        {review && (
          <>
            <h2>{review.title}</h2>
            <p className="reviewDate">{review.datetime}</p>
            <p className="reviewBody">{review.comment}</p>
          </>
        )}
        {!review && (
          <>
            <h2>Post Not Found</h2>
            <p>Well, that's disappointing.</p>
            <p>
              <Link to="/main">Visit main Homepage</Link>
            </p>
          </>
        )}
      </article>
    </main>
  );
};

export default CommentList;
