import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import simufoot.Equipe;
import simufoot.Joueur;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class AppliSimufoot {

	public static void main(String[] args) {
		List<Equipe> equipes = chargement();
		sauvegarde(equipes);
	}
	
	private static List<Equipe> chargement() {
		List<Equipe> equipes = new ArrayList<>();
		Equipe equipe = null;
		try {
			File fichierEquipes = new File("equipes.txt");
			Scanner reader = new Scanner(fichierEquipes);
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				if (line.equals("Equipe :")) {
					String[] datas = reader.nextLine().split(",");
					int []resultats = {Integer.parseInt(datas[3]), Integer.parseInt(datas[4]), Integer.parseInt(datas[5])};
					equipe = new Equipe(datas[0], datas[1], datas[2], resultats, datas[6]);
					equipes.add(equipe);
				}
				if (line.equals("Joueur :")) {
					String[] datas = reader.nextLine().split(",");
					equipe.add(new Joueur(datas[0], datas[1], datas[2],datas[3], Integer.parseInt(datas[4]), Integer.parseInt(datas[5]), Integer.parseInt(datas[6]), Integer.parseInt(datas[7]), Integer.parseInt(datas[8])));
				}
			}
			reader.close();
		} catch (FileNotFoundException error) {
			System.out.println("An error occurred.");
			error.printStackTrace();
		}
		return equipes;
	}
	
	private static void sauvegarde(List<Equipe> equipes) {
		try {
			File fichierEquipes = new File("equipes.txt");
			fichierEquipes.createNewFile();
		} catch (IOException error) {
			System.out.println("An error occurred.");
			error.printStackTrace();
		}
		try {
			String contenuSauvegarde = "";
			for (Equipe equipe : equipes) {
				contenuSauvegarde = contenuSauvegarde + "Equipe :\n" + equipe.toStringSave() + "\n";
				for (Joueur joueur : equipe) {
					contenuSauvegarde = contenuSauvegarde + "Joueur :\n" + joueur.toStringSave() + "\n";
				}
			}
			FileWriter writer = new FileWriter("equipes.txt");
			writer.write(contenuSauvegarde);
			writer.close();
		} catch (IOException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}
}
