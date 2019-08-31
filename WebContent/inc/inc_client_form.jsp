<label for="nomClient">Nom <span class="requis">*</span></label>
<input type="text" id="nomClient" name="nomClient" value='<c:out value="${client.nom }"></c:out>' size="20"
	maxlength="20" />
	<c:out value="${form.erreurs['nomClient'] }"></c:out>
<br />

<label for="prenomClient">prenom</label>
<input type="text" id="prenomClient" name="prenomClient" value='<c:out value="${client.prenom}"></c:out>'
	size="20" maxlength="20" />
	<c:out value="${form.erreurs['prenomClient'] }"></c:out>
<br />

<label for="adresseClient">Adresse de livraision <span
	class="requis">*</span>
</label>
<input type="text" id="adresseClient" name="adresseClient" value='<c:out value="${client.adresse }"></c:out>'
	size="20" max="20" />
	<c:out value="${form.erreurs['adresseClient'] }"></c:out>
<br />

<label for="telephoneClient">Numéro de téléphone <span
	class="requis">*</span></label>
<input type="text" id="telephoneClient" name="telephoneClient" value='<c:out value="${client.telephone}"></c:out>'
	size="20" maxlength="20" />
	<c:out value="${form.erreurs['telephoneClient'] }"></c:out>
<br />

<label for="emailClient">Adresse email</label>
<input type="email" id="emailClient" name="emailClient" value='<c:out value="${client.email}"></c:out>'
	size="20" maxlength="20" />
	<c:out value="${form.erreurs['emailClient']}"></c:out>
<br />
