<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>회원 정보 수정</title>
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
				<h1 class="display-5 fw-bold">회원 수정</h1>
				<p class="col-md-8 fs-4">Membership Updating</p>
			</div>
		</div>

		<form action="/members/editMember" method="post">

			<input type="hidden" id="id" name="id" value="${user.id}" />

			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">성명</label>
				<div class="col-sm-3">
					<input class="form-control" type="text" id="username" name="username" placeholder="이름" value="${user.username}" required />
				</div>
			</div>

			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">이메일</label>
				<div class="col-sm-3 d-flex align-items-center">
					<input class="form-control flex-shrink-0" type="email" id="email" name="email" placeholder="이메일" value="${user.email}" required />
					<button type="button" id="checkEmailBtn" class="btn btn-primary flex-shrink-0 ms-1">중복 확인</button>
				</div>
			</div>

			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">비밀번호</label>
				<div class="col-sm-3">
					<input class="form-control" type="password" id="password" name="password" placeholder="비밀번호" />
					<span style="white-space: nowrap;">비밀번호를 변경하려면 입력하세요.</span>
				</div>
			</div>

			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">비밀번호 확인</label>
				<div class="col-sm-3">
					<input class="form-control" type="password" id="confirmPassword" name="confirmPassword" placeholder="비밀번호 확인" />
				</div>
			</div>

			<div class="mb-3 row">
				<div class="col-sm-offset-2 col-sm-10 ">
					<input type="submit" class="btn btn-primary" value="회원 수정">
					<input type="reset" class="btn btn-primary" value="초기화" onclick="reset()">
				</div>
			</div>

			<a href="/members/delete" class="btn btn-danger">회원 탈퇴</a>

		</form>

		<jsp:include page="/footers" />

	</div>

</body>
</html>
