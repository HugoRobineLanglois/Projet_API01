<%@page import="com.UTC.BooksMatching.Beans.User"%>
<%@page import="java.util.List"%>
<%@ include file="EnTete.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Gestion des utilisateurs</title>
	<link rel="stylesheet" type="text/css" href="semantic.css">
	<link rel="stylesheet" type="text/css" href="icon.css">
	
</head>
<body>
<div>

<div class="ui center aligned segment" id="notation">
  <div class="ui"><h1>Gestion des utilisateurs</h1></div>
  <div class="ui horizontal divider">ou</div>
  <div class="teal ui ">Modifiez ou ajoutez les utilisateurs dans notre base de données</div>
</div>

<table class="ui celled table">
	<thead>
			<tr>
				<th>Nom</th>
				<th>Adresse</th>
				<th>Telephone</th>
				<th>Date de création</th>
				<th>Statut du compte</th>
				<th>ACTIONS</th>
			</tr>
		</thead>
		<tbody>
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
								<a href="UserServlet?action=supprimer&id=<%=u.getId()%>"  class="ui button">Supprimer</a>
								<a href="UserServlet?action=modifier&id=<%=u.getId()%>"  class="ui button">Modifier</a>	
							</td>
						</tr>
				<%
						}
						
						
					}
				%>
				</tbody>
			</table>
	</div>
<div class="ui tertiary segment" id="new">


	<div class="ui block header">
      <i class="plus icon"></i>
      <div class="content">
        Création
        <div class="sub header">(ou modification des utilisateurs)</div>
      </div>
    </div>
	    <form  class="ui form segment" method="post" action="UserServlet">

	           
	            <label for="nomUser">Nom <span class="requis">*</span></label>
	            <input type="text" id="nomUser" name="nomUser" size="20" maxlength="20" value="${uModif.nom}" />
	            <br />
	
	            <label for="adresseUser">Adresse<span class="requis">*</span></label>
	            <input type="text" id="adresseUser" name="adresseUser" value="${uModif.adresse}" size="20" maxlength="50" />
	            <br />
	
	            <label for="telephoneUser">Numéro de téléphone<span class="requis">*</span></label>
	            <input type="text" id="telephoneUser" name="telephoneUser" size="20" maxlength="20" value="${uModif.telephone}"/>
	            <br />
	            
	            <label for="mdpUser">Mot de passe<span class="requis">*</span></label>
	            <input pattern=".{8,}" required title="8 characters minimum" type="password" id="mpdUser" name="mdpUser" value="${uModif.pwd}" size="20" maxlength="20">
	            <br />
	            

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