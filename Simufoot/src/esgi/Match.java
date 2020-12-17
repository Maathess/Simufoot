package esgi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Match {
	private String pays;
	private String stade;
	private LocalDateTime date;
	private int[] score;
	private String resultat;
	private List<Equipe> equipes = new ArrayList<Equipe>();
	
	public Match(String pays, String stade, LocalDateTime date, Equipe equipeLocale, Equipe equipeExterieure) {
		this.pays = pays;
		this.stade = stade;
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
		return "Match [pays=" + pays + ", stade=" + stade + ", date=" + date + ", score=" + Arrays.toString(score)
				+ ", resultat=" + resultat + ", equipes=" + equipes + "]";
	}
}
