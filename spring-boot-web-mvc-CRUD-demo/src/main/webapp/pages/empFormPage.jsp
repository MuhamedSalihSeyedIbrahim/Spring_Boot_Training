<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="/header"></jsp:include>

<section class="container-fluid p-4">

<div class="row">

<div class="col-sm-6">

<form:form class="form" method="POST" modelAttribute="emp">

<form:hidden path="empId"/>

<div class="form-group">
<form:errors></form:errors>
</div>

<div class="form-group">
<form:label path="firstName">
FirstName : 
</form:label>
<form:input path="firstName" type="text" class="form-control"></form:input>
</div>

<div class="form-group">
<form:label path="lastName">
LastName : 
</form:label>
<form:input path="lastName" type="text" class="form-control"></form:input>
</div>

<div class="form-group">
<form:label path="basic">
Basic : 
</form:label>
<form:input path="basic" type="decimal" class="form-control"></form:input>
</div>

<div class="form-group">
<form:label path="mobileNumber">
Mobile Number : 
</form:label>
<form:input path="mobileNumber" class="form-control"></form:input>
</div>

<div class="form-group">
<form:label path="joinDate">
JoinDate : 
</form:label>
<form:input path="joinDate"  type="date" class="form-control"></form:input>
</div>


<div class="form-group">
<form:label path="emailid">
Email : 
</form:label>
<form:input path="emailid" type="email" class="form-control"></form:input>
</div>

<div class="form-group">
<form:label path="dept">Department : </form:label>
<form:select path="dept" type="text"  >
<form:option value="">----SELECT----</form:option>
<form:options items="${depts }"/>
</form:select>
</div>

<div class="form-group">
<button class="btn btn-primary form-control mb-4">SAVE</button>
</div>

</form:form>

</div>

</div>

</section>


<jsp:include page="/footer"></jsp:include>