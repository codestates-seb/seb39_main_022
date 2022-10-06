// const theme = {
//     color: {
//      primary: '#03a9f4', // 주 색상
//      secondary: '#795548', // 부 색상
//      white: '#FFFFFF',
//      gray: '#CCCCCC',
//      default: '#999999', // 기본 문자 색상
//      error: '#FF0000', // 오류 색상
//    }
//  }


const colors = {
    red: "#f05d4d",
    yellow: "#fec126",
    green: "#238f51",
  };

  const size = {
    mobile: "479px",
    tablet: "991px",
    desktop: "2000px",
  };
  

  // 미디어 쿼리의 중복 코드를 줄이기위해 정의된 변수입니다
const device = {
    mobile: `@media only screen and (max-width: ${size.mobile})`,
    tablet: `@media only screen and (max-width: ${size.tablet})`,
    desktopL: `@media only screen and (max-width: ${size.desktop})`,
  };
  