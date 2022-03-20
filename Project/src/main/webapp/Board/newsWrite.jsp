<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글쓰기</title>
<link rel="stylesheet" href="css/Project.css">
<link rel="stylesheet" href="css/Board.css">
<link rel="stylesheet" href="css/Write.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<script src="js/summernote-ko-KR.js"></script>
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
                            <strong class="title"><i class="fas fa-comments"></i>${boardInfo.board_name}</strong>
                        </div>
                        <form action="writeOK.do" method="post">                        
                        	<table class="write_table">
                        		<tr>
                        			<td><label for="title">제목</label><input type="text" name="title" id="title" size="45" placeholder="45자 제한" required="required"></td>
                        		</tr>
                        		<tr>
                        			<c:choose>                        			
                        			<c:when test="${fn:contains(boardInfo.board_code, '002')}">
                        			<td>
                        				<span>구분</span>
                        				<input type="radio" id="multi" name="article_category" value="multi" checked>
  										<label for="multi">Multi</label>
                        				<input type="radio" id="playstation" name="article_category" value="playstation">
  										<label for="playstation">Playstation</label>
                        				<input type="radio" id="nintendo" name="article_category" value="nintendo">
  										<label for="nintendo">Nintendo</label>
                        				<input type="radio" id="xbox" name="article_category" value="xbox">
  										<label for="xbox">Xbox</label>  									
                        				<input type="radio" id="pc" name="article_category" value="pc">
  										<label for="pc">PC</label>
                        				<input type="radio" id="mobile" name="article_category" value="mobile">
  										<label for="mobile">Mobile</label>  									
                        			</td>
                        			</c:when>
                        			<c:when test="${boardInfo.board_code eq '004'}">
                        			<td>
                        				<span>구분</span>
                        				<input type="radio" id="multi" name="article_category" value="multi" checked>
  										<label for="multi">Multi</label>
                        				<input type="radio" id="playstation" name="article_category" value="playstation">
  										<label for="playstation">Playstation</label>
                        				<input type="radio" id="nintendo" name="article_category" value="nintendo">
  										<label for="nintendo">Nintendo</label>
                        				<input type="radio" id="xbox" name="article_category" value="xbox">
  										<label for="xbox">Xbox</label>	
                        			</td>
                        			</c:when>
                        			<c:when test="${boardInfo.board_code eq '005'}">
                        			<td>
                        				<span>구분</span>
                        				<input type="radio" id="S/W" name="article_category" value="S/W" checked>
  										<label for="S/W">S/W</label>
                        				<input type="radio" id="H/W" name="article_category" value="H/W">
  										<label for="H/W">H/W</label>
                        				<input type="radio" id="정보" name="article_category" value="정보">
  										<label for="정보">정보</label>
                        				<input type="radio" id="인디" name="article_category" value="인디">
  										<label for="인디">인디</label>	
                        			</td>
                        			</c:when>
                        			<c:when test="${boardInfo.board_code eq '006'}">
                        			<td>
                        				<span>구분</span>
                        				<input type="radio" id="Android" name="article_category" value="Android" checked>
  										<label for="Android">Android</label>
                        				<input type="radio" id="Apple" name="article_category" value="Apple">
  										<label for="Apple">Apple</label>
                        				<input type="radio" id="etc" name="article_category" value="etc">
  										<label for="etc">etc</label>	
                        			</td>
                        			</c:when>
                        			</c:choose>
                        		</tr>                                
                                <tr>
                                    <td>
                                        <div class="wrte_notice"><p>※ 이미지의 우측 하단을 드래그하면 크기를 조절할 수 있습니다.</p>
                                        <p>※ 12MB 이상의 이미지는 업로드할 수 없습니다.</p>                                        
                                        </div>
                                    </td>
                                </tr>
                        		<tr>
                        			<td>
                        				<textarea id="summernote" name="contents" >${articleInfo.contents}</textarea>
                        			</td>
                        		</tr>
                        	</table>
                        <input type="hidden" name="bCode" value="${boardInfo.board_code}">                        
                        <div class="board_bottom_bar">
                            <div class="bottom_button_bar">
                                <button type="submit" style="justify-self: end;"><i class="fas fa-pencil-alt"></i>등록</button>
                                <a href="board.do?bCode=${boardInfo.board_code}" style="justify-self: start;"><i class="fas fa-sync-alt"></i>취소</a>
                            </div>                            
                        </div>
                        </form>
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
  <script src="js/SummerImage.js"></script>
</body>
</html>