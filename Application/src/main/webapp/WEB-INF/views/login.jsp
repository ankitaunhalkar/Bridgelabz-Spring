<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
<script type="text/javascript" src="<c:url value="/resources/js/validation.js"/>"></script>
<title>Login</title>
</head>
<body>
<div class="form"> 
<h1>Login Here</h1>
<form action = "loginProcess" modelAttribute = "login">
Email:  <input type = "text" name="email" id="email"/><br><br>
Password:  <input type = "password" name="password" id="password" maxlength="8"/><br><br>
<input class="btncolor" type = "submit" value="Submit" onclick="return validateLogin()"/> 
<button class="btncolor"><a href="register">Register</a></button> 
</form>
</div>
</body>
</html>