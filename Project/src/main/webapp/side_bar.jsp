<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="item">
	<div id="aside_bar">
		<div id="best" class="aside_contents">
			<strong class="title"><i class="fas fa-bars"></i> 실시간 커뮤니티
				베스트</strong>
			<ul>
				<c:forEach var="dto" items="${realList}">
					<li>
						<div class="article_list" style="width: 210px;">
							<a class="text_over" href="view.do?no=${dto.no}">${dto.title}</a>
							<span class="replyCnt">[${dto.replyCnt}]</span>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div id="popular" class="aside_contents">
			<strong class="title"><i class="fas fa-list-ol"></i> 게시판 인기
				순위</strong>
			<ol>
				<c:forEach var="dto" items="${allRankList}">
					<li>
						<div class="all_rank_list">
							<a class="text_over" href="board.do?bCode=${dto.board_code}">${dto.board_name}</a>
						</div>
					</li>
				</c:forEach>
			</ol>
		</div>
	</div>
</div>
