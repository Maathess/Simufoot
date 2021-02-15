package simufoot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tournoi {
	private String nom;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private List<Equipe> participants = new ArrayList<>();
	private List<Equipe> podium = new ArrayList<>();
	private List<Match> matchs = new ArrayList<>();
	
	public Tournoi(String nom, LocalDate dateDebut, List<Equipe> participants) {
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.participants = participants;
	}
	
	public void cloreTournoi() {
		dateFin = matchs.get(matchs.size()).getDate();
	}

	@Override
	public String toString() {
		return "Tournoi [nom=" + nom + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", participants="
				+ participants + ", podium=" + podium + ", matchs=" + matchs + "]";
	}
}
