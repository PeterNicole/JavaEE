<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Banner.jsp" />		
	<div class="row col-md-offset-3 col-md-7">
		<h1>Database Login</h1>
	</div>
	<div class="row col-md-offset-3 col-md-7">
		<form name="loginForm" method="POST" action="LoginServlet" >
				<label>User Name: </label>
				<input type="text" name="username" />
				
				<label>Password: </label>
				<input type="password" name="password" />
				
				<input type="submit" name="login" value="Login"/>
		</form>
		<span class="col-md-4"></span>
	</div>
	<div class="row"><br/></div>
		
		<p>${error}</p>
	
<jsp:include page="Footer.jsp" />