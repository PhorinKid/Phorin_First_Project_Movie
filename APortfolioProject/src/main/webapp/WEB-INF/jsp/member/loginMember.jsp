<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>로그인</title>
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
				<h1 class="display-5 fw-bold">로그인</h1>
				<p class="col-md-8 fs-4">Membership Login</p>      
			</div>
		</div>
		
		<div class="container" align="center">
			<div class="col-md-4 col-md-offset-4">
				<h3 class="form-signin-heading">Please sign in</h3>
				
				<form class="form-signin" action="/members/loginProcess" method="post">
					<div class="form-floating mb-3 row">     
						<input type="text" class="form-control" id="member_id" name="member_id" placeholder="아이디" required autofocus/>
						<label for="floatingInput">ID</label>
					</div>
					
					<div class="form-floating  mb-3 row">     
						<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호" required />
						<label for="floatingPassword">Password</label>
					</div>
					<button class="btn btn-lg btn-success btn-block" type="submit">로그인</button>
				</form>
			</div>
			
			<div class="text-center">
				<span><b>계정이 없으신가요?</b> <a href="/members/addMember">회원 가입</a></span>
			</div>
		</div>
		
		<jsp:include page="/footers" />
		
	</div>

</body>
</html>