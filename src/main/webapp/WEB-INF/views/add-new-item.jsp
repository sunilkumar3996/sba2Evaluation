<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<style type="text/css">
			.error{
				color : red;
			}
	</style>
</head>
<body>
<%@ include file="header.jsp" %>
<br>
<br>
	<h1>Provide Item Info</h1>
	<hr>
	<spring:form action="${pageContext.request.contextPath}/admin/product-save" method="post" modelAttribute="product">
			<div>
				<div><spring:label path="productName">Enter name</spring:label></div>
				<div>
					<spring:input path="productName"/>
					 <spring:errors path="productName" cssClass="error"/>
				</div>
			</div>
			<br><br>
			<div>
				<div><spring:label path="cost">Enter Cost</spring:label></div>
				<div>
					<spring:input path="cost"/>
					<spring:errors path="cost" cssClass="error"/>
				</div>
			</div>
			
			<br><br>
			<div>
				<div><spring:label path="productDescription">Enter Product Description</spring:label></div>
				<div>
					<spring:input path="productDescription"/>
					 <spring:errors path="productDescription" cssClass="error"/>
				</div>
			</div>
			<br><br>
		
			<div>
				<div><input type="submit" value="Submit" /></div>
			</div>
		</spring:form>
		
		<br>
<br>
<%@ include file="footer.jsp" %>
</body>
</html>