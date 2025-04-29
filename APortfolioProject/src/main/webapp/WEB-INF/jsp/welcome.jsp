<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="refresh" content="5">
<title>${greeting}</title>
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
                <h1 class="display-5 fw-bold">${greeting}</h1>
                <p class="col-md-8 fs-4">Movies</p>
            </div>
        </div>

        <div class="row align-items-md-stretch text-center">
            <div class="col-md-12">
                <div class="h-100 p-5">
                    <h3>${tagline}</h3>
                    <p>현재 접속 시간: <fmt:formatDate value="${currentTime}" pattern="hh:mm:ss a" /></p>
                </div>
            </div>
        </div>

        <jsp:include page="/footers" />

    </div>
    
</body>
</html>