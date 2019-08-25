<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Affiche Commande</title>
</head>
<body>

<c:import url="inc/menu.jsp"></c:import>

<p> ${message} </p>


<c:if test="${!erreur}">

		<p> <c:out value="${commande.client.nom }"></c:out> </p>
		<p> <c:out value="${commande.client.prenom }"></c:out> </p>
		<p> <c:out value="${commande.client.adresse }"></c:out> </p>
		<p> <c:out value="${commande.client.telephone }"></c:out> </p>
		<p> <c:out value="${commande.client.email }"></c:out> </p>
		
		<p> <c:out value="${commande.date }"></c:out> </p>
		<p> <c:out value="${commande.montant }"></c:out> </p>
		<p> <c:out value="${commande.modePaiement }"></c:out> </p>
		<p> <c:out value="${commande.statuPaiement }"></c:out> </p>
		<p> <c:out value="${commande.modeLivraison }"></c:out> </p>
		<p> <c:out value="${commande.statuLivraison }"></c:out> </p>

</c:if>

</body>
</html>