package com.mt.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.mt.beans.Client;
import com.mt.beans.Commande;

public class CreationCommandeForm {

    public static final String CHAMP_MONTANT          = "montantCommande";
    public static final String CHAMP_MODE_PAIEMENT    = "modePaiementCommande";
    public static final String CHAMP_STATUT_PAIEMENT  = "statutPaiementCommande";
    public static final String CHAMP_MODE_LiVRAISON   = "modeLivraisonCommande";
    public static final String CHAMP_STATUT_LIVRAISON = "statutLivraisonCommande";

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    private String              resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public Commande creerCommande( HttpServletRequest request ) {

        Commande commande = new Commande();

        CreationClientForm clientForm = new CreationClientForm();
        Client client = clientForm.CreerClient( request );

        erreurs = clientForm.getErreurs();

        commande.setClient( client );

        String montant = getValeurChamp( request, CHAMP_MONTANT );
        String modePaiement = getValeurChamp( request, CHAMP_MODE_PAIEMENT );
        String statutPaiement = getValeurChamp( request, CHAMP_STATUT_PAIEMENT );
        String modeLivraison = getValeurChamp( request, CHAMP_MODE_LiVRAISON );
        String statutLivraison = getValeurChamp( request, CHAMP_STATUT_LIVRAISON );

        double tempMontant = -1;

        try {
            tempMontant = validationMontant( montant );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_MONTANT, e.getMessage() );
        }

        commande.setMontant( tempMontant );

        try {
            validationModePaiement( modePaiement );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_MODE_PAIEMENT, e.getMessage() );
        }
        commande.setModePaiement( modePaiement );

        try {
            validationStatutPaiement( statutPaiement );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_STATUT_PAIEMENT, e.getMessage() );
        }
        commande.setStatuPaiement( statutPaiement );

        try {
            validationModeLivraison( modeLivraison );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_MODE_LiVRAISON, e.getMessage() );

        }
        commande.setModeLivraison( modeLivraison );

        try {
            validationStatutLivraison( statutLivraison );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_STATUT_LIVRAISON, statutLivraison );
        }
        commande.setStatuLivraison( statutLivraison );

        if ( erreurs.isEmpty() ) {

            resultat = "Succés de la création de la commande";

        } else {
            resultat = "Echec de la création de la commande";

        }

        return commande;
    }

    private double validationMontant( String montant ) throws Exception {

        double temp = -1;
        if ( montant != null ) {
            try {
                temp = Double.parseDouble( montant );
                if ( temp < 0 ) {
                    throw new Exception( "Le montant doit être un nombre positif" );
                }
            } catch ( Exception e ) {
                throw new Exception( "Le montant est composé uniquement de chiffres" );
            }

        } else {
            throw new Exception( "Merci d'introduire un montant" );
        }

        return temp;

    }

    private void validationModePaiement( String modePaiement ) throws Exception {

        if ( modePaiement != null ) {
            if ( modePaiement.length() < 2 ) {
                throw new Exception( "Le mode de paiement doit contenir au moins deux caractères" );
            }
        } else {
            throw new Exception( "Merci d'introduire le mode de paiement" );
        }

    }

    private void validationStatutPaiement( String statutPaiement ) throws Exception {
        if ( statutPaiement != null && statutPaiement.length() < 2 ) {
            throw new Exception( "Le statut de paiement doit contenir au moins deux caractères" );
        }
    }

    private void validationModeLivraison( String modeLivraison ) throws Exception {

        if ( modeLivraison != null ) {
            if ( modeLivraison.length() < 2 ) {
                throw new Exception( "Le mode de livraison doit contenir au moins deux caractères" );
            }
        } else {
            throw new Exception( "Merci d'introduire le mode de livraison" );
        }
    }

    private void validationStatutLivraison( String statutLivraison ) throws Exception {
        if ( statutLivraison == null && statutLivraison.length() < 2 ) {
            throw new Exception( "Le statut de livraison doit contenir au moins deux caractère" );
        }
    }

    private String getValeurChamp( HttpServletRequest request, String nom ) {
        String resultat = request.getParameter( nom );
        if ( resultat == null || resultat.trim().length() == 0 ) {
            resultat = null;
        }

        return resultat;

    }
}
