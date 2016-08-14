<!-- 
 * @author Nicole Dahlquist & Peter Thomson
 * July 12, 2016
 * PROG3060 - NDPTAssn3
 * Schedule.jsp
 * jsp for displaying team schedule
 * 
 * Revised August 13, 2016: Refactored to use score acquired from EJB
 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="Banner.jsp" />

	<h1>Scheduled Games for ${team.teamName} </h1>	
	<table class="table table-striped">
		<tr>
			<th>Game Date</th>
			<th>Game Time</th>
			<th>Arena Name</th>
			<th>Home</th>
			<th>Visitor</th>
			<th style="text-align:center">Score</th>
			<th></th>
		</tr>
		<c:forEach var = "game" items = "${scheduledGames}">
			<tr>
				<td><fmt:formatDate value="${game.gameDate}" pattern="dd-MM-yyyy"/></td>
				<td><fmt:formatDate value="${game.gameTime}" pattern="h:mm a" /></td>
				<td>${game.arena.arenaName}</td>	
				<td>${game.home.teamName}</td>	
				<td>${game.visitor.teamName}</td>	
				<td></td>	
				<td><a class="btn btn-primary" href="<c:url value='/UpdateGame'>
						<c:param name='gameId' value='${game.gameId}'></c:param>
						</c:url>">Update</a>	
					</td>					
			</tr>
		</c:forEach>
	</table>
	<br/>
	<h1>Completed Games for ${team.teamName}</h1>
	<table class="table table-striped">
		<caption style="font-weight:bold;padding:15px 0;border: 1px red solid;">
			Wins:  ${team.wins}  Overtime Losses: ${team.overtimeLosses}  Losses: ${team.losses}
		</caption>
		<tr style="text-align:center">
			<th>Game Date</th>
			<th>Game Time</th>
			<th>Arena Name</th>
			<th>Home</th>
			<th>Visitor</th>
			<th style="text-align:center">${team.teamName} - Opponent</th>
		</tr>
		<c:forEach var = "game" items = "${completedGames}">
			<tr>
				<td><fmt:formatDate value="${game.gameDate}" pattern="dd-MM-yyyy" /></td>
				<td><fmt:formatDate value="${game.gameTime}" pattern="h:mm a" /></td>
				<td>${game.arena.arenaName}</td>	
				<td>${game.home.teamName}</td>	
				<td>${game.visitor.teamName}</td>	
				<td style="text-align:center">${game.score}</td>
			</tr>
		</c:forEach>
	</table>
<jsp:include page="Footer.jsp" />