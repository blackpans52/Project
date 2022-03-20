<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>News</title>
    <link rel="stylesheet" href="css/Project.css">
    <link rel="stylesheet" href="css/News.css">
    <script src="https://kit.fontawesome.com/fc7ebf84d2.js" crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="guide_bar.jsp"%>
    <main id="main">
        <div id="main_wrap">
            <div id="main_contents">
                <div class="container">
                    <div class="item">
                        <div class="news_container">
                            <div class="item1">
                                <div class="news_img">
                                	<c:forEach var="dto" items="${mainNews1}">
                                    <a id="main_article" href="view.do?no=${dto.no}"><img class="main_img" src="${dto.thumbnail}" alt=""></a>
                                    <div class="img_summary">
                                        <h2 class="text_over">${dto.title}</h2>
                                    </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="item1">                                
                                    <ul class="news_subimg">
                                    	<c:set var="main_news_ctn" value="0" />
                                    	<c:forEach var="dto" items="${mainNewsList}"> 
                                        <li onmouseover="javascript:imageChanging(${main_news_ctn})" onmouseout="javascript:imageUnbordering(${main_news_ctn})">
                                            <a class="article" href="view.do?no=${dto.no}"><img class="sub_img" src="${dto.thumbnail}" alt=""/>
                                                <div class="img_summary">
                                                    <p class="text_over">${dto.title}</p>
                                                </div>
                                            </a>
                                        </li>
                                        <c:set var="main_news_ctn" value="${main_news_ctn+1}" />
                                        </c:forEach>                                        
                                    </ul>                                
                            </div>                  
                        </div>
                        <div class="board_container"> 
                            <div class="board">
                                <div class="title">
                                    <a href="board.do?bCode=002"><i class="fas fa-newspaper"></i>뉴스</a>
                                </div>
                                <div class="side_article">
                                <ul class="side_ul">
                                    <c:forEach var="dto" items="${newsList1}">
                                    <li class="text_over">
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
                                    <c:forEach var="dto" items="${newsList2}">
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
                                    <a href="board.do?bCode=004"><i class="fas fa-user"></i>콘솔 유저정보</a>
                                </div>
                                <ul class="one_ul">
                                    <c:forEach var="dto" items="${consoleList1}">
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
                                    <a href="board.do?bCode=0021"><i class="fas fa-bookmark"></i>게임 리뷰</a>
                                </div>
                                <ul class="one_ul">
                                    <c:forEach var="dto" items="${reviewList1}">
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
                                    <a href="board.do?bCode=005"><i class="fas fa-desktop"></i>PC 유저정보</a>
                                </div>
                                <ul class="one_ul">
                                    <c:forEach var="dto" items="${pcList}">
                                    <li>
                                    	<div class="article_list">
                                        <a class="text_over" href="view.do?no=${dto.no}">                                        
                                        	${dto.title}</a>
											<span class="replyCnt">[${dto.replyCnt}]</span>
										</div>
                                    </li>
                                    </c:forEach>
                                </ul>
                            </div>
                            <div class="board">
                                <div class="title">
                                    <a href="board.do?bCode=006"><i class="fas fa-mobile-alt"></i>모바일 유저정보</a>
                                </div>
                                <ul class="one_ul">
                                    <c:forEach var="dto" items="${mobileList}">
                                    <li>
                                    	<div class="article_list">
                                        <a class="text_over" href="view.do?no=${dto.no}">                                        
                                        	${dto.title}</a>
											<span class="replyCnt">[${dto.replyCnt}]</span>
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
    <script src="js/News.js"></script>
</body>
</html>