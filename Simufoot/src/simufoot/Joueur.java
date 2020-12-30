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
	private int score;

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

	@Override
	public String toString() {
		return String.format(
				"%nJoueur : %n Nom : %s,%n Pr�nom : %s,%n Nationalit� : %s,%n Poste : %s, Num�ro : %s,%n Vitesse : %s,%n"
				+ " Frappe : %s,%n Passe : %s, D�fense : %s,%n Score : %s]",
				nom, prenom, passe, origine, poste, numero, vitesse, frappe, passe, defense);

	}
}