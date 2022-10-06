import Feed from "./Feed";

const SearchResults = ({ searchResults, loading }) => {
  return (
    <main
      className="SearchResults"
      style={{ overflow: "auto", height: "100%" }}>
      {searchResults.length ? (
        <Feed posts={searchResults} loading={loading} />
      ) : (
        <p style={{ marginTop: "2rem" }}>장소가 없습니다.</p>
      )}
    </main>
  );
};

export default SearchResults;
