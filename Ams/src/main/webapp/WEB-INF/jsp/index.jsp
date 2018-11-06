<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AirLine Reservation</title>
</head>

<style>
body{
background-image :url("D:/Users/sabsyed/Documents/image.jpg");
 background-repeat:no-repeat;
 width:"100%";
 height: "100%";
}
form { width: 400px; }
label { float: left; width: 150px; }
input[type=text] { float: left; width: 250px; }
.clear { clear: both; height: 0; line-height: 0; }
.floatcenter { float: center; }

.navbar {
  overflow: hidden;
  background-color: #333;
  position: fixed;
  top: 0;
  width: 100%;
} 
.error {
	color: red;
}

</style>
<body   >
<h1><font color=" #00e6e6"><marquee>Airline Reservation System</marquee></font></h1>
<table align="center">
<form:form method="POST" modelAttribute="tour" action="search">
<tr><td><font color="blue"><p style = "font-size:20px"><label>From: </label><form:input path="tourFrom" type="text"/><td><form:errors path="tourFrom" cssClass="error" /></td></p></td></tr>
<tr><td><font color="blue"><p style = "font-size:20px"><label>To: </label><form:input path="to" type="text"/><td><form:errors path="to" cssClass="error" /></td></p></td></tr>
<tr><td><font color="blue"><p style = "font-size:20px"><label>journey date:</label><form:input path="travelDate" type="date" min="2000-12-12"/><td></p></td><td><form:errors path="travelDate" cssClass="error" /></td></tr>

<br><br><br>
<center><tr><td ><input type="submit" class="floatcenter" value="search" style="font-face: 'Comic Sans MS'; font-size: larger; color: #8533ff; background-color: #ff4da6; /* border: 3pt ridge white */"/></td></tr></center>
</form:form>
<tr><td><font color="blue"><p style = "font-size:20px">Or Login as</font></p><button><center><a href="admin">admin</a></center></button></td></tr> 
</table>
</body>
</html>