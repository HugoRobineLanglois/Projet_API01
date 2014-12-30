<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>En t�te</title>
	</head>
	<body>
	    <c:if test="${ !empty sessionScope.logs && sessionScope.logs == 'User' }">
	        <p>Vous �tes un lecteur !</p>
	    </c:if>
	    <c:if test="${ !empty sessionScope.logs && sessionScope.logs == 'Admin' }">
	        <p>Vous �tes un administrateur !</p>
	    </c:if>
	    <c:if test="${ empty sessionScope.logs }">
	        <p>Vous n'�tes pas authentifi� !</p>
	    </c:if>
	
	</body>
</html>