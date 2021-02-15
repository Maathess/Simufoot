package simufoot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Match {
	private Stade stade;
	private LocalDate date;
	private int[] score = new int[2];
	private String resultat;
	private List<Equipe> equipes = new ArrayList<>();
	
	public Match(Stade stade, LocalDate date, Equipe equipeLocale, Equipe equipeExterieure) {
		this.stade = stade;
		this.date = date;
		this.equipes.add(equipeLocale);
		this.equipes.add(equipeExterieure);
	}
	
	public Match(String nomStade, String paysStade, String adresseStade, LocalDate date, Equipe equipeLocale, Equipe equipeExterieure) {
		this.stade = new Stade(nomStade, paysStade, adresseStade);
		this.date = date;
		this.equipes.add(equipeLocale);
		this.equipes.add(equipeExterieure);
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void simulerMatch() {
		this.score[0] = 0;
		this.score[1] = 0;
		float scoreEquipe1 = 0;
		float scoreEquipe2 = 0;
		float scoreAttaquant1 = 0;
		float scoreDefenseur1 = 0;
		float scoreAttaquant2 = 0;
		float scoreDefenseur2 = 0;

		scoreEquipe1 = equipes.get(0).getScore();
		for (Joueur joueur : equipes.get(0)) {
			if (joueur.getPoste().equals("Attaquant")) {
				scoreAttaquant1 = scoreAttaquant1 + joueur.getScore();
			}

			if (joueur.getPoste().equals("Défenseur")) {
				scoreDefenseur1 = scoreDefenseur1 + joueur.getScore();
			}
		}
		scoreEquipe2 = equipes.get(0).getScore();
		for (Joueur joueur : equipes.get(1)) {
			if (joueur.getPoste().equals("Attaquant")) {
				scoreAttaquant2 = scoreAttaquant2 + joueur.getScore();
			}

			if (joueur.getPoste().equals("Défenseur")) {
				scoreDefenseur2 = scoreDefenseur2 + joueur.getScore();
			}
		}
		if (scoreAttaquant1 > scoreDefenseur2) {
			this.score[0] = (int) ((scoreEquipe1 / scoreEquipe2 + scoreAttaquant1 / scoreDefenseur2) / 2 * Math.random() * (2 - 0.5) + 0.5);
		}
		if (scoreAttaquant2 > scoreDefenseur1) {
			this.score[1] = (int) ((scoreEquipe2 / scoreEquipe1 + scoreAttaquant2 / scoreDefenseur1) / 2 * Math.random() * (2 - 0.5) + 0.5);
		}
		if (this.score[0] < this.score[1]) {
			this.resultat = "Défaite";
			equipes.get(0).addDefaite();
			equipes.get(1).addVictoire();
		} else if (this.score[0] > this.score[1]) {
			this.resultat = "Victoire";
			equipes.get(0).addVictoire();
			equipes.get(1).addDefaite();
		} else {
			this.resultat = "Egalité";
			equipes.get(0).addEgalite();
			equipes.get(1).addEgalite();
		}
	}

	public String toStringResultats() {
		return equipes.get(0).getNom() + " " + Arrays.toString(score) + " " + equipes.get(1).getNom() + " : " + resultat;
	}
	
	@Override
	public String toString() {
		return String.format("Match [stade=%s, date=%s, score=%s, résultat=%s, équipes=%s]", 
				stade.toString(),date, Arrays.toString(score), resultat,equipes);
	}
}
