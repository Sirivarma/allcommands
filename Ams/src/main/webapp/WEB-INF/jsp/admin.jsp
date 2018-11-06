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
</head>
<body background="<c:url value='D:/Users/sabsyed/Documents/image.jpg' />">

<form:form modelAttribute="Admin" action="adminLogin">
<center>username:<form:input path="username" name="username"/></center><br>
<center>password:<form:input path="password" name="password" type="password"/></center><br>
<center><input type="submit" value="login" style="font-face: 'Comic Sans MS'; font-size: larger; color: #8533ff; background-color: #ff4da6;" /></center>
</form:form>
</body>
</html>