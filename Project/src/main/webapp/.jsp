<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <div class="overlay"></div>
    <div id="guide_bar">
        <div class="guide_top">
            <div class="guide_icon icon_guide">
                <i class="fas fa-angle-double-left" onclick="guide(0)"></i>
            </div>
            <div class="logo logo_guide">
                <a href="index.do">
                    <h1><i class="fas fa-bolt"></i> logo</h1>
                </a>
            </div>
        </div>
        <div class="guide_wrap">
            <div class="guide_contents">
                <i class="fas fa-home guide_contents_icon"></i>
                <a href="index.jsp" class="guide_title">홈</a>
            </div>
            <c:choose>
            	<c:when test="${empty userInfo}">
            		<div class="guide_contents">
		                <i class="fas fa-sign-in-alt guide_contents_icon"></i>
		                <a href="login.do" class="guide_title">로그인</a>
           			</div>
            	</c:when>
            	<c:when test="${not empty userInfo}">
            		<div class="guide_contents">
		                <i class="fas fa-sign-in-alt guide_contents_icon"></i>
		                <a href="logout.do" class="guide_title">로그아웃</a>
           			</div>            	
            	<c:if test="${userInfo.authority != 'admin'}">            	
		            <div class="guide_contents">
		            	<i class="fas fa-edit guide_contents_icon"></i>
						<a href="memberModify.do" class="guide_title">정보 수정</a>
					</div>							
				</c:if>				
		        <c:if test="${userInfo.authority == 'admin'}"> 
		            <div class="guide_contents">
		            	<i class="fas fa-list-ul guide_contents_icon"></i>
						<a href="Membermanage.do" class="guide_title">회원</a>
					</div>
					<div class="guide_contents">
						<i class="fas fa-list-ol guide_contents_icon"></i>
						<a href="boardManage.do" class="guide_title">게시판</a>
					</div>			
				</c:if>
			</c:when>		
            </c:choose>
        </div>        
    </div>
    <header id="header">
        <div id="header_wrap">
            <div class="guide_icon icon_header"><i class="fas fa-angle-double-right" onclick="guide(1)"></i></div>
            <div class="logo logo_header">
                <a href="index.do">
                    <h1><i class="fas fa-bolt"></i> logo</h1>
                </a>
            </div>
            <div id="search_bar">
                <form method="get" action="">
                    <input type="text" name="q" id="search" autocomplete="off" value="미구현">
                    <button type="submit" class="btn" id="searchBtn"><i class="fas fa-search"></i></button>
                </form>
            </div>
        </div>
    </header>
    <nav id="gnb_bar">
        <div id="gnb_wrap">
            <ul>
                <li><a href="Playstation.jsp"><i class="fab fa-playstation"></i>Playstation</a></li>
                <li><a href="Nintendo.jsp"><i class="fas fa-toggle-on"></i>Nintendo</a></li>
                <li><a href="Xbox.jsp"><i class="fab fa-xbox"></i>Xbox</a></li>
                <li><a href="PC.jsp"><i class="fas fa-desktop"></i>PC</a></li>
                <li><a href="Mobile.jsp"><i class="fas fa-mobile-alt"></i>Mobile</a></li>
                <li><a href="Arcade.jsp"><i class="fas fa-gamepad"></i>Arcade/고전</a></li>
                <li><a href="News.jsp"><i class="fas fa-newspaper"></i>뉴스</a></li>
                <li><a href="Community.jsp"><i class="fas fa-comment"></i>커뮤니티</a></li>               
            </ul>
        </div>
    </nav>
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
                                            <a href="#"><i class="fab fa-playstation"></i>1</a>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="title">
                                            <a href="#"><i class="fab fa-playstation"></i>2</a>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="title">
                                            <a href="#"><i class="fab fa-playstation"></i>3</a>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="title">
                                            <a href="#"><i class="fab fa-playstation"></i>4</a>
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
                                <strong class="title"><i class="fab fa-playstation"></i>Playstation 게임 인기 순위</strong>
                                <ol>
                                    <li>미구현</li>
                                    <li>미구현</li>
                                    <li>미구현</li>
                                    <li>미구현</li>
                                    <li>미구현</li>
                                    <li>미구현</li>
                                </ol>
                            </div>
                        </div>
                        <div class="board_container"> 
                            <div class="board">
                                <div class="title">
                                    <a href="#"><i class="fab fa-playstation"></i>Playstation 뉴스</a>
                                </div>
                                <ul class="side_ul">
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                </ul>
                                <ul class="side_ul">
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                </ul>                             
                            </div>
                            <div class="board">
                                <div class="title">
                                    <a href="#"><i class="fab fa-playstation"></i>1</a>
                                </div>
                                <ul class="one_ul">
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                </ul>
                            </div>
                            <div class="board">
                                <div class="title">
                                    <a href="#"><i class="fab fa-playstation"></i>2</a>
                                </div>
                                <ul class="one_ul">
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                    <li>
                                        <p>게시글 1</p>
                                    </li>
                                </ul>
                            </div>
                            <div class="board">
                                <div class="title">
                                    <a href="#"><i class="fab fa-playstation"></i>Playstation 게시판 목록</a>
                                </div>                        
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div id="aside_bar">
                            <div id="best" class="aside_contents">
                                <strong class="title"><i class="fas fa-bars"></i></i> 실시간 베스트</strong>
                                <ul>
                                    <li>게시글1</li>
                                    <li>게시글2</li>
                                    <li>게시글3</li>
                                    <li>게시글4</li>
                                    <li>게시글5</li>
                                    <li>게시글6</li>
                                    <li>게시글7</li>
                                </ul>
                            </div>
                            <div id="popular" class="aside_contents">
                                <strong class="title"><i class="fas fa-list-ol"></i> 게시판 인기 순위</strong>
                                <ol>
                                    <li>리그 오브 레전드</li>
                                    <li>던전 앤 파이터</li>
                                    <li>다크 소울 3</li>
                                    <li>미구현</li>
                                    <li>미구현</li>
                                    <li>미구현</li>
                                    <li>미구현</li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <footer id="footer">
        <div id="footer_wrap">
            <h1>footer</h1>
        </div>
    </footer>
    <script src="js/Basic.js"></script>
</body>

</html>