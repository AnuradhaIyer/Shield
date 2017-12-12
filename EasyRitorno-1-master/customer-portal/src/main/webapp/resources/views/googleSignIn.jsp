<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta name="google-signin-client_id" content="621235523747-r5su1pbj4jjtbe0bci2bq2h5o56u9qdv.apps.googleusercontent.com">
	<script src="https://apis.google.com/js/platform.js" async defer></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
		<div class="g-signin2" data-onsuccess="onSignIn"></div>
		  <div class="data">
		  	<p> Profile Details	</p>
		  	<img id="pic" class="img-circle" width="100" height="100"/>
		  	<p> Email address</p>
		  	<p id="email" class="alert alert-danger"></p>
		  	<button onclick="signOut()" class="btn btn-danger">Sign Out</button>
		  	<a type='hidden' style="visbility: none" id='signInLink'  onclick="window.location.href='/home'" ></a>
		  </div>
			<script type="text/javascript">
		 	function onSignIn(googleUser) {
			    /* alert("You have been successfully signed in"); */
			    var profile = googleUser.getBasicProfile();
			    sessionStorage.setItem('userEmail',profile.getEmail());
			    sessionStorage.setItem('userName',profile.ig);
			   // window.location.href='/customer/home';
			  // debugger;
			    $('#signInLink').trigger('click');
			   
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

</body>
</html>