<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${boardInfo.board_name}</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
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
                    <%@ include file="/left_side_bar.jsp"%>
                    <div class="item">
                        <div>
                            <strong class="title"><i class="fas fa-images"></i>${boardInfo.board_name}</strong>                           
                        </div>
                        <div class="sub_container">
                        <c:if test="${empty searchTag}">
                        	<c:forEach var="dto" items="${list}">
                            <div class="item1">
                                <img src="${dto.thumbnail}" alt="">
                                <div class="picture_board_subject text_over">
                                    <p>
                                    	<a href="view.do?no=${dto.no}">${dto.title}</a>
										<span class="replyCnt">[${dto.replyCnt}]</span>
									</p>
                                </div>
                                <div class="picture_board_writer">
                                    <p>${dto.nickname}</p>
                                </div>
                            </div>
                            </c:forEach> 
                        </c:if>
                        <c:if test="${not empty searchTag}">
                        	<c:forEach var="dto" items="${list}">
                            <div class="item1">
                                <img src="${dto.thumbnail}" alt="">
                                <div class="picture_board_subject text_over">
                                    <p>
                                    	<a href="view.do?no=${dto.no}&&searchF=1">${dto.title}</a>
										<span class="replyCnt">[${dto.replyCnt}]</span>
									</p>
                                </div>
                                <div class="picture_board_writer">
                                    <p>${dto.nickname}</p>
                                </div>
                            </div>
                            </c:forEach>
                        </c:if>                                              
                        </div>
                        <div class="board_bottom_bar">
							<div class="bottom_button_bar">
								<c:choose>																
								<c:when test="${boardInfo.admin_write eq true}">
									<c:choose>																	
										<c:when test="${boardInfo.admin_id eq userInfo.id or userInfo.authority == 'admin'}">									
											<a class="write_button" href="write.do?bCode=${boardInfo.board_code}" style="justify-self: start;"><i class="fas fa-pencil-alt"></i>글쓰기</a>									
											<a class="refresh_button" href="#" onclick="window.location.reload()" style="justify-self: end;"><i class="fas fa-sync-alt"></i>새로고침</a>
										</c:when>
										<c:when test="${true}">
											<a class="refresh_button" href="#" onclick="window.location.reload()" style="justify-self: start;"><i class="fas fa-sync-alt"></i>새로고침</a>
										</c:when>	
									</c:choose>									
								</c:when>
								<c:when test="${boardInfo.admin_write eq false}">
									<c:choose>																	
										<c:when test="${not empty userInfo}">									
											<a class="write_button" href="write.do?bCode=${boardInfo.board_code}" style="justify-self: start;"><i class="fas fa-pencil-alt"></i>글쓰기</a>									
											<a class="refresh_button" href="#" onclick="window.location.reload()" style="justify-self: end;"><i class="fas fa-sync-alt"></i>새로고침</a>
										</c:when>
										<c:when test="${true}">
											<a class="refresh_button" href="#" onclick="window.location.reload()" style="justify-self: start;"><i class="fas fa-sync-alt"></i>새로고침</a>
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
										<c:if test="${page != 1}">
											<a href="board.do?bCode=${boardInfo.board_code}&page=${page-1}"><i class="fas fa-caret-left"></i></a>
										</c:if>
										<c:forEach var="i" begin="${pageStart}" end="${pageEnd}" step="1">
											<c:if test="${i eq page}"> <a href="#" style="color: #0073E6;">${page}</a> </c:if>
											<c:if test="${i ne page}">
												<a href="board.do?bCode=${boardInfo.board_code}&page=${i}">${i}</a>
											</c:if>
										</c:forEach>
										<c:if test="${pageCnt != page}">
											<a href="board.do?bCode=${boardInfo.board_code}&page=${page+1}"><i class="fas fa-caret-right"></i></a>
										</c:if>										
									</c:when>
									<c:when test="${not empty searchPageCnt}">
										<c:if test="${page != 1}">
											<a href="search.do?bCode=${boardInfo.board_code}&searchTag=${searchTag}&search=${search}&page=${page-1}"><i class="fas fa-caret-left"></i></a>
										</c:if>
										<c:forEach var="i" begin="1" end="${searchPageCnt}" step="1">
											<c:if test="${i eq page}"> <a href="#" style="color: #0073E6;">${i}</a> </c:if>
											<c:if test="${i ne page}">
												<a href="search.do?bCode=${boardInfo.board_code}&searchTag=${searchTag}&search=${search}&page=${i}">${i}</a>
											</c:if>
										</c:forEach>
										<c:if test="${searchPageCnt != page}">
											<a href="search.do?bCode=${boardInfo.board_code}&searchTag=${searchTag}&search=${search}&page=${page+1}"><i class="fas fa-caret-right"></i></a>
										</c:if>
									</c:when>
								</c:choose>
							</div>
							<form action="search.do" method="post">
								<div class="bottom_search_bar">
									<select name="searchTag" id="searchTag"
										class="bottom_search_select">
										<option value="title">제목
										<option value="title+contents">제목+내용
										<option value="id">작성자
									</select> <input type="text" name="search" id="search_input" class="bottom_search_input"
										autocomplete="off"> <input type="hidden" name="bCode"
										value="${boardInfo.board_code}">
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