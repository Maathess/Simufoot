package simufoot;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tournoi {
	private String nom;
	private LocalDateTime dateDebut;
	private LocalDateTime dateFin;
	private List<Equipe> participants = new ArrayList<>();
	private List<Equipe> podium = new ArrayList<>();
	private List<Match> matchs = new ArrayList<>();
	
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
		return String.format("Tournoi [nom=%s, dateDebut=%s, dateFin=%s, participants=%s, podium=%s, matchs=%s]"
				,nom,dateDebut,dateFin,participants,podium,matchs);
	}
}
