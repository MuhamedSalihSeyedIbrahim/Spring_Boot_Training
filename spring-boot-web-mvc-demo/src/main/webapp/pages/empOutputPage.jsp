<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>



 <jsp:include page="/header"/>
<h2>Employee Details</h2>


<c:choose>
<c:when test="emp eq null">
<p>No data</p>
</c:when>
<c:otherwise>
<table>
<tr><td><em>Employee ID</em></td><td><strong>${emp.empId }</strong></td></tr>
<tr><td><em>Employee Name</em></td><td><strong>${emp.name }</strong></td></tr>
<tr><td><em>Designation</em></td><td><strong>${emp.designation }</strong></td></tr>
<tr><td><em>Basic pay</em></td><td><strong>${emp.basic }</strong></td></tr>
<tr><td><em>HRA</em></td><td><strong>${emp.hra }</strong></td></tr>
<tr><td><em>TA</em></td><td><strong>${emp.ta }</strong></td></tr>
</table>
</c:otherwise>
</c:choose>


 <jsp:include page="/footer"/>