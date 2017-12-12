<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Easy Ritorno</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
   <style>
p.padding {
    padding-right: 2cm;
}
p.padding2 {
    padding-right: 50%;
}

    .fa {
  padding: 12px;
  font-size: 20px;
  width: 30px;
  text-align: center;
  text-decoration: none;
  margin: 5px 2px;
  
  
}
.w-auto {
    width: auto;
}
.table-wrapper-2 {
    display: block;
    max-height: 500px
 }     

.fa:hover {
    opacity: 0.7;
}

.fa-facebook {
  background: #3B5998;
  color: white;
}

.fa-twitter {
  background: #55ACEE;
  color: white;
}

.fa-youtube {
  background: #bb0000;
  color: white;
}
.btn {
    border: none;
    color: white;
    padding: 11px 33px;
    font-size: 19px;
    cursor: pointer;
    border="0"; 
    align="center";
}
    
.success {background-color: #337ab7; border="0"
    align="center"} /* Green */
.success:hover {background-color: #337ab7; border="0"
    align="center"}
    }
    
</style>
    
</style>
</head>
</head>
<body data-ng-app="easyRitornoApp">
	<script type="text/javascript" src="/resources/scripts/angular.min.js"></script>
	<script type="text/javascript" src="/resources/scripts/ng-file-upload.js"></script>
	<script type="text/javascript" src="/resources/scripts/bootstrap.3.3.5.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="/resources/scripts/angular-route.min.js"></script>
	<script type="text/javascript" src="/resources/scripts/app.js"></script> 	
	<div data-ng-controller="listorderCtrl">
	<div ng-include src="'/resources/views/nav.jsp'"></div> 
	<h2>Order Details </h2>
	
<!-- <div class='order'>{{orders['ordersList'][0]['packType']}}</div> -->	
	<div ng-show="isDataPresent">
	<table class="table table-striped table-bordered table-responsive w-auto">
	<thead>
		<tr>
			<th><p class="text-center"><label class="col-md-4 control-label">ORDERID</th></label></p>
			<th><label class="col-md-4 control-label">PACKAGETYPE</th></label>
			<th><label class="col-md-4 control-label">CUSTOMERADDRESS</th></label>
			<th><label class="col-md-4 control-label">SHIPPINGADDRESS</th></label>
			<th><label class="col-md-4 control-label">TOTALCOST</th></label>
			<th><label class="col-md-4 control-label">STATUS</th></label>
		</tr>
		</thead>
		
		<tr ng-repeat="a in orders['ordersList'] ">
		<td><p class="text-center">{{a['id']}}</td></p>
		<td><p class="text-center">{{a['packType']}}</td></p>
		
		<td><p class="text-center">{{a['custAdr']}}</td></p>
		<td><p class="text-center">{{a['shippingAdr']}}</td></p>
		<td><p class="text-center">{{a['totalCost']}}</td></p>
		<td><p class="text-center">{{a['orderStatus']}}</td></p>
		
		</tr>
	</table>
	
	
	<div ng-show="!isDataPresent">
			<p style="text-align: center; font-size: larger;">No Files uploaded</p>
	</div>
		<div class="Center' col-md-3" style="float:right; margin-left:139px;">
	<button class="btn success" onclick='window.location.href="/resources/views/orders.jsp"'>Create Order</button>
	</div>
	</div>
	
	
	
	</div> </br> </br> </br> </br>
<!-- 
<a href="#" class="fa fa-twitter"></a>
<a href="#" style="postion:absolute" class="fa fa-youtube"></a><br> <br><br> -->
           <div style="position:absolute;top: 450px; right:0%;margin-left:10px; ">
           
           <div>
           <img src="http://redhint.com/wp-content/uploads/2017/09/Twitter.jpg" alt="Smiley face" width="70" height="70">
           </div>
            <a  class="twitter-timeline"  href="https://twitter.com/search?q=Easyritorno" data-widget-id="930980880494899201">Tweets about Easyritorno</a>
            <div  ><script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+"://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script><br> </div></br></br>
            <div>
            <img src="http://www.freeiconspng.com/uploads/facebook-transparent-like-us-31.jpg" width="250" height="60">
            </div>
         	 <div ><iframe src="http://www.facebook.com/plugins/likebox.php?href=http%3A%2F%2Fwww.facebook.com%2F2031430373801315 &width=600&colorscheme=light&show_faces=true&border_color&stream=true&header=true&height=700" scrolling="yes" frameborder="0" style="border:none; overflow:hidden; width:600px; height:630px; background: white; float:left; " allowtransparency="true"></iframe></div>
 			</div>
  <div ng-include src="'/resources/views/footer.jsp'"></div>         
</body>
</html>