<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body bgcolor="" align="center" color="blue">
<table align="center">
<tr><td columnspan=2>
<h2>Enter passenger Details</h2></td>
</tr>
<tr><td columnspan=2>
</tr>
<form:form method="POST" modelAttribute="Customer" action="bookTicket" >
<tr><td><font color="#ff00aa">First Name:</font></td><td> <form:input path="firstname" type="text"/><td><form:errors path="firstname" cssClass="error" /></td></td></tr>
<tr><td><font color="#ff00aa">Last Name:</font></td><td>  <form:input path="lastname" type="text"/><td><form:errors path="lastname" cssClass="error" /></td></td></tr>
<tr><td><font color="#ff00aa">Date of birth:</font></td><td> <form:input path="Dateofbirth" type="date" max="2017-12-31"/><td><form:errors path="Dateofbirth" cssClass="error" /></td></td></tr>
<tr><td><font color="#ff00aa">Gender: </font></td><td> <form:radiobutton path="gender" value="Male"/>Male<br>
<form:radiobutton path="gender" value="Female"/>Female<td><form:errors path="gender" cssClass="error" /></td></td>
<tr><td><font color="#ff00aa">phone number:</font> </td><td> <form:input path="phonenumber" type="number"/><td><form:errors path="phonenumber" cssClass="error" /></td></td></tr>
<tr><td></td><td><input type="submit" value="book ticket"></td></tr>
<form:form modelAttribute="flights" >
<form:hidden path="flightName" /><br>
<form:hidden path="source" /><br>
<form:hidden path="flightNumber"/>
<form:hidden path="destination" /><br>
<form:hidden path="arrivalTime" /><br>
<form:hidden path="deptTime" /><br>
<form:hidden path="price" /><br> 
</form:form>
</form:form>

<a href="bookTicket"></a>

</body>
</html>