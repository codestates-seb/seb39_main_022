import { Link} from 'react-router-dom';

import styled from "styled-components";

const Nav = ({ search, setSearch }) => {
    return (
        <NavBar>
            <form className="searchForm" onSubmit={(e) => e.preventDefault()}>
                
                <input
                    id="search"
                    type="text"
                    placeholder="장소를 입력하세요."
                    value={search || ''}
                    onChange={(e) => setSearch(e.target.value)}
                />
            <ul>
                <li><Link to="/">Home</Link></li>
                <li><Link to="/about">이용방법</Link></li>
                <li><Link to='/favorite'>즐겨찾기</Link></li>
                <li><Link to="/post">후기작성</Link></li> 
            </ul>
            </form>
        </NavBar>
    )
}

export default Nav

 const NavBar = styled.div`
  width: 100%;
  max-width: 40vw;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: flex-start;
  border: 1px solid red;

  input{ height:3rem; width:100%; margin:auto;}

  ul,li {list-style-type: none; float: left; margin-right:1rem;}
`;