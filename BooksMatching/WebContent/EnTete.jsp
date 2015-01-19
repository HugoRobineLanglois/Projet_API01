<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="menu">
	
	    <c:if test="${ !empty sessionScope.Status && sessionScope.Status == 'User' }">
	        <%@ include file="MenuUser.jsp"  %>
	        <a href="LoginServlet?action=deconnexion" class="item" ><i class="sign out icon" ></i>Déconnexion</a>
	    </c:if>
	    <c:if test="${ !empty sessionScope.Status && sessionScope.Status == 'Admin' }">
	        <%@ include file="MenuAdmin.jsp"  %>
	        <a href="LoginServlet?action=deconnexion" class="item" ><i class="sign out icon" ></i>Déconnexion</a>

	    </c:if>
	    <c:if test="${ empty sessionScope.Status }">
	    </c:if>
</div>
</div>

