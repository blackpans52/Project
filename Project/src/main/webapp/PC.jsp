<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PC</title>
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
                                            <a href="#"><i class="fas fa-desktop"></i>1</a>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="title">
                                            <a href="#"><i class="fas fa-desktop"></i>2</a>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="title">
                                            <a href="#"><i class="fas fa-desktop"></i>3</a>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="title">
                                            <a href="#"><i class="fas fa-desktop"></i>4</a>
                                        </div>
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
                                <strong class="title"><i class="fas fa-desktop"></i>PC 게임 인기 순위</strong>
                                <ol>
                                    <c:forEach var="dto" items="${pcRankList}">
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
                                    <a href="board.do?aCode=pc&&bCode=002"><i class="fas fa-desktop"></i>PC 뉴스</a>
                                </div>
                                <div class="side_article">
                                <ul class="side_ul">
                                    <c:forEach var="dto" items="${pcNewsList1}">
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
                                    <c:forEach var="dto" items="${pcNewsList2}">
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
                                    <a href="board.do?bCode=005"><i class="fas fa-desktop"></i>PC 유저정보</a>
                                </div>
                                <ul class="one_ul">
                                    <c:forEach var="dto" items="${pcUserNewsList}">
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
                                    <a href="board.do?bCode=0014"><i class="fas fa-desktop"></i>PC 유저 게시판</a>
                                </div>
                                <ul class="one_ul">
                                    <c:forEach var="dto" items="${pcUserBoardList}">
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
                                    <a href="#"><i class="fas fa-desktop"></i>PC 게임 게시판 목록</a>
                                </div>
                                <ul class="board_ul">
                                    <c:forEach var="dto" items="${pcCategoryBoardList}">
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