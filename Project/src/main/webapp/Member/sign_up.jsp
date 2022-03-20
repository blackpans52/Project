<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/sign_up.css">
<title>회원 가입</title>
</head>
<body>
	<div class="sign_up_container">
	<div class="item">
	<form action="sign_upOK.do" method="post" name="signUp" autocomplete="off" onsubmit="return passwordCheck();">
		<div class="title">
			<strong>회원 정보</strong>
		</div>
		<p>※ 아이디와 닉네임은 중복확인 버튼을 통해 입력해주십시오.</p>
		<div class="input-box">			
			<input type="text" name="id" id="id" placeholder="아이디" readonly required>
			<label for="id">아이디</label>
		</div>
		<div class="right_buttom">
			<input type="button" onClick="idCheck()" value="중복확인">
		</div>
		<div class="input-box">	
			<input type="text" name="nickname" id="nickname" placeholder="닉네임" readonly required>
			<label for="nickname">닉네임</label>
		</div>
		<div class="right_buttom">
			<input type="button" onClick="nickCheck()" value="중복확인">
		</div>	
		<div class="input-box">	
			<input type="password" name="pw" id="pw" placeholder="비밀번호" required>
			<label for="pw">비밀번호</label>
		</div>	
		
		<div class="input-box">	
			<input type="password" name="pwOK" id="pwOK" placeholder="비밀번호 확인" required>
			<label for="pwOK">비밀번호 확인</label>
		</div>
		
		<div class="input-box">	
			<input type="email" name="email" id="email" placeholder="이메일" required>
			<label for="email">이메일</label>
		</div>
		
		<div class="input-box">	
			<input type="tel" name="tel" id="tel" maxlength='16' placeholder="전화번호" oninput="autoHyphen(this)" required>
			<label for="tel">전화번호</label>
		</div>				
		<div class="title address_form">
			<strong>주소</strong>
			<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기">
		</div>
		<div class="input-box">
			<input type="text" name="postcode" id="postcode" placeholder="우편번호" required>
			<label for="postcode">우편번호</label>
		</div>
		<div class="input-box">			
			<input type="text" name="roadAddress" id="roadAddress" placeholder="도로명주소" required>
			<label for="roadAddress">도로명주소</label>
		</div>
		<div class="input-box">
			<input type="text" name="jibunAddress" id="jibunAddress" placeholder="지번주소" required>
			<label for="jibunAddress">지번주소</label>
		</div>
		<span id="guide" style="color:#999;display:none"></span>
		<div class="input-box">
			<input type="text" name="detailAddress" id="detailAddress" placeholder="상세주소">
			<label for="detailAddress">상세주소</label>
		</div>
		<div class="input-box">
			<input type="text" name="extraAddress" id="extraAddress" placeholder="주소 참고항목">
			<label for="extraAddress">주소 참고항목</label>
		</div>
		<div class="center_buttom">
			<input type="submit" value="회원가입">
			<input type="button" value="취소" onclick="history.go(-1)">
		</div>
	</form>
	</div>
</div>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="js/execDaumPostcode.js"></script>
<script src="js/pwCheck.js"></script>
<script>
	function idCheck() { 
		window.open("idCheck.do", "아이디 중복확인", "width=500, height=300");
	}
	
	function nickCheck() {
		window.open("nickCheck.do", "닉네임 중복확인", "width=500, height=300");
	}
	const autoHyphen = (target) => {
		 target.value = target.value
		   .replace(/[^0-9]/, '')
		   .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
	}
</script>
</body>
</html>