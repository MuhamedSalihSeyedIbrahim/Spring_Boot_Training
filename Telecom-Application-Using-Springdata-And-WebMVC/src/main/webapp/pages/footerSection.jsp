<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<footer
	class="container-fluid p-2 bg-dark text-light text-center fixed-bottom">
	<c:forEach var="link" items="${ link }">
		<li class="btn btn-sm m-2"><a class="nav-link" href="${ link.key}">${link.value}</a>
		</li>
	</c:forEach>
</footer>
</body>
</html>