<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
button{
background-color:red;
color:black;
}
button:hover{
background-color:#00FFEE;
color:red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Available Flight Details </title>
</head>
<body align="center">
 <h1><font color="blue">Available Flight Details:</font></h1>
 <c:set var="size" value="${size}"></c:set>
<c:if test="size eq 0">
<h1>No flights available</h1>
</c:if>

<table align="center" width="100%">
<tr><th>Flight Name</th><th>Departure Time</th><th>Arrival Time</th><th>Price</th><th></th></tr>
<c:forEach items="${flights}" var="flight">
<tr><td><font color="#ff0080">${flight.getFlightName()}</font></td>
<td><font color="blue">${flight.getDeptTime()}</font></td>
<td><font color="red">${flight.getArrivalTime()}</font></td>
<td><font color="green">${flight.getPrice()}</font></td>
<td><button><a href="bookFlight?id=${flight.getFlightNumber()}">BOOK NOW</a></button></td>
</tr>

</c:forEach>
</body>

</html>

<!-- 

.antMatchers("/addFlight","/addresult").hasAnyAuthority("ADMIN")//"/admin","/adminLogin",
				.antMatchers("/resources/**","/admin","/bookFlight","/displayDetails","/displayFlights","/","/search","/bookTicket","/error1")
				.permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/admin").successHandler(customSuccessHandler)
				.usernameParameter("username").passwordParameter("password")
				.permitAll()
				.and()
				.logout().permitAll(); -->