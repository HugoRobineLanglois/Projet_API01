<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.UTC.BooksMatching.Beans.Admin"%>
<%@page import="com.UTC.BooksMatching.dao.AdminDao"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Affichage des administrateurs</title>
</head>
<body>
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
					<a href="">Supprimer</a>
					<a href="">Modifier</a>	
				</td>
			</tr>
		<%
			}
			
			
		}
		%>
		
	</table>

</body>
</html>