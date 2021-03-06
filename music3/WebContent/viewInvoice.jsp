<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Invoice Details</title>
</head>
<body>
<c:if test="${empty admin}">
  <jsp:forward page="adminWelcome.jsp"/>
</c:if>
<!-- forward to adminWelcome page upon failure to validate admin -->
<c:if test="${admin.message != 'OK'}">
  <jsp:forward page="adminWelcome.jsp"/>
</c:if>
<c:set target="${admin}" property="invoiceId" value="${param.invoiceId}"/>


<h2>Your invoice</h2>
Customer Name: ${admin.invoice.user.firstname}&nbsp;${admin.invoice.user.lastname}
<br>
Email Address: ${admin.invoice.user.emailAddress}
<br>
Date: ${admin.invoice.invoiceDate}
<br><br>


<table border="1">
  <tr>
    <td>Description</td>
    <td>Quantity</td>
    <td>Price</td>
  </tr>
  
  <c:forEach var="lineitems" items="${admin.invoice.lineItems}">
  <tr>
    <td>${lineitems.product.description}</td>
    <td>${lineitems.quantity}</td>
    <td>$${lineitems.product.price * lineitems.quantity}</td>
  </tr>
  </c:forEach>
  <tr>
    <td></td>
    <td>Total Amount</td>
    <td>$${admin.invoice.totalAmount}</td>
  </tr>      
 </table>
<br> 
<br>
Invoice Status:<c:if test="${admin.invoice.isProcessed == 'y'}">Processed</c:if>
      <c:if test="${admin.invoice.isProcessed == 'n'}">Unprocessed</c:if>
 
<br>
<c:if test="${param.cmd == 'processInvoice'}">
<c:url var="processInvoice" value="processInvoice.jsp"/>
<form action="${processInvoice}" method="get">
   <input type="hidden" name="invoiceId" value="${param.invoiceId}"/>
   <input type="submit" value="Process">
</form>
<br>

<c:url var="processInvoices" value="processInvoices.jsp"/>
<a href="${processInvoices}">View Unprocessed Invoices</a> 
</c:if>

<br>
<c:url var="displayReports" value="displayReports.jsp"/>
<a href="${displayReports}">Go Back to Display Reports</a>
<br>
<c:url var="adminMenu" value="adminPage.jsp"/>
<a href="${adminMenu}">Go back to Admin HomePage</a> 
</body>
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         