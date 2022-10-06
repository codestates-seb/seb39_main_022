import './App.css';

import {  Routes, Route } from "react-router-dom";

import Landing from './page/Landing';
import Main from './page/Main';
import Signup from './page/Signup';
import Login from './page/Login';
import Favorite from './page/Favorite';
import FavoriteDetail from './page/FavoriteDetail';
import AddReview from './page/AddReview';
import Review from './page/Review';
import About from './page/AboutSlider';
import SearchResults from './component/SearchResults';

function App() {
  // const [posts, setPosts] = useState([]);


  // const [reviewTitle, setReviewTitle] = useState("");
  // const [reviewDescription, setReviewDescription] = useState("");
  // const [reviews, setReviews] = useState([]);
  // const history = useNavigate();

  // //-- 리뷰 api ▼ ----------------------------------------
  // useEffect(() => {
  //   const getPosts = async () => {
  //   try {
  //       const response = await axios.get("http://localhost:4000/comments");
  //       setPosts(response.data); //comment api가져오기.
  //     } catch (err) {
  //       if (err.response) {
  //         // 리스폰 응답 실패.
  //         console.log(posts);
  //         console.log(err.response.data);
  //         console.log(err.response.status);
  //         console.log(err.response.headers);
  //       } else {
  //         console.log(`error: ${err.message}`);
  //       }
  //     }
  //   };
  //   getPosts();
  // }, []);


  // //-- 리뷰작성 ▼ ----------------------------------------
  // const handleSubmit = async (e) => {
  //   e.preventDefault();
  //   const id = reviews.length ? reviews[reviews.length - 1].id + 1 : 1;
  //   // const datetime = format(new Date(), "MMMM dd, yyyy pp");
  //   const newReview = { id, title: reviewTitle, body: reviewDescription };
  //   try {
  //     // const response = await api.post('/posts') //이건 후기추가
  //     const allReviews = [...reviews, newReview];
  //     setReviews(allReviews);
  //     setReviewTitle("");
  //     setReviewDescription("");
  //     history("/");
  //   } catch (err) {
  //     console.log(`error: ${err.message}`);
  //   }
  // };
  return ( 
      <div className="App">
        <Routes>
          <Route path='/' element={<Landing />} />
          <Route path='/main' element={<Main />} />
          <Route path='/signup' element={<Signup />} />
          <Route path='/login' element={<Login />} />
          <Route path="/about" element={<About />} />
          <Route path='/favorite' element={<Favorite />} />
          <Route path='/favorite/:id' element={<FavoriteDetail />} />
          <Route path='/searchResults' element={<SearchResults />} />
          <Route path='/addreview' element={<AddReview />} />
          <Route path='/review/:id' element={<Review />} />
        </Routes>
      </div>
  );
}
export default App;