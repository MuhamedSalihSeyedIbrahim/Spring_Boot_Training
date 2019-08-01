<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>

<jsp:include page="/header"></jsp:include>

<div class="container p-4">

	<table class="table table-striped table-bordered">
		<c:choose>
			<c:when test="${OfferData eq null}">
				<p class="alter alert-info">Please Select the Offer Type</p>
			</c:when>
			<c:otherwise>
				<thead>
					<tr>
						<th>Offer ID#</th>
						<th>Offer Name</th>
						<th>Offer Price</th>
						<th>Offer Validity</th>
						<th>Description</th>
						<th>Action</th>
					</tr>
				</thead>
				<c:forEach var="d" items="${OfferData}">
				<tr>
				<!-- the attributes name must be start with small letters  -->
					<td>${d.id}</td>
					<td>${d.offerName}</td>
					<td>${d.cost}</td>
					<td>${d.validityPeriod}</td>
					<td>${d.description}</td>
					
					<td><a href="/saveCustomer?id=${d.id}" class="btn btn-primary ">Choose</a></td>
				</tr>
				</c:forEach>
			
			</c:otherwise>
		</c:choose>

		
	</table>
</div>

<jsp:include page="/footer"></jsp:include>