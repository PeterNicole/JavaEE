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
<jsp:include page="Banner.jsp" />
	<h1>Scheduled Games for ${teamName} <a class="btn btn-primary" href="<c:url value='/Team'></c:url>">Teams</a></h1>	
	<table class="table table-striped">
		<tr>
			<th>Game Date</th>
			<th>Arena Name</th>
			<th>Home</th>
			<th>Visitor</th>
			<th style="text-align:center">Home Score</th>
			<th style="text-align:center">Visitor Score</th>
			<th>OT</th>
			<th>SO</th>
		</tr>
		<c:forEach var = "game" items = "${scheduledGames}">
			<tr>
				<td>${game.date}</td>
				<td>${game.arenaName}</td>	
				<td>${game.homeTeam}</td>	
				<td>${game.visitorTeam}</td>	
				<td style="text-align:center"></td>	
				<td style="text-align:center"></td>	
				<td></td>	
				<td></td>					
			</tr>
		</c:forEach>
	</table>
	<br/>
	<h1>Completed Games for ${teamName} <a class="btn btn-primary" href="<c:url value='/Team'></c:url>">Teams</a></h1>
	<table class="table table-striped">
		<caption> Wins: ${wins} Ties: ${ties} Losses: ${losses}</caption>
		<tr style="text-align:center">
			<th>Game Date</th>
			<th>Arena Name</th>
			<th>Home</th>
			<th>Visitor</th>
			<th style="text-align:center">Home Score</th>
			<th style="text-align:center">Visitor Score</th>
			<th>OT</th>
			<th>SO</th>
		</tr>
		<c:forEach var = "game" items = "${completedGames}">
			<tr>
				<td>${game.date}</td>
				<td>${game.arenaName}</td>	
				<td>${game.homeTeam}</td>	
				<td>${game.visitorTeam}</td>	
				<td style="text-align:center">${game.homeScore}</td>	
				<td style="text-align:center">${game.visitorScore}</td>	
				<td>${game.OT}</td>	
				<td>${game.SO}</td>					
			</tr>
		</c:forEach>
	</table>
<jsp:include page="Footer.jsp" />