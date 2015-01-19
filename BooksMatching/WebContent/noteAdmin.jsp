<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.UTC.BooksMatching.Beans.NoteDetail"%>
<%@page import="com.UTC.BooksMatching.Beans.Note"%>
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
<div class="ui center aligned segment" id="notation">
  <div class="ui"><h1>Gestion des notes</h1></div>
  <div class="teal ui ">Modifiez des notes données par les utilisateurs</div>
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
				<a href="NoteServletAdmin?action=supprimer&user=<%=n.getUser().getId()%>&book=<%=n.getBook().getId()%>" class="ui red button">Supprimer</a>
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


<%
  		Note note= (Note)request.getAttribute("nModif");
		int qw=0, dr=0, dk=0, da=0;
		if(note!=null){
		qw=note.getQualityOfWriting();
		dr=note.getDesireToRecommend();
		dk=note.getDesireToKeepReading();
		da=note.getDesireFromSameAuteur();
		}
%>		
<div class="ui tertiary segment">
	<div class="ui block header">
      <i class="sliders icon"></i>
      <div class="content">
        Modifiez les notes
        <div class="sub header">Vous pouvez modifier les évaluations des utilisateurs</div>
      </div>
    </div>

	<form class="ui form segment" method="post" action="NoteServletAdmin">
		<div class="segment">
		<label for="qualityOfWriting" style="width: 20%">La qualité de l'écriture : </label>
				<input name="qualityOfWriting" type="radio" value="0" style="margin-left: 10%" <% if(note != null && qw==0){ %> checked<%} %>/>
		        <label>0</label>
		
				<input name="qualityOfWriting" type="radio" value="1" style="margin-left: 10%" <% if(note != null && qw==1){ %> checked <%} %>/>
		        <label>1</label>

		        <input name="qualityOfWriting" type="radio" value="2" style="margin-left: 10%" <% if(note != null && qw==2) {%> checked <%} %>/>
		        <label>2</label>

		        <input name="qualityOfWriting" type="radio" value="3" style="margin-left: 10%" <% if(note != null && qw== 3){ %> checked <%} %>/>
		        <label>3</label>
		        
		        <input name="qualityOfWriting" type="radio" value="4" style="margin-left: 10%" <% if(note != null && qw==4){ %> checked <%} %>/>
		        <label>4</label>
		        
		        <input name="qualityOfWriting" type="radio" value="5" style="margin-left: 10%" <% if(note != null && qw==5){ %> checked <%} %>/>
		        <label>5</label>
		</div>
		<br />
		<div class="segment">
		<label for="desireToKeepReading" style="width: 20%">L'envie de contier de lire : </label>
				<input name="desireToKeepReading" type="radio" value="0" style="margin-left: 10%" <% if(note != null && dk==0){ %> checked<%} %>/>
		        <label>0</label>
		
				<input name="desireToKeepReading" type="radio" value="1" style="margin-left: 10%" <% if(note != null && dk==1){ %> checked<%} %>/>
		        <label>1</label>

		        <input name="desireToKeepReading" type="radio" value="2" style="margin-left: 10%" <% if(note != null && dk==2){ %> checked<%} %>/>
		        <label>2</label>

		        <input name="desireToKeepReading" type="radio" value="3" style="margin-left: 10%" <% if(note != null && dk==3){ %> checked<%} %>/>
		        <label>3</label>
		        
		        <input name="desireToKeepReading" type="radio" value="4" style="margin-left: 10%" <% if(note != null && dk==4){ %> checked<%} %>/>
		        <label>4</label>
		        
		        <input name="desireToKeepReading" type="radio" value="5" style="margin-left: 10%" <% if(note != null && dk==5){ %> checked<%} %>/>
		        <label>5</label>
		</div>
		<br />
		<div class="segment">
		<label for="desireFromSameAuteur" style="width: 20%">L'envie de lire du même auteur </label>
				<input name="desireFromSameAuteur" type="radio" value="0" style="margin-left: 10%" <% if(note != null && da==0){ %> checked<%} %>/>
		        <label>0</label>
		
				<input name="desireFromSameAuteur" type="radio" value="1" style="margin-left: 10%" <% if(note != null && da==1){ %> checked<%} %>/>
		        <label>1</label>

		        <input name="desireFromSameAuteur" type="radio" value="2" style="margin-left: 10%" <% if(note != null && da==2){ %> checked<%} %>/>
		        <label>2</label>

		        <input name="desireFromSameAuteur" type="radio" value="3" style="margin-left: 10%" <% if(note != null && da==3){ %> checked<%} %>/>
		        <label>3</label>
		        
		        <input name="desireFromSameAuteur" type="radio" value="4" style="margin-left: 10%" <% if(note != null && da==4){ %> checked<%} %>/>
		        <label>4</label>
		        
		        <input name="desireFromSameAuteur" type="radio" value="5" style="margin-left: 10%" <% if(note != null && da==5){ %> checked<%} %>/>
		        <label>5</label>
		</div>
		<br />
		<div class="segment">
		<label for="desireToRecommend" style="width: 20%">L'envie de le recommander: </label>
				<input name="desireToRecommend" type="radio" value="0" style="margin-left: 10%" <% if(note != null && dr==0){ %> checked<%} %>/>
		        <label>0</label>
		
				<input name="desireToRecommend" type="radio" value="1" style="margin-left: 10%" <% if(note != null && dr==1){ %> checked<%} %>/>
		        <label>1</label>

		        <input name="desireToRecommend" type="radio" value="2" style="margin-left: 10%"<% if(note != null && dr==2){ %> checked<%} %>/>
		        <label>2</label>

		        <input name="desireToRecommend" type="radio" value="3" style="margin-left: 10%" <% if(note != null && dr==3){ %> checked<%} %>/>
		        <label>3</label>
		        
		        <input name="desireToRecommend" type="radio" value="4" style="margin-left: 10%" <% if(note != null && dr==4){ %> checked<%} %>/>
		        <label>4</label>
		        
		        <input name="desireToRecommend" type="radio" value="5" style="margin-left: 10%" <% if(note != null && dr==5){ %> checked<%} %>/>
		        <label>5</label>
		</div>
		<br />
		<label for="comment">Commentaires(facultatif): </label>
		<input type="text" name="comment" id="comment" value="${nModif.comments}"/>
		<br /><br/>

		<center>
		<div class="ui buttons">
			    <input class="ui red button" type="reset" value="Reset"/>
			    <div class="or"></div>
			    <input type="hidden" name="action" value="modifier" />
			    <input type="hidden" name="user" value="${nModif.idUser }"/>
			    <input type="hidden" name="book" value="${nModif.idBook}" />
			    <input class="ui teal button" type="submit" value="Enregistrer"/>
		</div>
		</center>
	</form>
</div> 

</body>
</html>