import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import MapTest from './component/Map';
import Landing from './component/Landing';

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route path='/' element={<Landing />} />
          <Route path='/maptest' element={<MapTest />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
