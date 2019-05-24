package dev.controller;

import dev.controller.dto.CollegueVM;
import dev.repository.CollegueRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * WEB API d'authentification.
 *
 * Elle permet de récupérer les informations du collègue connecté.
 */
@RestController
public class AuthentificationController {

	@Autowired
    private CollegueRepo collegueRepo;

    public AuthentificationController(CollegueRepo collegueRepo) {
        this.collegueRepo = collegueRepo;
    }

    @GetMapping("/me")
    public ResponseEntity<?> quiSuisJe() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.collegueRepo.findByEmail(email)
                .map(CollegueVM::new)
                .map(col -> ResponseEntity.ok(col))
                .orElse(ResponseEntity.badRequest().build());
    }
}
