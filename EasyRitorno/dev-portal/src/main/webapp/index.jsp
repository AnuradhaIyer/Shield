<!-- Referenced from: https://github.com/spring-projects/spring-security-saml
				 https://startbootstrap.com/template-overviews/creative/ -->
<%@ page import="org.springframework.security.saml.SAMLCredential" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.opensaml.saml2.core.Attribute" %>
<%@ page import="org.springframework.security.saml.util.SAMLUtil" %>
<%@ page import="org.opensaml.xml.util.XMLHelper" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html lang="en">
<head>
	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  	<meta name="description" content="">
  	<meta name="author" content="">
<!-- Bootstrap core CSS -->
    <link href="/dev-portal/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Oswald:700|Patua+One|Roboto+Condensed:700" rel="stylesheet">
	
    <!-- Custom fonts for this template -->
    <link href="/dev-portal/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="/dev-portal/resources/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/dev-portal/resources/css/creative.min.css" rel="stylesheet">
	<title>Info</title>
  </head>

<body >
<header class="masthead text-center text-white " style="height:100%;  ">
 <%
                                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                                SAMLCredential credential = (SAMLCredential) authentication.getCredentials();
                                pageContext.setAttribute("authentication", authentication);
                                pageContext.setAttribute("credential", credential);
                                pageContext.setAttribute("assertion", XMLHelper.nodeToString(SAMLUtil.marshallMessage(credential.getAuthenticationAssertion())));
                            %>
           
      <div class="container my-auto" >
      <div align="right">
      <table>
      <tr>
      	<td>
     	  <form class="left" action="<c:url value="/saml/logout"/>" method="get"><strong>Welcome </strong><c:out value="${authentication.name}"/>!  <input type="submit" value="Logout" class="btn btn-primary btn-xl js-scroll-trigger"  style=" height:30px; width:80px;text-transform:capitalize; font-weight:300;padding:0px 0px 0px 0px; " /></form>
         </td>
      </tr> 
      </table>
      </div>
      <div style="padding-top:30px">
      
          <%-- <p align=right><strong>Welcome </strong><c:out value="${authentication.name}"/> !</p> --%>
            <h1 >
              <strong><i>Easy Ritorno Dev Portal</i></strong>
            </h1>
            <hr>
      
             
          </div>
      <div align="right">
     
                                </div>
        <div class="row" style="padding-top:10px">
         
          <div class="col-lg-8 mx-auto">
            <p class="text-faded mb-5">Open apps using the below links</p>
           <!--  <a class="btn btn-primary btn-xl js-scroll-trigger" href="#about"></a> -->
          </div>
          <div id="site-wrapper">

    <div class="main" id="main-two-columns">
        <div class="left" id="main-content">
            <div class="section">
                <div class="section-content">
                    <div class="post">
                        <!-- <div class="post-title"><h2 class="label label-green">Authenticated user</h2></div> -->
                        <!-- <p class="quiet large">Overview of the authenticated user's data.</p> -->
                        <div class="post-body" style="padding-top:50px">
                           
                            
                            <table>
                               
                                <tr>
                                <div class="container">
    <div class="row">
        <div class="col-md-6">
        <td style="padding: 0px 20px 0px 20px">
           </td><td style="padding: 0px 20px 0px 20px">  <button class="btn btn-default btn-lg" style="background-color:white;" onclick="window.open('https://localhost:8081', '_blank')"   ><img height="40" width="100" alt="Jenkins"  src="/dev-portal/resources/appImages/Jenkins_icon2.png"></button>
           </td><td style="padding: 0px 20px 0px 20px">   <button class="btn btn-default btn-lg" style="background-color:white;" onclick="window.open('https://192.168.0.11', '_blank')" ><img height="40" width="100" alt="Github" src="/dev-portal/resources/appImages/github_icon1.png"></button>
             </td><td style="padding: 0px 20px 0px 20px"> <button class="btn btn-default btn-lg" style="background-color:white;" onclick="window.open('https://localhost:6001','_blank')" ><img height="40" width="110" alt="BitBucket" src="/dev-portal/resources/appImages/bitbucket_icon3.png"></button>
            </td><td style="padding: 0px 20px 0px 20px">  <button class="btn btn-default btn-lg" style="background-color:white;" onclick="window.open('https://localhost:7001','_blank')" ><img height="40" width="110" alt="Bamboo" src="/dev-portal/resources/appImages/bamboo_icon3.png"></button>
            </td><td style="padding: 0px 20px 0px 20px">  <button class="btn btn-default btn-lg"  style="background-color:white;" onclick="window.open('https://localhost:8001','_blank')" ><img height="40" width="100" alt="Jira" src="/dev-portal/resources/appImages/jira_icon2.png"></button>
            </td><td style="padding: 0px 20px 0px 20px">  <button class="btn btn-default btn-lg" style="background-color:white;" onclick="window.open('https://localhost:9001','_blank')" ><img height="40" width="130" alt="Confluence" src="/dev-portal/resources/appImages/confluence_icon.png"></button>
            </td>
            <!-- <td style="padding: 0px 20px 0px 20px">  <button class="btn btn-default btn-lg"><a href="https://localhost:9001" target=_blank ><img height="40" width="130" alt="Confluence" src="/dev-portal/resources/appImages/confluence_icon.png"></a></button>
            </td> -->
        
    </div>
                                </tr>
                                
                            </table>
                            <p></p>
                            <table>
                               
                                <c:forEach var="attribute" items="${credential.attributes}">
                                    <tr>
                                        <td width="200">
                                            <strong><c:out value="${attribute.name}"/></strong><c:if test="${not empty attribute.friendlyName}"> (<c:out value="${attribute.friendlyName}"/>)</c:if>
                                        </td>
                                        <td>
                                            <%
                                                Attribute a = (Attribute) pageContext.getAttribute("attribute");
                                                String[] attributeValues = credential.getAttributeAsStringArray(a.getName());
                                                pageContext.setAttribute("attributeValues", attributeValues);
                                            %>
                                            <c:forEach var="attributeValue" items="${attributeValues}">
                                                <c:out value="${attributeValue}"/>&nbsp;
                                            </c:forEach>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <p></p>
                            <table>
                               
                            </table>
                            <p></p>
                            <table>
                                
                            </table>
                           
                        </div>
                    </div>
                    <div class="clearer">&nbsp;</div>
                </div>
            </div>
            <div class="clearer">&nbsp;</div>
        </div>
       
    </div>
   
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