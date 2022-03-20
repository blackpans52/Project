<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Arcade/고전</title>
    <link rel="stylesheet" href="css/Project.css">
    <link rel="stylesheet" href="css/Arcade.css">
    <script src="https://kit.fontawesome.com/fc7ebf84d2.js" crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="/guide_bar.jsp"%>
	<main id="main">
        <div id="main_wrap">
            <div id="main_contents">
                <div class="container">
                    <div class="item">                        
                        <div class="board_container">                             
                            <div class="board">
                                <div class="title">
                                    <a href="board.do?bCode=015"><i class="fas fa-gamepad"></i>고전 게임 게시판</a>
                                </div>
                                <ul class="one_ul">
                                    <c:forEach var="dto" items="${arcadeList1}">
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
                                    <a href="board.do?bCode=0151"><i class="fas fa-gamepad"></i>드림캐스트</a>
                                </div>
                                <ul class="one_ul">
                                    <c:forEach var="dto" items="${arcadeList2}">
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
                                    <a href="board.do?bCode=0152"><i class="fas fa-gamepad"></i>패미컴</a>
                                </div>
                                <ul class="one_ul">
                                    <c:forEach var="dto" items="${arcadeList3}">
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
                                    <a href="board.do?bCode=0153"><i class="fas fa-gamepad"></i>슈퍼 패미컴</a>
                                </div>
                                <ul class="one_ul">
                                    <c:forEach var="dto" items="${arcadeList4}">
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
                                    <a href="board.do?bCode=0154"><i class="fas fa-gamepad"></i>네오지오</a>
                                </div>
                                <ul class="one_ul">
                                    <c:forEach var="dto" items="${arcadeList5}">
                                    <li>
                                    	<div class="article_list">
                                        <a class="text_over" href="view.do?no=${dto.no}">${dto.title}</a>											
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
</body>
</html>