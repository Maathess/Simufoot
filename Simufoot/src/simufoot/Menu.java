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
	private static final String MENU_SIMULATION = "menusimulation.txt";
	private static final String MENU_EQUIPE = "menuequipe.txt";
	private static final String MENU_JOUEURS = "menujoueurs.txt";

	private List<Equipe> equipes;
	private Scanner scanner;
	
	public Menu() {
		this.equipes = new ArrayList<>();
		this.scanner = new Scanner(System.in);
	}
	
	public void chargerMenuPrincipal() {
		int choix = 0;

		while (choix < 1 || choix > 2) {
			choix = scannerChoixMenu(MENU_PRINCIPAL);
			if (choix == 1) {
				chargerMenuSimulation();
			} else if (choix == 2) {
				quitterPartie();
			} else {
				System.out.println("Le numéro choisi ne fait pas partie des choix possibles!");
			}
		}
	}
	
	private void quitterPartie() {
		System.out.println("A bientôt sur Simufoot");
		this.sauvegarde(equipes);
		System.exit(0);
	}

	private void chargerMenuSimulation() {
		int choix = 0;
		Equipe equipe;

		while (choix < 1 || choix > 3) {
			choix = scannerChoixMenu(MENU_SIMULATION);
			if (choix == 1) {
				equipe = scannerEquipe();
				chargerMenuEquipe(equipe);
			} else if (choix == 2) {
				creationEquipe();
				chargerMenuSimulation();
			} else if (choix == 3) {
				chargerMenuPrincipal();
			} else {
				System.out.println("Le numéro choisi ne fait pas partie des choix possibles");
			}
		}
	}

	private void creationEquipe() {
		int choix = 0;
		Equipe equipe = creerEquipe();
		equipes.add(equipe);
		System.out.println("Maintenant que l'équipe " + equipe.toString() + "a été créé, il faut lui ajouter des joueurs.");
		ajouterJoueur(equipe);
		while (equipe.size() < 11 && choix != 2) {
			System.out.println("Il n'y a pas assez de joueurs, veux-tu en ajouter ? \n 1 - OUI \n 2 - NON");
			choix = scannerNumerique();
			while (choix != 2) {
				ajouterJoueur(equipe);
				System.out.println("Veux-tu ajouter d'autres joueurs ? \n\t 1 - OUI \n\t 2 - NON");
				choix = scannerNumerique();
			}
		}
		System.out.println("L'équipe a été ajoutée avec succès.");
	}
	
	private Equipe creerEquipe() {
		String nomEquipe = scannerString("Quel nom vas-tu donner à cette équipe?");
		String paysEquipe = scannerString("De quel pays vient cette équipe?");
		String villeEquipe = scannerString("De quelle ville vient cette équipe?");
		return new Equipe(nomEquipe, paysEquipe, villeEquipe);
	}
	
	private void chargerMenuEquipe(Equipe equipe) {
		int choix = 0;
			
		while (choix < 1 || choix > 6) {
			System.out.println(equipe);
			choix = scannerChoixMenu(MENU_EQUIPE);
			if (choix == 1) {
				choixAdversaire(equipe);
			} else if (choix == 2) {
				chargerMenuJoueurs(equipe);
			} else if (choix == 3) {
				modifierEquipe(equipe);
			} else if (choix == 4) {
				supprimerEquipe(equipe);
			} else if (choix == 5) {
				chargerMenuSimulation();
			} else if (choix == 6) {
				chargerMenuPrincipal();
			} else {
				System.out.println("Le numéro choisi ne fait pas partie des choix possibles");
			}
		}
	}
	
	private void choixAdversaire(Equipe equipe) {
		Equipe equipeAdverse = equipe;

		if (equipes.size() != 1) {
			while (equipeAdverse.equals(equipe)) {
				equipeAdverse = scannerEquipe();
				if (!equipeAdverse.equals(equipe)) {
					equipe.affronterEquipe(equipeAdverse, "nomStade", "paysStade", "adresseStade");
					System.out.println(equipe.getLastMatchJoue().toStringResultats());
					chargerMenuEquipe(equipe);
				} else {
					System.out.println("Ton équipe ne peut pas s'affronter elle même!");
				}
			}
		} else {
			System.out.println("Il n'y a pas encore d'autre équipe à affronter. Veuillez en créer au moins une autre.");
			chargerMenuPrincipal();
		}
	}

	private void modifierEquipe(Equipe equipe) {
		equipe.setNom(scannerString("Quel nouveau nom vas-tu donner à cette équipe?\nNom actuel : " + equipe.getNom()));
		equipe.setPays(scannerString("De quel pays vient cette équipe?\nPays actuel : " + equipe.getPays()));
		equipe.setVille(scannerString("De quelle ville vient cette équipe?\nPays actuel : " + equipe.getVille()));
		equipe.setStrategie(scannerString("Quelle sera la nouvelle stratégie de cette équipe?\nStratégie actuel : " + equipe.getStrategie()));
		chargerMenuEquipe(equipe);
	}

	private void supprimerEquipe(Equipe equipe) {
		int choix = 0;
		while (choix < 1 || choix > 2) {
			System.out.println("Êtes-vous sûr de vouloir supprimer cette équipe?\n" + equipe.toString() + "\n1 - OUI \n2 - NON");
			choix = scannerNumerique();
			if (choix == 1) {
				equipes.remove(equipe);
				chargerMenuSimulation();
			} else if (choix == 2){
				chargerMenuEquipe(equipe);
			} else {
				System.out.println("Le numéro choisi ne fait pas partie des choix possibles");
			}
		}
		chargerMenuEquipe(equipe);
	}

	private void chargerMenuJoueurs(Equipe equipe) {
		int choix = 0;
			
		while (choix < 1 || choix > 5) {
			choix = scannerChoixMenu(MENU_JOUEURS);
			if (choix == 1) {
				ajouterJoueur(equipe);
			} else if (choix == 2) {
				modifierJoueur(equipe);
			} else if (choix == 3) {
				supprimerJoueur(equipe);
			} else if (choix == 4) {
				listeJoueurs(equipe);
				chargerMenuJoueurs(equipe);
			} else if (choix == 5) {
				chargerMenuEquipe(equipe);
			} else if (choix == 6) {
				chargerMenuPrincipal();
			} else {
				System.out.println("Le numéro choisi ne fait pas partie des choix possibles");
			}
		}
	}
	
	private void ajouterJoueur(Equipe equipe) {
		equipe.add(creerJoueur());
		System.out.println("Joueur créé et ajouté à l'équipe.");
		chargerMenuJoueurs(equipe);
	}
	
	private void modifierJoueur(Equipe equipe) {
		int choix = 0;
		Joueur joueur;
		
		if (equipe.size() != 0) {
			joueur = scannerJoueur(equipe);
			while (choix < 1 || choix > 2) {
				System.out.println("Êtes-vous sûr de vouloir modifier ce joueur?\n" + joueur.toString() + "\n1 - OUI \n2 - NON");
				choix = scannerNumerique();
				if (choix == 1) {
					joueurModifie(joueur);
					chargerMenuJoueurs(equipe);
				} else if (choix == 2) {
					chargerMenuJoueurs(equipe);
				} else {
					System.out.println("Le numéro choisi ne fait pas partie des choix possibles");
				}
			}
		} else {
			System.out.println("Il n'y a pas de joueur dans cette équipe veuillez en créer un d'abord!");
			chargerMenuJoueurs(equipe);
		}
	}
	
	private void joueurModifie(Joueur joueur) {
		joueur.setPrenom(scannerString("Quel sera le nouveau prénom de ce joueur?\nPrénom actuel : " + joueur.getPrenom()));
		joueur.setNom(scannerString("Quel sera le nouveau nom de ce joueur?\nNom actuel : " + joueur.getNom()));
		joueur.setOrigine(scannerString("Quelle sera la nouvelle origine de ce joueur?\nOrigine actuelle : " + joueur.getOrigine()));
		joueur.setPoste(scannerString("Quel sera le nouveau  poste de ce joueur?\nPoste actuel : " + joueur.getPoste()));
		joueur.setNumero(scannerStatistiqueNumerique("Quel sera le nouveau  numéro de ce joueur?\nNuméro actuel : " + joueur.getNumero()));
		joueur.setVitesse(scannerStatistiqueNumerique("Quelle sera la nouvelle vitesse de ce joueur?\nVitesse actuelle : " + joueur.getVitesse()));
		joueur.setFrappe(scannerStatistiqueNumerique("Quelle sera la nouvelle frappe de ce joueur?\nFrappe actuelle : " + joueur.getFrappe()));
		joueur.setPasse(scannerStatistiqueNumerique("Quelle sera la nouvelle passe de ce joueur?\nPasse actuelle : " + joueur.getPasse()));
		joueur.setDefense(scannerStatistiqueNumerique("Quelle sera la nouvelle défense de ce joueur?\nDefense actuel : " + joueur.getDefense()));
	}

	private void supprimerJoueur(Equipe equipe) {
		int choix = 0;
		Joueur joueur;
		
		if (equipe.size() != 0) {
			joueur = scannerJoueur(equipe);
			while (choix < 1 || choix > 2) {
				System.out.println("Êtes-vous sûr de vouloir supprimer ce joueur?\n" + joueur.toString() + "\n1 - OUI \n2 - NON");
				choix = scannerNumerique();
				if (choix == 1) {
					equipe.remove(joueur);
					chargerMenuJoueurs(equipe);
				} else if (choix == 2) {
					chargerMenuJoueurs(equipe);
				} else {
					System.out.println("Le numéro choisi ne fait pas partie des choix possibles");
				}
			}
		} else {
			System.out.println("Il n'y a pas de joueur dans cette équipe veuillez en créer un d'abord!");
			chargerMenuJoueurs(equipe);
		}
	}
	
	public Joueur creerJoueur() {
		String prenom = scannerString("Quel sera le prénom de ce joueur?");
		String nom = scannerString("Quel sera le nom de ce joueur?");
		String origine = scannerString("Quelle sera l'origine de ce joueur?");
		String poste = scannerString("Quel sera le poste de ce joueur?");
		int numero = scannerStatistiqueNumerique("Quel sera le numéro de ce joueur?");
		int vitesse = scannerStatistiqueNumerique("Quelle sera la vitesse de ce joueur?");
		int frappe = scannerStatistiqueNumerique("Quelle sera la frappe de ce joueur?");
		int passe = scannerStatistiqueNumerique("Quelle sera la passe de ce joueur?");
		int defense = scannerStatistiqueNumerique("Quelle sera la défense de ce joueur?");
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
	
	private int scannerStatistiqueNumerique(String questionStatistique) {
		int choix = 0;
		
		while (choix < 1 || choix > 100) {
			System.out.println(questionStatistique);
			choix = scannerNumerique();
		}
		return choix;
	}
	
	private String scannerString(String question) {
		System.out.println(question);
		return scanner.nextLine();
	}
	
	private int scannerChoixMenu(String menu) {
		int choix = 0;
		
		try {
			lireMenu(menu);
			choix = scannerNumerique();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return choix;
	}
	
	private Equipe scannerEquipe() {
		int choix = 0;

		while (choix < 1 || choix > equipes.size()) {
			listeEquipes();
			choix = scannerNumerique();
			if (choix < 1 || choix > equipes.size()) {
				System.out.println("Ce choix ne correspond à aucune équipe!");
			}
		}
		return equipes.get(choix - 1);
	}
	
	private Joueur scannerJoueur(Equipe equipe) {
		int choix = 0;

		while (choix < 1 || choix > equipe.size()) {
			System.out.println("Quel joueur choisis-tu?");
			listeJoueurs(equipe);
			choix = scannerNumerique();
			if (choix < 1 || choix > equipe.size()) {
				System.out.println("Ce choix ne correspond à aucun joueur!");
			}
		}
		return equipe.get(choix - 1);
	}
	
	private int scannerNumerique() {
		String choix = "";
		int numChoix = 0;
		
		while (!this.isNumeric(choix)) {
			choix = scanner.nextLine();
			if (!this.isNumeric(choix)) {
				System.out.println("Ce choix n'est pas un nombre!");
			} else {
				numChoix = Integer.parseInt(choix);
			}
		}
		return numChoix;
	}
	
	private void listeEquipes() {
		int i = 1;

		if (!equipes.isEmpty()) {
			System.out.println("Quelle équipe choisis-tu?");
			for (Equipe equipe : equipes) {
				System.out.println(i + " : " + equipe);
				i = i + 1;
			}
		} else {
			System.out.println("Il n'y a d'équipe veuillez en créer une d'abord!");
		}
	}
	
	private void listeJoueurs(Equipe equipe) {
		int i = 1;

		if (!equipe.isEmpty()) {
			for (Joueur joueur : equipe) {
				System.out.println(i + " : " + joueur);
				i = i + 1;
			}
		} else {
			System.out.println("Il n'y a pas de joueur dans cette équipe veuillez en créer un d'abord!");
		}
	}
	
	private boolean isNumeric(String str) { 
		try {  
			Double.parseDouble(str);  
			return true;
		} catch (NumberFormatException e) {  
			return false;  
		}  
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