package simufoot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private static final String PATH_EQUIPES = "equipes.txt";
	private static final String MENU_PRINCIPAL = "menuprincipal.txt";
	private static final String MENU_TOURNOI = "menutournoi.txt";
	private static final String MENU_EQUIPE = "menuequipe.txt";

	private List<Equipe> equipes;
	private Scanner scanner;
	
	public Menu() {
		this.equipes = new ArrayList<>();
		this.scanner = new Scanner(System.in);
	}
	
	public void chargerMenuPrincipal() {
		try {
			String choixPrincipal = "";

			while (choixPrincipal != "1" || choixPrincipal != "2") {
				lireMenu(MENU_PRINCIPAL);
				choixPrincipal = scanner.next();
				if (choixPrincipal.matches("1")) {
					chargerMenuTournoi();
				} else if (choixPrincipal.matches("2")) {
					quitterPartie();
				} else {
					System.out.println("Le numéro choisi ne fait pas partie des choix possibles");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void chargerMenuTournoi() {
		try {
			int numChoixEquipe = 0;

			lireMenu(MENU_TOURNOI);
			String choixMenuTournoi = scanner.next();
			if (choixMenuTournoi.matches("1")) {
				listeEquipesTournoi();
				numChoixEquipe = scanner.nextInt();
				System.out.println("Tu joueras avec : " + equipes.get(numChoixEquipe - 1) + " durant l'intégralité du tournoi.");
				chargerMenuEquipe(equipes.get(numChoixEquipe - 1));
			} else if (choixMenuTournoi.matches("2")) {
				equipes.add(creerEquipe());
				System.out.println("Maintenant que l'équipe " + equipes.get(equipes.size() - 1).toString()
						+ "a été créé, il faut lui ajouter des joueurs.");
				creerJoueur();
				if (equipes.get(numChoixEquipe).size() < 11) {
					System.out.println("Il n'y a pas assez de joueurs, veux-tu en ajouter ? \n 1 - OUI \n 2 - NON");
					int choixAjoutJoueurs = scanner.nextInt();
					while (choixAjoutJoueurs != 2) {
						creerJoueur();
						System.out.println("Veux-tu ajouter d'autres joueurs ? \n\t 1 - OUI \n\t 2 - NON");
						choixAjoutJoueurs = scanner.nextInt();
					}
				}
				else {
					System.out.println("Maintenant que les joueurs ont été créés, tu peux commencer à jouer.");
				}
			} else if (choixMenuTournoi.matches("3")) {
				chargerMenuPrincipal();
			} else {
				System.out.println("Le numéro choisi ne fait pas partie des choix possibles");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void chargerMenuEquipe(Equipe equipe) {
		try {
			String choixPrincipal = "";
			
			while (choixPrincipal != "1" || choixPrincipal != "2") {
				lireMenu(MENU_EQUIPE);
				choixPrincipal = scanner.next();
				if (choixPrincipal.matches("1")) {
					choixAdversaire(equipe);
				} else if (choixPrincipal.matches("2")) {
					chargerMenuPrincipal();
				} else {
					System.out.println("Le numéro choisi ne fait pas partie des choix possibles");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void choixAdversaire(Equipe equipe) {
		int numChoixEquipe = 0;
		Equipe equipeAdverse = equipe;

		if (equipes.size() != 1) {
			while (equipeAdverse.equals(equipe)) {
				listeEquipesTournoi();
				numChoixEquipe = scanner.nextInt();
				equipeAdverse = equipes.get(numChoixEquipe - 1);
				if (!equipeAdverse.equals(equipe)) {
					equipe.affronterEquipe(equipeAdverse, "nomStade", "paysStade", "adresseStade");
					System.out.println(equipe.getLastMatchJoue().toStringResultats());
					chargerMenuEquipe(equipe);
				} else {
					System.out.println("Ton équipe ne peut pas s'affronter elle même.");
				}
			}
		} else {
			System.out.println("Il n'y a pas encore d'autre équipe à affronter. Veuillez en créer au moins une autre.");
			chargerMenuPrincipal();
		}
	}
	
	private void listeEquipesTournoi() {
		int i = 1;

		if (!equipes.isEmpty()) {
			System.out.println("Quelle équipe choisis-tu?");
			for (Equipe equipe : equipes) {
				System.out.println(i + " : " + equipe);
				i = i + 1;
			}
		} else {
			System.out.println("Il n'y a pas encore d'équipes qui ont été créés pour ce tournoi.");
		}
	}

	private Equipe creerEquipe() {
		System.out.println("Quel nom vas-tu donner à cette équipe?");
		String nomEquipe = scanner.next();
		System.out.println("Cette équipe vient de quel pays?");
		String paysEquipe = scanner.next();
		System.out.println("De quelle ville vient cette équipe?");
		String villeEquipe = scanner.next();
		return new Equipe(nomEquipe, paysEquipe, villeEquipe);
	}
	
	public Joueur creerJoueur() {
		System.out.println("Quel sera le prénom de ce joueur?");
		String prenom = scanner.next();
		System.out.println("Quel sera le nom de ce joueur?");
		String nom = scanner.next();
		System.out.println("Quel sera l'origine de ce joueur?");
		String origine = scanner.next();
		System.out.println("Quel sera le poste de ce joueur?");
		String poste = scanner.next();
		System.out.println("Quel sera le numéro de ce joueur?");
		int numero = scanner.nextInt();
		System.out.println("Quelle sera la vitesse de ce joueur?");
		int vitesse = scanner.nextInt();
		System.out.println("Quelle sera la frappe de ce joueur?");
		int frappe = scanner.nextInt();
		System.out.println("Quelle sera la passe de ce joueur?");
		int passe = scanner.nextInt();
		System.out.println("Quelle sera la défense de ce joueur?");
		int defense = scanner.nextInt();
		return new Joueur(prenom, nom, origine, poste, numero, vitesse, frappe, passe, defense);
	}
	
	private void lireMenu(String nomFichier) throws IOException {
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(nomFichier, StandardCharsets.ISO_8859_1));
			String line;
			while ((line = bf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.err.println("Le fichier " + nomFichier + " n'a pas pu être lu car " + e.getCause());
		} finally {
			if (bf != null) {
				bf.close();
			}
		}
	}
	
	private void quitterPartie() {
		System.out.println("A bientôt sur Simufoot");
		System.exit(0);
	}

	public void sauvegarde(List<Equipe> equipes) {
		try {
			File fichierEquipes = new File(PATH_EQUIPES);
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
			FileWriter writer = new FileWriter(PATH_EQUIPES);
			writer.write(contenuSauvegarde);
			writer.close();
		} catch (IOException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}
	
	public List<Equipe> chargement() {
		Equipe equipe = null;

		try {
			File fichierEquipes = new File(PATH_EQUIPES);
			Scanner reader = new Scanner(fichierEquipes);
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				if (line.equals("Equipe :")) {
					String[] datas = reader.nextLine().split(",");
					int[] resultats = { Integer.parseInt(datas[3]), Integer.parseInt(datas[4]),
							Integer.parseInt(datas[5]) };
					equipe = new Equipe(datas[0], datas[1], datas[2], resultats, datas[6]);
					equipes.add(equipe);
				}
				if (line.equals("Joueur :")) {
					String[] datas = reader.nextLine().split(",");
					equipe.add(new Joueur(datas[0], datas[1], datas[2], datas[3], Integer.parseInt(datas[4]),
							Integer.parseInt(datas[5]), Integer.parseInt(datas[6]), Integer.parseInt(datas[7]),
							Integer.parseInt(datas[8])));
				}
			}
			reader.close();
		} catch (FileNotFoundException error) {
			System.out.println("An error occurred.");
			error.printStackTrace();
		}
		return equipes;
	}
}