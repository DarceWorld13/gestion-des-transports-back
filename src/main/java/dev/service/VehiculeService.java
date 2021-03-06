package dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import dev.controller.dto.ModifierStatutVehiculeDTO;
import dev.domain.StatutVehicule;
import dev.controller.dto.VehiculeDTO;
import dev.domain.Vehicule;
import dev.exception.BadArgumentsException;
import dev.exception.EmptyRepositoryException;
import dev.exception.VehiculeNonTrouverException;
import dev.repository.VehiculeRepo;

@Service
public class VehiculeService {

	@Autowired
	VehiculeRepo repo;

	
	public List<VehiculeDTO> listerVehicules() throws EmptyRepositoryException {
		
		List<VehiculeDTO> resultat = new ArrayList<>();
		List<Vehicule> vehiculeTrouve = repo.findAll();
		
		if(vehiculeTrouve.isEmpty() || vehiculeTrouve == null) {
			throw new EmptyRepositoryException("Il n'y a aucun véhicule enregistré dans la base de données");
		}else {
			for(Vehicule vehicule:vehiculeTrouve) {
				
				VehiculeDTO vehiculedto = new VehiculeDTO(vehicule); 
				resultat.add(vehiculedto);
			}
			return resultat;
		}
    
	}

	public Vehicule ajouterVehicule(Vehicule vehicule) throws BadArgumentsException {

		for (Vehicule v : repo.findAll()) {
			if (v.getImmatriculation().equalsIgnoreCase(vehicule.getImmatriculation())) {
				throw new BadArgumentsException("Cette voiture est déjà enregistrée dans la base de données");
			}
		}
		if (vehicule.getMarque().isEmpty() || vehicule.getMarque() == null) {
			throw new BadArgumentsException("Le champ de la marque ne doit pas être vide");
		} else if (vehicule.getModele().isEmpty() || vehicule.getModele() == null) {
			throw new BadArgumentsException("Le champ du modèle ne doit pas être vide");
		} else if (vehicule.getImmatriculation().isEmpty() || vehicule.getImmatriculation() == null) {
			throw new BadArgumentsException("Le champ de l'immatriculation ne doit pas être vide");
		} else if (vehicule.getPhotoUrl().isEmpty() || vehicule.getPhotoUrl() == null) {
			throw new BadArgumentsException("Le champ photo ne doit pas être vide");
		} else if (!vehicule.getPhotoUrl().contains("http") || vehicule.getPhotoUrl().length() < 8) {
			throw new BadArgumentsException("Veuillez entrer un lien URL correct pour le champ photo (http://...)");
		} else if (vehicule.getNbPlaces() < 1 || vehicule.getNbPlaces() == null) {
			throw new BadArgumentsException("Veuillez entrer un nombre de places");
		} else {

			repo.save(vehicule);
			return vehicule;

		}

	}

	@Transactional
	public ModifierStatutVehiculeDTO modifierStatutVehicule(String immatriculation, StatutVehicule status) {
		Optional<Vehicule> vehicule = repo.findByImmatriculation(immatriculation);
		vehicule.get().setStatutVehicule(status);
		ModifierStatutVehiculeDTO vehiculeDTO = new ModifierStatutVehiculeDTO(vehicule.get());
		return vehiculeDTO;
	}

	public VehiculeDTO trouverVehiculeImmatriculation(String immatriculation) throws VehiculeNonTrouverException {
		Optional<Vehicule> vehicule = repo.findByImmatriculation(immatriculation);
		VehiculeDTO vDTO;
		
		if (vehicule.isPresent()) {
			vDTO = new VehiculeDTO(vehicule.get());
			return vDTO;
		} else {
			throw new VehiculeNonTrouverException("Le vehicule n'a pas été trouvé !");
		}

	}

	public void setRepo(VehiculeRepo repo) {
		this.repo = repo;
	}

}
