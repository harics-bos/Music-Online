<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="user" class="cs636.music.presentation.web.UserBean" scope="session" />
<html>
<body>
<c:if test="${param.upd =='update'}" >
	<c:set target="${user}" property="productCode" value="${param.prodcode}"/>
	<c:set target="${user}" property="quantity" value="${param.quantity}"/>
	<% user.changeCart(); %>
	<jsp:forward page="cart.jsp"/>
</c:if>
<c:if test="${param.rem =='remove'}" >
  <c:set target="${user}" property="productCode" value="${param.prodcode}"/>
  <% user.removeCartItem(); %>
  <jsp:forward page="cart.jsp"/>
</c:if>

</body>
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    