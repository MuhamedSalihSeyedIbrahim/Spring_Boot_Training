<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<title>CRUD</title>
<link href="styles/site.css" rel="stylesheet" />
<base href="/" />
</head>
<body>
	<header>
		<h1>Spring Data Web MVC App</h1>
	</header>
	<section>
		<h3>Welcome Home</h3>

		<c:choose>
			<c:when test="${currentUserName ne null }">
				<p>
					Hello!
					<stromg>${currentUserName }</stromg>
				</p>
				<div>
					<a href="emps/list">Employees</a> <span>|</span> 
					<a href="emps/add">Add New Record</a> <span>|</span>
					<a href="logout">Logout</a>
				</div>
			</c:when>
			<c:otherwise>
					<a href="login">Login</a>
			</c:otherwise>
		</c:choose>

	</section>
	<footer> </footer>
</body>
</html>