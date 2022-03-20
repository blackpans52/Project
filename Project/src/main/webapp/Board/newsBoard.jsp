<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${boardInfo.board_name}</title>
<link rel="stylesheet" href="css/Project.css">
<link rel="stylesheet" href="css/Board.css">
<link rel="stylesheet" href="css/NewsBoard.css">
<script src="https://kit.fontawesome.com/fc7ebf84d2.js" crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="/guide_bar.jsp"%>
	<main id="main">
		<div id="main_wrap">
			<div id="main_contents">
				<div class="container">
					<%@ include file="/left_side_bar.jsp"%>
					<div class="item">
						<div>
							<strong class="title"><i class="fas fa-comments"></i>${boardInfo.board_name}</strong>
						</div>
						<div class="category_bar">
						<c:choose>
							<c:when test="${aCode eq 'multi'}">
								<a class="tag_on1" href="board.do?bCode=${boardInfo.board_code}">All</a>
							</c:when>
							<c:when test="${aCode ne 'multi'}">
								<a href="board.do?bCode=${boardInfo.board_code}">All</a>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test="${aCode eq 'playstation'}">
								<a class="tag_on2" href="board.do?aCode=playstation&&bCode=${boardInfo.board_code}">P/S</a>
							</c:when>
							<c:when test="${aCode ne 'playstation'}">
								<a href="board.do?aCode=playstation&&bCode=${boardInfo.board_code}">P/S</a>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test="${aCode eq 'nintendo'}">
								<a class="tag_on2" href="board.do?aCode=nintendo&&bCode=${boardInfo.board_code}">Nin</a>
							</c:when>
							<c:when test="${aCode ne 'nintendo'}">
								<a href="board.do?aCode=nintendo&&bCode=${boardInfo.board_code}">Nin</a>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test="${aCode eq 'xbox'}">
								<a class="tag_on2" href="board.do?aCode=xbox&&bCode=${boardInfo.board_code}">Xbox</a>
							</c:when>
							<c:when test="${aCode ne 'xbox'}">
								<a href="board.do?aCode=xbox&&bCode=${boardInfo.board_code}">Xbox</a>
							</c:when>
						</c:choose>	
						<c:choose>
							<c:when test="${aCode eq 'pc'}">
								<a class="tag_on2" href="board.do?aCode=pc&&bCode=${boardInfo.board_code}">PC</a>
							</c:when>
							<c:when test="${aCode ne 'pc'}">
								<a href="board.do?aCode=pc&&bCode=${boardInfo.board_code}">PC</a>
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test="${aCode eq 'mobile'}">
								<a class="tag_on3" href="board.do?aCode=mobile&&bCode=${boardInfo.board_code}">Mobile</a>
							</c:when>
							<c:when test="${aCode ne 'mobile'}">
								<a href="board.do?aCode=mobile&&bCode=${boardInfo.board_code}">Mobile</a>
							</c:when>
						</c:choose>
						</div>
						<c:if test="${list != null}">
							<div class="news_board">
								<c:if test="${empty searchTag}">
									<ul>
										<c:forEach var="dto" items="${list}">
											<li>
												<div class="news_article">
													<img alt="" src="${dto.thumbnail}" width="180px"
														height="90px">
													<div class="news_article_info">
														<span class="news_article_title"><a
															href="view.do?no=${dto.no}">${dto.title}</a> <span
															class="replyCnt">[${dto.replyCnt}]</span> </span>
														<div>
															<span class="news_article_contents">${dto.contents}</span>
														</div>
														<div class="etc_info">
															<span>${dto.wtime}</span> <span>조회수 ${dto.hit}</span> <span>${dto.nickname}</span>
														</div>
													</div>
												</div>
											</li>
										</c:forEach>
									</ul>
								</c:if>

								<c:if test="${not empty searchTag}">
									<ul>
										<c:forEach var="dto" items="${list}">
											<li>
												<div class="news_article">
													<img alt="" src="${dto.thumbnail}" width="180px"
														height="90px">
													<div class="news_article_info">
														<span class="news_article_title"><a
															href="view.do?no=${dto.no}&&searchF=1">${dto.title}</a> <span
															class="replyCnt">[${dto.replyCnt}]</span> </span>
														<div>
															<span class="news_article_contents">${dto.contents}</span>
														</div>
														<div class="etc_info">
															<span>${dto.wtime}</span> <span>조회수 ${dto.hit}</span>
														</div>
													</div>
												</div>
											</li>
										</c:forEach>
									</ul>
								</c:if>							
						</c:if>
					</div>
					<div class="board_bottom_bar">
						<div class="bottom_button_bar">
							<c:choose>
								<c:when test="${boardInfo.admin_write eq true}">
									<c:choose>
										<c:when
											test="${boardInfo.admin_id eq userInfo.id or userInfo.authority == 'admin'}">
											<a class="write_button"
												href="write.do?bCode=${boardInfo.board_code}"
												style="justify-self: start;"><i
												class="fas fa-pencil-alt"></i>글쓰기</a>
											<a class="refresh_button"
												href="#" onclick="window.location.reload()"
												style="justify-self: end;"><i class="fas fa-sync-alt"></i>새로고침</a>
										</c:when>
										<c:when test="${true}">
											<a class="refresh_button"
												href="#" onclick="window.location.reload()"
												style="justify-self: start;"><i class="fas fa-sync-alt"></i>새로고침</a>
										</c:when>
									</c:choose>
								</c:when>
								<c:when test="${boardInfo.admin_write eq false}">
									<c:choose>
										<c:when test="${not empty userInfo}">
											<a class="write_button"
												href="write.do?bCode=${boardInfo.board_code}"
												style="justify-self: start;"><i
												class="fas fa-pencil-alt"></i>글쓰기</a>
											<a class="refresh_button" href="#" onclick="window.location.reload()"
												style="justify-self: end;"><i class="fas fa-sync-alt"></i>새로고침</a>
										</c:when>
										<c:when test="${true}">
											<a class="refresh_button" href="#" onclick="window.location.reload()"
												style="justify-self: start;"><i class="fas fa-sync-alt"></i>새로고침</a>
										</c:when>
									</c:choose>
								</c:when>
							</c:choose>
						</div>
						<div class="bottom_page_bar">
							<c:set var="page" value="${param.page}" />
							<c:if test="${page eq null }">
								<c:set var="page" value="1" />
							</c:if>
							<c:choose>
								<c:when test="${not empty pageCnt}">
									<c:choose>
									<c:when test="${empty aCode}">
									<c:if test="${page != 1}">
										<a href="board.do?bCode=${boardInfo.board_code}&page=${page-1}"><i class="fas fa-caret-left"></i></a>
									</c:if>
									<c:forEach var="i" begin="${pageStart}" end="${pageEnd}"
										step="1">
										<c:if test="${i eq page}">
											<a href="#" style="color: #0073E6;">${page}</a>
										</c:if>
										<c:if test="${i ne page}">
											<a href="board.do?bCode=${boardInfo.board_code}&page=${i}">${i}</a>
										</c:if>
									</c:forEach>
									<c:if test="${pageCnt != page}">
										<a href="board.do?bCode=${boardInfo.board_code}&page=${page+1}"><i class="fas fa-caret-right"></i></a>
									</c:if>
									</c:when>
									<c:when test="${not empty aCode}">
									<c:if test="${page != 1}">
										<a
											href="board.do?aCode=${aCode}&&bCode=${boardInfo.board_code}&page=${page-1}"><i
											class="fas fa-caret-left"></i></a>
									</c:if>
									<c:forEach var="i" begin="${pageStart}" end="${pageEnd}"
										step="1">
										<c:if test="${i eq page}">
											<a href="#" style="color: #0073E6;">${page}</a>
										</c:if>
										<c:if test="${i ne page}">
											<a href="board.do?aCode=${aCode}&&bCode=${boardInfo.board_code}&page=${i}">${i}</a>
										</c:if>
									</c:forEach>
									<c:if test="${pageCnt != page}">
										<a
											href="board.do?aCode=${aCode}&&bCode=${boardInfo.board_code}&page=${page+1}"><i
											class="fas fa-caret-right"></i></a>
									</c:if>
									</c:when>
									</c:choose>
								</c:when>
								<c:when test="${not empty searchPageCnt}">
									<c:choose>
									<c:when test="${empty aCode}">
									<c:if test="${page != 1}">
										<a href="search.do?bCode=${boardInfo.board_code}&searchTag=${searchTag}&search=${search}&page=${page-1}"><i class="fas fa-caret-left"></i></a>
									</c:if>
									<c:forEach var="i" begin="1" end="${searchPageCnt}" step="1">
										<c:if test="${i eq page}">
											<a href="#" style="color: #0073E6;">${i}</a>
										</c:if>
										<c:if test="${i ne page}">
											<a
												href="search.do?bCode=${boardInfo.board_code}&searchTag=${searchTag}&search=${search}&page=${i}">${i}</a>
										</c:if>
									</c:forEach>
									<c:if test="${searchPageCnt != page}">
										<a href="search.do?bCode=${boardInfo.board_code}&searchTag=${searchTag}&search=${search}&page=${page+1}"><i class="fas fa-caret-right"></i></a>
									</c:if>
									</c:when>
									<c:when test="${not empty aCode}">
									<c:if test="${page != 1}">
										<a href="search.do?aCode=${aCode}&&bCode=${boardInfo.board_code}&searchTag=${searchTag}&search=${search}&page=${page-1}"><i class="fas fa-caret-left"></i></a>
									</c:if>
									<c:forEach var="i" begin="1" end="${searchPageCnt}" step="1">
										<c:if test="${i eq page}">
											<a href="#" style="color: #0073E6;">${i}</a>
										</c:if>
										<c:if test="${i ne page}">
											<a
												href="search.do?aCode=${aCode}&&bCode=${boardInfo.board_code}&searchTag=${searchTag}&search=${search}&page=${i}">${i}</a>
										</c:if>
									</c:forEach>
									<c:if test="${searchPageCnt != page}">
										<a href="search.do?aCode=${aCode}&&bCode=${boardInfo.board_code}&searchTag=${searchTag}&search=${search}&page=${page+1}"><i class="fas fa-caret-right"></i></a>
									</c:if>
									</c:when>
									</c:choose>
								</c:when>
							</c:choose>
						</div>
						<form action="search.do" method="post">
							<div class="bottom_search_bar">
								<select name="searchTag" id="searchTag"
									class="bottom_search_select">
									<option value="title">제목
									<option value="title+contents">제목+내용
								</select> <input type="text" name="search" id="search_input"
									class="bottom_search_input" autocomplete="off"> 
									<input type="hidden" name="bCode" value="${boardInfo.board_code}">
									<input type="hidden" name="aCode" value="${aCode}">
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

		const extractTextPattern = /(<([^>]+)>)/gi;
		let target = document.getElementsByClassName('news_article_contents');

		for (i = 0; i < target.length; i++) {
			let src = target[i].innerHTML;
			let extractedText = src.replace(extractTextPattern, '');
			target[i].innerHTML = extractedText;
		}
	</script>
</body>
</html>