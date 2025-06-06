<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>회원 탈퇴</title>
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
				<h1 class="display-5 fw-bold">회원 탈퇴</h1>
				<p class="col-md-8 fs-4">Membership Joining</p>
			</div>
		</div>
	
		<form class="text-center" action="/members/deletemember" method="post">
			<p><b>탈퇴하시겠습니까?</b></p>
			<button type="submit" class="btn btn-danger">탈퇴 하기</button>
			<a href="/welcomes" class="btn btn-primary">취소</a>
		</form>

		<jsp:include page="/footers" />
		
	</div>
	
</body>
</html>
