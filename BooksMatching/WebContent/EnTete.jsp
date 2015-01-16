<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>En tête</title>
	</head>
	<body>
	    <c:if test="${ !empty sessionScope.Status && sessionScope.Status == 'User' }">
	        <p>Vous êtes un lecteur !</p>
	        <%@ include file="MenuUser.jsp"  %>
	    </c:if>
	    <c:if test="${ !empty sessionScope.Status && sessionScope.Status == 'Admin' }">
	        <p>Vous êtes un administrateur !</p>
	        <%@ include file="MenuAdmin.jsp"  %>
	    </c:if>
	    <c:if test="${ empty sessionScope.Status }">
	        <p>Vous n'êtes pas authentifié !</p>
	    </c:if>
	    <a href="LoginServlet?action=deconnexion">Déconnexion</a>
	
	</body>
</html>