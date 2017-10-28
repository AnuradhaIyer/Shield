<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>

<html>
<head>
<title>Shield Twitter Box</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
hr {
	border: none;
	height: 1px;
	color: #333;
	background-color: #333;
}
</style>
</head>
<body style="margin: 0px 0px 0px 20px;">
	<h2>Shield Twitter Box</h2>
	<br>
	<form action="executeApi" method="POST">
		<input type="text" name="searchStr" value=""> <select
			name="twitteroptions">
			<option value="Create Friendship">Create Friendship</option>
			<option value="Status Update">Status Update</option>
			<option value="Trends Available">Trends Available</option>
			<option value="Search HashTag">Search HashTag</option>
			<option value="Home Timeline">Home Timeline</option>
			<option value="Language Support">Language Support</option>
			<option value="Trends Closest">Trends Closest</option>
			<option value="Followers List">Followers List</option>
		</select> <input type="submit" value="Submit" />
	</form>
	<br>
	<div class="panel panel-primary">
		<%
			try {
				if (session.getAttribute("option") != null) {
		%>
		<div class="panel-heading"><%=session.getAttribute("option")%></div>
		<%
			}

				if (session.getAttribute("twitterResponse") != null) {
					List<String> responses = (List<String>) session.getAttribute("twitterResponse");

					for (String resp : responses) {
		%>
		<div class="panel-body"><%=resp%></div>
		<hr>
		<%
			}
				}
			} catch (Exception e) {
			}
		%>
	</div>
</body>
</html>

