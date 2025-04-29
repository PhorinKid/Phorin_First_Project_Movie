<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>${movie.title}-영화 정보</title>
<link rel="stylesheet" href="/css/bootstrap.min.css" />
</head>
<body>

	<!-- 에러 표시 -->
	<c:if test="${not empty error}">
		<script type="text/javascript">
			alert("${error}");
		</script>
	</c:if>

	<!-- 메시지 표시 -->
	<c:if test="${not empty message}">
		<script type="text/javascript">
			alert("${message}");
		</script>
	</c:if>

	<div class="container py-4">

		<jsp:include page="/menus" />

		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">영화 정보</h1>
				<p class="col-md-8 fs-4">MovieInfo</p>
			</div>
		</div>

		<div class="row align-items-md-stretch">
			<div class="col-md-5">
				<img src="https://image.tmdb.org/t/p/w500${movie.poster_path}" alt="${movie.title}" class="img-fluid">
			</div>

			<div class="col-md-6">
				<h3><b>${movie.title}</b></h3>
				<p><b>개봉일 : </b>${movie.release_date}
				<p><b>평점 : </b>${movie.rating}
				<p><b>줄거리</b><br>${movie.overview}
				<p>
					<a href="<c:url value='/movies/reviews/${movie.id}'/>" class="btn btn-success">리뷰 목록 &raquo;</a>
					<a href="/movies/list" class="btn btn-warning">영화 목록 &raquo;</a>
				</p>
			</div>
		</div>

		<jsp:include page="/footers" />

	</div>

</body>
</html>