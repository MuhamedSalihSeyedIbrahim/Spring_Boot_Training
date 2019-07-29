<%@  taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>



 <jsp:include page="/header"/>
<h2>Employee form</h2>

<form:form method="POST" modelAttribute="emp">

<div>
<form:label path="empId">EmployeeId:</form:label>
<form:input path="empId" type="number"/>
</div>

<div>
<form:label path="name">Name : </form:label>
<form:input path="name" type="text"/>
</div>

<div>
<form:label path="designation">Designation : </form:label>
<form:select path="designation" type="text">
<form:option value="">----SELECT----</form:option>
<form:options items="${designations }"/>
</form:select>

</div>

<div>
<form:label path="basic">Basic : </form:label>
<form:input path="basic" type="number"/>
</div>

<div>
<button>DONE</button>
</div>

</form:form>


 <jsp:include page="/footer"/>