package com.mt.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.mt.beans.Client;

public class CreationClientForm {

    public static final String  CHAMP_NOM     = "nomClient";
    public static final String  CHAMP_prenom  = "prenomClient";
    public static final String  CHAMP_ADRESSE = "adresseClient";
    public static final String  CHAMP_TEL     = "telephoneClient";
    public static final String  CHAMP_EMAIL   = "emailClient";

    private String              resultat;
    private Map<String, String> erreurs       = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Client CreerClient( HttpServletRequest request ) {

        Client client = new Client();

        String nomClient = getValeurChamp( request, CHAMP_NOM );
        String prenomClient = getValeurChamp( request, CHAMP_prenom );
        String adresseClient = getValeurChamp( request, CHAMP_ADRESSE );
        String telephoneClient = getValeurChamp( request, CHAMP_TEL );
        String emailClient = getValeurChamp( request, CHAMP_EMAIL );

        try {
            verifierNom( nomClient );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_NOM, e.getMessage() );
        }

        client.setNom( nomClient );

        try {
            verifierPrenom( prenomClient );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_prenom, e.getMessage() );

        }

        client.setPrenom( prenomClient );
        try {
            verifierAdresse( adresseClient );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_ADRESSE, e.getMessage() );
        }
        client.setAdresse( adresseClient );
        try {
            verifierNumTelephone( telephoneClient );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_TEL, e.getMessage() );
        }

        client.setTelephone( telephoneClient );

        try {
            verifierEmail( emailClient );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_EMAIL, e.getMessage() );
        }
        client.setEmail( emailClient );

        if ( erreurs.isEmpty() ) {
            resultat = "Succés de la création du client";
        } else {
            resultat = "Echec de la création du client";
        }

        return client;
    }

    private void verifierNom( String nom ) throws Exception {

        if ( nom != null ) {
            if ( nom.trim().length() < 2 )
                throw new Exception( "le nom doit contenir au moins deux caractère " );
        } else {
            throw new Exception( "Merci d'introduire votre nom " );
        }

    }

    private void verifierPrenom( String prenom ) throws Exception {
        if ( prenom != null && prenom.length() < 2 )
            throw new Exception( "le prenom doit contenir au moins deux caractère" );
    }

    private void verifierAdresse( String adresse ) throws Exception {
        if ( adresse != null ) {
            if ( adresse.length() < 10 )
                throw new Exception( "L'adresse doit contenir au moins 10 caractère" );
        } else {
            throw new Exception( "Merci d'introduire votre adresse" );
        }
    }

    private void verifierNumTelephone( String tel ) throws Exception {
        if ( tel != null ) {

            if ( !tel.matches( "^\\d+$" ) ) {
                throw new Exception( "Le numéro de téléphone doit contenir uniquement des chiffres" );
            } else if ( tel.length() < 4 ) {
                throw new Exception( "Le numéro de téléphone doit avoir au moins 4 chiffre" );
            }

        } else {
            throw new Exception( "Merci d'introduire votre numéro de téléphone" );
        }
    }

    private void verifierEmail( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci d'introduire un email valide" );
        }
    }

    private String getValeurChamp( HttpServletRequest request, String nomChamp ) {

        String valeur = request.getParameter( nomChamp );

        if ( valeur == null || valeur.trim().length() == 0 ) {

            valeur = null;
        }

        return valeur;

    }

}
