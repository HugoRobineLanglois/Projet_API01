<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.UTC.BooksMatching.Beans.Admin"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" type="text/css" href="semantic.css">
		<link rel="stylesheet" type="text/css" href="icon.css">
		<title>Liste des administrateurs</title>
	</head>
	<body>
		<%@ include file="EnTete.jsp"  %>
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
				<th>
					<a href="AdminServlet?action=sort">Adresse</a>
				</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Telephone</th>
				<th>Date de creation</th>
				<th>Actions</th>
			</tr></thead>
			<tbody>
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
										<a href="AdminServlet?action=supprimer&adresse=<%=a.getAdresse()%>" class="ui button">Supprimer</a>
										<a href="AdminServlet?action=modifier&adresse=<%=a.getAdresse()%>" class="ui button">Modifier</a>
									</td>
								</tr>
							
			<%
						}
					
					
				}
			%>
			</tbody>
		</table>
		
<div class="ui tertiary segment">


	<div class="ui block header">
      <i class="plus icon"></i>
      <div class="content">
        Ajout
        <div class="sub header">(Modification)</div>
      </div>
    </div>
		
		<form method="post" action="AdminServlet" class="ui form segment">
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
				<input type="password" pattern=".{8,}" required title="8 caractères minimum" name="pwd" id="pwd" value="${uModif.pwd}"/>
				<br />
				<label for="telephone">Telephone :</label>
				<input type="text" name="telephone" id="telephone" value="${uModif.telephone}"/>
				<br />

			<div class="ui buttons">
				    <input class="ui button" type="reset"/>
				    <div class="or"></div>
				    <input class="ui teal button" type="submit"/>
			</div>
		
		</form>
</div>
	
	</body>
</html>