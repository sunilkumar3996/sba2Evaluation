<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<h1>Order Summary</h1>
	<br>
	<br>
<hr/>
	<table>
		<tbody>
				<tr>
					<td><label>Order ID: </label></td>
					<td>${coronaKit.id}</td>
				</tr>
				<tr>
					<td><label>Order Date: </label></td>
					<td>${coronaKit.orderDate}</td>
				</tr>
				<tr>
					<td><label>Total Amount: </label></td>
					<td>${coronaKit.totalAmount}</td>
				</tr>
				<tr>
					<td><label>Delivery Address: </label></td>
					<td>${coronaKit.deliveryAddress}</td>
				</tr>
			
		</tbody>
	</table>
	<br>
	<br>
<br>
<%@ include file="footer.jsp" %>
</body>
</html>