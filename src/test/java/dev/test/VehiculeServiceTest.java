package dev.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import dev.domain.Vehicule;
import dev.domain.Vehicule.Categorie;
import dev.exception.BadArgumentsException;
import dev.exception.EmptyRepositoryException;
import dev.repository.VehiculeRepo;
import dev.service.VehiculeService;

public class VehiculeServiceTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	private VehiculeRepo mock;
	private VehiculeService service;
	
	@Before
	public void init() {
		service = new VehiculeService();
		mock = Mockito.mock(VehiculeRepo.class);
		service.setRepo(mock);
	}
	
	@Test
	public void testEnregistrerVehiculeAvecMarqueVide() throws BadArgumentsException {
		
		exception.expect(BadArgumentsException.class);
		exception.expectMessage("Le champ de la marque ne doit pas être vide");
		
		Vehicule vehicule = new Vehicule("", "806", Categorie.BERLINES_TAILLE_L, "CA-456-CA", "http://ghj.jpg", 3);
		
		service.ajouterVehicule(vehicule);
		
	}
	
	@Test
	public void testEnregistrerVehiculeAvecModeleVide() throws BadArgumentsException {
		
		exception.expect(BadArgumentsException.class);
		exception.expectMessage("Le champ du modèle ne doit pas être vide");
		
		Vehicule vehicule = new Vehicule("Peugeot", "", Categorie.BERLINES_TAILLE_L, "CA-456-CA", "http://ghj.jpg", 3);
		
		service.ajouterVehicule(vehicule);
		
	}
	
	@Test
	public void testEnregistrerVehiculeAvecImmatriculationVide() throws BadArgumentsException {
		
		exception.expect(BadArgumentsException.class);
		exception.expectMessage("Le champ de l'immatriculation ne doit pas être vide");
		
		Vehicule vehicule = new Vehicule("Peugeot", "806", Categorie.BERLINES_TAILLE_L, "", "http://ghj.jpg", 3);
		
		service.ajouterVehicule(vehicule);
		
	}
	
	@Test
	public void testEnregistrerVehiculeAvecPhotoUrlVide() throws BadArgumentsException {
		
		exception.expect(BadArgumentsException.class);
		exception.expectMessage("Le champ photo ne doit pas être vide");
		
		Vehicule vehicule = new Vehicule("Peugeot", "806", Categorie.BERLINES_TAILLE_L, "CA-123-CA", "", 3);
		
		service.ajouterVehicule(vehicule);
		
	}
	
	@Test
	public void testEnregistrerVehiculeAvecNbPlacesVide() throws BadArgumentsException {
		
		exception.expect(BadArgumentsException.class);
		exception.expectMessage("Veuillez entrer un nombre de places");
		
		Vehicule vehicule = new Vehicule("Peugeot", "806", Categorie.BERLINES_TAILLE_L, "CA-123-CA", "http://hjkhjk.jpg", 0);
		
		service.ajouterVehicule(vehicule);
		
	}
	
	@Test
	public void testEnregistrerVehiculeOK() throws BadArgumentsException {
		
		Vehicule vehicule = new Vehicule("Peugeot", "806", Categorie.BERLINES_TAILLE_L, "CA-123-CA", "http://hjkhjk.jpg", 4);
		service.ajouterVehicule(vehicule);
		
		Mockito.verify(mock).save(vehicule);
		
	}
	
	
}
