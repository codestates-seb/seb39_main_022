import './App.css';
import { useEffect, useState } from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Landing from './page/Landing';
import Main from './page/Main';
import Signup from './page/Signup';
import Login from './page/Login';
import Favorite from './page/Favorite';
import FavoriteDetail from './page/FavoriteDetail';
import AddReview from './page/AddReview';
import Review from './page/Review';


function App() {
  const [uniqueId, setUniqueId] = useState("");
  const [isLogin, setIsLogin] = useState(false);

  // 한 번 로그인 체크
  useEffect(() => {
    const id = localStorage.getItem("id")

    if (id) {
      setUniqueId(id)
    }
  }, [])

  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route path='/' element={<Landing />} />
          <Route path='/main'
            element={<Main
              isLogin={isLogin}
            />} />
          <Route path='/signup' element={<Signup />} />
          <Route
            path='/login'
            element={<Login
              setUniqueId={setUniqueId}
              setIsLogin={setIsLogin}
            />} />
          <Route path='/favorite' element={<Favorite />} />
          <Route
            path='/favorite/:id'
            element={<FavoriteDetail
              uniqueId={uniqueId}
            />} />
          <Route path='/addReview' element={<AddReview />} />
          <Route path='/review/:id' element={<Review />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
