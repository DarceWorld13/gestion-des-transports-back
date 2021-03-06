package dev.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Collegue {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nom;

	private String prenom;

	private String email;

	private String motDePasse;

	private String permis;

	private String telephone;
	
	private String photoUrl;

	@OneToMany(mappedBy = "collegue", cascade = CascadeType.PERSIST)
	private List<RoleCollegue> roles;

	@OneToMany
	@JoinColumn(name = "annonceur_id")
	private List<Annonce> annonces;
	
	@OneToMany(mappedBy = "unChauffeur")
	private List<Reservation> listesDeReservations; 

	public Collegue() {
	}

	public Collegue(String nom, String prenom, String email, String motDePasse, String telephone, String photoUrl) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.telephone = telephone;
		this.photoUrl = photoUrl;
	}

	public Collegue(String nom, String prenom, String email, String motDePasse, List<RoleCollegue> roles,
			List<Annonce> annonces, String photoUrl) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.roles = roles;
		this.annonces = annonces;
		this.photoUrl = photoUrl;
	}

	public Collegue(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<RoleCollegue> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleCollegue> roles) {
		this.roles = roles;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the permis
	 */
	public String getPermis() {
		return permis;
	}

	/**
	 * @param permis
	 *            the permis to set
	 */
	public void setPermis(String permis) {
		this.permis = permis;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set

	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
  
  public List<Annonce> getAnnonces() {
		return annonces;
	}

	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
}
