package esgi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tournoi {
	private String nom;
	private LocalDateTime dateDebut;
	private LocalDateTime dateFin;
	private List<Equipe> participants = new ArrayList<Equipe>();
	private List<Equipe> podium = new ArrayList<Equipe>();
	private List<Match> matchs = new ArrayList<Match>();
	
	public Tournoi(String nom, LocalDateTime dateDebut, List<Equipe> participants) {
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
