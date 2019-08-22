package com.mt.beans;

import java.time.LocalDate;

public class Commande {

	private Client client;
	private LocalDate date;
	private double montant;
	private String modePaiement;
	private String statuPaiement;
	private String modeLivraison;	
	private String statuLivraison;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	public String getStatuPaiement() {
		return statuPaiement;
	}

	public void setStatuPaiement(String statuPaiement) {
		this.statuPaiement = statuPaiement;
	}

	public String getModeLivraison() {
		return modeLivraison;
	}

	public void setModeLivraison(String modeLivraison) {
		this.modeLivraison = modeLivraison;
	}

	public String getStatuLivraison() {
		return statuLivraison;
	}

	public void setStatuLivraison(String statuLivraison) {
		this.statuLivraison = statuLivraison;
	}

}
