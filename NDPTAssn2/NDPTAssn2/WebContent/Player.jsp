<!-- 
 * @author Nicole Dahlquist & Peter Thomson
 * July 21, 2016
 * PROG3060 - NDPTAssn2
 * Player.jsp
 * jsp for displaying player info
 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Banner.jsp" />

	<h1>Player Information for ${roster.player.lastName}, 
		${roster.player.firstName} on ${roster.team.teamName}
		<a class="btn btn-primary" style="float:right;"href="<c:url value='/Roster'>
		<c:param name='teamID' value='${roster.team.teamId}'></c:param></c:url>">Back to Roster</a></h1>
	<h3><b>Jersey:</b> ${roster.jersey }</h3>
	<h3><b>Position:</b> ${roster.position }</h3>
	<h3><b>Height:</b> ${roster.player.height } cm</h3>
	<h3><b>Weight:</b> ${roster.player.weight } kg</h3>
	<h3><b>Home Town:</b> ${roster.player.city }</h3>
	<h3><b>State/Province:</b> ${roster.player.state_province }</h3>
	<h3><b>Country:</b> ${roster.player.country }</h3>
	<h3><b>School:</b> <c:if test="${empty roster.player.school}">N/A</c:if>
		<c:if test="${not empty roster.player.school}">${roster.player.school }</c:if></h3>
		
<jsp:include page="Footer.jsp" />