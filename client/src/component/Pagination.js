import React from "react";
import styled from "styled-components";

// prop으로 받은 것
// 총 게시물 수(total) 10
// 페이지당 게시물 수(pagenationLimit) 5
// 현재 페이지 번호(currentPageNumber) 1
function Pagination({ total, pagenationLimit, currentPageNumber, setCurrentPageNumber }) {
  // 필요한 페이지의 개수 계산
  // ex) 10/5 = 2
  const pageSize = Math.ceil(total / pagenationLimit);

  return (
    <>
      <Nav>
        {/* disabled === 비활성화 */}
        <Button onClick={() => setCurrentPageNumber(currentPageNumber => currentPageNumber - 1)} disabled={currentPageNumber === 1}>
          &lt;
        </Button>
        {Array(pageSize)
          .fill()
          .map((_, i) => (
            <Button
              key={i + 1}
              onClick={() => setCurrentPageNumber(i + 1)}
              // aira-current === 현재 페이지
              aria-current={currentPageNumber === i + 1 ? "currentPageNumber" : null}
            >
              {i + 1}
            </Button>
          ))}
        <Button onClick={() => setCurrentPageNumber(currentPageNumber + 1)} disabled={currentPageNumber === pageSize}>
          &gt;
        </Button>
      </Nav>
    </>
  );
}

const Nav = styled.nav`
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 1rem;
`;

const Button = styled.button`
  border: none;
  border-radius: 1rem;
  padding: .5rem;
  background: black;
  color: white;
  font-size: 1.5vmax;

  &:hover {
    background: #238f51;
    cursor: pointer;
  }

  &[disabled] {
    background: grey;
    cursor: revert;
    transform: revert;
  }

  &[aria-current] {
    background: #238f51;
    font-weight: bold;
    cursor: revert;
    transform: revert;
  }
`;

export default Pagination;