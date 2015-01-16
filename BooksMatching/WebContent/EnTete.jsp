<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>En tÃªte</title>
	</head>
	<body>

<div class="menu">
	<div class="ui secondary pointing four item demo menu">
	    <c:if test="${ !empty sessionScope.Status && sessionScope.Status == 'User' }">
	        <%@ include file="MenuUser.jsp"  %>
	        <a href="LoginServlet?action=deconnexion" class="item" ><i class="sign out icon" ></i>Déconnexion</a>
	    </c:if>
	    <c:if test="${ !empty sessionScope.Status && sessionScope.Status == 'Admin' }">
	        <%@ include file="MenuAdmin.jsp"  %>
	        <a href="LoginServlet?action=deconnexion" class="item" ><i class="sign out icon" ></i>Déconnexion</a>
	        </div>
	        </div>
	    </c:if>
	    <c:if test="${ empty sessionScope.Status }">
	    </c:if>
	    <a href="LoginServlet?action=deconnexion">Déconnexion</a>
	
	</body>
</html>
</div>