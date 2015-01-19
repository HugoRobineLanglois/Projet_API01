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
<div class="ui center aligned segment" id="suggest">
  <div class="ui"><h1>Nous vous suggerrons quelques lectures</h1></div>
  <div class="ui horizontal divider"><i class="setting icon"></i></div>
  <div class="teal ui ">Basées sur les évaluations que vous avez faîtes de vos lectures et les appréciations générales des livres</div>
</div>

<div class="ui card" style="margin-left: auto; margin-right: auto;">
  <div class="image">
    <center><i class="massive book icon" style="margin-top: 10px; margin-bottom: 30px "></i></center>
  </div>
  <div class="content">
    <div class="header">Livre 1</div>
    <div class="meta">
      <a class="group">Meta</a>
    </div>
    <div class="description">One or two sentence description that may go to several lines</div>
  </div>
</div>

<div class="ui card" style="margin-left: auto; margin-right: auto;">
  <div class="image">
    <center><i class="massive book icon" style="margin-top: 10px; margin-bottom: 30px "></i></center> 
  </div>
  <div class="content">
    <div class="header">Livre 2</div>
    <div class="meta">
      <a class="group">Meta</a>
    </div>
    <div class="description">One or two sentence description that may go to several lines</div>
  </div>
</div>


<div class="ui center aligned segment" id="notation">
  <div class="ui"><h1>Notez vos lectures</h1></div>
  <div class="ui horizontal divider">ou</div>
  <div class="teal ui ">Ajoutez de nouveau(x) livre(s) dans notre base de données</div>
</div>





<div class="ui form segment">
	<div class="grouped inline fields">
		<form method="post" action="BookServlet" class="ui teal dividing header">
		          
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
	    <form method="post" action="BookServlet">
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
    <th><a href="BookServlet?action=sort">Titre</a></th>
    <th>Auteur</th>
    <th>Editeur</th>
    <th>Genre</th>
    <th>ISBN</th>
  </tr></thead>
  <tbody>
  	<%
		Object obj = request.getAttribute("listeB");
  		Object note= request.getAttribute("listeN");
		if(obj!=null){
			List<Books> lb = (List<Books>)obj;
			for(Books b : lb){
				
				
	%>
    <tr>
      <td>
<%--       		<a href="BookServlet?action=supprimer&id=<%=b.getId()%>" class="ui button">Supprimer</a> --%>
			<a href="BookServlet?action=modifier&id=<%=b.getId()%>" class="ui button" >Modifier</a>
			<% 
					if(note!=null){
					List<Note> ln=(List<Note>)note;
					int res=0; 
					for(Note n: ln){
						if( n.getIdBook()==b.getId()){
							if(n.getIsValid()==0) {
								res=1; 
							}
							else {
								res=2;
							}
						};
					}
					
					
					if(res==1) {
						// Note mais non valide
							
						%>
						
							<form method="post" action="NoteServlet">
							 	<input type="hidden" name="idBook" value="<%=b.getId()%>"/>
							 	<input type="hidden" name="new" value="0"/>
							 	<input type="hidden" name="Book" value="<%=b%>"/>
								<input type="submit" class="teal ui button" value="Modifier ma note" style="float: left"/>
							</form>
							<form method="post" action="BookServlet">
							 	<input type="hidden" name="idBook" value="<%=b.getId()%>"/>
							 	<input type="hidden" name="action" value="valider"/>
								<input type="submit" class="secondary ui button" value="Valider ma note"/>
							</form>
						<% 
					}
					else if(res==2) {
						//Note mais valide
						%>
						
							<form method="post" action="NoteServlet">
							 	<input type="hidden" name="idBook" value="<%=b.getId()%>"/>
							 	<input type="hidden" name="new" value="0"/>
							 	<input type="hidden" name="Book" value="<%=b%>"/>
								<input type="submit" class="teal ui button" value="Modifier ma note"/>
							</form>
						<%
					}else {
						// pas de note
						%>
						<form method="post" action="NoteServlet">
							 	<input type="hidden" name="idBook" value="<%=b.getId()%>"/>
							 	<input type="hidden" name="new" value="1"/>
							 	<input type="hidden" name="Book" value="<%=b%>"/>
								<input type="submit" class="teal ui button" value="Noter ce livre"/>
							</form>
						<%
					}
				}else {
					// pas de note
					%>
					<form method="post" action="NoteServlet">
							 	<input type="hidden" name="idBook" value="<%=b.getId()%>"/>
							 	<input type="hidden" name="new" value="1"/>
							 	<input type="hidden" name="Book" value="<%=b%>"/>
								<input type="submit" class="teal ui button" value="Noter ce livre"/>
							</form>
					<%
				}

					

			%>

			
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

<form class="ui form segment" method="post" action="BookServlet">
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