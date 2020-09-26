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
<h1>Available List of Items</h1>
	<br>
	<br>
<hr/>
	<table border="1" width="100%">
		<thead>
			<th>Name</th>
			<th>Cost</th>
			<th>Description</th>
			
		</thead>
		<tbody>
			<core:forEach var="product" items="${products}">
				<tr>
					<td>${product.productName}</td>
					<td>${product.cost}</td>
					<td>${product.productDescription}</td>
					<!-- <td><spring:input path="productName"/></td> -->
					<td><a href="${pageContext.request.contextPath}/user/add-to-cart/${product.id}"><button>Add To Kit</button></a></td>
				</tr>
			</core:forEach>
		</tbody>
	</table>
	<br>
<br>
<%@ include file="footer.jsp" %>
</body>
</html>