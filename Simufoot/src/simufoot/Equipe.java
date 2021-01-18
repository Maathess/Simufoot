package simufoot;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Equipe extends ArrayList<Joueur> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private String pays;
	private String ville;
	private int[] resultats = { 0, 0, 0 };
	private String strategie = "Neutre";

	private List<Match> matchsJoues = new ArrayList<>();

	public Equipe(String nom, String pays, String ville) {
		this.nom = nom;
		this.pays = pays;
		this.ville = ville;
	}

	// Une bonne méthode est une méthode avec peu d'arguments (3 max) 
	// TODO : Objet Stade avec le pays
	
	// TODO : Déplacer la méthode dans la classe match
	public void affronterEquipe(Equipe adversaire, String pays, String stade) {
		Match match = new Match(pays, stade, LocalDateTime.now(), this, adversaire);
		match.simulerMatch();
		matchsJoues.add(match);
		adversaire.matchsJoues.add(match);
	}

	public void changerStrategie(String strategie) {
		this.strategie = strategie;
	}

	public String listeJoueurs() {
		StringBuilder sbJoueurs = new StringBuilder();
		for (int i = 0; i < this.size(); i++) {
			sbJoueurs.append(super.get(i).toString());
		}
		return sbJoueurs.toString();
	}

	public String getNom() {
		return nom;
	}

	public String toStringSave() {
		return String.format("%s,%s,%s,%s,%s", nom, pays, ville, Arrays.toString(resultats), strategie);
	}

	public void renvoyerJoueur(Joueur joueur) {
		this.remove(joueur);
	}

	public void transfererJoueur(Joueur joueur, Equipe equipe) {
		equipe.add(joueur);
		this.remove(joueur);
	}

	@Override
	public String toString() {
		return String.format(
				"Cette équipe à pour nom : %s, elle vient %s et joue dans le championnat de %s. Elle joue avec la stratégie suivante : %s.%nCette équipe a pour effectif : %s",
				nom, ville, pays, strategie, listeJoueurs());
	}

}