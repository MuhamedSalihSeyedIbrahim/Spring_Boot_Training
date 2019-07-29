<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<title>Spring Boot Web Application</title>
</head>
<body>
	<c:choose>
		<c:when test="${msg ne null}">
			<h3>${msg }</h3>
		</c:when>
		<c:otherwise>
			<h1>Welcome To SpringBoot</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>