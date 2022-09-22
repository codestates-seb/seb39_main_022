import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Landing from './page/Landing';
import Favorite from './page/Favorite';
import Detail from './page/Detail';

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route path='/' element={<Landing />} />
          <Route path='/favorite' element={<Favorite />} />
          <Route path='/detail' element={<Detail />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
