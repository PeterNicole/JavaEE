<!-- 
 * @author Nicole Dahlquist & Peter Thomson
 * June 4, 2016
 * PROG3060 - NDPTAssn1
 * Roster.jsp
 * jsp for displaying team rosters
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Banner.jsp" />
	<h1>Roster for ${teamName} <a class="btn btn-primary" style="float:right;"href="<c:url value='/Team'></c:url>">Back to Teams</a></h1>	
	<table class="table table-striped">
		<tr>
			<th style="text-align:center">Jersey</th>
			<th>Name</th>
			<th>Position</th>
			<th style="text-align:center">Height (cm)</th>
			<th style="text-align:center">Weight (kg)</th>
			<th>Country</th>
		</tr>
		<c:forEach var = "player" items = "${roster}">
			<tr>	
				<td style="text-align:center">${player.jerseyNumber}</td>
				<td>${player.lastName}, ${player.firstName}</td>	
				<td>${player.position}</td>	
				<td style="text-align:center">${player.height}</td>	
				<td style="text-align:center">${player.weight}</td>	
				<td>${player.country}</td>					
			</tr>
		</c:forEach>
	</table>
<jsp:include page="Footer.jsp" />