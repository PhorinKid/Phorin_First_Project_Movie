<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>리뷰 작성</title>
<link rel="stylesheet" href="/css/bootstrap.min.css" />
</head>
<body>

	<div class="container py-4">

		<jsp:include page="/menus" />

		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">${movie.title}</h1>
				<p class="col-md-8 fs-4">Review Write</p>
			</div>
		</div>

		<div class="row align-items-md-stretch text-center">
			<form name="newWrite" action="/reviews/add" method="post" onsubmit="return checkForm()">
			
				<input type="hidden" name="movie_id" value="${movie.id}">
				<input type="hidden" name="user_id" value="${user.id}">

				<div class="mb-3 row">
					<label class="col-sm-2 control-label text-start">작성자</label>
					<div class="col-sm-3">
						<input name="name" type="text" class="form-control" value="${user.username}" placeholder="name" readonly>
					</div>
				</div>

				<div class="mb-3 row">
					<label class="col-sm-2 control-label text-start">제목</label>
					<div class="col-sm-5">
						<input name="review_title" type="text" class="form-control" placeholder="subject">
					</div>
				</div>

				<div class="mb-3 row">
					<label class="col-sm-2 control-label text-start">내용</label>
					<div class="col-sm-8">
						<textarea name="content" cols="50" rows="5" class="form-control" placeholder="content"></textarea>
					</div>
				</div>

				<div class="mb-3 row">
					<label class="col-sm-2 control-label text-start">평점</label>
					<div class="col-sm-3">
						<input type="number" name="rating" class="form-control w-50" min="0" max="10" step="0.1" placeholder="rating">
					</div>
				</div>

				<div class="mb-3 row">
					<div class="col-sm-offset-2 col-sm-10 ">
						<input type="submit" class="btn btn-success" value="작성 완료">
						<a href="/movies/reviews/${movie.id}" class="btn btn-danger">작성 취소</a>
					</div>
				</div>
			</form>
		</div>

		<jsp:include page="/footers" />

	</div>
</body>
</html>
<script type="text/javascript">
	function checkForm() {
		if (!document.newWrite.review_title.value.trim()) {
			alert("제목을 입력하세요.");
			return false;
		}
		if (!document.newWrite.content.value.trim()) {
			alert("내용을 입력하세요.");
			return false;
		}
		if (!document.newWrite.rating.value.trim()) {
			alert("평점을 입력하세요.");
			return false;
		}
		return true;
	}
</script>
