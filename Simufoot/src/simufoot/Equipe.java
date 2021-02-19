package simufoot;

import java.time.LocalDate;
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

	public int getScore() {
		int score = 0;
		for(Joueur joueur : this) {
			score = score + joueur.getScore();
		}
		return score / this.size();
	}
	
	public String getNom() {
		return nom;
	}

	public String getPays() {
		return pays;
	}

	public String getVille() {
		return ville;
	}

	public String getStrategie() {
		return strategie;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setStrategie(String strategie) {
		this.strategie = strategie;
	}
	
	public Match getLastMatchJoue() {
		return this.matchsJoues.get(this.matchsJoues.size() - 1);
	}
	
	public void addVictoire() {
		this.resultats[0] = this.resultats[0] + 1;
	}
	
	public void addEgalite() {
		this.resultats[1] = this.resultats[1] + 1;
	}
	
	public void addDefaite() {
		this.resultats[2] = this.resultats[2] + 1;
	}

	public void affronterEquipe(Equipe adversaire, String nomStade, String paysStade, String adresseStade) {
		Match match = new Match(nomStade, paysStade, adresseStade, LocalDate.now(), this, adversaire);
		match.simulerMatch();
		this.matchsJoues.add(match);
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
				nom,pays,ville, resultats[0] + "," + resultats[1] + "," + resultats[2],strategie);
	}
	
	@Override
	public String toString() {
		return "Equipe [nom=" + nom + ", pays=" + pays + ", ville=" + ville + ", resultats="
				+ Arrays.toString(resultats) + ", strategie=" + strategie + "]";
	}
}