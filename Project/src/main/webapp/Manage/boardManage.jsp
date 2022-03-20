<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판 관리(관리자 전용)</title>
<link rel="stylesheet" href="css/Project.css">
<link rel="stylesheet" href="css/manage.css">
<script src="https://kit.fontawesome.com/fc7ebf84d2.js" crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="/guide_bar.jsp"%>
	<div class="table_container">
	<table>
		<tr class="header">
			<th>게시판 코드</th>
			<th>게시판 이름</th>
			<th>게시판 분류1</th>
			<th>게시판 분류2</th>
			<th>게시글 수</th>
			<th>게시판 관리자 id</th>
			<th>글 작성 권한</th>
			<th>게시판 삭제</th>	
		</tr>
	<c:if test="${boardList != null}">
		<c:forEach var="dto" items="${boardList}">
			<tr>
				<td>${dto.board_code}</td>
				<td>${dto.board_name}</td>
				<td>${dto.board_category1}</td>
				<td>${dto.board_category2}</td>
				<td>${dto.article_Cnt}</td>
				<td>${dto.admin_id}</td>
				<td>
					<c:choose>
					<c:when test="${dto.admin_write eq false}">
					모든 유저
					</c:when>
					<c:when test="${dto.admin_write eq true}">
					관리자
					</c:when>
					</c:choose>
				</td>
				<td>
					<c:if test="${dto.board_importance eq false}">
						<a href="deleteBoard.do?bCode=${dto.board_code}">삭제</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>	
	</c:if>
	</table>
	</div>
	
	<div class="container">	
	<form action="createBoard.do" method="post" autocomplete="off">
	<h3>게시판 생성</h3>
	<div class="create_board_container">
		<label for="board_code">게시판 코드</label> <input type="text" name="board_code" id="board_code" required>
		<label for="board_name">게시판 이름</label> <input type="text" name="board_name" id="board_name" required>
		
		<div class="board_category1">
		<p>게시판 분류1</p>		
		<div><input type="checkbox" name="board_category1[]" value="playstation">Playstation</div>
		<div><input type="checkbox" name="board_category1[]" value="nintendo">Nintendo</div>
		<div><input type="checkbox" name="board_category1[]" value="xbox">Xbox</div>
		<div><input type="checkbox" name="board_category1[]" value="pc">PC</div>
		<div><input type="checkbox" name="board_category1[]" value="mobile">Mobile</div>
		<div><input type="checkbox" name="board_category1[]" value="arcade">AC/고전</div>
		<div><input type="checkbox" name="board_category1[]" value="community">Community</div>
		<div><input type="checkbox" name="board_category1[]" value="news">News</div>
		</div>
					
		<label for="board_category2">게시판 분류2</label>
		<select name="board_category2" id="board_category2">
			<option value="common">일반
			<option value="picture">사진	
			<option value="news">뉴스			
		</select>
		<label for="admin_write">작성 권한</label>
		<select name="admin_write" id="admin_write">
			<option value="False">모든 유저
			<option value="True">관리자만 작성					
		</select>
		<div class="center_button create_button">
			<input type="submit" value="게시판 생성">
		</div>
	</div>
	</form>
	</div>
	<footer id="footer">
        <div id="footer_wrap">
            <h1>footer</h1>
        </div>
    </footer>
<script src="js/Basic.js"></script>
</body>
</html>