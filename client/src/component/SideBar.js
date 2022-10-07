import { Routes, Route } from "react-router-dom";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import styled from "styled-components";

import Nav from "./Nav";
import SearchResults from "./SearchResults";
import Pagination from "./Pagination";

import api from "../api/posts";

const Sidebar = () => {
  const [posts, setPosts] = useState([]);
  const [search, setSearch] = useState("");
  const [searchResults, setSearchResults] = useState([]);

  const [favoriteList, setFavoriteList] = useState([]);

  const [loading, setLoading] = useState(true);
  // pagenation-----------------------------------
  // 페이지당 게시물 수(pagenationLimit) pageSize
  const [pagenationLimit] = useState(5);
  // 현재 페이지 번호(currentPageNumber)
  const [currentPageNumber, setCurrentPageNumber] = useState(1);

  // pagenation-----------------------------------
  useEffect(() => {
    const getPosts = async () => {
      try {
        //데[이터를 부르는 로직 = 로딩컴포넌트의 위치.
        const response = await api.get("/posts");
        setPosts(response.data); //200응답 ok
        setFavoriteList(response.data);
        setLoading(false);
      } catch (err) {
        if (err.response) {
          // 리스폰 응답 실패.
          console.log(err.response.data);
          console.log(err.response.status);
          console.log(err.response.headers);
        } else {
          console.log(`error: ${err.message}`);
        }
        setLoading(false);

      }
    };
    getPosts();
  }, []);

  // useEffect(() => {
  //   const filteredResults = posts.filter(
  //     (post) => post.소재지도로명주소.includes(search) || post.title.includes(search)
  //   );
  //   filteredResults.reverse()

  //   setSearchResults(filteredResults);
  // }, [posts, search, setSearchResults]);

  // 모달창 노출 여부 state -------------------------
  const [modalOpen, setModalOpen] = useState(false);
  //const [navBoxOpen, setNavBoxOpen] = useState(true);

  // 모달창 노출
  const showModal = () => {
    setModalOpen(true);
    //setNavBoxOpen(false);
  };
  const closeModal = () => {
    setModalOpen(false);
    //setNavBoxOpen(true);
  };

  const onChange = (event) => {
    const currentSearch = event.target.value;

    const titleSearch = posts.filter(
      (post) =>
        post.title.includes(currentSearch) || post.body.includes(currentSearch)
    );

    titleSearch.reverse();

    setSearchResults(titleSearch);

    setSearch(currentSearch);
  };


  return (
    <SidebarContainer>
      <header>
        <button
          onClick={() => {
            closeModal();
          }}>
          ☁️
        </button>
        <h1>구르미</h1>
        <button>{`<`}</button>
      </header>
      <Nav
 style={{texDecoration: "none",
 }}
        showModal={showModal}
        search={search}
        setSearch={setSearch}
        onChange={onChange}
      />
      {modalOpen && (
        <>
          <SearchResults posts={searchResults} loading={false} />
          <Pagination
            total={favoriteList?.length}
            pagenationLimit={pagenationLimit}
            currentPageNumber={currentPageNumber}
            setCurrentPageNumber={setCurrentPageNumber}
          />
        </>
      )}
      {loading && (
        <div
          style={{
            position: "fixed",
            top: "50%",
            left: "50%",
            zIndex: "99999999",
            borderRadius: '99999px',
            transform: "translate(-50%, -50%)",
            width: "100px",
            height: "100px",
            backgroundColor: "rgba(0,0,0,0.5)",
            background: "#f05d4d",
            color: "white",
          }}
        >
          {" "}
          loading...{" "}
        </div>
      )}
      <Routes>
        <Route
          path="/searchResults"
          element={
            modalOpen && (
              <SearchResults posts={searchResults} loading={loading} />
            ) && (
              <Pagination
                total={favoriteList?.length}
                pagenationLimit={pagenationLimit}
                currentPageNumber={currentPageNumber}
                setCurrentPageNumber={setCurrentPageNumber}
              />
            )
          }
        />
      </Routes>

      <section className="socialBtn">
        <Link to="/login">로그인</Link>
        <Link to="/signup">회원가입</Link>
      </section>
      <section className="moveBtn">
        <Link to="/about">사용법</Link>
        <Link to="/favorite">즐겨찾기</Link>
      </section>
    </SidebarContainer>
  );
};
export default Sidebar;
const SidebarContainer = styled.div`
  font-size: 1rem;
  
  /* border: 1px solid black; */
  display: flex;
  flex-direction: column;
  width: 30vw;
  padding: 1.5rem 1rem;
  box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
  height: 100vh;
  .search-bar {
    height: 2.5rem;
    padding: 0.5rem;
    border-radius: 0.5rem;
    border: 1px solid #238f51;
    outline-color: #238f51;
  }
  .socialBtn {
    margin: 1rem 0;
    /* border: 1px solid black; */
    display: flex;
    justify-content: space-between;
    a {
      width: 8.5rem;
      height: 2rem;
      line-height: 2rem;
      border-radius: 0.5rem;
      border: none;
      background-color: #238f51;
      text-decoration: none;
      text-align: center;
      font-size: 1rem;
      color: white;
    }
  }
  header {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    button {
      width: 3rem;
      height: 3rem;
    background-color: #fec126;
    color: white;
    font-size: larger;
    }
  }
  button {
    width: 8rem;
    height: 2rem;
    border-radius: 0.5rem;
    border: none;
    width: auto;
    padding: 0 1rem;


  }
  .moveBtn {
    /* border: 1px solid black; */
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    height: 3rem;
    a {
      text-decoration: none;
      font-size: 1rem;
      color: #238f51;
    }
  }
`;
