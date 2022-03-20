<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Playstation</title>
    <link rel="stylesheet" href="css/Project.css">
    <link rel="stylesheet" href="css/Basic.css">
    <script src="https://kit.fontawesome.com/fc7ebf84d2.js" crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="/guide_bar.jsp"%>
	<main id="main">
        <div id="main_wrap">
            <div id="main_contents">
                <div class="container">
                    <div class="item">
                        <div class="slide_container">
                            <div class="slide">
                                <input type="radio" name="pos" id="pos1" checked>
                                <input type="radio" name="pos" id="pos2">
                                <input type="radio" name="pos" id="pos3">
                                <input type="radio" name="pos" id="pos4">
                                <ul>
                                    <li>
                                        <div class="title">
                                            <i class="fab fa-playstation"></i>Playstation 신작
                                        </div>
                                        <a class="new_game_img" href="#" style="background-image: url(Image/elden_ring.jpg)"></a>
                                    </li>
                                    <li>
                                        <div class="title">
                                            <i class="fab fa-playstation"></i>Playstation 신작
                                        </div>
                                        <a class="new_game_img" href="#" style="background-image: url(Image/horizon.jpg)"></a>
                                    </li>
                                    <li>
                                        <div class="title">
                                            <i class="fab fa-playstation"></i>Playstation 신작
                                        </div>
                                        <a class="new_game_img" href="#" style="background-image: url(Image/gran.jpg)"></a>
                                    </li>
                                    <li>
                                        <div class="title">
                                            <i class="fab fa-playstation"></i>Playstation 신작
                                        </div>
                                        <a class="new_game_img" href="#" style="background-image: url(Image/wwe.jpg)"></a>
                                    </li>
                                </ul>
                                <p class="bullet">
                                    <label for="pos1">1</label>
                                    <label for="pos2">2</label>
                                    <label for="pos3">3</label>
                                    <label for="pos4">4</label>
                                </p>
                            </div>
                            <div class="popular_game">
                                <strong class="title"><i class="fab fa-playstation"></i>Playstation 게임 인기 순위</strong>
                                <ol>
                                    <c:forEach var="dto" items="${pRankList}">
                                    <li>
                                    	<div class="rank_list">
                                        <a class="text_over" href="board.do?bCode=${dto.board_code}">${dto.board_name}</a>
										<span> 게시글 ${dto.article_Cnt}</span>
										</div>
                                    </li>
                                    </c:forEach>
                                </ol>
                            </div>
                        </div>
                        <div class="board_container"> 
                            <div class="board">
                                <div class="title">
                                    <a href="board.do?aCode=playstation&&bCode=002"><i class="fab fa-playstation"></i>Playstation 뉴스</a>
                                </div>
                                <div class="side_article">
                                <ul class="side_ul">
                                    <c:forEach var="dto" items="${pNewsList1}">
                                    <li>
                                    	<div class="article_list">
                                        <a class="text_over" href="view.do?no=${dto.no}">
                                        <c:choose>
                                        	<c:when test="${dto.article_category eq 'multi'}">
                                        		<span class="category_tag">Multi</span>
                                        	</c:when>
                                        	<c:when test="${dto.article_category eq 'playstation'}">
                                        		<span class="category_tag">PS</span>
                                        	</c:when>
                                        	<c:when test="${dto.article_category eq 'nintendo'}">
                                        		<span class="category_tag">Nin</span>
                                        	</c:when>
                                        	<c:when test="${dto.article_category eq 'xbox'}">
                                        		<span class="category_tag">Xbox</span>
                                        	</c:when>
                                        	<c:when test="${dto.article_category eq 'pc'}">
                                        		<span class="category_tag">PC</span>
                                        	</c:when>
                                        	<c:when test="${dto.article_category eq 'mobile'}">
                                        		<span class="category_tag">Mo</span>
                                        	</c:when>
                                        </c:choose>
                                        ${dto.title}</a>
										<span class="replyCnt">[${dto.replyCnt}]</span>
										</div>
                                    </li>
                                    </c:forEach>
                                </ul>
                                <ul class="side_ul">
                                    <c:forEach var="dto" items="${pNewsList2}">
                                    <li>
                                    	<div class="article_list">
                                        <a class="text_over" href="view.do?no=${dto.no}">
                                        <c:choose>
                                        	<c:when test="${dto.article_category eq 'multi'}">
                                        		<span class="category_tag">Multi</span>
                                        	</c:when>
                                        	<c:when test="${dto.article_category eq 'playstation'}">
                                        		<span class="category_tag">PS</span>
                                        	</c:when>
                                        	<c:when test="${dto.article_category eq 'nintendo'}">
                                        		<span class="category_tag">Nin</span>
                                        	</c:when>
                                        	<c:when test="${dto.article_category eq 'xbox'}">
                                        		<span class="category_tag">Xbox</span>
                                        	</c:when>
                                        	<c:when test="${dto.article_category eq 'pc'}">
                                        		<span class="category_tag">PC</span>
                                        	</c:when>
                                        	<c:when test="${dto.article_category eq 'mobile'}">
                                        		<span class="category_tag">Mo</span>
                                        	</c:when>
                                        </c:choose>
                                        ${dto.title}</a>
										<span class="replyCnt">[${dto.replyCnt}]</span>
										</div>
                                    </li>
                                    </c:forEach>
                                </ul>
                                </div>                             
                            </div>
                            <div class="board">
                                <div class="title">
                                    <a href="board.do?bCode=004"><i class="fab fa-playstation"></i>Playstation 유저정보</a>
                                </div>
                                <ul class="one_ul">
                                    <c:forEach var="dto" items="${pUserNewsList}">
                                    <li>
                                    	<div class="article_list">
                                        <a class="text_over" href="view.do?no=${dto.no}">
                                        <c:choose>
                                        	<c:when test="${dto.article_category eq 'multi'}">
                                        		<span class="category_tag">Multi</span>
                                        	</c:when>
                                        	<c:when test="${dto.article_category eq 'playstation'}">
                                        		<span class="category_tag">PS</span>
                                        	</c:when>
                                        	<c:when test="${dto.article_category eq 'nintendo'}">
                                        		<span class="category_tag">Nin</span>
                                        	</c:when>
                                        	<c:when test="${dto.article_category eq 'xbox'}">
                                        		<span class="category_tag">Xbox</span>
                                        	</c:when>
                                        	<c:when test="${dto.article_category eq 'pc'}">
                                        		<span class="category_tag">PC</span>
                                        	</c:when>
                                        	<c:when test="${dto.article_category eq 'mobile'}">
                                        		<span class="category_tag">Mo</span>
                                        	</c:when>
                                        </c:choose>
                                        ${dto.title}</a>
										<span class="replyCnt">[${dto.replyCnt}]</span>
										</div>
                                    </li>
                                    </c:forEach>
                                </ul>
                            </div>
                            <div class="board">
                                <div class="title">
                                    <a href="board.do?bCode=0011"><i class="fab fa-playstation"></i>Playstation 유저 게시판</a>
                                </div>
                                <ul class="one_ul">
                                    <c:forEach var="dto" items="${pUserBoardList}">
                                    <li>
                                    	<div class="article_list">
                                        <a class="text_over" href="view.do?no=${dto.no}">${dto.title}</a>
										<span class="replyCnt">[${dto.replyCnt}]</span>
										</div>
                                    </li>
                                    </c:forEach>
                                </ul>
                            </div>
                            <div class="board">
                                <div class="title">
                                    <a href="#"><i class="fab fa-playstation"></i>Playstation 게임 게시판 목록</a>
                                </div>                             
                                <ul class="board_ul">
                                    <c:forEach var="dto" items="${pCategoryBoardList}">
                                    <li>
                                    	<div class="article_list">
                                        <a class="text_over" href="board.do?bCode=${dto.board_code}">${dto.board_name}</a>										
										</div>
                                    </li>
                                    </c:forEach>
                                </ul>               
                            </div>
                        </div>
                    </div>
                    <%@ include file="side_bar.jsp"%>
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
    const pos = document.getElementsByName("pos");
    setInterval(checked_select, 15000);

    function resetInterval(num) {
    	clearInterval(num);
    	setInterval(checked_select, 15000);
    }

    function checked_select() {
    	for (let i = 0; i < pos.length; i++) {
    		if (pos[i].checked == true) {
    			fade_slide(i);
    			break;
    		}
    	}
    }

    function fade_slide(num) {
    	pos[num].checked = false;

    	if (num == pos.length - 1) {
    		pos[0].checked = true;
    	} else {
    		pos[num + 1].checked = true;
    	}
    }
    </script>
</body>
</html>