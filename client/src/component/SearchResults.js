import Feed from "./Feed";

const SearchResults = ({ posts =[], loading }) => {
  return (
    <main
      className="SearchResults"
      style={{ overflow: "auto", height: "100%" }}>
      {posts.length !== 0 ? (
        <Feed posts={posts} loading={loading} />
      ) : (
        <p style={{ marginTop: "2rem", color:"lightgray"}}>장소가 없습니다.</p>
      )}
    </main>
  );
};

export default SearchResults;
