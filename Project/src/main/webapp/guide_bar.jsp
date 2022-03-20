<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
					<div class="guide_contents">
		            	<i class="fas fa-user-times guide_contents_icon"></i>
						<a href="memberDelete.do" class="guide_title" onclick="return confirm('정말로 회원 탈퇴를 하시겠습니까?')">회원 탈퇴</a>
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
                <form method="get" action="#">
                    <input type="text" name="q" id="search" autocomplete="off">
                    <button type="submit" class="searchbtn" id="searchBtn"><i class="fas fa-search"></i></button>
                </form>
            </div>
            <c:if test="${not empty userInfo}">
            <div id="member_bar">
            	<span>${userInfo.nickname}님 환영합니다.</span>
            </div>
            </c:if>
        </div>
    </header>
    <nav id="gnb_bar">
        <div id="gnb_wrap">
            <ul>
                <li><a href="Playstation.do"><i class="fab fa-playstation"></i>Playstation</a></li>
                <li><a href="Nintendo.do"><i class="fas fa-toggle-on"></i>Nintendo</a></li>
                <li><a href="Xbox.do"><i class="fab fa-xbox"></i>Xbox</a></li>
                <li><a href="PC.do"><i class="fas fa-desktop"></i>PC</a></li>
                <li><a href="Mobile.do"><i class="fas fa-mobile-alt"></i>Mobile</a></li>
                <li><a href="Arcade.do"><i class="fas fa-gamepad"></i>Arcade/고전</a></li>
                <li><a href="News.do"><i class="fas fa-newspaper"></i>뉴스</a></li>
                <li><a href="Community.do"><i class="fas fa-comment"></i>커뮤니티</a></li>               
            </ul>
        </div>
    </nav>
    <script src="js/Basic.js"></script>
