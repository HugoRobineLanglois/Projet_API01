<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.UTC.BooksMatching.Beans.User"%>
<html>
	<head>
		<meta charset="utf-8" />
	 	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	 	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
		<title>BooksMatching</title>
		<link rel="stylesheet" type="text/css" href="semantic.css">
		<script src="semantic.js"></script>
	</head>
	<body>
		<%@ include file="MenuNote.jsp"  %>
		<div class="ui card" style="margin-left: auto; margin-right: auto;">
	  <div class="image">
	    <center><i class="massive book icon" style="margin-top: 10px; margin-bottom: 30px "></i></center>
	  </div>
	  <div class="content">
	    <div class="header">Utilisateur ayant donné la note la plus proche</div>
	    <div class="meta">
	      <a class="group">Meta</a>
	    </div>
	    <div class="description">
	    	j'écris qqch
	    	<%
				Object obj = request.getAttribute("Farthest");
				if(obj!=null){
					String cl = (String)obj;
			%> 
				<%=cl %>
					Je suis ici
					
				}else{
					%> Je n'ai pas récupéré de match<%
				}
					
			%>
	    </div>
	  </div>
	</div>
	
	<div class="ui card" style="margin-left: auto; margin-right: auto;">
	  <div class="image">
	    <center><i class="massive book icon" style="margin-top: 10px; margin-bottom: 30px "></i></center> 
	  </div>
	  <div class="content">
	    <div class="header">Utilisateur ayant donné la note la plus éloigné</div>
	    <div class="meta">
	      <a class="group">Meta</a>
	    </div>
	    <div class="description">
	    	   <%
				Object obj2 = request.getAttribute("Farthest");
				if(obj!=null){
					String fa = (String)obj2;
					%> <%=fa %>
					
				}else{
					%> Je n'ai pas récupéré de match<%
				}
					
			%>
	    </div>
	  </div>
	</div>
	</body>
</html>