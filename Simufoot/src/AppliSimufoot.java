import java.util.ArrayList;
import java.util.List;

import simufoot.Equipe;
import simufoot.Joueur;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppliSimufoot {

	public static void main(String[] args) {
		List<Equipe> equipes = new ArrayList<>();
		equipes.add(new Equipe("PSG", "France", "Paris"));
		equipes.get(0).add(new Joueur("Gérard", "Leblond", "France", "Gardien", 1, 50, 50, 50, 50));
		equipes.get(0).add(new Joueur("Nicolas", "Lebrun", "France", "Attaquant", 2, 50, 50, 50, 50));
		equipes.get(0).add(new Joueur("Vincent", "Leblanc", "France", "Défenseur", 3, 50, 50, 50, 50));
		equipes.get(0).add(new Joueur("René", "Legris", "France", "Défenseur", 4, 50, 50, 50, 50));
		equipes.get(0).add(new Joueur("Théo", "Leroux", "France", "Attaquant", 5, 50, 50, 50, 50));
		equipes.get(0).add(new Joueur("Rachid", "Lebleu", "France", "Attaquant", 6, 50, 50, 50, 50));
		equipes.add(new Equipe("OM", "France", "Marseille"));
		equipes.get(1).add(new Joueur("Gérard", "Leblond", "France", "Gardien", 1, 50, 50, 50, 50));
		equipes.get(1).add(new Joueur("Nicolas", "Lebrun", "France", "Attaquant", 2, 50, 50, 50, 50));
		equipes.get(1).add(new Joueur("Vincent", "Leblanc", "France", "Défenseur", 3, 50, 50, 50, 50));
		equipes.get(1).add(new Joueur("René", "Legris", "France", "Défenseur", 4, 50, 50, 50, 50));
		equipes.get(1).add(new Joueur("Théo", "Leroux", "France", "Attaquant", 5, 50, 50, 50, 50));
		equipes.get(1).add(new Joueur("Rachid", "Lebleu", "France", "Attaquant", 6, 50, 50, 50, 50));
		sauvegarde(equipes);
	}
	
	private static void sauvegarde(List<Equipe> equipes) {
		try {
			File myObj = new File("equipes.txt");
			myObj.createNewFile();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		try {
			String contenuSauvegarde = "";
			for (Equipe equipe : equipes) {
				contenuSauvegarde = contenuSauvegarde + "Equipe : " + equipe.toStringSave() + "\n";
				for (Joueur joueur : equipe) {
					contenuSauvegarde = contenuSauvegarde + "Joueur : " + joueur.toStringSave() + "\n";
				}
			}
			FileWriter myWriter = new FileWriter("equipes.txt");
			myWriter.write(contenuSauvegarde);
		 	myWriter.close();
		} catch (IOException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}
}
