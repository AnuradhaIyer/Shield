<!DOCTYPE html>
<html>
<head> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script> 
<script src="https://code.angularjs.org/1.4.5/angular-route.js"></script>
<script type="text/javascript" src="/resources/scripts/app.js"></script> 
<script type="text/javascript" src="/resources/scripts/ng-file-upload.js"></script>
<script type="text/javascript" src="/resources/scripts/bootstrap.3.3.5.min.js"></script>
<script type="text/javascript" src="/path/to/bootstrap/dist/bootstrap.min.js"></script>
<!-- <script type="text/javascript" src="/path/to/bootstrap-datetimepicker.min.js"></script> -->
<script src="https://code.angularjs.org/1.5.5/angular.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/styles/app.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<!-- <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
 --><script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.3/moment-with-locales.min.js"></script>	
 </head>

<body data-ng-app="easyRitornoApp"> 
<div ng-include src="'/resources/views/nav.jsp'"></div>
   <div data-ng-controller="ordersCtrl"> 
<div class="container-fluid">
	<div class="alert alert-danger" ng-show="showErrorAlert">
		<button type="button" class="close"
			data-ng-click="switchBool('showErrorAlert')">◊</button>
		<strong>Error!</strong> {{errorTextAlert}}
	</div>
</div>

<div class="container well">		
	<h3>Packaging Information</h3>  
	<div class="form-group col-md-12">
		<label class="col-md-4 control-label"><b>Packaging Type</b></label>
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-folder-close"></i></span><select class="form-control" data-ng-model="selectedItem" data-ng-options="item.name for item in items track by item.name" placeholder="Packing Type" class="form-control"></select>
			</div>
		</div>
	    <!-- <select  data-ng-model="selectedItem" data-ng-options="item.name for item in items track by item.name"></select> -->
	</div>

	<div class="form-group col-md-12">
	    <label class="col-md-4 control-label"><b>Declared Value</b></label>
	    <div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-usd"></i></span>
					<input class="form-control" id="declValue" data-ng-model="declValue" type="text" placeholder="Enter value in USD" required>
			</div>
		</div>
		<!-- <input id="declValue" data-ng-model="declValue" type="text" placeholder="Enter value in USD" required> -->
	</div>

	<div class="form-group col-md-12">
		<label class="col-md-4 control-label"><b>Customer Address</b></label>
		<!-- <input id="custAdr" data-ng-model="custAdr" type="text" style="width:250px;height:60px" required> -->
		 <div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-home"></i></span>
					<textarea class="form-control" rows="2" cols="20" id="custAdr" data-ng-model="custAdr">Enter address here</textarea>
			</div>
		</div>
		<!-- <textarea rows="2" cols="20" id="custAdr" data-ng-model="custAdr">Enter address here</textarea> -->
	</div>
	<div class="form-group col-md-12">
	    <label class="col-md-4 control-label"><b>Pickup Date/Time</b></label>
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-calendar"></i></span>
					<input class="form-control" id="pickTime" data-ng-model="pickTime" type="date">
			</div>
		</div>
		<!-- <input id="pickTime" data-ng-model="pickTime" type="datetime-local"> --> 
	</div>

	<div class="form-group col-md-12">
		<label class="col-md-4 control-label"><b>Shipping Address</b></label>
		<!-- <input id="custAdr" data-ng-model="custAdr" type="text" style="width:250px;height:60px" required> -->
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-globe"></i></span>
					<textarea class="form-control" rows="2" cols="20" id="shippingAdr" data-ng-model="shippingAdr">Enter address here</textarea>
			</div>
		</div><br><br>
		<!-- <textarea rows="2" cols="20" id="shippingAdr" data-ng-model="shippingAdr">Enter address here</textarea> -->
	</div>

	<div class="form-group col-md-12">
	    <label class="col-md-4 control-label"><b>Shipping Date</b></label>
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon  glyphicon-calendar	Try it
"></i></span>
					<input class="form-control" id="shippingTime" data-ng-model="shippingTime" type="date">
			</div>
		</div>
		<!-- <input id="shippingTime" data-ng-model="shippingTime" type="date"> -->
	</div>
	    	
	<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post" target="_blank">
		<input  type="hidden" name="cmd" value="_cart"> 
		<input 	type="hidden" name="upload" value="1"> 
	     <input type="hidden" name="business" value="shield13.merchant@gmail.com"> 
	     
	    <input type="hidden" name="item_name_1" value="Pack Type">
	    <div>
		    <label class="col-md-4 control-label" style="padding-left:32px"><b>Total Cost</b></label>
		    <div class="form-group col-md-4">
				<div class="input-group">
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-usd"></i></span>
						<input class="form-control"  id="totalCost" data-ng-model="selectedItem.totalCost" type="text"  name="amount_1"  style="height:30px" data-ng-pattern="" readonly>
				</div>
			</div>
	        <!-- <input id="totalCost" data-ng-model="selectedItem.totalCost" type="text"  name="amount_1"  style="width:250px;height:30px" data-ng-pattern="" readonly> -->
	    </div>    
        <input type="hidden" name="quantity_1" value="1">
        <input type="hidden" name="return" value="http://localhost:9090/customer/"/>
         <br/>
         <br/>	
		<br/> 
		<div class="form-group col-md-12">        
	    <div class="alert alert-success" ng-show="showSuccessAlert">
				<button type="button" class="close"
					data-ng-click="switchBool('showSuccessAlert')">◊</button>
				<strong> Please proceed to pay through Paypal </strong> 
				<input style="display:none; margin:0 auto;"  id ="paypal" type="image" name="submit" border="0" align="center" 
				src="https://www.paypalobjects.com/webstatic/en_US/i/buttons/PP_logo_h_100x26.png"
				alt="Buy Now">
	  </div>
	  </div>
	</form>
	<div class="form-group col-md-12" style="    left: 36%;
    margin: 33px;
">
	<button id="confirm" class="btn btn-primary" data-ng-click="submitOrder()">
      Confirm Order Request
     </button>
     </div>
		<!-- Display the payment button. -->
		<div class="form-group col-md-12" font-size: 33px;>
		
				

	
      <!-- <div class="alert alert-success" ng-show="showSuccessAlert">
				<button type="button" class="close"
					data-ng-click="switchBool('showSuccessAlert')">◊</button>
				<strong> Please proceed to pay through Paypal </strong> 
				<input style="display:none; margin:0 auto;"  id ="paypal" type="image" name="submit" border="0" align="center" 
				src="https://www.paypalobjects.com/webstatic/en_US/i/buttons/PP_logo_h_100x26.png"
				alt="Buy Now">
	  </div> -->
	  </div> 
</div>	  
	<!-- <a data-ng-click="submitOrder()">Submit Order</a> -->
	<!-- </div> -->
	<div ng-include src="'/resources/views/footer.jsp'"></div>
	<div ng-include src="'/resources/views/footer.jsp'"></div> 
	<script type="text/javascript">
		$('#confirm').on('click',function(){
			$('#paypal').css('display','block');
		})
		
	</script>
</body>
</html>
