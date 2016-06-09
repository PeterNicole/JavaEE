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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teams</title>
</head>
<body>
	<h1>Teams</h1>
	<table>
		<tr>
			<th>Team Name</th>
			<th>League</th>
			<th>Sponsor</th>
			<th>Website</th>
			<th>Head Coach</th>
			<th>Assistant Coach</th>
			<th>Manager</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var = "team" items = "${teams}">
			<tr>
				<td>${team.name}</td>	
				<td>${team.league}</td>	
				<td>${team.sponsor}</td>	
				<td>${team.website}</td>	
				<td>${team.headCoach}</td>	
				<td>${team.asstCoach}</td>	
				<td>${team.manager}</td>	
				<td>
					<a href="<c:url value='/RosterServlet'>
								<c:param name='teamID' value='${team.teamID}'></c:param>
								<c:param name='teamName' value='${team.name}'></c:param>
							</c:url>">View Roster
					</a>							
				</td>		
				<td>
					<a href="<c:url value='/ScheduleServlet'>
								<c:param name='teamID' value='${team.teamID}'></c:param>
								<c:param name='teamName' value='${team.name}'></c:param>
							</c:url>">View Schedule
					</a>							
				</td>			
			</tr>
		</c:forEach>
	</table>
</body>
</html>