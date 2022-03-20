<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로딩</title>
</head>
<body>
<c:choose>
<c:when test="${not empty msg}">
	<script type="text/javascript">
		alert('${msg}');
		location.href = '${from}';
	</script>
</c:when>
<c:when test="${empty msg}">
	<script type="text/javascript">
		location.href = '${from}';
	</script>
</c:when>
</c:choose>
</body>
</html>