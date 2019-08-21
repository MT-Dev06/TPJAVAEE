<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Créatio d'un client</title>
<link type="text/css" rel="stylesheet" href="inc/style.css"/>
</head>
<body>

<div>
	<form method="get" action="creationClient">
		<fieldset>
			<legend>Information Client	</legend>
            
            <label for="nomClient">Nom <span class="requis">*</span></label>
			<input type="text" id="nomClient" name="nomClient" value="" size="20" maxlength="20"/>
			<br/>
            
            <label for="prenomClient">prenom</label>
            <input type="text" id="prenomClient" name="prenomClient" value="" size="20" maxlength="20"/>
            <br/>

            <label for="adresseClient">Adresse de livraision <span class="requis">*</span> </label>
            <input type="text" id="adresseClient" name="adresseClient" value="" size="20" max="20"/>
            <br/>

            <label for="telephoneClient" >Numéro de téléphone <span class="requis">*</span></label>
            <input type="text" id="telephoneClient" name="telephoneClient" value="" size="20" maxlength="20"/>
            <br/>

            <label for="emailClient">Adresse email</label>
            <input type="email" id="emailClient" name="emailClient" value="" size="20" maxlength="20" />
            <br/>		
        </fieldset>
        <input type="submit" value="Valider"/>
        <input type="reset" value="Remettre à zéro"/>
        <br/>

	</form>
</div>
</body>
</html>