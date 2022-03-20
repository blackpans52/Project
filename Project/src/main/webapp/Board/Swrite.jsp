<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글쓰기</title>
<link rel="stylesheet" href="css/Project.css">
<link rel="stylesheet" href="css/Board.css">
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
                        			<td><label for="title">제목</label><input type="text" name="title" id="title" size="45" placeholder="45자 제한"></td>
                        		</tr>                                
                                <tr>
                                    <td>
                                        <div class="wrte_notice"><p>※ 이미지의 우측 하단을 드래그하면 크기를 조절할 수 있습니다.</p>
                                        <p>※ 12MB 이상의 이미지는 업로드할 수 없습니다.</p>
                                        <p>※ 문제가 되는 내용의 게시글은 삭제 조치됩니다.</p></div>
                                    </td>
                                </tr>
                        		<tr>
                        			<td>
                        				<textarea id="summernote" name="contents" ></textarea>
                        			</td>
                        		</tr>
                        	</table>
                        <input type="hidden" name="bCode" value="${boardInfo.board_code}">                        
                        <div class="board_bottom_bar">
                            <div class="bottom_button_bar">
                                <button class="write_button" type="submit" style="justify-self: end;"><i class="fas fa-pencil-alt"></i>등록</button>
                                <button class="just_button" type="button" style="justify-self: start;" onclick="history.go(-1)"><i class="fas fa-sync-alt"></i>취소</button>
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