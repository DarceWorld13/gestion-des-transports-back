package dev.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	@Column(name = "dateDeReservation")
	private LocalDateTime dateDeReservation; 
	@Column(name = "dateDeRetour")
	private LocalDateTime dateDeRetour; 
	
	@ManyToOne
	@JoinColumn(name = "id_vehicule")
	private Vehicule uneVoiture; 
	
	

	public Reservation() {
		super();	
	}


public Reservation(int id, LocalDateTime dateDeReservation, LocalDateTime dateDeRetour, Vehicule uneVoiture) {
		super();
		this.id = id;
		this.dateDeReservation = dateDeReservation;
		this.dateDeRetour = dateDeRetour;
		this.uneVoiture = uneVoiture;
	}


public Reservation( LocalDateTime dateDeReservation, LocalDateTime dateDeRetour, Vehicule uneVoiture) {
		super();
		this.dateDeReservation = dateDeReservation;
		this.dateDeRetour = dateDeRetour;
		this.uneVoiture = uneVoiture;
	}

	public Vehicule getUneVoiture() {
		return uneVoiture;
	}

	public void setUneVoiture(Vehicule uneVoiture) {
		this.uneVoiture = uneVoiture;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getDateDeReservation() {
		return dateDeReservation;
	}
	public void setDateDeReservation(LocalDateTime dateDeReservation) {
		this.dateDeReservation = dateDeReservation;
	}
	public LocalDateTime getDateDeRetour() {
		return dateDeRetour;
	}
	public void setDateDeRetour(LocalDateTime dateDeRetour) {
		this.dateDeRetour = dateDeRetour;
	}

	

}