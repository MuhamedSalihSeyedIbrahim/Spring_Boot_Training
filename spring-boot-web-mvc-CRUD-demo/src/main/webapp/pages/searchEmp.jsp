<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<jsp:include page="/header"/>
<script>
	function searchfun(event)
	{
		document.getElementById("inp").placeholder = "Enter Employee "+event.target.value;

		if(event.target.value === "Basic")
		{
			document.getElementById("inp1").hidden=false;
			document.getElementById("inp").placeholder = "Enter Min range";
			document.getElementById("inp1").placeholder = "Enter Max range";
		}
		else
		{
			document.getElementById("inp1").hidden=true;
			
		}
	}
</script>
<div class="container p-4">
	<form method="GET" action="findData">
	<table class="table table-striped">
		<tr>
			<td><strong>Search Employee Data</strong></td>
			<td>
				<select  name="search" class="form-control" onchange="searchfun(event)">
					<option value="">----SELECT-----</option>
					<option value="Id">Search By Id</option>
					<option value="EmailId">Search By Email Id</option>
					<option value="Mobileno">Search By mobile number</option>
					<option value="Department"> Search By department</option>
					<option value="JoiningDate">Search By joining date</option>
					<option value="Basic">Search By Basic value</option>
				</select>
				</td>
				<td>
					<input  type="text" id="inp" name="inputval" class="form-control" />
				</td>
				<td>
					<input hidden="true" type="text" id="inp1" name="inputval1" class="form-control" />
				</td>
				<td>
					<button  class="btn btn-success">Search</button>
				</td>
		</tr>
		</table>
					<c:choose>
					<c:when test="${data eq null}">
					<tr>
						<td><p class="alert alert-info">
						Sry data can not be fetched
					</p></td>
					</tr>
					</c:when>
				
				<c:when test="${check==1}">
					<table class="table table-bordered  table-striped">
							<tr>
							<td><strong>ID</strong></td>
							<td><strong>First Name</strong></td>
							<td><strong>last Name</strong></td>
							<td><strong>Basic</strong></td>
							<td><strong>Department</strong></td>
							<td><strong>Joining Date</strong></td>
							<td><strong>Mobile Number</strong></td>
							<td><strong>Email Id</strong></td>
						</tr>
						<tr>
								<td>
									${data.empId}
								</td>
								<td>
									${data.firstName}
								</td>
								<td>
									${data.lastName}
								</td>
								<td>${data.basic}</td>
								<td>${data.dept}</td>
								<td>${data.joinDate}</td>
								<td>${data.mobileNumber}</td>
								<td>${data.emailid}</td>
						</tr>
					</table>
				</c:when>
				<c:otherwise>
					<table class="table table-bordered table-striped">
					<tr>
						<td><strong>ID</strong></td>
						<td><strong>First Name</strong></td>
						<td><strong>last Name</strong></td>
						<td><strong>Basic</strong></td>
						<td><strong>Role</strong></td>
						<td><strong>Joining Date</strong></td>
						<td><strong>Mobile Number</strong></td>
						<td><strong>Email Id</strong></td>
					</tr>
					
						<c:forEach var ="val" items="${data}">
							<tr>
								<td>
									${val.empId}
								</td>
								<td>
									${val.firstName}
								</td>
								<td>
									${val.lastName}
								</td>
								<td>${val.basic}</td>
								<td>${val.dept}</td>
								<td>${val.joinDate}</td>
								<td>${val.mobileNumber}</td>
								<td>${val.emailid}</td>
						 </tr>
					 </c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
		

	</form>
</div>
<jsp:include page="/footer"/>
