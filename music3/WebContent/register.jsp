<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="user" class="cs636.music.presentation.web.UserBean" scope="session" />
<html>
<head>
<title>Register</title>
</head>
<body>
<h2>Register</h2>

<c:if test="${empty user}">
  <jsp:forward page="userWelcome.jsp"/>
</c:if>

<c:if test="${!empty param.email}">
	<c:set target="${user}" property="firstName" value="${param.firstName}"/> 
	<c:set target="${user}" property="lastName" value="${param.lastName}"/> 
	<c:set target="${user}" property="email" value="${param.email}"/> 
	<% user.registerUser(); %>
</c:if>

<c:if test="${!empty user.user}">	
	<c:if test="${!empty param.listen }">
	<c:set target="${user}" property="productCode" value="${param.prodCode}"/>
	   <jsp:forward page="listen.jsp"/>
	</c:if>
	<c:if test="${!empty param.checkout }">
		<jsp:forward page="invoice.jsp"/>
	</c:if>
	<c:otherwise>
		<jsp:forward page="userWelcome.jsp"/>
	</c:otherwise>	
</c:if>

<c:url var="register" value="register.jsp" />
<form action="${register}">
<input type="hidden" name="checkout" value="${param.checkout}"/>
<input type="hidden" name="listen" value="${param.listen}"/>
<input type="hidden" name="prodCode" value="${param.prodCode}"/>
<table border="1" cellpadding="5" >
    <tr>
        <td align="right">First name</td>
        <td><input type="text" name="firstName">
        </td>
    </tr>
    <tr>
        <td align="right">Last name</td>
        <td><input type="text" name="lastName">
        </td>
    </tr>
    <tr>
        <td align="right"><font color=red>* </font>Email</td>
        <td><input type="text" name="email">
        </td>
    </tr>
</table>
<br>
<input type="submit" value="Register">
 </form>
</body>
</html>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             