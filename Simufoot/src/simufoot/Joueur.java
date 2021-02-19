package simufoot;

public class Joueur {
	private String nom;
	private String prenom;
	private String origine;
	private String poste;
	private int numero;
	private int vitesse;
	private int frappe;
	private int passe;
	private int defense;

	public Joueur(String nom, String prenom, String origine, String poste, int numero, int vitesse, int frappe,
			int passe, int defense) {
		this.nom = nom;
		this.prenom = prenom;
		this.origine = origine;
		this.poste = poste;
		this.numero = numero;
		this.vitesse = vitesse;
		this.frappe = frappe;
		this.passe = passe;
		this.defense = defense;
	}

	public void modifierStatistiques(int vitesse, int frappe, int passe, int defense) {
		this.vitesse = vitesse;
		this.frappe = frappe;
		this.passe = passe;
		this.defense = defense;
	}

	public int getScore() {
		return (vitesse + frappe + passe + defense) / 4;
	}
	
	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getOrigine() {
		return origine;
	}

	public String getPoste() {
		return poste;
	}

	public int getNumero() {
		return numero;
	}

	public int getVitesse() {
		return vitesse;
	}

	public int getFrappe() {
		return frappe;
	}

	public int getPasse() {
		return passe;
	}

	public int getDefense() {
		return defense;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public void setFrappe(int frappe) {
		this.frappe = frappe;
	}

	public void setPasse(int passe) {
		this.passe = passe;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public void modifierVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public void modifierFrappe(int frappe) {
		this.frappe = frappe;
	}

	public void modifierPasse(int passe) {
		this.passe = passe;
	}

	public void modifierDefense(int defense) {
		this.defense = defense;
	}

	public String toStringSave() {
		return nom + "," + prenom + "," + origine + "," + poste + ","
				+ numero + "," + vitesse + "," + frappe + "," + passe + "," + defense;
	}
	
	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ", prenom=" + prenom + ", origine=" + origine + ", poste=" + poste + ", numero="
				+ numero + ", vitesse=" + vitesse + ", frappe=" + frappe + ", passe=" + passe + ", defense=" + defense
				+ ", score=" + getScore() + "]";
	}
}
