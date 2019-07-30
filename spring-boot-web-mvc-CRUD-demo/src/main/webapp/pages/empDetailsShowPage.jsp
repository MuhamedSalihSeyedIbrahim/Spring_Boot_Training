<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="/header"></jsp:include>
<section >
<div style="margin-top:10%">
<center>
<div class="card" style="width: 18rem;">
  <div class="card-body" >
    <h5 class="card-header">Employee Details</h5>
    <p class="card-text">Emp Id              : ${emp.empId}</p>
    <p class="card-text">Full Name           : ${emp.firstName} ${emp.lastName}</p>
    <p class="card-text">Salary (Basic)      : ${emp.basic}</p>
    <p class="card-text">Department          : ${emp.dept}</p>
    <p class="card-text">Mobile Number       : ${emp.mobileNumber}</p>
    <p class="card-text">EmailId             : ${emp.emailid}</p>
    <p class="card-text">Joined Date             : ${emp.joinDate}</p>
    <a href="/editEmps?empId=${emp.empId}" class="btn btn-primary">Edit</a>
    <a href="/deleteEmps?empId=${emp.empId}" class="btn btn-danger">Delete</a>
  </div>
</div>
</center>
</div>
</section>
<jsp:include page="/footer"></jsp:include>