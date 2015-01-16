<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<%@ include file="EnTete.jsp"  %>
		<center><h1>Welcome to the app, please login :</h1></center>
		<form class="ui form segment" method="post" action="LoginServlet">

	            <div class="two required fields">
				    <div class="field">
				      <label for="nomUser">Login</label>
				      <div class="ui left icon input">
					      <i class="user icon"></i>
					      <input type="text" id="nomUser" name="nomUser" value="" size="20" maxlength="20" />
					   </div>
				    </div>
				    <div class="field">
				      <label for="mdp">Password</label>
				      <div class="ui left icon input">
					      <i class="lock icon"></i>
					      <input pattern=".{8,}" required title="8 characters minimum" type="password" id="mdp" name="mdp">
					    </div>
				    </div>
			  </div>
	
<!-- 	            <label for="nomUser">Login <span class="requis">*</span></label> -->
<!-- 	            <input type="text" id="nomUser" name="nomUser" value="" size="20" maxlength="20" /> -->
<!-- 	            <br /> -->
	            
<!-- 	            <label for="mdp"> Password <span class="requis">*</span></label> -->
<!-- 	            <input pattern=".{8,}" required title="8 characters minimum" type="password" id="mdp" name="mdp"> -->
<!-- 	            <br /> -->
	            

	        <center><div class="ui buttons">
			    <input class="ui button" type="reset"/>
			    <div class="or"></div>
			    <input class="ui positive button" type="submit"/>
			</div></center>
	    </form>
	</body>
</html>