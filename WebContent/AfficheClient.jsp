<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Affiche Client</title>
</head>
<body>

	<h1>Information Client</h1>
	<p> ${message} </p>
	<p>
	
	${client.nom}
	<br/>
	
	${client.prenom}
	<br/>
	
	${client.adresse }
	<br/>
	
	${client.telephone }
	<br/>
	
	${client.email}
	</p>

</body>
</html>