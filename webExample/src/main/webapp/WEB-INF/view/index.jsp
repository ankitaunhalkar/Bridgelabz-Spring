<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<body>
<h2>Hello World!</h2>
<h2>${serverTime}</h2>
<h2><%=request.getAttribute("serverTime") %></h2>
</body>
</html>
