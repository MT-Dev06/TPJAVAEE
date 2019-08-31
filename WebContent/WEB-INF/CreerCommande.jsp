<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'une commande</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
    <c:import url="/inc/menu.jsp"></c:import>
        <div>
            <form method="post" action="creationCommande">
            
            <c:set var="client" value="${commande.client }" scope="request"></c:set>
            
                <fieldset>
                    <legend>Informations client</legend>
    
                 <c:import url="/inc/inc_client_form.jsp"></c:import>
                    
                </fieldset>
                <fieldset>
                    <legend>Informations commande</legend>
                    
                    <label for="dateCommande">Date <span class="requis">*</span></label>
                    <input type="text" id="dateCommande" name="dateCommande" value='<c:out value="${commande.date }"></c:out>' size="20" maxlength="20" disabled />

                    <br />
                    
                    <label for="montantCommande">Montant <span class="requis">*</span></label>
                    <input type="text" id="montantCommande" name="montantCommande" value='<c:out value="${commande.montant }"></c:out>' size="20" maxlength="20" />
					<c:out value="${form.erreurs['montantCommande'] }"></c:out>
                    <br />
                    
                    <label for="modePaiementCommande">Mode de paiement <span class="requis">*</span></label>
                    <input type="text" id="modePaiementCommande" name="modePaiementCommande" value='<c:out value="${modePaiement}"></c:out>' size="20" maxlength="20" />
                    <c:out value="${form.erreurs['modePaiementCommande'] }"></c:out>
                    <br />
                    
                    <label for="statutPaiementCommande">Statut du paiement</label>
                    <input type="text" id="statutPaiementCommande" name="statutPaiementCommande" value='<c:out value="${commande.statuPaiement}"></c:out>' size="20" maxlength="20" />
                   	<c:out value="${form.erreurs['statutPaiementCommande'] }"></c:out>
                    <br />
                    
                    <label for="modeLivraisonCommande">Mode de livraison <span class="requis">*</span></label>
                    <input type="text" id="modeLivraisonCommande" name="modeLivraisonCommande" value='<c:out value="${commande.modeLivraison}"></c:out>' size="20" maxlength="20" />
                    <c:out value="${form.erreurs['modeLivraisonCommande'] }"></c:out>
                    <br />
                    
                    <label for="statutLivraisonCommande">Statut de la livraison</label>
                    <input type="text" id="statutLivraisonCommande" name="statutLivraisonCommande" value='<c:out value="${commande.statuLivraison}"></c:out>' size="20" maxlength="20" />
                   	<c:out value="${form.erreurs['statutLivraisonCommande'] }"></c:out>
                    <br />
                </fieldset>
                
                <c:out value="${form.resultat}"></c:out>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>