$(document).ready(function () {
      $('#summernote').summernote({
		height: 600,
        lang: 'ko-KR',        
        fontNames: ['맑은 고딕','돋움','굴림','바탕','궁서','Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', 'sans-serif'],
        fontSizes: ['8', '9', '10', '11', '12', '14', '16', '18', '24', '36'],
        toolbar: [
          ['fontsize'],
          ['font', ['bold', 'underline', 'strikethrough', 'clear']],
          ['fontname', ['fontname']],
          ['color', ['color']],
          ['para', ['paragraph']],
          ['table', ['table']],
          ['insert', ['link', 'picture']],
          ['undo_redo', ['undo', 'redo']],
          ['view', ['codeview', 'help']]
        ],        
        callbacks : {
    		onImageUpload : function(files, editor, welEditable) {    			
    			for (var i = 0; i < files.length; i++) {
    				sendFile(files[i], this);
    			}
    		}
    	}
      });
      $('#summernote').summernote('fontName', '맑은 고딕');
    });
    
    /* summernote에서 이미지 업로드시 실행할 함수 */
    function sendFile(file, editor) {
            // 파일 전송을 위한 폼생성
	 		data = new FormData();
	 	    data.append("uploadFile", file);
	 	    $.ajax({ // ajax를 통해 파일 업로드 처리
	 	        data : data,
	 	        type : "POST",
	 	        url : "Board/summernote_imageUpload.jsp",
	 	        cache : false,
	 	        contentType : false,
	 	        processData : false,
	 	        success : function(data) { // 처리가 성공할 경우
                    // 에디터에 이미지 출력
	 	        	$(editor).summernote('editor.insertImage', data.url);
	 	        }
	 	    });
	 	}