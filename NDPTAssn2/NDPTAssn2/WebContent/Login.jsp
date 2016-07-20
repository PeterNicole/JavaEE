<!-- 
 * @author Nicole Dahlquist & Peter Thomson
 * June 4, 2016
 * PROG3060 - NDPTAssn1
 * Login.jsp
 * jsp for logging in to database
 -->
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
				<c:if test="${param.error}">
					<p class="text-danger">Invalid database credentials provided.</p>
				</c:if>
		</form>
		<span class="col-md-4"></span>
	</div>
	<div class="row"><br/></div>
	
<jsp:include page="Footer.jsp" />