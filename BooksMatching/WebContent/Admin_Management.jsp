<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.UTC.BooksMatching.Beans.Admin"%>
<%@page import="com.UTC.BooksMatching.dao.AdminDao"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des administrateurs</title>
</head>
<body>
		<%@ include file="EnTete.jsp"  %>
		
		<table>
		<%
		List<Admin> listeA = AdminDao.findall();
		if(listeA!=null){
			for(Admin a : listeA){
			%>
			<tr>
				<td><%=a.getId()%></td>
				<td><%=a.getNom()%></td>
				<td>
					<a href="AdminServlet?action=supprimer&id=<%=a.getId()%>">Supprimer</a>
					<a href="AdminServlet?action=modifier&id=<%=a.getId()%>">Modifier</a>	
				</td>
			</tr>
		<%
			}
			
			
		}
		%>
		
	</table>
	
	<form method="post" action="AdminServlet">
		<label for="Nom">Nom :</label>
		<input type="text" name="nom" id="nom" value="${aModif.nom}"/>
		<br />
		<label for="Tel">Tel :</label>
		<input type="text" name="adresse" id="adresse" value="${aModif.adresse}"/>
		<br />
		<label for="Pwd">Password :</label>
		<input type="text" name="pwd" id="pwd" value="${aModif.pwd}"/>
		<br />
		<input type="hidden" name=id name="id" value="${uModif.id}"/>
		<input type="reset" value="Reset" /><input type="submit" value="Valider" />
	</form>
</body>
</html>