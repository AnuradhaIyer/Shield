<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body data-ng-app="easyRitornoApp">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="/resources/scripts/angular.min.js"></script>
	<script type="text/javascript" src="/resources/scripts/ng-file-upload.js"></script>
	<script type="text/javascript" src="/resources/scripts/bootstrap.3.3.5.min.js"></script>
	<script type="text/javascript" src="/resources/scripts/app.js"></script>
	 <div ng-include src="'/resources/views/nav.jsp'"></div> 
	<div  data-ng-controller="homeCtrl">

		<div class="container-fluid">
			<div class="alert alert-success" ng-show="showSuccessAlert">
				<button type="button" class="close"
					data-ng-click="switchBool('showSuccessAlert')">◊</button>
				<strong>Done!</strong> {{successTextAlert}}
			</div>

			<div class="alert alert-danger" ng-show="showErrorAlert">
				<button type="button" class="close"
					data-ng-click="switchBool('showErrorAlert')">◊</button>
				<strong>Error!</strong> {{errorTextAlert}}
			</div>

			<div class="container">
				<form class="well form-horizontal" name="customerForm"
					ng-submit="createCustomer()">
					<legend>
						<center>
							<h2>
								<b>Schedule a pickup</b>
							</h2>
						</center>
					</legend>
					<br>
					<div class="form-group">
						<label class="col-md-4 control-label">First Name</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input name="first_name"
									placeholder="First Name" class="form-control"
									ng-model="firstname" type="text">
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label">Last Name</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input name="last_name"
									placeholder="Last Name" class="form-control"
									ng-model="lastname" type="text">
							</div>
						</div>
					</div>


					<div class="form-group">
						<label class="col-md-4 control-label">Address</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input name="address"
									placeholder="Address" class="form-control" ng-model="address"
									type="text">
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label">Select a city</label>
						<div class="col-md-4 selectContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-list"></i></span> <input name="city"
									placeholder="City" class="form-control" ng-model="city"
									type="text">

							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label">E-Mail</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-envelope"></i></span> <input id="userEmail"
									name="email" placeholder="E-Mail Address" class="form-control"
									ng-model="email" type="text">
							</div>
						</div>
					</div>




					<!-- Text input-->

					<div class="form-group">
						<label class="col-md-4 control-label">Contact No.</label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-earphone"></i></span> <input
									name="contact_no" placeholder="phone" class="form-control"
									ng-model="contactno" type="text">
							</div>
						</div>
					</div>
					
					<div class="form-group">
		<label class="col-md-4 control-label"></label>
		<div class="col-md-4">
			<br>
			<input type="submit" class="btn btn-warning">
				SUBMIT <span class="glyphicon glyphicon-send"></span>
			</button>
		</div>
	</div>
				</form>
			</div>
		</div>
	</div>
	 <div ng-include src="'/resources/views/footer.jsp'"></div> 
</body>
</html>