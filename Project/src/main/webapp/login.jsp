<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/LogIn.css">
<title>로그인</title>
</head>
<body>
	<%
	Cookie[] cookies = request.getCookies();
	String id = "";
	String checked = "";

	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("id")) {
		id = cookies[i].getValue();
		checked = "checked";
		break;
			}
		}
	}
	%>
	<div class="login_container">
		<div class="item">
			<form action="loginOK.do" method="post" autocomplete="off">
				<div class="input-box">
					<input id="username" type="text" name="id" value="<%=id%>" placeholder="아이디"> 
					<label for="username">아이디</label>
				</div>
				<div class="input-box">
					<input id="pw" type="password" name="pw" placeholder="비밀번호">
					<label for="password">비밀번호</label>
				</div>
				<div class="check">
					<input type="checkbox" name="saveID" value="save" <%=checked%>>
					아이디 저장하기
				</div>
				<input type="hidden" name="from" value="<%= request.getHeader("referer")%>">
				<input type="submit" value="로그인"> 
				<input type="button"value="회원가입" onClick="location.href='sign_up.do'">
			</form>
		</div>
	</div>
</body>
</html>