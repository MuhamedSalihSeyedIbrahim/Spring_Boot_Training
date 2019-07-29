<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<title>Task Page</title>
<link rel="stylesheet" href="resources/site.css">
</head>
<body>
	<jsp:include page="/header" />
	<h1>Task List</h1>
	<form>
		<label>Task Name: <input type="text" name="task" required/></label>
		<button formaction="addTask"> ADD </button>
		<button formaction="delTask"> DELETE </button>
		<button formaction="tasks" formnovalidation >REFRESH </button>
	</form>
	
	<h3>Tasks </h3>
	<ol>
		<c:forEach var="t" items="${tasks}">
		<li>${t}</li>	
		</c:forEach>
	</ol>
	
	<jsp:include page="/footer" />
	
</body>

</html>