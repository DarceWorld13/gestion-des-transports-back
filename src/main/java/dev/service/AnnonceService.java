package dev.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.controller.dto.AnnonceDTO;
import dev.domain.Annonce;
import dev.domain.Collegue;
import dev.exception.CollegueNonTrouveException;
import dev.exception.EmptyRepositoryException;
import dev.repository.AnnonceRepo;
import dev.repository.CollegueRepo;
import dev.repository.VehiculeRepo;

@Service
public class AnnonceService {

	@Autowired
	AnnonceRepo annonceRepo;
	@Autowired
	CollegueRepo collegueRepo;
	@Autowired
	VehiculeRepo vehiculeRepo;

	public AnnonceService() {
	}

	public AnnonceService(AnnonceRepo annonceRepo, CollegueRepo collegueRepo) {
		this.annonceRepo = annonceRepo;
		this.collegueRepo = collegueRepo;
	}

	public AnnonceDTO creerAnnonce(AnnonceDTO dto) {
		Long idAnnonceur = dto.getAnnonceurId();
		Collegue annonceur = collegueRepo.findById(idAnnonceur)
				.orElseThrow(() -> new CollegueNonTrouveException("L'annonceur n'a pas été retrouvé"));
		Annonce annonceCree = new Annonce(annonceur, dto.getAdressDepart(), dto.getAdressArrivee(), null, null,
				dto.getDateTimeDepart(), dto.getPlace());
		annonceRepo.save(annonceCree);

		// TODO: quand géolocalisation fonctionnelle => annonce et dto renvoyée
		// devront être valorisés (distance, durée)
		dto.setId(annonceCree.getId());
		return dto;
	}

	public List<AnnonceDTO> listerSesAnnonces(String emailAnnonceur) throws EmptyRepositoryException {
		List<Annonce> annonces = annonceRepo.trouveAnnoncesParEmailAnnonceur(emailAnnonceur)
				.orElseThrow(() -> new EmptyRepositoryException("Aucune annonce n'a été retrouvée"));
		return annonces.stream()
				.map(annonce -> new AnnonceDTO(annonce.getId(), annonce.getAnnonceur().getId(),
						annonce.getAdressDepart(), annonce.getAdressArrivee(), annonce.getDuree(),
						annonce.getDistance(), annonce.getDateTimeDepart(), annonce.getPlace()))
				.collect(Collectors.toList());
	}

}
