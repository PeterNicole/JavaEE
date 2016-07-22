<!-- 
 * @author Nicole Dahlquist & Peter Thomson
 * July 21, 2016
 * PROG3060 - NDPTAssn2
 * UpcomingGames.jsp
 * jsp for displaying upcoming games info
 -->
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="Banner.jsp" />

	<h1>Upcoming Games</h1>	
	<table class="table table-striped">
		<tr>
			<th>Game Date</th>
			<th>Game Time</th>			
			<th>Home</th>
			<th>Visitor</th>
			<th>Arena Name</th>
		</tr>
		<c:forEach var = "game" items = "${upcomingGames}">
			<tr>
				<td><fmt:formatDate value="${game.gameDate}" pattern="dd-MM-yyyy" /></td>
				<td><fmt:formatDate value="${game.gameTime}" pattern="h:mm a" /></td>					
				<td>${game.home.teamName}</td>	
				<td>${game.visitor.teamName}</td>	
				<td>${game.arena.arenaName}</td>				
			</tr>
		</c:forEach>
	</table>
		
<jsp:include page="Footer.jsp" />