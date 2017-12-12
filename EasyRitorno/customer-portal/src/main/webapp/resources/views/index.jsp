<!DOCTYPE html>
<html>
<head>
<meta name="google-signin-client_id" content="621235523747-r5su1pbj4jjtbe0bci2bq2h5o56u9qdv.apps.googleusercontent.com">
 <script src="https://apis.google.com/js/platform.js" async defer></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 <style type="text/css">
   .g-signin2{
     margin-left:500px;
     margin-top: 200px; 
     /*display: block;*/
   }
   .data
   {
   	display: none;
   }
 </style>
</head>
<body>
	<script type="text/javascript" src="/resources/scripts/angular.min.js"></script>
	<script type="text/javascript" src="/resources/scripts/ng-file-upload.js"></script>
	<script type="text/javascript" src="/resources/scripts/angular-route.min.js"></script>
	<script type="text/javascript" src="/resources/scripts/app.js"></script> 	
<body data-ng-app="easyRitornoApp">
	  <div ng-include src="'/resources/views/nav.jsp'"></div> 
	<div class="g-signin2" data-onsuccess="onSignIn"></div>
  <div class="data">
  	<p> Profile Details	</p>
  	<img id="pic" class="img-circle" width="100" height="100"/>
  	<p> Email address</p>
  	<p id="email" class="alert alert-danger"></p>
  	<button onclick="signOut()" class="btn btn-danger">Sign Out</button>
  </div>
	<script type="text/javascript">
 	function onSignIn(googleUser) {
	    /* alert("You have been successfully signed in"); */
	    var profile = googleUser.getBasicProfile();
	    sessionStorage.setItem('userEmail',profile.getEmail());
	    sessionStorage.setItem('userName',profile.ig);
	    window.location.href='/resources/views/home.jsp';
	    
	   
 /* 		var profile = googleUser.getBasicProfile();
 		$(".g-signin2").css('display','none');
 		$(".data").css('display','block');
 		$("#pic").attr('src',profile.getImageUrl());
 		$("#email").text(profile.getEmail()); */
 	}
 	function signOut(){
 		var auth2 = gapi.auth2.getAuthInstance();
 		auth2.signOut().then(function(){
 			alert("You have been successfully signed out!");
 			$(".g-signin2").css('display','block');
 			$(".data").css('display','none');
 		});
 	}
 </script>
 <!-- <div data-ng-view></div>   -->
  <div ng-include src="'/resources/views/footer.jsp'"></div> 
</body>
</html>
