<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>리뷰</title>
<link rel="stylesheet" href="/css/bootstrap.min.css" />
</head>
<body>

	<div class="container py-4">

		<jsp:include page="/menus" />

		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">${movie.title}</h1>
				<p class="col-md-8 fs-4">Review</p>
			</div>
		</div>

		<div class="row align-items-md-stretch text-center">
			<form name="newUpdate" action="#" method="post">

				<div class="mb-3 row">
					<label class="col-sm-2 text-start d-flex align-items-center">작성자</label>
					<div class="col-sm-3 d-flex align-items-center">
						<p class="form-control-plaintext text-start m-0">${review.member_id}</p>
					</div>
				</div>

				<div class="mb-3 row">
					<label class="col-sm-2 text-start d-flex align-items-center">제목</label>
					<div class="col-sm-5 d-flex align-items-center">
						<p class="form-control-plaintext text-start m-0">${review.review_title}</p>
					</div>
				</div>

				<div class="mb-3 row">
					<label class="col-sm-2 text-start d-flex align-items-center">내용</label>
					<div class="col-sm-8 d-flex align-items-center">
						<p class="form-control-plaintext text-start m-0" style="white-space: pre-wrap; word-wrap: break-word;"><c:out value="${review.content}" /></p>
					</div>
				</div>

				<div class="mb-3 row">
					<label class="col-sm-2 text-start d-flex align-items-center">평점</label>
					<div class="col-sm-3 d-flex align-items-center">
						<p class="form-control-plaintext text-start m-0">${review.rating}</p>
					</div>
				</div>
			</form>
			
			<div>
				<button class="like-btn btn btn-dark" data-review-id="${review.id}">
					좋아요 (<span id="like-count-${review.id}">${review.like_count ne null ? review.like_count : 0}</span>)
				</button>
			</div>
			
			<div class="text-end mt-3">
				<c:if test="${not empty user and user.id == review.user_id}">
				    <form action="/reviews/delete/${review.id}" method="post" style="display: inline;">
				        <input type="hidden" id="movie_id" name="movie_id" value="${movie.id}"/>
				        <input type="submit" class="btn btn-danger" value="삭제 하기"/>
				    </form>
				</c:if>
				<a href="/movies/reviews/${review.movie_id}" class="btn btn-primary">돌아가기</a>
			</div>
		</div>
		
		<jsp:include page="/footers" />
		
	</div>
</body>
</html>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	//좋아요
	$(document).ready(function() {
		$(".like-btn").on("click", function() {
			var reviewId = $(this).data("review-id");
			var userId = "${user != null ? user.id : ''}";
	
			if (!userId || userId === "undefined") {
				alert("로그인 후 이용해주세요.");
				return;
			}
	
			$.post("/likes/" + reviewId + "/" + userId, function(response) {
				if (response === "success") {
					$.get("/likes/" + reviewId + "/count", function(count) {
						$("#like-count-" + reviewId).text(count);
					});
				}
			});
		});
	});
</script>