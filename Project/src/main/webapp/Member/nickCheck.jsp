<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>닉네임 중복 확인</title>
</head>
<body>
	<c:if test="${empty result}">
		<h3> 닉네임 중복체크 </h3>
		<form method="post" action="nickCheckOK.do" onsubmit="return blankCheck(this)">
			닉네임 : <input type="text" name="nick" autofocus>
			<input type="submit" value="중복확인">
		</form>
	</c:if>
	<c:if test="${not empty result}">
		입력 닉네임 : <strong>${nick}</strong>
	<c:choose>
		<c:when test="${not result}">
			<p>사용 가능한 닉네임입니다..</p>
			<a href="javascript:apply('${nick}')">[적용]</a>
		</c:when>
		<c:when test="${result}">
			<c:if test="${notModify}">
				<p>수정되지 않았습니다.</p>
				<a href="javascript:apply('${nick}')">[적용]</a>
			</c:if>
			<c:if test="${not notModify}">
				<p>해당 닉네임은 사용하실 수 없습니다.</p>			
			</c:if>
		</c:when>		
	</c:choose>	
	<a href="javascript:history.back()">[다시시도]</a>
	<a href="javascript:window.close()">[창닫기]</a>
	</c:if>
<script>	
	function blankCheck(form){
		let nick = form.nick.value;
		nick = nick.trim();
		if(id.length < 2){
			alert("닉네임은 2자 이상 입력해주십시오.");
			return false;
		}
		return true;
	}
	
	function apply(nick){
		opener.document.signUp.nickname.value = nick;
		window.close();
	}
</script>
</body>
</html>