import Post from "./Post";

const Feed = ({ posts, onChange  }) => {
  return (
    <>
      {posts.map((post) => (
        <Post key={post.id} post={post}  onChange={onChange}  />
      ))}
    </>
  );
};

export default Feed;
