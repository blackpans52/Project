const pw = document.getElementById("pw");
const pwOK = document.getElementById("pwOK");

	function passwordCheck() {
		if(pw.value.length < 4) {
			alert("비밀번호는 4자 이상으로 입력해주십시오");
			return false;
		}	
		if(pw.value != pwOK.value) {
			alert("(비밀번호 확인) 비밀번호가 다릅니다.");
			return false;
		}
		else if(pw.value == pwOK.value) {
			return true; 
		}
	}