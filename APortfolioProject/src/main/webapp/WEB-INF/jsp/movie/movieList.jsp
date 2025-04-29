<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>영화 목록</title>
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
				<h1 class="display-5 fw-bold">영화 목록</h1>
				<p class="col-md-8 fs-4">MovieList</p>
			</div>
		</div>

		<div class="row align-items-md-stretch text-center">
			<c:forEach var="movie" items="${movies}">
				<div class="col-md-4">
					<div class="h-100 p-2">
						<img src="https://image.tmdb.org/t/p/w500${movie.poster_path}" alt="${movie.title} 포스터" class="img-fluid" style="max-width: 250px; height: auto;">
						<h5><b>${movie.title}</b></h5>
						<p>
							<b>개봉일 :</b> ${movie.release_date} <br>
							<b>평점 :</b> ${movie.rating}
						<p><a href="<c:url value='/movies/detail/${movie.id}'/>" class="btn btn-secondary" role="button">상세 정보 &raquo;</a>
					</div>
				</div>
			</c:forEach>
		</div>

		<jsp:include page="/footers" />

	</div>

</body>
</html>