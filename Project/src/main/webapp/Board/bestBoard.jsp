<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>베스트</title>
<link rel="stylesheet" href="css/Project.css">
<link rel="stylesheet" href="css/Board.css">
<script src="https://kit.fontawesome.com/fc7ebf84d2.js" crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="/guide_bar.jsp"%>
	<main id="main">
		<div id="main_wrap">
			<div id="main_contents">
				<div class="container">
					<div class="item">
					<div id="list" class="aside_contents">
						<strong class="title"><i class="fas fa-clipboard-list"></i>커뮤니티</strong>
							<ul>
								<li>커뮤니티</li>
							</ul>
					</div>
					</div>
					<div class="item">
						<div>
							<strong class="title"><i class="fas fa-comments"></i>베스트</strong>
						</div>
						<table class="board_table">
							<colgroup>
								<col width="100px">
								<col>
								<col width="90px">
								<col width="80px">
								<col width="100px">
							</colgroup>
							<tr>
								<th><p>게시판</p></th>
								<th><p>제목</p></th>
								<th><p>글쓴이</p></th>
								<th><p>조회</p></th>
								<th><p>시간</p></th>
							</tr>
							<c:if test="${list != null}">
								<c:if test="${empty searchTag}">
									<c:forEach var="dto" items="${list}">
										<tr>
											<td>${dto.board_code}</td>
											<td>											
												<div class="article_list">
												<a class="text_over" href="view.do?no=${dto.no}">${dto.title}</a>											
												<span class="replyCnt">[${dto.replyCnt}]</span>											
												</div>
											</td>
											<td>${dto.nickname}</td>
											<td>${dto.hit}</td>
											<td>${dto.wtime}</td>
										</tr>
									</c:forEach>
								</c:if>
								<c:if test="${not empty searchTag}">
									<c:forEach var="dto" items="${list}">
										<tr>
											<td>${dto.board_code}</td>
											<td>
												<div class="article_list">
												<a href="view.do?no=${dto.no}&&searchF=1">${dto.title}</a>											
												<span class="replyCnt">[${dto.replyCnt}]</span>											
											</div>
											</td>
											<td>${dto.nickname}</td>
											<td>${dto.hit}</td>
											<td>${dto.wtime}</td>
										</tr>
									</c:forEach>
								</c:if>
							</c:if>
						</table>
						<div class="board_bottom_bar">
							<div class="bottom_button_bar">				
								<a class="refresh_button" href="#" onclick="window.location.reload()" style="justify-self: start;"><i class="fas fa-sync-alt"></i>새로고침</a>								
							</div>
							<div class="bottom_page_bar">
								<c:set var="page" value="${param.page}" />
								<c:if test="${page eq null }">
									<c:set var="page" value="1" />
								</c:if>
								<c:choose>
									<c:when test="${not empty pageCnt}">
										<c:if test="${page != 1}">
											<a href="best.do&page=${page-1}"><i class="fas fa-caret-left"></i></a>
										</c:if>
										<c:forEach var="i" begin="${pageStart}" end="${pageEnd}" step="1">
											<c:if test="${i eq page}"> <a href="#" style="color: #0073E6;">${page}</a> </c:if>
											<c:if test="${i ne page}">
												<a href="best.do&page=${i}">${i}</a>
											</c:if>
										</c:forEach>
										<c:if test="${pageCnt != page}">
											<a href="best.do&page=${page+1}"><i class="fas fa-caret-right"></i></a>
										</c:if>										
									</c:when>
									<c:when test="${not empty searchPageCnt}">
										<c:if test="${page != 1}">
											<a href="bestSearch.do&searchTag=${searchTag}&search=${search}&page=${page-1}"><i class="fas fa-caret-left"></i></a>
										</c:if>
										<c:forEach var="i" begin="1" end="${searchPageCnt}" step="1">
											<c:if test="${i eq page}"> <a href="#" style="color: #0073E6;">${i}</a> </c:if>
											<c:if test="${i ne page}">
												<a href="bestSearch.do&searchTag=${searchTag}&search=${search}&page=${i}">${i}</a>
											</c:if>
										</c:forEach>
										<c:if test="${searchPageCnt != page}">
											<a href="bestSearch.do&searchTag=${searchTag}&search=${search}&page=${page+1}"><i class="fas fa-caret-right"></i></a>
										</c:if>
									</c:when>
								</c:choose>
							</div>
							<form action="bestSearch.do" method="post">
								<div class="bottom_search_bar">
									<select name="searchTag" id="searchTag"
										class="bottom_search_select">
										<option value="title">제목
										<option value="title+contents">제목+내용
										<option value="nickname">작성자
									</select> <input type="text" name="search" id="search_input" class="bottom_search_input"
										autocomplete="off">
									<button type="submit" class="bottom_search_button">
										<i class="fas fa-search"></i>
									</button>
								</div>
							</form>
						</div>
					</div>
					<%@ include file="/side_bar.jsp"%>
				</div>
			</div>
		</div>
	</main>
	<footer id="footer">
		<div id="footer_wrap">
			<h1>Portfolio project K.A.R</h1>
		</div>
	</footer>
	<script src="js/Basic.js"></script>
	<script>
		if ("${searchTag}" != "") {
			searchTag.value = "${searchTag}";
			search_input.value = "${search}";
		}
	</script>
</body>
</html>