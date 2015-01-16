<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.UTC.BooksMatching.Beans.Books"%>
<%@page import="java.util.List"%>
<%@ include file="EnTete.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Liste des livres</title>
</head>
<body>
<h1>Book List</h1>
<h4>Trier par</h4>
Tri :
<form method="post" action="BookServlet">
	<input name="sortType" type="radio" value="1"/>titre
	<input name="sortType" type="radio" value="2"/>auteur
	<input name="sortType" type="radio" value="3"/>editeur
	<input type="hidden" name="action" value="sort" />
	<input type="submit" value="Trier" />
</form>

<table border="1">
<tr>
	<th>
		<a href="BookServlet?action=sort">Titre</a>
	</th>
	<th>Auteur</th>
	<th>Editeur</th>
	<th>Genre</th>
	<th>ISBN</th>
	<th>ACTIONS</th>
</tr>
	<%
		Object obj = request.getAttribute("listeB");
		if(obj!=null){
			List<Books> lb = (List<Books>)obj;
			for(Books b : lb){
	%>
			<tr>
				<td><%=b.getTitre()%></td>
				<td><%=b.getAuteur()%></td>
				<td><%=b.getEditeur()%></td>
				<td><%=b.getGenre()%></td>
				<td><%=b.getISBN()%></td>
				<td>
					<a href="BookServlet?action=supprimer&id=<%=b.getId()%>">Supprimer</a>
					<a href="BookServlet?action=modifier&id=<%=b.getId()%>">Modifier</a>	
				</td>
			</tr>
	<%
			}
			
			
		}
	%>
</table>

<h3>
<a href="BookServlet">Ajout</a>
/Modif</h3>

<form method="post" action="BookServlet">
		<label for="titre">Titre :</label>
		<input type="text" name="titre" id="titre" value="${uModif.titre}"/>
		<br />
		<label for="auteur">Auteur :</label>
		<input type="text" name="auteur" id="auteur" value="${uModif.auteur}"/>
		<br />
		<label for="editeur">Editeur :</label>
		<input type="text" name="editeur" id="editeur" value="${uModif.editeur}"/>
		<br />
		<label for="genre">Genre :</label>
		<input type="text" name="genre" id="genre" value="${uModif.genre}"/>
		<br />
		<label for="isbn">ISBN :</label>
		<input type="text" name="isbn" id="isbn" value="${uModif.ISBN}"/>
		<br />
		<input type="hidden" name="id" value="${uModif.id}"/>
		<input type="submit" value="Valider" />
	</form>

</body>
</html>