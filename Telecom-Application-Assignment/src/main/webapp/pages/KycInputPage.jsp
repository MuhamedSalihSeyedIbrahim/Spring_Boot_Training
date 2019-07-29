<%@  taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>



 <jsp:include page="/header"/>
<h2>KYC Data Collecting Form</h2>

<form:form method="POST" modelAttribute="client_KYC">

<div>
<form:label path="fullName">FullName:</form:label>
<form:input path="fullName" type="text"/>
</div>



<div>
<form:label path="email">Email:</form:label>
<form:input path="email" value="" type="email"/>
</div>

<div>
<form:label path="phoneNo">Phone:</form:label>
<form:input path="phoneNo" value="" type="number"/>
</div>
<div>
<form:label path="aadhar">Aadhar: </form:label>
<form:input path="aadhar" value="" type="number"/>
</div>

<div>
<form:label path="address">Address:</form:label>
<form:input path="address" value="" type="text"/>
</div>

<div>
<button>DONE</button>
</div>

</form:form>


 <jsp:include page="/footer"/>