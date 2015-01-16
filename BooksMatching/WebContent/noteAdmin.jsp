<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.UTC.BooksMatching.Beans.NoteDetail"%>
<%@page import="java.util.List"%>
<%@ include file="EnTete.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
	 	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	 	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
		<title>Gestion des notes</title>
		<link rel="stylesheet" type="text/css" href="semantic.css">
		<link rel="stylesheet" type="text/css" href="icon.css">
		<script src="semantic.js"></script>
</head>
<body>

<div class="ui center aligned segment">
  <div class="ui"><h1>Modifiez les notes</h1></div>
  <div class="ui horizontal divider">ou</div>
  <div class="teal ui ">Vous pouvez modifier les notes données par les utilisateurs</div>
</div>

<div class="ui form segment">
	<div class="grouped inline fields">
		<form method="post" action="NoteServletAdmin" class="ui teal dividing header">
		          
		    <label class="content">Trier par :  </label>
		   	<div class="sub header">
		        <input name="sortType" type="radio" value="titre"/>
		        <label>Titre</label>

		        <input name="sortType" type="radio" value="user"/>
		        <label>Utilisateur</label>

		        <input name="sortType" type="radio" value="date"/>
		        <label>Date</label>
		     

			<input type="hidden" name="action" value="sort" />
		    <input type="submit" value="Trier" class="ui button" style="width: 10%; "/>
		    
		     </div>
	    </form>
	    
	    
	    <br>
	    <form method="post" action="NoteServletAdmin">
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
    <th><a href="NoteServletAdmin?action=sort">Titre</a></th>
    <th>Auteur</th>
    <th>Utilisateur</th>
    <th>Qualité de l'écriture</th>
    <th>Envie de lire</th>
    <th>Envie de lire des livres du même auteur</th>
    <th>Recommandation du livre</th>
    <th>Commentaire</th>
    <th>Date</th>
  </tr></thead>
  <tbody>
  	<%
  		//Object users = request.getAttribute("listeU");
		//Object books = request.getAttribute("listeB");
  		Object notes= request.getAttribute("listeN");
		if(notes!=null){
			List<NoteDetail> ln = (List<NoteDetail>)notes;
			int res=0;
			for(NoteDetail n : ln){
	%>
	<% 
			if(n.getNote().getIsValid()==0) {
				res=1; 
			}
			else {
				res=2;
			};
			
			if(res==2) {
					//Note valide
	%>
    <tr>
	    <td>
				<a href="NoteServletAdmin?action=modifier&user=<%=n.getUser().getId()%>&book=<%=n.getBook().getId()%>" class="teal ui button">Modifier</a>
		</td>
	    <td><%=n.getBook().getTitre()%></td>
		<td><%=n.getBook().getAuteur()%></td>
		<td><%=n.getUser().getNom()%></td>
		<td><%=n.getNote().getQualityOfWriting()%></td>
		<td><%=n.getNote().getDesireToKeepReading()%></td>
		<td><%=n.getNote().getDesireFromSameAuteur()%></td>
		<td><%=n.getNote().getDesireToRecommend()%></td>
		<td><%=n.getNote().getComments()%></td>
		<td><%=n.getNote().getDate()%></td>
    </tr>
   <%
			}		
		}
	}
	%>
  </tbody>
</table>


<div class="ui tertiary segment">
	<div class="ui block header">
      <i class="sliders icon"></i>
      <div class="content">
        Notez ce livre
        <div class="sub header">(ou modifier la notation)</div>
      </div>
    </div>

	<form class="ui form segment" method="post" action="NoteServlet">
		<div class="segment">
		<label for="qualityOfWriting">La qualité de l'écriture : </label>
				<input name="qualityOfWriting" type="radio" value="0" style="margin-left: 10%"/>
		        <label>0</label>
		
				<input name="qualityOfWriting" type="radio" value="1" style="margin-left: 10%"/>
		        <label>1</label>

		        <input name="qualityOfWriting" type="radio" value="2" style="margin-left: 10%"/>
		        <label>2</label>

		        <input name="qualityOfWriting" type="radio" value="3" style="margin-left: 10%"/>
		        <label>3</label>
		        
		        <input name="qualityOfWriting" type="radio" value="4" style="margin-left: 10%"/>
		        <label>4</label>
		        
		        <input name="qualityOfWriting" type="radio" value="5" style="margin-left: 10%"/>
		        <label>5</label>
		</div>
		<br />
		<label for="desireToKeepReading">L'envie de continuer la lecture: </label>
		<input type="text" name="desireToKeepReading" id="desireToKeepReading" value="${nModif.desireToKeepReading}"/>
		<br />
		<label for="desireFromSameAuteur">L'envie de lire plus du même auteur :</label>
		<input type="text" name="desireFromSameAuteur" id="desireFromSameAuteur" value="${nModif.desireFromSameAuteur}"/>
		<br />
		<label for="desireToRecommend">L'envie de recommender ce livre</label>
		<input type="text" name="desireToRecommend" id="desireToRecommend" value="${nModif.desireToRecommend}"/>
		<br />
		<label for="comment">Commentaires(facultatif): </label>
		<input type="text" name="comment" id="comment" value="${uModif.comment}"/>
		<br /><br/>

		<center>
		<div class="ui buttons">
			    <input class="ui red button" type="reset" value="Supprimer"/>
			    <div class="or"></div>
			    <input class="ui button" type="reset" value="Enregistrer"/>
			    <div class="or"></div>
			    <input type="hidden" name="id" value="${uModif.id}"/>
			    <input class="ui teal button" type="submit" value="Valider"/>
		</div>
		</center>
	</form>
</div>

</body>
</html>