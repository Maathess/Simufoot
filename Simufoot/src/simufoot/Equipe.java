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

	public void transfererJoueur(Joueur joueur, Equipe equipe) {
		equipe.add(joueur);
		this.remove(joueur);
	}

	public String toStringSave() {
		return String.format("%s,%s,%s,%s,%s",
				nom,pays,ville,Arrays.toString(resultats),strategie);
	}
	
	@Override
	public String toString() {
		return String.format("Equipe [nom=%s, pays=%s, ville=%s, resultats=%s, stratégie=%s, matchsJoues=%s]",
				nom,pays,ville,Arrays.toString(resultats),strategie,matchsJoues);
	}
}