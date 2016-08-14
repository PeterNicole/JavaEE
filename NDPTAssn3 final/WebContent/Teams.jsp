<!-- 
 * @author Nicole Dahlquist & Peter Thomson
 * July 12, 2016
 * PROG3060 - NDPTAssn3
 * Teams.jsp
 * jsp for displaying team info
 *
 * Revised August 13, 2016: Added next game string from EJB
 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Banner.jsp" />
	<br/>
	<h1>League Standing</h1>
	<table class="table table-striped">
		<tr>
			<th>Team Name</th>
			<th style="text-align:center;">Points</th>
			<th style="text-align:center;">Games Played</th>
			<th style="text-align:center;">Wins</th>
			<th style="text-align:center;">Losses</th>
			<th style="text-align:center;">Overtime Losses</th>
			<th style="text-align:left;">Next Game</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var = "team" items = "${teams}">
			<tr>
				<td>${team.teamName}</td>	
				<td style="text-align:center;">${team.points}</td>	
				<td style="text-align:center;">${team.totalGames}</td>	
				<td style="text-align:center;">${team.wins}</td>	
				<td style="text-align:center;">${team.losses}</td>	
				<td style="text-align:center;">${team.overtimeLosses}</td>	
				<td style="text-align:left;">${team.nextGame}</td>
				<td>
					<a class="btn btn-primary" href="
						<c:url value='/Roster'>
							<c:param name='teamID' value='${team.teamId}'></c:param>
						</c:url>">Roster
					</a>							
				</td>		
				<td>
					<a class="btn btn-primary" href="
						<c:url value='/Schedule'>
								<c:param name='teamID' value='${team.teamId}'></c:param>
								<c:param name='teamName' value='${team.teamName}'></c:param>
						</c:url>">Schedule
					</a>							
				</td>			
			</tr>
		</c:forEach>
	</table>
<jsp:include page="Footer.jsp" />