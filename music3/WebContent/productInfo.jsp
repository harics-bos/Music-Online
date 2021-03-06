<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="user" class="cs636.music.presentation.web.UserBean" scope="session" />
<html>
<head>
<title>Product Details</title>
</head>
<body>
<h2>Product Details</h2>
<c:if test="${empty param.prodCode}">
  <jsp:forward page="catalog.jsp"/>
</c:if>

<c:set target="${user}" property="productCode" value="${param.prodCode}"/>


<h3>Description: ${user.product.description}</h3>
<h3>Price: $${user.product.price}</h3>
	<c:url var="addtoCart" value="cart.jsp">
		<c:param name="prodCode" value="${param.prodCode}"/>
		<c:param name="quantity" value="1"/>
		<c:param name="cmd" value="add"/>
	</c:url>
	<a href="${addtoCart}"> Add to cart</a>
    <br>
	<c:url var="viewCart" value="cart.jsp" />
	<a href="${viewCart}"> Show Cart</a> 
    <br>
	<c:url var="sound" value="${!empty user.user ? 'listen.jsp':'register.jsp'}" >
	    <c:param name="prodCode" value="${param.prodCode}"/>
		<c:param name="listen" value="true"/>
	</c:url>
	<a href="${sound}">Listen Samples</a> 
	<br>
	<c:url var="catalog" value="catalog.jsp" />
	<a href="${catalog}">Browse Catalog</a>
	<br>
	<c:url var="userWelcome" value="userWelcome.jsp" />
	<a href="${userWelcome}"> Back to User Homepage</a>

</body>
</html>

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            