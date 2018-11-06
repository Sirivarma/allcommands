<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="<c:url value='D:/Users/sabsyed/Documents/image.jpg' />">
<h1><center><font color=" #00e6e6">Ticket Confirmation</font></center></h1>
<h2><font color="green">Your ticket has been booked succesfully with customer id <font color="#ff33cc">${custId}</font></font></h2>
<h3><font color="#0066ff">Passenger name: <font color="#ff33cc">${firstName}</font></font></h3>
<h3><font color="#0066ff">From: <font color="#ff33cc">${flight1.getSource()}</font></font></h3>
<h3><font color="#0066ff">To: <font color="#ff33cc">${flight1.getDestination()}</font></font></h3>
<h3><font color="#0066ff">The departure time is: <font color="#ff33cc">${flight1.getDeptTime()} </font></font></h3>
<h3><font color="#0066ff">Reaches the destination at: <font color="#ff33cc">${flight1.getArrivalTime()}</font></font></h3>
<h3><center><font color="black">Thank you for booking with us,you will recieve your ticket at:<font color="#ff33cc"> ${phoneno} </font> number</font></center></h3>
<h3><center>If you wish to book another ticket,please click on the link below</center></h3>
<center><button><a href="/">Book Again</a></button></center>
</body>
</html>