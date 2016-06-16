<!-- 
 * @author Nicole Dahlquist & Peter Thomson
 * June 4, 2016
 * PROG3060 - NDPTAssn1
 * Schedule.jsp
 * jsp for displaying team schedule
 -->
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule for ${teamName}</title>
</head>
<body>
	<h1>Schedule for ${teamName}</h1>
	<table>
		<tr>
			<th>Arena Name</th>
			<th>Home</th>
			<th>Visitor</th>
			<th>Home Score</th>
			<th>Visitor Score</th>
			<th>OT</th>
			<th>SO</th>
		</tr>
		<c:forEach var = "game" items = "${schedule}">
			<tr>
				<td>${game.arenaName}</td>	
				<td>${game.homeTeam}</td>	
				<td>${game.visitorTeam}</td>	
				<td>${game.homeScore}</td>	
				<td>${game.visitorScore}</td>	
				<td>${game.OT}</td>	
				<td>${game.SO}</td>					
			</tr>
		</c:forEach>
	</table>
</body>
</html>