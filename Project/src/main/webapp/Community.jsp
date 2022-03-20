<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>커뮤니티</title>
    <link rel="stylesheet" href="css/Project.css">
    <link rel="stylesheet" href="css/Community.css">
    <script src="https://kit.fontawesome.com/fc7ebf84d2.js" crossorigin="anonymous"></script>
</head>
<body>
    <%@ include file="guide_bar.jsp"%>
    <main id="main">
        <div id="main_wrap">
            <div id="main_contents">
                <div class="container">
                    <div class="item">                        
                        <div class="board_container">                             
                            <div class="board">
                                <div class="title">
                                    <a href="best.do"><i class="fas fa-thumbs-up"></i>베스트</a>
                                </div>
                                <div class="side_article">
                                <ul class="side_ul">
                                    <c:forEach var="dto" items="${bestList1}">
                                    <li>
                                    	<div class="article_list">
                                        <a class="text_over" href="view.do?no=${dto.no}">${dto.title}</a>																						
										<span class="replyCnt">[${dto.replyCnt}]</span>											
										</div>
                                    </li>
                                    </c:forEach>
                                </ul>
                                <ul class="side_ul">
                                    <c:forEach var="dto" items="${bestList2}">
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
                            <div class="board">
                                <div class="title">
                                    <a href="board.do?bCode=001"><i class="fas fa-comments"></i>자유 게시판</a>
                                </div>
                                <div class="side_article">
                                <ul class="side_ul">
                                	<c:forEach var="dto" items="${freeList1}">
                                    <li>
                                    	<div class="article_list">
                                        <a class="text_over" href="view.do?no=${dto.no}">${dto.title}</a>											
										<span class="replyCnt">[${dto.replyCnt}]</span>											
										</div>
                                    </li>
                                    </c:forEach>                   
                                </ul>
                                <ul class="side_ul">
                                    <c:forEach var="dto" items="${freeList2}">                                    
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
                            <div class="board">
                                <div class="title">
                                    <a href="board.do?bCode=003"><i class="fas fa-images"></i>사진 게시판</a>
                                </div>                                
                                    <ul class="wide_one_ul">
                                	<c:forEach var="dto" items="${pictureList}">
                                    <li>                                    	
                                        <div class="item2">
			                                <img alt="" src="${dto.thumbnail}">
			                                <div class="picture_board_subject text_over">
			                                    <p>	
				                                    <a href="view.do?no=${dto.no}">${dto.title}</a>
												</p>
			                                </div>			                                
                            			</div>                            			
                                    </li>
                                    </c:forEach>
                                	</ul>                              
                            </div>
                            <div class="board">
                                <div class="title">
                                    <a href="#"><i class="fas fa-comment"></i>커뮤니티 게시판 목록</a>
                                </div>
                                <ul class="board_ul">
                                    <c:forEach var="dto" items="${comCategoryBoardList}">
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
</body>

</html>