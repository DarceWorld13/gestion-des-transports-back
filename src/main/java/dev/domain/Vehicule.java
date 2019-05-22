package dev.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicule {

	public enum Categorie {
		MICRO_URBAINES("Micro-urbaines"),
		MINI_CITADINES("Mini-citadines"),
		CITADINES_POLYVALENTES("Citadines polyvalentes"),
		COMPACTES("Compactes"),
		BERLINES_TAILLE_S("Berlines Taille S"),
		BERLINES_TAILLE_M("Berlines Taille M"),
		BERLINES_TAILLE_L("Berlines Taille L"),
		SUV_TOUTTERRAINS_PICKUP("SUV, Tout-terrains, Pick-up");
		
		private String nom = "";
		
		Categorie(String nom) {
			this.nom = nom;
		}
		
		public String toString() {
			return nom;
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String marque;
	private String modele;
	@Enumerated(EnumType.STRING)
	private Categorie categorie;
	private String immatriculation;
	private String photoUrl;
	private Integer nbPlaces;
	
	
	public Vehicule() { }
	

	public Vehicule(String marque, String modele, Categorie categorie, String immatriculation, String photoUrl, Integer nbPlaces) {
		super();
		this.marque = marque.toUpperCase();
		this.modele = modele.toLowerCase();
		this.categorie = categorie;
		this.immatriculation = immatriculation.toUpperCase();
		this.photoUrl = photoUrl;
		this.nbPlaces = nbPlaces;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque.toUpperCase();
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele.toLowerCase();
	}

	public String getCategorie() {
		return categorie.toString();
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation.toUpperCase();
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Integer getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(Integer nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	
}
