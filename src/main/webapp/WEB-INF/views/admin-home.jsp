<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="spring-form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <spring-form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value="Logout">
</spring-form:form>  --%>
<br>
<br>
<h1>This is Admin dashboard</h1>
<hr/>
<a href="${pageContext.request.contextPath}/admin/product-entry">Add New Item</a>
<br>
<a href="${pageContext.request.contextPath}/admin/product-list">List All Items</a>
<br>
<br>
<%@ include file="footer.jsp" %>
</body>

</html>