import java.time.LocalDateTime;
import java.util.List;

import simufoot.Equipe;
import simufoot.Match;
import simufoot.Menu;
import simufoot.Stade;

public class AppliSimufoot {
	public static void main(String[] args) {
		Menu m = new Menu();
		List<Equipe> equipes = m.chargement();
		m.sauvegarde(equipes);
		LocalDateTime date = LocalDateTime.now();
		Equipe local = equipes.get(0);
		Equipe ext = equipes.get(1);
		Stade stade = new Stade("Chocapic", "France", "rue 123");
		Match match = new Match(stade, date, local, ext);
		match.simulerMatch();
		System.out.print(match);

	}

}