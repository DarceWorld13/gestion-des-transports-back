package dev.domain;

public enum CategorieVehicule {

	MICRO_URBAINES("Micro-urbaines"),
	MINI_CITADINES("Mini-citadines"),
	CITADINES_POLYVALENTES("Citadines polyvalentes"),
	COMPACTES("Compactes"),
	BERLINES_TAILLE_S("Berlines Taille S"),
	BERLINES_TAILLE_M("Berlines Taille M"),
	BERLINES_TAILLE_L("Berlines Taille L"),
	SUV_TOUTTERRAINS_PICKUP("SUV, Tout-terrains, Pick-up");
	
	private String nom = "";
	
	CategorieVehicule(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		return nom;
}
}
