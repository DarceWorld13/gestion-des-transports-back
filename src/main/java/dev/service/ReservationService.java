package dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.controller.dto.ReservationDTO;
import dev.domain.Reservation;
import dev.exception.ReservationInvalideException;
import dev.repository.ReservationRepository;
import dev.repository.VehiculeRepo;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired
	VehiculeRepo vrepo; 
	
	public ReservationService() {
		
	}

	public ReservationService(ReservationRepository reRepo) {
		
	reservationRepo=reRepo;

	}

	public ReservationRepository getReservationRepo() {
		return reservationRepo;
	}

	public void setReservationRepo(ReservationRepository reservationRepo) {
		this.reservationRepo = reservationRepo;
	} 
	
	//ajouter une réservation 
	
	public Reservation ajouterReservation(Reservation reservation) throws Exception {
		
		if(reservation.getDateDeReservation()==null || reservation.getDateDeRetour() ==null) {
			
			throw new ReservationInvalideException("on ne peut pas ajouter cette réservation"); 
		}else {
		
		reservationRepo.save(reservation); 
		
		return reservation; }
		
	}
	
	//afficher toutes les réservations 
public List<ReservationDTO> afficherToutesLesReservations(){
		
		List<ReservationDTO> listeDeReservation = new ArrayList<>(); 
		
		List<Reservation> maListesDeReservation = reservationRepo.findAll(); 
		
	for (Reservation reservation : maListesDeReservation) {
		
		ReservationDTO reservationDTO = new ReservationDTO(reservation);
		listeDeReservation.add(reservationDTO);
	}
		
		return listeDeReservation; 
	}
	
	
	
	
	
}