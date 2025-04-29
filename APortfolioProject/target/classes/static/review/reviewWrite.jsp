<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title> 리뷰 작성 </title>
</head>
<script type="text/javascript">
	function checkForm() {
		if (!document.newWrite.name.value) {
			alert("성명을 입력하세요.");
			return false;
		}
		if (!document.newWrite.subject.value) {
			alert("제목을 입력하세요.");
			return false;
		}
		if (!document.newWrite.content.value) {
			alert("내용을 입력하세요.");
			return false;
		}
	}
</script>
<body>
	<div>
		
		 <div>
	     	<div>
		        <h1>게시판</h1>
		        <p>Board</p>      
	    	</div>
	    </div>
	
		<div>
			<form name="newWrite" action="#"  method="post" onsubmit="return checkForm()">
				<input type="hidden" name="user_id" value="${user.id}">
				<div>
					<label>성명</label>
					<div>
						<input name="name" type="text" class="form-control" value="" placeholder="name">
					</div>
				</div>
				<div>
					<label>제목</label>
					<div>
						<input name="subject" type="text" class="form-control" placeholder="subject">
					</div>
				</div>
				<div>
					<label>내용</label>
					<div>
						<textarea name="content" cols="50" rows="5" class="form-control"placeholder="content"></textarea>
					</div>
				</div>
				<div>
					<div>
						<input type="submit" class="btn btn-primary " value="등록 ">				
						<input type="reset" class="btn btn-primary " value="취소 ">
					</div>
				</div>
			</form>
		</div>
		
	</div>
</body>
</html>



