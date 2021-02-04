package simufoot;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Match {
	private Stade stade;
	private LocalDateTime date;
	private int[] score;
	private String resultat;
	private List<Equipe> equipes = new ArrayList<>();

	public Match(Stade stade, LocalDateTime date, Equipe equipeLocale, Equipe equipeExterieure) {
		this.stade = stade;
		this.date = date;
		this.equipes.add(equipeLocale);
		this.equipes.add(equipeExterieure);
	}

	public Match(String nomStade, String paysStade, String adresseStade, LocalDateTime date, Equipe equipeLocale,
			Equipe equipeExterieure) {
		this.stade = new Stade(nomStade, paysStade, adresseStade);
		this.date = date;
		this.equipes.add(equipeLocale);
		this.equipes.add(equipeExterieure);
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void simulerMatch() {
		this.score[0] = 0;
		this.score[1] = 0;
		int scoreAttaquant1 = 0;
		int scoreDefenseur1 = 0;
		int scoreAttaquant2 = 0;
		int scoreDefenseur2 = 0;
		// ajout simulation

		// Equipe 1 :
		for (Joueur joueur : equipes.get(0)) {
			if (joueur.getPoste().equals("Attaquant")) {
				scoreAttaquant1 = scoreAttaquant1 + joueur.getScore();
			}

			if (joueur.getPoste().equals("Défenseur")) {
				scoreDefenseur1 = scoreDefenseur1 + joueur.getScore();
			}
		}
		// Equipe 2 :
		for (Joueur joueur : equipes.get(1)) {
			if (joueur.getPoste().equals("Attaquant")) {
				scoreAttaquant2 = scoreAttaquant2 + joueur.getScore();
			}

			if (joueur.getPoste().equals("Défenseur")) {
				scoreDefenseur2 = scoreDefenseur2 + joueur.getScore();
			}
		}

		if (scoreAttaquant1 > scoreDefenseur2) {
			this.score[0] = 1;
		}

		else if (scoreAttaquant2 > scoreDefenseur1) {
			this.score[1] = 1;
		}

		// Fin fonction simulation
		if (this.score[0] < this.score[1]) {
			this.resultat = "Défaite";
		} else if (this.score[0] > this.score[1]) {
			this.resultat = "Victoire";
		} else {
			this.resultat = "Egalité";
		}

	}

	@Override
	public String toString() {
		return String.format("Match [stade=%s, date=%, score=%s, résultat=%s, équipes=%s]", stade.toString(), date,
				Arrays.toString(score), resultat, equipes);
	}
}
