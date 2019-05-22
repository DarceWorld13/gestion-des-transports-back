package dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.AnnonceDto;
import dev.exception.EmptyRepositoryException;
import dev.service.AnnonceService;
import dev.service.CollegueService;

@RestController
@CrossOrigin
@RequestMapping("/collaborateur")
public class CollegueController {

	@Autowired
	private CollegueService collegueService;
	@Autowired
	private AnnonceService annonceService;

	@PostMapping("/annonces/creer")
	public ResponseEntity<AnnonceDto> creerAnnonce(@RequestBody AnnonceDto annonceDto) throws EmptyRepositoryException {
		AnnonceDto annonceDtoCree = annonceService.creerAnnonce(annonceDto);
		return ResponseEntity.ok(annonceDtoCree);
	}

	@ExceptionHandler(EmptyRepositoryException.class)
	public ResponseEntity<String> gereEmptyRepositoryException(EmptyRepositoryException ere) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ere.getMessage());
	}
}