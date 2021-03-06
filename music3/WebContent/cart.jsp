<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="user" class="cs636.music.presentation.web.UserBean" scope="session" />
<html>
<head>
<title>Cart Page</title>
</head>
<body>
<h2>Your Cart</h2>
<c:if test="${param.cmd =='add'}" >
	<c:set target="${user}" property="productCode" value="${param.prodCode}"/>
	<c:set target="${user}" property="quantity" value="${param.quantity}"/>
	<% user.addItemtoCart(); %>
</c:if>
<c:if test="${param.cmd == 'change'}">
	<c:set target="${user}" property="productCode" value="${param.prodCode}"/>
	<c:set target="${user}" property="quantity" value="${param.quantity}"/>
	<% user.changeCart(); %>
</c:if>
<c:if test="${param.cmd == 'remove'}">
	<c:set target="${user}" property="productCode" value="${param.prodCode}"/>
	<% user.removeCartItem(); %>
</c:if>
<table border="0" cellspacing = "5">
<tr>
	<th>Product Code</th>
	<th>Total</th>
	<th>Quantity</th>
	<th></th>
</tr>
<c:forEach var="item" items="${user.cart.items }">
	<tr valign="top">
		<td>${item.product.code}</td>
		<td>${item.product.price*item.quantity}</td>
		<td>
			<form action="<c:url value='cart.jsp' />">
				<input type="hidden" name="prodCode" value="${item.product.code}"/>
				<input type="text" name="quantity" value="${item.quantity}"/>
				<input type="hidden" name="cmd" value="change"/>
				<input type="submit" value="Update"/>
			</form>
		</td>
		<td>
			<form action="<c:url value='cart.jsp'/>">
				<input type="hidden" name="prodCode" value="${item.product.code}"/>
				<input type="hidden" name="quantity" value="0"/>
				<input type="hidden" name="cmd" value="remove"/>
				<input type="submit" value="Remove"/>
			</form>
		</td>
	</tr>
</c:forEach>

</table>
<c:if test="${!empty user.cart.items}">
	<c:url var="checkout" value="${!empty user.user ? 'invoice.jsp':'register.jsp'}" />
	<form action="${checkout}">
		<input type="hidden" name="checkout" value="true"/>
		<input type="submit" value="Checkout" />
	</form>
</c:if>
<br>
<a href="catalog.jsp">Continue Shopping</a><br>
<a href="userWelcome.jsp">Go back to User HomePage</a><br>


</body>
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                