<!-- 
 * @author Nicole Dahlquist & Peter Thomson
 * July 21, 2016
 * PROG3060 - NDPTAssn2
 * Arenas.jsp
 * jsp for displaying arenas
 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Banner.jsp" />

	<h1>Arena Information</h1>
	<table class="table table-striped">
		<tr style="text-align:center">
			<th>Name</th>
			<th>Street</th>
			<th>City</th>
			<th>State/Province</th>
			<th>Postal Code</th>
			<th>Country</th>
		</tr>
		<c:forEach var = "arena" items = "${arenas}">
			<tr>
				<td>${arena.arenaName }</td>
				<td>${arena.streetAddress }</td>
				<td>${arena.city }</td>
				<td>${arena.state_province }</td>
				<td>${arena.postalCode }</td>
				<td>${arena.country }</td>
			</tr>
		</c:forEach>
	</table>
		
<jsp:include page="Footer.jsp" />
