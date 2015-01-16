<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<input type="text" name="desireToKeepReading" id="desireToKeepReading" value="${uModif.desireToKeepReading}"/>
		<br />
		<label for="desireFromSameAuteur">L'envie de lire plus du même auteur :</label>
		<input type="text" name="desireFromSameAuteur" id="desireFromSameAuteur" value="${uModif.desireFromSameAuteur}"/>
		<br />
		<label for="desireToRecommend">L'envie de recommender ce livre</label>
		<input type="text" name="desireToRecommend" id="desireToRecommend" value="${uModif.desireToRecommend}"/>
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