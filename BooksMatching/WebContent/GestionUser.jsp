<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.UTC.BooksMatching.Beans.User"%>
<%@page import="java.util.List"%>
<%@ include file="EnTete.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestion des utilisateurs</title>
</head>
<body>
<div>
		<fieldset>
			<legend>Liste des utilisateurs</legend>
			<table border="1">
			<tr>
				<th>Nom</th>
				<th>Adresse</th>
				<th>Telephone</th>
				<th>Date de création</th>
				<th>Statut du compte</th>
				<th>ACTIONS</th>
			</tr>
				<%
					Object obj = request.getAttribute("listeU");
					if(obj!=null){
						List<User> lu = (List<User>)obj;
						for(User u : lu){
				%>
						<tr>
							<td><%=u.getNom()%></td>
							<td><%=u.getAdresse()%></td>
							<td><%=u.getTelephone()%></td>
							<td><%=u.getDateCreation()%></td>
							<td><%=u.getStatutCompte()%></td>
							<td>
								<a href="UserServlet?action=supprimer&id=<%=u.getId()%>">Supprimer</a>
								<a href="UserServlet?action=modifier&id=<%=u.getId()%>">Modifier</a>	
							</td>
						</tr>
				<%
						}
						
						
					}
				%>
			</table>
		</fieldset>
	</div>
	<div>
	    <form method="post" action="UserServlet">
	        <fieldset>
	            <legend>Création d'utilisateur</legend>
	
	            <label for="nomUser">Nom <span class="requis">*</span></label>
	            <input type="text" id="nomUser" name="nomUser" size="20" maxlength="20" value="${uModif.nom}" />
	            <br />
	
	            <label for="adresseUser">Adresse<span class="requis">*</span></label>
	            <input type="text" id="adresseUser" name="adresseUser" size="20" maxlength="20" value="${uModif.adresse}"/>
	            <br />
	
	            <label for="telephoneUser">Numéro de téléphone<span class="requis">*</span></label>
	            <input type="text" id="telephoneUser" name="telephoneUser" size="20" maxlength="20" value="${uModif.telephone}"/>
	            <br />
	            
	            <label for="mdpUser">Mot de passe<span class="requis">*</span></label>
	            <input pattern=".{8,}" required title="8 characters minimum" type="password" id="mpdUser" name="mdpUser" value="${uModif.pwd}" size="20" maxlength="20">
	            <br />
	            
	        </fieldset>
	        <input type="hidden" name="id" value="${uModif.id}"/>
	        <input type="submit" value="Valider"  />
	        <input type="reset" value="Remettre à zéro" /> <br />
	    </form>
	</div>
</body>
</html>