<!-- 
 * @author Nicole Dahlquist & Peter Thomson
 * June 4, 2016
 * PROG3060 - NDPTAssn1
 * Roster.jsp
 * jsp for displaying team rosters
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Roster for ${teamName}</title>
</head>
<body>
	<h1>Roster for ${teamName}</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Jersey</th>
			<th>Position</th>
			<th>Height (cm)</th>
			<th>Weight (kg)</th>
			<th>Country</th>
		</tr>
		<c:forEach var = "player" items = "${roster}">
			<tr>
				<td>${player.lastName}, ${player.firstName}</td>	
				<td>${player.jerseyNumber}</td>	
				<td>${player.position}</td>	
				<td>${player.height}</td>	
				<td>${player.weight}</td>	
				<td>${player.country}</td>					
			</tr>
		</c:forEach>
	</table>
</body>
</html>