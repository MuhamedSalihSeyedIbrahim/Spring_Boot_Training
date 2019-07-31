<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
	<head>
		<title>${apptitle}</title>
		<link rel="stylesheet" href="css/bootstrap.min.css"/>
		<script type="text/javascript" src="js/jquery.min.js"> </script>
		<script type="text/javascript" src="js/popper.min.js"> </script>
		<script type="text/javascript" src="js/bootstrap.min.js"> </script>
	</head>
	<body>
		<nav class="navbar nav-dark bg-dark navbar-expand-sm">
		
		<a href="#" class="navbar-brand">${apptitle}</a>
		<ul class="navbar-nav">
			<c:forEach var="link" items="${link }" >
				<li class="nav-item">
					<a class="nav-link" href="${link.key}">${link.value} </a>
				</li>
			</c:forEach>
		</ul>
		</nav>
