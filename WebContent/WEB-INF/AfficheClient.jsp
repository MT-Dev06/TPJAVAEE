<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Affiche Client</title>
</head>
<body>

	<c:import url="/inc/menu.jsp"></c:import>
		
	<p>${form.resultat}</p>
	
	<p> <c:out value="${client.nom}"></c:out> </p>
	<p> <c:out value="${client.prenom}"></c:out> </p>
	<p> <c:out value="${client.adresse}"></c:out> </p>
	<p> <c:out value="${client.telephone}"></c:out> </p>
	<p> <c:out value="${client.email}"></c:out> </p>
			
</body>
</html>