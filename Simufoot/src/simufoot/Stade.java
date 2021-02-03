package simufoot;

public class Stade {
	private String nom;
	private String pays;
	private String adresse;
	
	public Stade(String nom, String pays, String adresse) {
		this.nom = nom;
		this.pays = pays;
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return String.format("Stade [nom=%s, pays=%s, adresse=%s]", 
				nom,pays,adresse);
	}
}
