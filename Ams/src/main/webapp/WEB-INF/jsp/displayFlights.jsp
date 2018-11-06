<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="<c:url value='D:/Users/sabsyed/Documents/image.jpg' />">
	<table border="1">

		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Source</td>
			<td>Destination</td>
			<td>Departure Time</td>
			<td>Arrival Time</td>
			<td>Price</td>


		</tr>
		<c:forEach items="${flights}" var="flight">
			<tr>
				<td><c:out value="${flight.getFlightNumber()}" /></td>
				<td><c:out value="${flight.getFlightName()}" /></td>
				<td><c:out value="${flight.getSource()}" /></td>
				<td><c:out value="${flight.getDestination()}" /></td>
				<td><c:out value="${flight.getDeptTime()}" /></td>
				<td><c:out value="${flight.getArrivalTime()}" /></td>
				<td><c:out value="${flight.getPrice()}" /></td>

			
			</tr>
		</c:forEach>
	</table>
	<br>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<h2>
				
	
					<center> <a onclick="document.forms['logoutForm'].submit()"><font color="blue">Logout</font></a></center>
			</h2>

		</c:if>
</body>
</html>