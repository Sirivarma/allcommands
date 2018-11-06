<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Flights</title>
<style type="text/css">
form { width: 400px; }
label { float: left; width: 150px; }
input[type=text] { float: left; width: 250px; }
.floatcenter { float: center; }

.error {
	color: red;
}
</style>
</head>
<body>
<table align="center">
<form:form method="POST" modelAttribute="flights" action="addFlight">
<tr><td><font color="#4747d1"><label>Flight Name: </label></font><form:input path="flightName" /><td><form:errors path="flightName" cssClass="error" /></td></td></tr><br>
<tr><td><font color="#4747d1"><label>Source: </label></font> <form:input path="source" /><td><form:errors path="source" cssClass="error" /></td></td></tr><br>
<tr><td><font color="#4747d1"><label>Destination: </label></font><form:input path="destination" /><td><form:errors path="destination" cssClass="error" /></td></td><tr><br>
<tr><td><font color="#4747d1"><label>Departure Time: </label></font><form:input path="deptTime" /><td><form:errors path="deptTime" cssClass="error" /></td></td></tr><br>
<tr><td><font color="#4747d1"><label>ArrivalTime: </label></font><form:input path="arrivalTime" /><td><form:errors path="arrivalTime" cssClass="error" /></td></td></tr><br>
<tr><td><font color="#4747d1"><label>Price: </label></font><form:input type="text" path="price" /><td><form:errors path="price" cssClass="error" /></td></td></tr><br>
<tr><td><center><input type="submit"  class="floatcenter" value="Add Flight" style="font-face: 'Comic Sans MS'; font-size: larger; color: #8533ff; background-color: #ff4da6; /* border: 3pt ridge lightgrey */" /></center></td></tr>
	</form:form>
</table>
</body>
</html>