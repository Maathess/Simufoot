import java.util.List;

import simufoot.Equipe;
import simufoot.Menu;

public class AppliSimufoot {
	public static void main(String[] args) {
		Menu m = new Menu();
		List<Equipe> equipes = m.chargement();
		System.out.println("Bienvenue sur Simufoot! Le jeu o� tu peux cr�er ta propre �quipe pour atteindre les sommets!");
		m.chargerMenuPrincipal();
	}
}