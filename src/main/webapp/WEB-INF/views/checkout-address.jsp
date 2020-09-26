<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<br>
<br>
<h3>Enter Shipping Details</h3>
<form action="${pageContext.request.contextPath}/user/finalize" method="post">
			<div><label> Enter Address</label></div>
				<div><textarea name="address" rows="4" cols="50" required></textarea></div>
	<div>
				<div><input type="submit" value="Proceed To Order" /></div>
			</div>
</form>
<br><br>
<a href="${pageContext.request.contextPath}/user/show-kit">Show Kit</a>
<br>
<br>
<%@ include file="footer.jsp" %>
</body>

</html>