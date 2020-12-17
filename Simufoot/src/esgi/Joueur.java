package esgi;

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
	
	public Joueur(String nom, String prenom, String origine, String poste, int numero, int vitesse,
			int frappe, int passe, int defense) {
		this.nom = nom;
		this.prenom = prenom;
		this.origine = origine;
		this.poste = poste;
		this.numero = numero;
		this.vitesse = vitesse;
		this.frappe = frappe;
		this.passe = passe;
		this.defense = defense;
		this.score = (vitesse + frappe + passe + defense) / 4;
	}

	public void modifierStatistiques(int vitesse, int frappe, int passe, int defense) {
		this.vitesse = vitesse;
		this.frappe = frappe;
		this.passe = passe;
		this.defense = defense;
		this.score = (vitesse + frappe + passe + defense) / 4;
	}
	
	public void modifierVitesse(int vitesse) {
		this.vitesse = vitesse;
		this.score = (vitesse + frappe + passe + defense) / 4;
	}

	public void modifierFrappe(int frappe) {
		this.frappe = frappe;
		this.score = (vitesse + frappe + passe + defense) / 4;
	}

	public void modifierPasse(int passe) {
		this.passe = passe;
		this.score = (vitesse + frappe + passe + defense) / 4;
	}

	public void modifierDefense(int defense) {
		this.defense = defense;
		this.score = (vitesse + frappe + passe + defense) / 4;
	}

	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ", prenom=" + prenom + ", origine=" + origine + ", poste=" + poste + ", numero="
				+ numero + ", vitesse=" + vitesse + ", frappe=" + frappe + ", passe=" + passe + ", defense=" + defense
				+ ", score=" + score + "]";
	}
}
