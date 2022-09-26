# 🧑🏻‍🦼 Gurumi 
📗 전동휠체어 급속충전기 위치 제공 서비스 <br/>
충전기 위치 및 바퀴 공기 주입, 휴대폰 충전 가능 유무까지 파악할수있는 지도 웹입니다 <br/><br/>

📗 팀원소개 <br/>
|BE|BE|FE|FE(팀장)|
|---|---|---|---|
|배용호|임동근|안수인|최지혜|

---


# Backend 계획서

## Environment

- Spring Data JPA
- Java 11 
- DB : Mysql
- API 문서 : Swagger
- API 호출 : Web Client
- 공공데이터 : https://www.data.go.kr/data/15034533/standard.do
- 지도데이터 : https://apis.map.kakao.com/
--- 

## 기능 요구사항 
> front-end의 

### 프로젝트 기한
* 기본 기능(게시판)으로 2주 안에 구현을 끝내는 것을 목표로 합니다.
* 9월 15일에(변경될 수 있음) 서버 배포를 먼저 시작합니다.
* 개발 기간은 데모데이 2주 전인 9/26 ~ 9/30일을 목표로 합니다. (정확한 날짜는 합의 필요) 이후 code freezing 
* 테스팅 기간은 10/7일에 끝내는 것을 목표로 합니다.
* 10월 10일에 통합테스트 11일에는 배포를 합니다.(수정 가능)

#### 요구사항 수정 

- 프런트 엔드와 협의하여 필수적인 기능을 먼저 구현하도록 요구사항을 수정하고 점진적인 개발을 할 수 있도록 합니다.
- 백엔드에 추가하기로 했던 스프링 시큐리티 기능을 쓰지 않을 것을 협의해야 함
- 이동욱님의 AWS 책을 참고(?)해서 OAuth2 기능 개발 - 프런트엔드의 요구
- View가 아닌 Restful API가 되도록 협의 

### 현재 요구사항 명세서 진행상황(미완성)

- ![images/specification1.png](images/specification1.png)
![img.png](img.png)


