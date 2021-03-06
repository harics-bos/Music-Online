<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Downloads Report</title>
</head>
<body>

<c:if test="${empty admin}">
  <jsp:forward page="adminWelcome.jsp"/>
</c:if>

<c:if test="${admin.message != 'OK'}">
  <jsp:forward page="adminWelcome.jsp"/>
</c:if>


<h3>Downloads Report</h3>
<table>
<tr>
  <td align="center" >Customer Name</td>
  <td align="center" >Download Date</td>
  <td align="center" >Product Code</td>
  <td align="center" >Track Number</td>
  <td align="center" >Track Title</td>
  <td align="center" >Sample Filename</td>
</tr>
    
<c:forEach var="download" items="${admin.listofDownloads}">
<tr>
  <td align="center">${download.user.firstname}&nbsp;${download.user.lastname}  </td>
  <td align="center"> ${download.downloadDate} </td>
  <td align="center"> ${download.track.product.code} </td>
  <td align="center"> ${download.track.trackNumber} </td>
  <td align="center"> ${download.track.title} </td>
  <td align="center"> ${download.track.sampleFilename} </td>  
</tr>
</c:forEach>
</table>
<br>
<c:url var="displayReports" value="displayReports.jsp"/>
<A HREF="${displayReports}">Go Back to Display Reports</A>
<br>
<c:url var="adminMenu" value="adminPage.jsp"/>
<A HREF="${adminMenu}">Go Back to Admin Homepage</A>

</body>
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     