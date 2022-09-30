import {  useNavigate, Routes, Route } from "react-router-dom";
import { useState, useEffect } from "react";

import styled from "styled-components";

import Nav from "./Nav";
import Home from "./Home";
import NewPost from "./NewPost";
import PostPage from "./PostPage";
import About from "./About";
import Missing from "./Missing";
import api from "../api/posts";


// import { format } from "date-fns"; // <----날짜 라이브러리 설치----> npm i date-fns
//import {ko} from "date-fns/locale";

const SideBar =()=> {
  const [posts, setPosts] = useState([]);
  const [search, setSearch] = useState("");
  const [searchResults, setSearchResults] = useState([]);
  const [reviewTitle, setReviewTitle] = useState("");
  const [reviewDescription, setReviewDescription] = useState("");
const [reviews, setReviews] = useState([]);
  const history = useNavigate();

  useEffect(()=>{
    const getPosts = async () => {
      try{
        const response = await api.get('/posts');
        setPosts(response.data); //200응답 ok
      } catch (err) { 
        if (err.response){ // 리스폰 응답 실패.
          console.log(err.response.data);
          console.log(err.response.status);
          console.log(err.response.headers);
        }else{
          console.log(`error: ${err.message}`)
        }

      }
    }
    getPosts();
  },[])

  useEffect(() => {
    const filteredResults = posts.filter(
      (post) =>
        (post.body).includes(search) ||
        (post.title).includes(search)
    );

    setSearchResults(filteredResults.reverse());
  }, [posts, search]);
//-----
  const handleSubmit = async(e) => {
    e.preventDefault();
    const id = reviews.length ? reviews[reviews.length - 1].id + 1 : 1;
    // const datetime = format(new Date(), "MMMM dd, yyyy pp");
    const newReview = { id, title: reviewTitle,  body: reviewDescription };
   try {
    // const response = await api.post('/posts') //이건 후기추가
     const allReviews = [...reviews, newReview];
     setReviews(allReviews);
     setReviewTitle("");
     setReviewDescription("");
    history("/");

   }catch(err){
    console.log(`error: ${err.message}`)
   }
  };

  const handleDelete = (id) => {
    const postsList = posts.filter((post) => post.id !== id);
    setPosts(postsList);
    history("/");
  };

  return (

    <>
    <Container>

      <div className="SideBar">
        <Header>
        <button>▶︎</button>
        <h1>구르미</h1>
        <button>{`<`}</button>
        </Header>
        
       
        <Nav search={search} setSearch={setSearch} />
        <Routes>
          <Route exact path="/" element={<Home posts={searchResults} />} />
          </Routes>
      </div>
 
    <Routes>
        <Route exact path="/post" element={<NewPost
          handleSubmit={handleSubmit}
          reviewTitle={reviewTitle}
          setReviewTitle={setReviewTitle}
          reviewDescription={reviewDescription}
          setReviewDescription={setReviewDescription} />} />
        <Route path="/post/:id" element={<PostPage posts={posts} handleDelete={handleDelete} />} />
        <Route path="/about" element={<About />} />
        <Route path="*" element={<Missing />} />
      </Routes>
      </Container>     
      
      </>
    
  );
}

export default SideBar;

const Container =styled.div`

background-color: lavender;
display: flex;
  flex-direction:row;
  /* border: 1px solid #333;
  box-shadow: 0px 0px 15px gray; */
  .SideBar{
    padding: 1rem;
    height: 100vh;
    border: 1px solid #333;
  }
`;
const Header = styled.div`
display: flex;
  flex-direction:row;
  justify-content: space-between;
`

