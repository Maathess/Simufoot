package simufoot;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Equipe extends ArrayList<Joueur> {
	private String nom;
	private String pays;
	private String ville;
	private int[] resultats = { 0, 0, 0 };
	private String strategie = "Neutre";

	// TODO : Enlever la ligne 16
	private List<Joueur> joueurs = new ArrayList<>();
	private List<Match> matchsJoues = new ArrayList<>();;

	public Equipe(String nom, String pays, String ville) {
		this.nom = nom;
		this.pays = pays;
		this.ville = ville;
	}

	public void affronterEquipe(Equipe adversaire, String pays, String stade) {
		Match match = new Match(pays, stade, LocalDateTime.now(), this, adversaire);
		match.simulerMatch();
		matchsJoues.add(match);
		adversaire.matchsJoues.add(match);
	}

	public void changerStrategie(String strategie) {
		this.strategie = strategie;
	}

//	public void ajouterJoueur(Joueur joueur) {
//		this.joueurs.add(joueur);
//	}

//	public void renvoyerJoueur(Joueur joueur) {
//		this.joueurs.remove(joueur);
//	}

//	public void transfererJoueur(Joueur joueur, Equipe equipe) {
//		equipe.joueurs.add(joueur);
//		this.joueurs.remove(joueur);
//	}

	@Override
	public String toString() {
		return String.format("Equipe [nom=%s, pays=%s, ville=%s, resultats=%s, stratégie=%s, joueurs=%s, matchsJoues=%s]",
				nom,pays,ville,Arrays.toString(resultats),strategie,joueurs,matchsJoues);
	}
}