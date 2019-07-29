<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<title>Greet</title>
<link rel="stylesheet" href="resources/site.css">
</head>
<body>
	<jsp:include page="/header" />
	<h2>Greet ${greeting} !! </h2>
	<form>
			Name: <input type="text" name="unm" required/>
			<button>Greet Me!</button>
	</form>
	<jsp:include page="/footer" />
</body>

</html>