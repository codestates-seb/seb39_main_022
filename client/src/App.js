import './App.css';
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
  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route path='/' element={<Landing />} />
          <Route path='/main' element={<Main />} />
          <Route path='/signup' element={<Signup />} />
          <Route path='/login' element={<Login />} />
          <Route path='/favorite' element={<Favorite />} />
          <Route path='/favorite/:id' element={<FavoriteDetail />} />
          <Route path='/addReview' element={<AddReview />} />
          <Route path='/review/:id' element={<Review />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
