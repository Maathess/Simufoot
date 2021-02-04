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
	
	public Equipe(String nom, String pays, String ville, int[] resultats, String strategie) {
		this.nom = nom;
		this.pays = pays;
		this.ville = ville;
		this.resultats = resultats;
		this.strategie = strategie;
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
				nom,pays,ville, resultats[0] + "," + resultats[1] + "," + resultats[2],strategie);
	}
	
	@Override
	public String toString() {
		return String.format("Equipe [nom=%s, pays=%s, ville=%s, resultats=%s, strat�gie=%s, matchsJoues=%s]",
				nom,pays,ville,Arrays.toString(resultats),strategie,matchsJoues);
	}
}