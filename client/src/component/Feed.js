import Post from "./Post";

const Feed = ({ posts, loading }) => {
  return (
    <>
      {posts.map((post) => (
        <Post key={post.id} post={post} loading={loading}/>
      ))}
    </>
  );
};

export default Feed;
