import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Landing from './page/Landing';
import Favorite from './page/Favorite';
import Detail from './page/Detail';
import AddReview from './page/AddReview';

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route path='/' element={<Landing />} />
          <Route path='/favorite' element={<Favorite />} />
          <Route path='/favorite/:id' element={<Detail />} />
          <Route path='/addReview' element={<AddReview />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
