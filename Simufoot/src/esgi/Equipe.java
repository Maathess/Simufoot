package esgi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Equipe {
	private String nom;
	private String pays;
	private String ville;
	private int[] resultats = {0, 0, 0};
	private String strategie = "Neutre";
	private List<Joueur> joueurs = new ArrayList<Joueur>();
	private List<Match> matchsJoues = new ArrayList<Match>();
	
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
	
	public void ajouterJoueur(Joueur joueur) {
		this.joueurs.add(joueur);
	}
	
	public void renvoyerJoueur(Joueur joueur) {
		this.joueurs.remove(joueur);
	}
	
	public void transfererJoueur(Joueur joueur, Equipe equipe) {
		equipe.joueurs.add(joueur);
		this.joueurs.remove(joueur);
	}
	
	@Override
	public String toString() {
		return "Equipe [nom=" + nom + ", pays=" + pays + ", ville=" + ville + ", resultats="
				+ Arrays.toString(resultats) + ", strategie=" + strategie + ", joueurs=" + joueurs + ", matchsJoues="
				+ matchsJoues + "]";
	}
}