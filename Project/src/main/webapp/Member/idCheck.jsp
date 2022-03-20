<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>아이디 중복 확인</title>
</head>
<body>
	<c:if test="${empty result}">
		<h3> 아이디 중복체크 </h3>
		<form method="post" action="idCheckOK.do" onsubmit="return blankCheck(this)">
			아이디 : <input type="text" name="id" autofocus>
			<input type="submit" value="중복확인">
		</form>
	</c:if>
	<c:if test="${not empty result}">
		입력 ID : <strong>${id}</strong>
	<c:choose>
		<c:when test="${not result}">
			<p>사용 가능한 아이디입니다.</p>
			<a href="javascript:apply('${id}')">[적용]</a>
		</c:when>
		<c:when test="${result}">
			<p>해당 아이디는 사용하실 수 없습니다.</p>
			<a href="javascript:history.back()">[다시시도]</a>
			&nbsp; &nbsp;
			<a href="javascript:window.close()">[창닫기]</a>
		</c:when>		
	</c:choose>
	</c:if>
<script>	
	function blankCheck(form){
		let id = form.id.value;
		id = id.trim();
		if(id.length < 5){
			alert("아이디는 5자 이상 입력해주십시오.");
			return false;
		}
		return true;
	}
	
	function apply(id){
		opener.document.signUp.id.value=id;
		window.close();
	}
</script>
</body>
</html>