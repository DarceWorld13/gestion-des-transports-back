package dev.controller.dto;

import java.time.Duration;
import java.time.LocalDateTime;

import dev.domain.Annonce;
import dev.domain.Collegue;

public class AnnonceDto {

	private Long id;
	private Collegue annonceur;
	private String adressDepart;
	private String adressArrivee;
	private Duration duree;
	private Float distance;
	private LocalDateTime dateTimeDepart;
	private Integer place;

	public AnnonceDto() {
	}
	
	public AnnonceDto(Long id, Collegue annonceur, String adressDepart, String adressArrivee, Duration duree,
			Float distance, LocalDateTime dateTimeDepart, Integer place) {
		super();
		this.id = id;
		this.annonceur = annonceur;
		this.adressDepart = adressDepart;
		this.adressArrivee = adressArrivee;
		this.duree = duree;
		this.distance = distance;
		this.dateTimeDepart = dateTimeDepart;
		this.place = place;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = id;
	}

	public Collegue getAnnonceur() {
		return annonceur;
	}

	public void setAnnonceur(Collegue annonceur) {
		this.annonceur = annonceur;
	}

	public String getAdressDepart() {
		return adressDepart;
	}

	public void setAdressDepart(String adressDepart) {
		this.adressDepart = adressDepart;
	}

	public String getAdressArrivee() {
		return adressArrivee;
	}

	public void setAdressArrivee(String adressArrivee) {
		this.adressArrivee = adressArrivee;
	}

	public Duration getDuree() {
		return duree;
	}

	public void setDuree(Duration duree) {
		this.duree = duree;
	}

	public Float getDistance() {
		return distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}

	public LocalDateTime getDateTimeDepart() {
		return dateTimeDepart;
	}

	public void setDateTimeDepart(LocalDateTime dateTimeDepart) {
		this.dateTimeDepart = dateTimeDepart;
	}

	public Integer getPlace() {
		return place;
	}

	public void setPlace(Integer place) {
		this.place = place;
	}

	public Annonce dtoToObject() {
		Annonce annonce = new Annonce(annonceur, adressDepart, adressArrivee, duree, distance, dateTimeDepart, place);
		annonce.setId(id);
		return annonce;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adressArrivee == null) ? 0 : adressArrivee.hashCode());
		result = prime * result + ((adressDepart == null) ? 0 : adressDepart.hashCode());
		result = prime * result + ((annonceur == null) ? 0 : annonceur.hashCode());
		result = prime * result + ((dateTimeDepart == null) ? 0 : dateTimeDepart.hashCode());
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((duree == null) ? 0 : duree.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnnonceDto other = (AnnonceDto) obj;
		if (adressArrivee == null) {
			if (other.adressArrivee != null)
				return false;
		} else if (!adressArrivee.equals(other.adressArrivee))
			return false;
		if (adressDepart == null) {
			if (other.adressDepart != null)
				return false;
		} else if (!adressDepart.equals(other.adressDepart))
			return false;
		if (annonceur == null) {
			if (other.annonceur != null)
				return false;
		} else if (!annonceur.equals(other.annonceur))
			return false;
		if (dateTimeDepart == null) {
			if (other.dateTimeDepart != null)
				return false;
		} else if (!dateTimeDepart.equals(other.dateTimeDepart))
			return false;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (duree == null) {
			if (other.duree != null)
				return false;
		} else if (!duree.equals(other.duree))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		return true;
	}

	
	
}
