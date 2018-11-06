<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

   
</head>

<body align="center">

<div class="container">

    <form method="POST" action="admin" class="form-signin">
        <h1><center><font color="#4747d1">Welcome Admin</font></center></h1>

        <div class="form-group ${error != null ? 'has-error' : ''}">
           <center>Username:<input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/></center><br>
            <center>Password:<input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span></center><br>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <center><button class="btn btn-lg btn-primary btn-block" style="font-face: 'Comic Sans MS'; font-size: larger; color: #8533ff; background-color: #ff4da6;" type="submit">Log In</button></center>
            <br>
            <br>
            <br>
            <center> <a href="/"><font color="blue">Home</font></a></center>
        </div>
<br><br><br><br><br><br>
            <span>${message}</span>
    </form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
