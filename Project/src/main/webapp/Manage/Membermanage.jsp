<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원 관리(관리자 전용)</title>
<link rel="stylesheet" href="css/Project.css">
<link rel="stylesheet" href="css/manage.css">
<script src="https://kit.fontawesome.com/fc7ebf84d2.js" crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="/guide_bar.jsp"%>
	<div class="table_container">
	<table style="width: 1800px;">
		<tr class="header">
			<th>아이디</th>
			<th>닉네임</th>
			<th>이메일</th>
			<th>우편번호</th>		
			<th>도로명주소</th>		
			<th>상세주소</th>		
			<th>참고항목</th>		
			<th>전화번호</th>		
			<th>권한</th>
			<th>게시판 권한 부여</th>
			<th>정지 현황</th>
			<th>정지 처리</th>
		</tr>
	<c:if test="${memberList != null}">
		<c:forEach var="dto" items="${memberList}">
			<c:if test="${dto.id ne 'admin'}">
			<tr>
				<td>${dto.id}</td>
				<td>${dto.nickname}</td>
				<td>${dto.email}</td>
				<td>${dto.postcode}</td>
				<td>${dto.roadAddress}</td>
				<td>${dto.detailAddress}</td>
				<td>${dto.extraAddress}</td>
				<td>${dto.tel}</td>
				<td>
					<c:forEach var="board" items="${boardList}">
					<c:if test="${board.admin_id eq dto.id}">														
					${board.board_name} <br>			
					</c:if>	
					</c:forEach>
				</td>
				<td>
					<form action="memberAuthority.do" method="post">
					<select name="authority">
						<c:forEach var="board" items="${boardList}">
							<option value="${board.board_code}">${board.board_name}
						</c:forEach>
					</select>
					<input type="hidden" name="admin_id" value="${dto.id}">
					<input type="submit" value="권한 부여">
					</form>
				</td>
				<td>
					${dto.ban_time}
				</td>
				<td>
					<c:if test="${empty dto.ban_time}">
						<form action="memberBan.do" method="post">
						<select name="ban_time">
							<option value="3">3일 정지
							<option value="7">7일 정지
							<option value="30">30일 정지
							<option value="-1">영구 정지
						</select>
						<input type="hidden" name="id" value="${dto.id}">
						<input type="submit" value="정지 부여">
						</form>
					</c:if>
				</td>
			</tr>
		</c:if>	
		</c:forEach>
	</c:if>
	</table>
	</div>
	<footer id="footer">
        <div id="footer_wrap">
            <h1>footer</h1>
        </div>
    </footer>
<script src="js/Basic.js"></script>
</body>
</html>