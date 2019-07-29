<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<title>Home Page</title>
<link rel="stylesheet" href="resources/site.css">
</head>
<body>
	<jsp:include page="/header" />
	<h1>${pageTitle}</h1>
	<jsp:include page="/footer" />
	
</body>

</html>