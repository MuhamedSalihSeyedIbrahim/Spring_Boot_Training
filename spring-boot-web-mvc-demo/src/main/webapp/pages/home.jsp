<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<title>Home Page</title>
<link rel="stylesheet" href="resources/site.css">
</head>
<body>
	<jsp:include page="/header" />
	<h2>${pageTitle}</h2>
	<h3>Developers</h3>
	<ol>
		<c:forEach var="i" items="${developer}">
			<li>${i}</li> 
		</c:forEach>
	</ol>
	<jsp:include page="/footer" />
	
</body>

</html>