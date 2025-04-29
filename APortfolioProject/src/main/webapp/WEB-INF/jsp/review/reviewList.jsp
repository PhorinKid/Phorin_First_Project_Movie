<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>${movie.title}-리뷰 목록</title>
<link rel="stylesheet" href="/css/bootstrap.min.css" />
</head>
<body>

	<div class="container py-4">

		<jsp:include page="/menus" />

		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">${movie.title}</h1>
				<p class="col-md-8 fs-4">Reviews</p>
			</div>
		</div>

		<div class="row align-items-md-stretch text-center">
			<form action="<c:url value="/movies/reviews/${movie.id}"/>"
				method="get">

				<input type="hidden" name="page" value="${currentPage}" />
				<input type="hidden" id="movie_id" name="movie_id" value="${movie.id}" />
				<input type="hidden" id="user_id" name="user_id" value="${user.id}" />

				<div class="text-end">
					<span class="badge text-bg-success">전체 ${totalReviews}건</span>
				</div>

				<div style="padding-top: 20px">
					<table class="table table-hover text-center">
						<tr>
							<th style="width: 15%;">작성자</th>
							<th style="width: 45%;">제목</th>
							<th style="width: 10%;">평점</th>
							<th style="width: 20%;">등록일</th>
							<th style="width: 10%;">좋아요</th>
						</tr>

						<c:forEach var="review" items="${reviews}">
							<tr>
								<td>${review.member_id}</td>
								<td><a href="<c:url value="/reviews/${review.id}"/>">${review.review_title}</a></td>
								<td>${review.rating}</td>
								<td>${review.dates}</td>
								<td>${review.like_count}</td>
							</tr>
						</c:forEach>
					</table>
				</div>

				<div class="text-center py-3">
				  <c:forEach var="i" begin="1" end="${totalPages}">
				    <c:choose>
				      <c:when test="${i == currentPage}">
				        <button class="btn btn-primary btn-sm mx-1" disabled>${i}</button>
				      </c:when>
				      <c:otherwise>
				        <a href="?page=${i}&type=${type}&keyword=${keyword}" class="btn btn-outline-secondary btn-sm mx-1">${i}</a>
				      </c:otherwise>
				    </c:choose>
				  </c:forEach>
				</div>

				<div class="py-3" align="right">
					<a href="#" onclick="checkForm(); return false;"
						class="btn btn-primary">&laquo;글쓰기</a>
				</div>

				<div class="py-3 d-flex justify-content-between align-items-center">
					<div class="d-flex align-items-center">
						<select name="type" class="form-select me-1" style="width: auto;">
							<option value="subject" ${type eq 'subject' ? 'selected' : ''}>제목</option>
							<option value="content" ${type eq 'content' ? 'selected' : ''}>내용</option>
							<option value="name" ${type eq 'name' ? 'selected' : ''}>작성자</option>
						</select> <input name="keyword" type="text" class="form-control me-1"
							style="width: 200px;" value="${keyword}" /> <input type="submit"
							class="btn btn-primary" value="검색" />
					</div>

					<div>
						<a href="/movies/detail/${movie_id}" class="btn btn-primary">돌아가기</a>
						<a href="/movies/list" class="btn btn-primary">영화 목록</a>
					</div>
				</div>
			</form>
		</div>

		<jsp:include page="/footers" />

	</div>

</body>
</html>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function checkForm() {
		const userId = '${user.id}';
		if (!userId) {
			alert("로그인 해주세요.");
			return false;
		}
		location.href = "/reviews/reviewWrite/${movie.id}";
	}
</script>