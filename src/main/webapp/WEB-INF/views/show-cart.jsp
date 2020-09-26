<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
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
<a href="${pageContext.request.contextPath}/user/show-list">Show All Items</a>
<br>
<br>
<h1>Items in Cart</h1>
	<br>
	<br>
<hr/>
	<table border="1" width="100%">
		<thead>
			<th>Product ID</th>
			<th>Cost</th>
			<th>Quantity</th>
			
		</thead>
		<tbody>
			<core:forEach var="kit" items="${showkit}">
				<tr>
					<td>${kit.productId}</td>
					<td>${kit.amount}</td>
					<td>${kit.quantity}</td>
					<!-- <td><spring:input path="productName"/></td> -->
					<td><a href="${pageContext.request.contextPath}/user/delete/${kit.productId}"><button>Delete</button></a></td>
				</tr>
			</core:forEach>
			<%-- <core:forEach var="kit" items="${showkit}">
				<tr>
					<td>${kit.key}</td>
					<td>${kit.value.amount}</td>
					<td>${kit.value.quantity}</td>
					<!-- <td><spring:input path="productName"/></td> -->
					<td><a href="${pageContext.request.contextPath}/user/delete/${kit.productId}"><button>Delete</button></a></td>
				</tr>
			</core:forEach> --%>
		</tbody>
	</table>
	<br>
	<core:if test="${showkit.size() > 0}">
		<a href="${pageContext.request.contextPath}/user/checkout">Check Out</a>
	</core:if>
<br>
<br>
<%@ include file="footer.jsp" %>
</body>
</html>