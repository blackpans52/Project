<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로딩</title>
</head>
<body>
	<c:if test="${not empty msg}">
		<script type="text/javascript">
			alert('${msg}');
			location.href= "board.do?bCode=${bCode}"
		</script>
	</c:if>
		<script type="text/javascript">
			location.href= "board.do?bCode=${bCode}"
		</script>
</body>
</html>