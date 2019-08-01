<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<jsp:include page="/header" />
<div class="container-fluid p-4">
	<h3>Employee List</h3>
		<c:choose>
		<c:when test="${emp eq null}">
			<p class="alert alert-warning">
			Sorry! Data could not be fetched! Or No Record Found!
			</p>
			</c:when>
			<c:when test="${ emp.size()==0}">
				<p class="alert alert-info">
				<strong> 0 </strong> Record found
			</c:when>
			<c:otherwise>
				<table class=table table-bordered table-striped table-hovered">
				<thead>
				<tr>
				<th>Employee# </th>
				<th>Full Name</th>
				<th>Mobile</th>
				<th>Mail</th>
				<th>Actions</th>
				</tr>
				</thead>
				<tbody>
				
				<c:forEach var="e" items="${emp}">
				<tr>
					<td class="text-right">${e.empId }</td>
					<td>${e.firstName} ${e.lastName}</td>
					<td>${e.mobileNumber }</td>
					<td>${e.emailid }</td>
					<td><a href="details?empId=${e.empId }" class="btn btn-sm btn-info">View Details</a></td>
					</tr>
					</c:forEach>
					
				
				</tbody>
				</table>
				
			</c:otherwise>
		</c:choose>

</div>
<jsp:include page="/footer" />