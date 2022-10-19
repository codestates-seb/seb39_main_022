import React, { useState, useEffect } from 'react';
import axios from "axios";
import styled from "styled-components";

function Search() {
    const [searchList, setSearchList] = useState([]);
    const [search, setSearch] = useState("");

    const handleSearch = (event) => {
        setSearch(event.target.value);
    }

    const placeName = searchList.map(searchItem => searchItem.시설명)
    const filter = placeName.filter((searchItem) => {
        return searchItem.includes(search)
    })

    // get searchList
    useEffect(() => {
        const getSearchList = async () => {
            const response = await axios.get('http://localhost:4000/data');
            setSearchList(response.data)

        }

        getSearchList();
    }, []);
    // console.log(searchList)

    return (
        <SearchContainer>
            <input type='text' className="search-bar" placeholder="충전소를 검색해주세요" onChange={handleSearch} />
            <ul>
                {filter.map((item) => {
                    return (
                        <li key={item}>
                            {item}
                        </li>
                    )
                })}
            </ul>
        </SearchContainer>
    )
}

export default Search


const SearchContainer = styled.div`
    .search-bar{
        width: 100%;
        height: 2.5rem;
        padding: .5rem;
        border-radius: 0.5rem;
        border: 1px solid #238f51;
        outline-color: #238f51;
    }
`