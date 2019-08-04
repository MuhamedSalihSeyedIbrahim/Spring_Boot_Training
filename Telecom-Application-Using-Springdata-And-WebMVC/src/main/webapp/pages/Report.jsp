<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="/header"></jsp:include>
<section>
	<div style="margin-top: 10%">


		<div class="container-fluid">
			<div class="row m-4">
				<div class="col-md-6">
				<center>
					<div class="card" style="width: 18rem;">
						<div class="card-body">
							<h5 class="card-header">Customer Details</h5>
							<p class="card-text">Customer Id : ${Details.cusId}</p>
							<p class="card-text">Full Name : ${Details.firstName}
								${Details.lastName}</p>
							<p class="card-text">Email : ${Details.emailId}</p>
							<p class="card-text">Mobile Number : ${Details.mobileNumber}</p>
							<p class="card-text">Sim Scheme : ${Details.simScheme}</p>
							<p class="card-text">Aadhar : ${Details.aadhar}</p>
						</div>
					</div>
					</center>
				</div>

				<div class="col-md-6">
				<center>
					<div class="card" style="width: 18rem;">
						<div class="card-body">
							<p class="card-header">Choosed Offer Plan Details</p>
							<p class="card-text">Plan Id :
								${Details.packageDetailChoosed.planID}</p>
							<p class="card-text">Subscription Start Date :
								${Details.packageDetailChoosed.subscriptionStartDate}</p>
							<p class="card-text">Subscription End Date :
								${Details.packageDetailChoosed.subscriptionEndDate}</p>
							<p class="card-text">Description :
								${Details.packageDetailChoosed.description}</p>
							<p class="card-text">Cost :
								${Details.packageDetailChoosed.cost}</p>
						</div>
					</div>
					</center>
				</div>

			</div>
	
				<div class="col-md-12  justify-content-center ">
					<p class="alert alert-success">	SAVED!!</p>
</div>	
				</div>
			</div>
		</div>
	</div>



</section>
<jsp:include page="/footer"></jsp:include>