<%@page import="java.time.LocalDate" %>
<header>
	<h3 style="text-align:right">
		<%=LocalDate.now() %>
		</h3>
		<h1 style="border-bottom: 1px solid black"> ${appTitle} </h1>
</header>
<nav>
	<a href="home" > Home </a>
	<a href="client_KYC"> New Subscribe! </a>
</nav>