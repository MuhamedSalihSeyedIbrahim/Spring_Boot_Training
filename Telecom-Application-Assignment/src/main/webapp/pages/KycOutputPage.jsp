<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>



 <jsp:include page="/header"/>
<h2>Customer Details</h2>


<c:choose>
<c:when test="client_KYC eq null">
<p>No data</p>
</c:when>
<c:otherwise>
<table>
<tr><td><em> Id</em></td><td><strong>${client_KYC.customerId }</strong></td></tr>
<tr><td><em>Full Name</em></td><td><strong>${client_KYC.fullName }</strong></td></tr>
<tr><td><em>Address</em></td><td><strong>${client_KYC.address }</strong></td></tr>
<tr><td><em>Email</em></td><td><strong>${client_KYC.email }</strong></td></tr>
<tr><td><em>Phone Number</em></td><td><strong>${client_KYC.phoneNo }</strong></td></tr>
<tr><td><em>Aadhar</em></td><td><strong>${client_KYC.aadhar }</strong></td></tr>
</table>
<a href="packageSelection">Package Select</a>
</c:otherwise>
</c:choose>


 <jsp:include page="/footer"/>