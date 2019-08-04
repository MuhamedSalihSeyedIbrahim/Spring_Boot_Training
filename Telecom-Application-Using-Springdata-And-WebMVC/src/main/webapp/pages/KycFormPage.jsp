<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="/header"></jsp:include>

<section class="container-fluid p-4">

<div class="row">

<div class="col-sm-6">

<form:form class="form" method="POST"  modelAttribute="cus">

<form:hidden path="cusId"/>

<div class="form-group">

</div>

<div class="form-group">
<form:label path="firstName">
FirstName : 
</form:label>
<form:input path="firstName" type="text" class="form-control"></form:input>
<form:errors path="firstName"></form:errors>
</div>

<div class="form-group">
<form:label path="lastName">
LastName : 
</form:label>
<form:input path="lastName" type="text" class="form-control"></form:input>
<form:errors path="lastName"></form:errors>
</div>


<div class="form-group">
<form:label path="mobileNumber">
Mobile Number : 
</form:label>
<form:input path="mobileNumber" class="form-control"></form:input>
<form:errors path="mobileNumber"></form:errors>
</div>




<div class="form-group">
<form:label path="emailId">
Email : 
</form:label>
<form:input path="emailId" type="email" class="form-control"></form:input>
<form:errors path="emailId"></form:errors>

</div>

<div class="form-group">
<form:label path="emailId">
Aadhar : 
</form:label>
<form:input path="aadhar" type="number" class="form-control"></form:input>
<form:errors path="aadhar"></form:errors>

</div>

<div class="form-group">
<form:label path="simScheme">Schemes : </form:label>
<form:select path="simScheme" type="text"  >
<form:option value="">----SELECT----</form:option>
<form:options items="${Scheme }"/>
</form:select>
<form:errors path="simScheme"></form:errors>
</div>

<div class="form-group">
<button class="btn btn-primary form-control mb-4">SAVE</button>
</div>

</form:form>

</div>

</div>

</section>


<jsp:include page="/footer"></jsp:include>