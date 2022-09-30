import Feed from './Feed';

const Home = ({ posts }) => {
    return (
        <main className="Home" style={{overflow:"auto", height:"100%"}}>
            {posts.length ? (
                <Feed posts={posts} />
            ) : (
                <p style={{ marginTop: "2rem" }}>
                    장소가 없습니다.
                </p>
            )}

        </main>
    )
}

export default Home
