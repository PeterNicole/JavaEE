<!-- 
 * @author Nicole Dahlquist & Peter Thomson
 * June 4, 2016
 * PROG3060 - NDPTAssn1
 * Teams.jsp
 * jsp for displaying team info
 -->
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Banner.jsp" />
	<h1>Teams By Standing</h1>
	<table class="table table-striped">
		<tr>
			<th>Team Name</th>
			<th>League</th>
			<th>Sponsor</th>
			<th>Website</th>
			<th>Head Coach</th>
			<th>Assistant Coach</th>
			<th>Manager</th>
			<th colspan="2">Wins-Ties-Losses</th>
			<th colspan="1"></th>
			<th colspan="1"></th>
		</tr>
		<c:forEach var = "team" items = "${teams}">
			<tr>
				<td>${team.name}</td>	
				<td>${team.league}</td>	
				<td>${team.sponsor}</td>	
				<td><a target="_blank" href="http://${team.website}"/>${team.website }</td>	
				<td>${team.headCoach}</td>	
				<td>${team.asstCoach}</td>	
				<td>${team.manager}</td>	
				<td style="text-align:right">${team.wins}-${team.ties}-${team.losses}</td>
				<td></td>
				<td>
					<a class="btn btn-primary" href="
						<c:url value='/Roster'>
							<c:param name='teamID' value='${team.teamID}'></c:param>
							<c:param name='teamName' value='${team.name}'></c:param>
						</c:url>">Roster
					</a>							
				</td>		
				<td>
					<a class="btn btn-primary" href="
						<c:url value='/Schedule'>
								<c:param name='teamID' value='${team.teamID}'></c:param>
								<c:param name='teamName' value='${team.name}'></c:param>
						</c:url>">Schedule
					</a>							
				</td>			
			</tr>
		</c:forEach>
	</table>
<jsp:include page="Footer.jsp" />