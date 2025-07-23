<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- by default is true then it was Innoring expression language -->
<%@page isELIgnored="false"%>

<!-- using taglib we can enable jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>this is help page</title>
</head>
<body>

	<%
		/* String name = (String) request.getAttribute("name");
		Integer rollNumber = (Integer) request.getAttribute("rollNumber");
		LocalDateTime time = (LocalDateTime)request.getAttribute("time"); */
	%>
	<h1>
		Name is:
		<%-- <%=name% --%>
		${name }
	</h1>
	RollNumber is:
	<%-- 	<%=rollNumber%> --%>
	${rollNumber}
	<h2>
		Data and Time is:
		<%-- <%=time.toString()%> --%>
		${time.toString()}

	</h2>
	<hr>
	<c:forEach var="item" items="${marks} ">
	<%-- <h1>${item}</h1> --%>
	<h1><c:out value="${item}"></c:out></h1>
	</c:forEach>

</body>
</html>