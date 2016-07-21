<!-- 
 * @author Nicole Dahlquist & Peter Thomson
 * July 12, 2016
 * PROG3060 - NDPTAssn2
 * Roster.jsp
 * jsp for displaying team rosters
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Banner.jsp" />
	<h1>Roster for ${team.teamName} <a class="btn btn-primary" style="float:right;"href="<c:url value='/Team'></c:url>">Back to Teams</a></h1>
	<p><b>Head Coach:</b> ${team.headCoach.firstName} ${team.headCoach.lastName}</p>	
	<p><b>Assistant Coach:</b> ${team.asstCoach.firstName} ${team.asstCoach.lastName}</p>
	<p><b>Manager:</b> ${team.manager.firstName} ${team.manager.lastName}</p>
	<p><b>Trainer:</b> ${team.trainer.firstName} ${team.trainer.lastName}</p>
	
	<table class="table table-striped">
		<tr><th colspan="6"><h4>Forwards</h4><th></tr>
		<tr>
			<th style="text-align:center">Jersey</th>
			<th>Name</th>
			<th>Position</th>
			<th style="text-align:center">Height (cm)</th>
			<th style="text-align:center">Weight (kg)</th>
			<th></th>
		</tr>
		
		<c:forEach var = "roster" items = "${forwardRosters}">
			<tr>	
				<td style="text-align:center">${roster.jersey}</td>
				<td>${roster.player.lastName}, ${roster.player.firstName}</td>	
				<td>${roster.position}</td>	
				<td style="text-align:center">${roster.player.height}</td>	
				<td style="text-align:center">${roster.player.weight}</td>	
				<td>
					<a class="btn btn-primary" href="
						<c:url value='/Player'>
							<c:param name='rosterId' value='${roster.rosterId}'></c:param>
						</c:url>">Player Info
					</a>							
				</td>				
			</tr>
		</c:forEach>
		<tr><th colspan="6"><h4>Defence</h4><th></tr>
		<tr>
			<th style="text-align:center">Jersey</th>
			<th>Name</th>
			<th>Position</th>
			<th style="text-align:center">Height (cm)</th>
			<th style="text-align:center">Weight (kg)</th>
			<th></th>
		</tr>
		
		<c:forEach var = "roster" items = "${defenceRosters}">
			<tr>	
				<td style="text-align:center">${roster.jersey}</td>
				<td>${roster.player.lastName}, ${roster.player.firstName}</td>	
				<td>${roster.position}</td>	
				<td style="text-align:center">${roster.player.height}</td>	
				<td style="text-align:center">${roster.player.weight}</td>	
				<td>
					<a class="btn btn-primary" href="
						<c:url value='/Player'>
							<c:param name='rosterId' value='${roster.rosterId}'></c:param>
						</c:url>">Player Info
					</a>							
				</td>				
			</tr>
		</c:forEach>
		<tr><th colspan="6"><h4>Goal Tenders</h4><th></tr>
		<tr>
			<th style="text-align:center">Jersey</th>
			<th>Name</th>
			<th>Position</th>
			<th style="text-align:center">Height (cm)</th>
			<th style="text-align:center">Weight (kg)</th>
			<th></th>
		</tr>
		
		<c:forEach var = "roster" items = "${goalieRosters}">
			<tr>	
				<td style="text-align:center">${roster.jersey}</td>
				<td>${roster.player.lastName}, ${roster.player.firstName}</td>	
				<td>${roster.position}</td>	
				<td style="text-align:center">${roster.player.height}</td>	
				<td style="text-align:center">${roster.player.weight}</td>	
				<td>
					<a class="btn btn-primary" href="
						<c:url value='/Player'>
							<c:param name='rosterId' value='${roster.rosterId}'></c:param>
						</c:url>">Player Info
					</a>							
				</td>					
			</tr>
		</c:forEach>
	</table>
<jsp:include page="Footer.jsp" />