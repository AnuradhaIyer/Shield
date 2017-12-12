<!-- Referenced from: https://github.com/spring-projects/spring-security-saml
				 https://startbootstrap.com/template-overviews/creative/ -->
<%@ page import="org.springframework.security.saml.metadata.MetadataManager" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="java.util.Set" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  	<meta name="description" content="">
  	<meta name="author" content="">
<head>
	
<!-- Bootstrap core CSS -->
     <link href="/dev-portal/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

   <!--  Custom fonts for this template -->
    <link href="/dev-portal/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

   <!--  Plugin CSS -->
    <link href="/dev-portal/resources/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

  <!--   Custom styles for this template -->
    <link href="/dev-portal/resources/css/creative.min.css" rel="stylesheet">
	<title>Sign In</title>
  </head>
  <!-- style="background-image:url(/dev-portal/resources/appImages/development.jpg); height:500px; width:500px" -->
<body>

<header class="masthead text-center text-white" style="height:100%">
 
<div >
 <div class="container my-auto">
        <div class="row">
          <div class="col-lg-10 mx-auto" style="padding-top:20px">
            <h1>
              <strong><i>Easy Ritorno Dev Portal</i></strong>
            </h1>
            <hr>
          </div>
          <div class="col-lg-8 mx-auto" >
            <p class="text-faded mb-5">Please Sign In to continue!</p>
            <!-- <a class="btn btn-primary btn-xl js-scroll-trigger" href="#about">Find Out More</a> -->
          </div>
        </div>
      </div>
<div class="main" id="main-two-columns">
    <div class="left" id="main-content">
        <div class="section">
            <div class="section-content">
                <div class="post">
                   <!--  <div class="post-title"><h2 class="label label-green">Welcome to Dev-Portal</h2></div>
                    <p class="quiet large">Please Sign In to continue!</p> -->
                    <div class="post-body">
                        <%
                            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletConfig().getServletContext());
                            MetadataManager mm = context.getBean("metadata", MetadataManager.class);
                            Set<String> idps = mm.getIDPEntityNames();
                            pageContext.setAttribute("idp", idps);
                        %>
                        <p></p>
                        <form action="<c:url value="${requestScope.idpDiscoReturnURL}"/>" method="get">
                            <c:forEach var="idpItem" items="${idp}">
                               <input type="radio" style="opacity:0;" checked="checked" name="${requestScope.idpDiscoReturnParam}" id="idp_<c:out value="${idpItem}"/>" value="<c:out value="${idpItem}"/>"/>
                                <label style="opacity:0; for="idp_<c:out value="${idpItem}"/>"><c:out value="${idpItem}"/></label>
                                 <br/>
                            </c:forEach>
                            <br>
                            <input class="btn btn-primary btn-xl js-scroll-trigger" type="submit" value="Sign In"/>
                        </form>
                    </div>
                </div>
                <div class="clearer">&nbsp;</div>
            </div>
        </div>
        <div class="clearer">&nbsp;</div>
    </div>
   
</div>

</div>
<!-- Bootstrap core JavaScript -->
    <script src="/dev-portal/resources/vendor/jquery/jquery.min.js"></script>
    <script src="/dev-portal/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="/dev-portal/resources/vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="/dev-portal/resources/vendor/scrollreveal/scrollreveal.min.js"></script>
    <script src="/dev-portal/resources/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="/dev-portal/resources/js/creative.min.js"></script>
 </header>
</body>
</html>