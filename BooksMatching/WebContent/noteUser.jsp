<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.UTC.BooksMatching.Beans.Note"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
	 	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	 	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
		<title>Notation de livre</title>
		<link rel="stylesheet" type="text/css" href="semantic.css">
		<link rel="stylesheet" type="text/css" href="icon.css">
		<script src="semantic.js"></script>
</head>
<body>
<%@ include file="EnTete.jsp"  %>
<%
  		Note note= (Note)request.getAttribute("note");	
		int qw=note.getQualityOfWriting();
		int dr=note.getDesireToRecommend();
		int dk=note.getDesireToKeepReading();
		int da=note.getDesireFromSameAuteur();
		
%>
<div class="ui center aligned segment">
  <div class="ui"><h1>Notez le livre</h1></div>
  <div class="ui horizontal divider">ou</div>
  <div class="teal ui ">Vous pouvez également enregistrer et revenir ultérieurement à votre notation</div>
</div>

<div class="ui warning message header">
	<div class="content"> Titre du livre</div>
	<div class="sub header"> Auteur </div>
</div>


<div class="ui tertiary segment">
	<div class="ui block header">
      <i class="sliders icon"></i>
      <div class="content">
        Notez ce livre
        <div class="sub header">(ou modifier la notation)</div>
      </div>
    </div>

	<form class="ui form segment" method="post" action="BookServlet">
		<div class="segment">
		<label for="qualityOfWriting">La qualité de l'écriture : </label>
				<input name="qualityOfWriting" type="radio" value="0" style="margin-left: 10%" <% if(qw==0){ %> checked<%} %>/>
		        <label>0</label>
		
				<input name="qualityOfWriting" type="radio" value="1" style="margin-left: 10%" <% if(qw==1){ %> checked <%} %>/>
		        <label>1</label>

		        <input name="qualityOfWriting" type="radio" value="2" style="margin-left: 10%" <% if(qw==2) {%> checked <%} %>/>
		        <label>2</label>

		        <input name="qualityOfWriting" type="radio" value="3" style="margin-left: 10%" <% if(qw== 3){ %> checked <%} %>/>
		        <label>3</label>
		        
		        <input name="qualityOfWriting" type="radio" value="4" style="margin-left: 10%" <% if(qw==4){ %> checked <%} %>/>
		        <label>4</label>
		        
		        <input name="qualityOfWriting" type="radio" value="5" style="margin-left: 10%" <% if(qw==5){ %> checked <%} %>/>
		        <label>5</label>
		</div>
		<br />
		<div class="segment">
		<label for="desireToKeepReading">La qualité de l'écriture : </label>
				<input name="desireToKeepReading" type="radio" value="0" style="margin-left: 10%" <% if(dk==0){ %> checked<%} %>/>
		        <label>0</label>
		
				<input name="desireToKeepReading" type="radio" value="1" style="margin-left: 10%" <% if(dk==1){ %> checked<%} %>/>
		        <label>1</label>

		        <input name="desireToKeepReading" type="radio" value="2" style="margin-left: 10%" <% if(dk==2){ %> checked<%} %>/>
		        <label>2</label>

		        <input name="desireToKeepReading" type="radio" value="3" style="margin-left: 10%" <% if(dk==3){ %> checked<%} %>/>
		        <label>3</label>
		        
		        <input name="desireToKeepReading" type="radio" value="4" style="margin-left: 10%" <% if(dk==4){ %> checked<%} %>/>
		        <label>4</label>
		        
		        <input name="desireToKeepReading" type="radio" value="5" style="margin-left: 10%" <% if(dk==5){ %> checked<%} %>/>
		        <label>5</label>
		</div>
		<br />
		<div class="segment">
		<label for="desireFromSameAuteur">La qualité de l'écriture : </label>
				<input name="desireFromSameAuteur" type="radio" value="0" style="margin-left: 10%" <% if(da==0){ %> checked<%} %>/>
		        <label>0</label>
		
				<input name="desireFromSameAuteur" type="radio" value="1" style="margin-left: 10%" <% if(da==1){ %> checked<%} %>/>
		        <label>1</label>

		        <input name="desireFromSameAuteur" type="radio" value="2" style="margin-left: 10%" <% if(da==2){ %> checked<%} %>/>
		        <label>2</label>

		        <input name="desireFromSameAuteur" type="radio" value="3" style="margin-left: 10%" <% if(da==3){ %> checked<%} %>/>
		        <label>3</label>
		        
		        <input name="desireFromSameAuteur" type="radio" value="4" style="margin-left: 10%" <% if(da==4){ %> checked<%} %>/>
		        <label>4</label>
		        
		        <input name="desireFromSameAuteur" type="radio" value="5" style="margin-left: 10%" <% if(da==5){ %> checked<%} %>/>
		        <label>5</label>
		</div>
		<br />
		<div class="segment">
		<label for="desireToRecommend">La qualité de l'écriture : </label>
				<input name="desireToRecommend" type="radio" value="0" style="margin-left: 10%" <% if(dr==0){ %> checked<%} %>/>
		        <label>0</label>
		
				<input name="desireToRecommend" type="radio" value="1" style="margin-left: 10%" <% if(dr==1){ %> checked<%} %>/>
		        <label>1</label>

		        <input name="desireToRecommend" type="radio" value="2" style="margin-left: 10%"<% if(dr==2){ %> checked<%} %>/>
		        <label>2</label>

		        <input name="desireToRecommend" type="radio" value="3" style="margin-left: 10%" <% if(dr==3){ %> checked<%} %>/>
		        <label>3</label>
		        
		        <input name="desireToRecommend" type="radio" value="4" style="margin-left: 10%" <% if(dr==4){ %> checked<%} %>/>
		        <label>4</label>
		        
		        <input name="desireToRecommend" type="radio" value="5" style="margin-left: 10%" <% if(dr==5){ %> checked<%} %>/>
		        <label>5</label>
		</div>
		<br />
		<label for="comment">Commentaires(facultatif): </label>
		<input type="text" name="comment" id="comment" value="<%=note.getComments() %>"/>
		<br /><br/>

		<center>
		<div class="ui buttons">
			    <input class="ui red button" type="reset" value="Supprimer"/>
			    <div class="or"></div>
			    <input type="hidden" name="action" value="note" />
			    <input type="hidden" name="new" value="<%=(char) request.getAttribute("new") %>" />
			    <input type="hidden" name="idBook" value="<%=note.getIdBook() %>"/>
			    <input class="ui teal button" type="submit" value="Enregistrer"/>
		</div>
		</center>
	</form>
</div>

</body>
</html>