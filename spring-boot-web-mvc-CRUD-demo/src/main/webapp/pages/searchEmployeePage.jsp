<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<jsp:include page="/header"/>
<script>
	function searchfun(event)
	{
		document.getElementById("inp").placeholder = "Enter Employee "+event.target.value;
	}
</script>
<div class="container p-4">
	<form method="GET" action="findData">
		<table class="table  table-striped">
		<tr>
			<td><strong>Search Employee Data</strong></td>
			<td>
				<select  name="search" class="form-control" onchange="searchfun(event)">
					<option value="">----SELECT-----</option>
					<option value="Id">Search By Id</option>
					<option value="emailId">Search By Email Id</option>
					<option value="mobileno">Search By mobile number</option>
					<option value="department"> Search By department</option>
					<option value="joiningDate">Search By joining date</option>
				</select>
				</td>
				<td>
					<input  type="text" id="inp" name="inputval" class="form-control" />
				</td>
				<td>
					<button  class="btn btn-success">Search</button>
				</td>
		</tr>
					<c:choose>
					<c:when test="${data eq null}">
					<tr>
						<td><p class="alert alert-info">
						Sry data can not be fetched
					</p></td>
					</tr>
					</c:when>
					<c:when>
						<tr>
						<td><strong>First Name</strong></td>
						<td><strong>last Name</strong></td>
						<td><strong>Basic</strong></td>
						<td><strong>Joining Date</strong></td>
						<td><strong>Mobile Number</strong></td>
						<td><strong>Email Id</strong></td>
					</tr>
					
					</c:when>
					<c:otherwise>
					<tr>
						<td><strong>First Name</strong></td>
						<td><strong>last Name</strong></td>
						<td><strong>Basic</strong></td>
						<td><strong>Joining Date</strong></td>
						<td><strong>Mobile Number</strong></td>
						<td><strong>Email Id</strong></td>
					</tr>
					<tr>
						<c:forEach var ="val" items="${data}">
							<td>
								${data.firstname}
							</td>
							<td>
								${data.lastname}
							</td>
							<td>${emp.basic}</td>
							<td>${emp.dept}</td>
							<td>${emp.joinDate}</td>
							<td>${emp.mobileno}</td>
							<td>${emp.emailid}</td>
						</c:forEach>
					</tr>
					</c:otherwise>
			</c:choose>
		
	</table>
	</form>
</div>
<jsp:include page="/footer"/>