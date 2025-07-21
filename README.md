# 영화 리뷰 사이트

## 프로젝트 소개
영화 정보를 검색하고, 리뷰를 작성하고, 평점 및 좋아요 기능을 통해 다른 사용자와 소통할 수 있는 **영화 리뷰 웹사이트**입니다.  
TMDB API를 활용하여 최신 영화 정보를 가져오고, 사용자 중심의 리뷰 시스템을 구현한 개인 포트폴리오 프로젝트입니다.

---

## 사용 기술 스택
- **Backend**: Spring Boot, Java, MyBatis  
- **Frontend**: JSP, JavaScript, CSS  
- **Database**: MySQL  
- **API**: TMDB (The Movie Database) API

---

## 주요 기능
### 사용자 기능
- 회원가입, 로그인, 로그아웃
- 회원 정보 수정 및 회원 탈퇴

### 영화 기능
- TMDB API를 활용하여 영화 목록 불러오기
- 영화별 상세 페이지 이동

### 리뷰 기능
- 영화별 리뷰 작성 페이지 제공
- 리뷰에 평점 입력 기능
- 리뷰 좋아요 기능
- 리뷰 목록 및 상세 조회

---

## 프로젝트 선정 배경

OTT 서비스와 영화 콘텐츠 소비가 증가하면서, 사용자들이 자신만의 의견을 나누고 평가를 공유할 수 있는 공간의 수요도 늘어나고 있습니다.  
이 프로젝트는 TMDB API를 통해 영화 정보를 자동으로 받아오고, 사용자 리뷰 기능을 통해 **사용자 참여 기반의 영화 커뮤니티 환경**을 구현하고자 시작되었습니다.

단순한 게시판 형식이 아닌, **평점**, **좋아요**, **댓글(추후 구현)** 등의 기능을 통해 사용자 간 상호작용이 가능하도록 설계했습니다.

---

## 주요 화면 설계 이유

### 로그인 페이지 설계 이유

- **사용자 친화적인 인터페이스**: 단순한 입력창과 깔끔한 레이아웃으로, 첫 사용자도 쉽게 사용할 수 있도록 구성
- **시각적 안정감**: 푸른 계열의 배경과 미니멀 UI를 사용하여 신뢰감과 몰입도를 높임
- **회원가입**로 접근성과 실용성 강화
- **입력 유효성 검사 (JavaScript)** 를 통해 잘못된 입력 방지

---

## 기술 및 플랫폼 선택 이유

### API 선택 (TMDB)
- **TMDB API**는 영화 데이터베이스를 무료로 제공하며, 정식 포스터 이미지와 상세 정보(장르, 줄거리, 평점 등)를 포함하고 있어 영화 관련 프로젝트에 최적
- 복잡한 영화 등록 절차 없이, **REST API로 실시간 정보 제공 가능**

### 기술 스택 선택 사유

| 기술 | 선택 이유 |
|------|-----------|
| **Spring Boot** | 안정적인 구조와 다양한 웹 기능을 빠르게 구축 가능 |
| **MyBatis** | SQL 작성 자유도가 높고, 복잡한 쿼리 작업에 용이 |
| **JSP** | 프로젝트 규모가 작고, 빠르게 UI와 연결해보기 좋음 |
| **JavaScript** | 프론트엔드 유효성 검사 및 동적 처리를 위해 사용 |
| **MySQL** | 널리 사용되는 관계형 DB로 프로젝트 배포에 유리 |

---

## 프로젝트 구조

```
<summary>프로젝트 구조 보기</summary>

Movie Reviews
├── common/
├── configuration/
├── controller/
├── dto/
├── mapper/
├── service/
├── views/       #JSP
└── static/      #CSS, JS
```
---

## 주요 화면
  
- 회원가입
  
 ![회원가입](https://github.com/user-attachments/assets/c1b70303-b55a-43ae-88c9-b5486c2bd5a4)

- 로그인

 ![로그인](https://github.com/user-attachments/assets/c45c6628-a7c4-4416-aa44-8ac82410bbd9)

- 영화 목록

 ![영화목록](https://github.com/user-attachments/assets/2a7ec4d7-98fa-4f2d-8f1f-c3dec8db19cc)

- 리뷰 목록

 ![리뷰목록](https://github.com/user-attachments/assets/74a282cb-2a32-4887-8f1c-5c8e6a801070)

- 리뷰

 ![리뷰](https://github.com/user-attachments/assets/c74a6a1d-dddf-4dc6-9fa1-a568d1557414)

---

## 개발자
- **PhorinKid**  
  GitHub: [https://github.com/PhorinKid](https://github.com/PhorinKid)

---

## 라이선스
이 프로젝트는 개인 포트폴리오용으로 제작되었으며, 비상업적 용도로 자유롭게 활용하실 수 있습니다.
