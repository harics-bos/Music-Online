<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="user" class="cs636.music.presentation.web.UserBean" scope="session" />
<html>
<body>
<c:if test="${empty user}">
  <jsp:forward page="userWelcome.jsp"/>
</c:if>
<!--  forward to register page if user is not registered yet -->
<c:if test="${empty user.user}">
  <jsp:forward page="register.jsp"/>
</c:if>
<c:set target="${user}" property="trackNumber" value="${param.trackNum}"/>
<c:set target="${user}" property="productCode" value="${param.prodCode}"/>
<%user.addDownload();%>
<c:set var="sample" value="/WEB-INF/sound/${param.prodCode}/${param.sampleFileName}"/>
<jsp:forward page="${sample}" />

</body>
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        