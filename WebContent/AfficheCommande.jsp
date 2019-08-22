<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Affiche Commande</title>
</head>
<body>

<h3>Afficher Commande </h3>

<p> ${message} </p>

<h5>Client</h5>
<p>${commande.client.nom }</p>
<p>${commande.client.prenom }</p>
<p>${commmande.client.adresse }</p>
<p>${commande.client.telephone }</p>
<p>${commande.client.email }</p>
<h5>Commande</h5>
<p>${commande.date }</p>
<p>${commande.montant }</p>
<p>${commmande.modePaiement }</p>
<p>${commande.statuPaiement }</p>
<p>${commande.modeLivraison }</p>
<p>${commande.statuLivraison }</p>
</body>
</html>