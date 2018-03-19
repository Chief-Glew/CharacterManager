<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rachel is terrible</title>
</head>
<body>
	<c:forEach items="${messages}" var="message">
		<c:out value="${message}" />
		<br>
	</c:forEach>
	<form action="/dndcharacter/messenger/" method="post" name="message">
		<input type="text" name="message"> <input type="submit"
			value="submit" class="btn btn-success">
	</form>
	<a href="/dndcharacter/messenger/">refresh</a>
</body>
</html>