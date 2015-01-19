<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.UTC.BooksMatching.Beans.Books"%>
<%@page import="com.UTC.BooksMatching.Beans.Note"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="utf-8" />
	 	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	 	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
		<title>Liste des livres</title>
		<link rel="stylesheet" type="text/css" href="semantic.css">
		<link rel="stylesheet" type="text/css" href="icon.css">
		<script src="semantic.js"></script>
	</head>
<body>
<%@ include file="EnTete.jsp"  %>

<div class="ui center aligned segment" id="notation">
  <div class="ui"><h1>Gestion des livres</h1></div>
  <div class="ui horizontal divider">ou</div>
  <div class="teal ui ">Ajoutez de nouveau(x) livre(s) dans notre base de données</div>
</div>





<div class="ui form segment">
	<div class="grouped inline fields">
		<form method="post" action="BookAdminServlet" class="ui teal dividing header">
		          
		    <label class="content">Trier par :  </label>
		   	<div class="sub header">
		        <input name="sortType" type="radio" value="1"/>
		        <label>Titre</label>

		        <input name="sortType" type="radio" value="2"/>
		        <label>Auteur</label>

		        <input name="sortType" type="radio" value="3"/>
		        <label>Editeur</label>
		     

			<input type="hidden" name="action" value="sort" />
		    <input type="submit" value="Trier" class="ui button" style="width: 10%; "/>
		    
		     </div>
	    </form>
	    
	    
	    <br>
	    <form method="post" action="BookAdminServlet">

		<div class="ui action left icon input ">
		  <i class="search icon"></i>
		  <input type="text" placeholder="Rechercher..." name="toLook">
		  <input type="hidden" name="action" value="search" />
		  <div type="submit" value="Rechercher" class="ui teal button" style="text-align: center; width: 10%">Recherche</div>
		</div>
		</form>
	    
	    </div>	
  </div> 
	 
	    


<table class="ui definition table">
  <thead>
    <tr>
    <th></th>
    <th><a href="BookAdminServlet?action=sort">Titre</a></th>
    <th>Auteur</th>
    <th>Editeur</th>
    <th>Genre</th>
    <th>ISBN</th>
  </tr></thead>
  <tbody>
  	<%
		Object obj = request.getAttribute("listeB");

		if(obj!=null){
			List<Books> lb = (List<Books>)obj;
			for(Books b : lb){
				
				
	%>
    <tr>
      <td>
      		<a href="BookAdminServlet?action=supprimer&id=<%=b.getId()%>" class="ui button">Supprimer</a>
			<a href="BookAdminServlet?action=modifier&id=<%=b.getId()%>" class="ui button" >Modifier</a>

			
	  </td>
      <td><%=b.getTitre()%></td>
	<td><%=b.getAuteur()%></td>
	<td><%=b.getEditeur()%></td>
	<td><%=b.getGenre()%></td>
	<td><%=b.getISBN()%></td>
    </tr>
   <%
			}
			
			
		}
	%>
  </tbody>
</table>

<div class="ui tertiary segment" id="new">


	<div class="ui block header">
      <i class="plus icon"></i>
      <div class="content">
        Ajout
        <div class="sub header">(Modification)</div>
      </div>
    </div>

<form class="ui form segment" method="post" action="BookAdminServlet">

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
		<label for="ISBN">ISBN :</label>
		<input type="text" name="ISBN" id="ISBN" value="${uModif.ISBN}"/>
		<br /><br/>

		<div class="ui buttons">
			    <input class="ui button" type="reset"/>
			    <div class="or"></div>
			    <input type="hidden" name="id" value="${uModif.id}"/>
			    <input class="ui teal button" type="submit"/>
		</div>
	</form>
</div>
</body>
</html>