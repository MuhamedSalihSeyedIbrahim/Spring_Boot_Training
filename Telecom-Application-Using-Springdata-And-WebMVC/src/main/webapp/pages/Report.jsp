<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="/header"></jsp:include>
<section >
<div style="margin-top:10%">
<center>
<div class="card" style="width: 18rem;">
  <div class="card-body" >
    <h5 class="card-header">Customer Details</h5>
    <p class="card-text">Customer Id              : ${Details.cusId}</p>
    <p class="card-text">Full Name           : ${Details.firstName} ${Details.lastName}</p>
    <p class="card-text">Email     : ${Details.emailId}</p>
    <p class="card-text">Mobile Number          : ${Details.mobileNumber}</p>
    <p class="card-text">Mobile Number       : ${Details.SimScheme}</p>
    <p class="card-text">EmailId             : ${Details.aadhar}</p>
   	    <p class="card-text">EmailId             : ${Details.packageDetailChoosed.planId}</p>
   	    <p class="card-text">EmailId             : ${Details.packageDetailChoosed.SubscriptionStartDate}</p>
   	    <p class="card-text">EmailId             : ${Details.packageDetailChoosed.SubscriptionEndDate}</p>
   		<p class="card-text">EmailId             : ${Details.packageDetailChoosed.Description}</p>
    	<p class="card-text">EmailId             : ${Details.packageDetailChoosed.Cost}</p>
    
    <a href="/editEmp?id=${emp.empId}" class="btn btn-primary">Edit</a>
    <a href="/deleteEmps?empId=${emp.empId}" class="btn btn-danger">Delete</a>
  </div>
</div>
</center>
</div>
</section>
<jsp:include page="/footer"></jsp:include>