import simufoot.Equipe;
import simufoot.Joueur;

public class AppliSimufoot {

	public static void main(String[] args) {
		Equipe equipe = new Equipe("PSG", "France", "Paris");
		equipe.add(new Joueur(null, null, null, null, 0, 0, 0, 0, 0));
	}
}
