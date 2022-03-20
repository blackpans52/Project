<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${articleInfo.title}</title>
<link rel="stylesheet" href="css/Project.css">
<link rel="stylesheet" href="css/Board.css">
<link rel="stylesheet" href="css/View.css">
<script src="https://kit.fontawesome.com/fc7ebf84d2.js"
	crossorigin="anonymous"></script>
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
						<div class="view_container">
							<table class="view_table">
								<tr>
									<td>
									<c:if test="${not empty articleInfo.article_category}">
									[${articleInfo.article_category}]&nbsp;
									</c:if>
									${articleInfo.title}</td>
								</tr>
								<tr>
									<td>
										<span>${articleInfo.nickname}</span>
										<span>${articleInfo.wtime}</span>
										<span>조회 ${articleInfo.hit}</span>
										<span>댓글 ${articleInfo.replyCnt}</span>
									</td>
								</tr>
								<tr>
									<td><div class="contents_box">${articleInfo.contents}</div></td>
								</tr>
								<tr>
									<td><div class="contents_button_bar">
											<div class="bar1">
												<c:if test="${userInfo.id eq articleInfo.id or userInfo.id eq boardInfo.admin_id or userInfo.authority == 'admin'}">
													<a class="first_button button"
														href="modify.do?no=${articleInfo.no}"><i
														class="fas fa-pencil-alt"></i>수정</a>
													<a class="just_button button"
														href="delete.do?no=${articleInfo.no}"><i
														class="fas fa-trash-alt"></i>삭제</a>
												</c:if>
												<c:choose>												
												<c:when test="${boardInfo.board_category1 eq 'community' and userInfo.authority == 'admin'}">						
													<c:choose>
													<c:when test="${articleInfo.best eq false}">
													<a class="just_button button"
														href="bestOn.do?no=${articleInfo.no}"><i class="fas fa-thumbs-up"></i>베스트</a>
													</c:when>
													<c:when test="${articleInfo.best eq true}">
													<a class="just_button button"
														href="bestOff.do?no=${articleInfo.no}"><i class="fas fa-thumbs-down"></i>베스트 해제</a>
													</c:when>
													</c:choose>
												</c:when>
												<c:when test="${boardInfo.board_code eq '002' and userInfo.authority == 'admin'}">
													<c:choose>
													<c:when test="${articleInfo.main_news eq false}">
													<a class="just_button button"
														href="mainNewsOn.do?no=${articleInfo.no}"><i class="fas fa-thumbs-up"></i>메인으로</a>
													</c:when>
													<c:when test="${articleInfo.main_news eq true}">
													<a class="just_button button"
														href="mainNewsOff.do?no=${articleInfo.no}"><i class="fas fa-thumbs-down"></i>메인 해제</a>
													</c:when>
													</c:choose>
												</c:when>	
												</c:choose>									
											</div>
											<div class="bar2">
												<c:if test="${not empty searchF}">
													<a class="just_button button"
														href="board.do?bCode=${articleInfo.board_code}"><i
														class="fas fa-list"></i>전체목록</a>
													<a class="just_button button"
														href="javascript:history.go(-1)"><i
														class="fas fa-list"></i>검색목록</a>
												</c:if>
												<c:if test="${empty searchF}">
													<a class="just_button button"
														href="board.do?bCode=${articleInfo.board_code}"><i
														class="fas fa-list"></i>목록</a>
												</c:if>
											</div>
										</div></td>
								</tr>
							</table>
							<c:if test="${replyList != null}">
								<table class="reply_table">
									<colgroup>
										<col width="150px">
										<col>
										<col width="150px">
									</colgroup>
									<c:set var="reply_ctn" value="0" />
									<c:forEach var="dto" items="${replyList}">
										<tr>
											<td>${dto.nickname}</td>
											<td><c:if test="${not empty dto.reply_nick}">
													<p class="nested_reply_nick">${dto.reply_nick}</p>
												</c:if>
												<div class="modify_reply_box">
													<form action="modifyReply.do" method="post"
														style="display: inline-block;">
														<div class="modify_reply_container">
															<textarea name="modify_reply_contents">${dto.reply_contents}</textarea>
															<input class="just_button button" type="submit"
																value="등록"> <input type="hidden" name="no"
																value="${dto.no}"> <input type="hidden"
																name="viewno" value="${articleInfo.no}">
														</div>
													</form>
												</div> <c:choose>
													<c:when test="${empty dto.reply_nick}">
														<span class="flag reply_contents">${dto.reply_contents}</span>
													</c:when>
													<c:when test="${not empty dto.reply_nick}">
														<span class="flag nested_reply_contents">${dto.reply_contents}</span>
													</c:when>
												</c:choose> <label class="nested_reply_button" for="rep${dto.no}"><i
													class="fas fa-reply"></i>답글</label> <input
												class="nested_reply_check" type="checkbox" id="rep${dto.no}">
												<form class="nested_reply" action="nestedReply.do"
													method="post">
													<div class="nested_reply_box">
														<textarea class="nested_reply_area"
															name="nested_reply_contents" required></textarea>
														<input type="hidden" name="no" value="${dto.no}">
														<input type="hidden" name="viewno"
															value="${articleInfo.no}"> <input
															class="just_button button" type="submit" value="등록">
													</div>
												</form></td>
											<td>
												<div class="reply_button">
													<c:if
														test="${userInfo.id eq dto.id or userInfo.id eq boardInfo.admin_id or userInfo.authority == 'admin'}">
														<input class="modify_reply_open just_button button"
															type="button" value="수정"
															onclick="modifyReply(${reply_ctn}, this)">
													</c:if>
													<c:if
														test="${userInfo.id eq dto.id or userInfo.id eq boardInfo.admin_id or userInfo.authority == 'admin'}">
														<a class="just_button button"
															href="deleteReply.do?no=${dto.no}&viewno=${articleInfo.no}">삭제</a>
													</c:if>
													<span>${dto.wtime}</span>
												</div>
											</td>
										</tr>
										<c:set var="reply_ctn" value="${reply_ctn+1}" />
									</c:forEach>
								</table>
							</c:if>
							<form class="main_reply_form"
								action="reply.do?no=${articleInfo.no}" method="post">
								<div class="main_reply_box">
									<textarea class="reply_box" name="reply_contents" required></textarea>
									<input class="just_button button" type="submit" value="등록">
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
	const modify_reply_box = document.getElementsByClassName("modify_reply_box");
	const modify_reply_open = document.getElementsByClassName("modify_reply_open");
	const flag = document.getElementsByClassName("flag");
	
	function modifyReply(num, e) {
		for(i=0;i<modify_reply_open.length;i++) {
			modify_reply_open[i].setAttribute("style", `display: inline;`);
		}		
		for(i=0;i<modify_reply_box.length;i++) {
			modify_reply_box[i].setAttribute("style", `display: none;`);
		}
		for(i=0;i<flag.length;i++) {
			flag[i].setAttribute("style", `display: inline;`);
		}
		modify_reply_box[num].setAttribute("style", `display: inline;`);
		flag[num].setAttribute("style", `display: none;`);
		e.setAttribute("style", `display: none;`);
	}
</script>
</body>
</html>