<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="user" class="cs636.music.presentation.web.UserBean" scope="session" />
<html>
<head>
<title>Invoice</title>
</head>
<body>
<h2>Invoice</h2>
Customer Name: ${user.user.firstname} ${user.user.lastname}
<br>
Email Address: ${user.user.emailAddress}
<br>
<c:if test="${empty user}">
  <jsp:forward page="userWelcome.jsp"/>
</c:if>
<c:if test="${empty user.user}">
  <jsp:forward page="register.jsp"/>
</c:if>

<br>
<table>
   <tr>
 	<td>Product Code</td>
    <td>Description</td>
    <td>Quantity</td>
    <td>Price</td>
  </tr>
  
  <c:forEach var="item" items="${user.cart.items}">
  <tr>
  	<td>${item.product.code}</td>
    <td>${item.product.description}</td>
    <td>${item.quantity}</td>
    <td>$${item.product.price*item.quantity}</td>
  </tr>
  <c:set var="Total" value="${Total + item.product.price*item.quantity}" />
  </c:forEach>
  <tr>
    <td></td>
    <td></td>
    <td>Total Amount:</td>
    <td>$${Total}</td>
  </tr>      
 </table>
<% user.checkout(); %>
<br>
<br>
Checkout Successful
<br>
<br>
	
	<c:url var="catalog" value="catalog.jsp" />
	<a href ="${catalog}">Browse Catalog</A> 
    <br>
    <c:url  var="cart" value="cart.jsp"/>
	<a href="${cart}"> Show Cart</A>
	<br>
	<c:url var="userWelcome" value="userWelcome.jsp"/>
	<a href="${userWelcome}"> Back to User Homepage</A>
</body>
</html>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 