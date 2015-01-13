<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.UTC.BooksMatching.Beans.Admin"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="EnTete.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="./css/bootstrap.css">
		<link rel="stylesheet" href="./css/bootstrap.mini.css">
		<title>Liste des administrateurs</title>
	</head>
	<body>
		<!--  %@ include file="EnTete.jsp"  %> -->
		<h1>Admin List</h1>
		<h4>Trier par</h4>
		Tri :
		<form method="get" action="AdminServlet">
			<input name="sortType" type="radio" value="1"/>nom
			<input name="sortType" type="radio" value="2"/>auteur
			<input name="sortType" type="radio" value="3"/>editeur
			<input type="hidden" name="action" value="sort" />
			<input type="submit" value="Trier" />
		</form>
		
		<table border="1">
		<tr>
			<th>
				<a href="AdminServlet?action=sort">Titre</a>
			</th>
			<th>Adresse</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Telephone</th>
			<th>Date_creation</th>
			<th>ACTIONS</th>
		</tr>
			<%
				Object obj = request.getAttribute("listeA");
				if(obj!=null){
					List<Admin> la = (List<Admin>)obj;
					for(Admin a : la){
			%>
							
								<tr>			
									<td><%=a.getAdresse()%></td>
									<td><%=a.getNom()%></td>
									<td><%=a.getPrenom()%></td>
									<td><%=a.getTelephone()%></td>
									<td><%=a.getDate_creation()%></td>
									<td>
										<a href="AdminServlet?action=supprimer&adresse=<%=a.getAdresse()%>">Supprimer</a>
									</td>
								</tr>
							
			<%
						}
					
					
				}
			%>
		</table>
		
		<h3>
		Ajout/Modification</h3>
		
		<form method="post" action="AdminServlet">
				<label for="Adresse">Adresse :</label>
				<input type="email" name="adresse" id="adresse" value="${uModif.adresse}"/>
				<br />
				<label for="Nom">Nom :</label>
				<input type="text" name="nom" id="nom" value="${uModif.nom}"/>
				<br />
				<label for="Prenom">Prenom :</label>
				<input type="text" name="prenom" id="prenom" value="${uModif.prenom}"/>
				<br />
				<label for="pwd">Mot de passe :</label>
				<input type="password" name="pwd" id="pwd" value="${uModif.pwd}"/>
				<br />
				<label for="telephone">Telephone :</label>
				<input type="text" name="telephone" id="telephone" value="${uModif.telephone}"/>
				<br />
				<!-- <input type="hidden" name="id" value="${uModif.id}"/> -->
				<input type="submit" value="Valider" />
			</form>
	
	</body>
</html>