package simufoot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;



public class Menu {

	private static final String MENU_PRINCIPAL = "menuprincipal.txt";
	private static final String MENU_TOURNOI = "menutournoi.txt";
	private static final String MENU_CREATIONJOUEUR = "menuprincipal.txt";
	private static final String MENU_QUITTER = "menuquitter.txt";

	private List<Equipe> equipes;

	public Menu(List<Equipe> equipes) {
		this.equipes = equipes;
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
			System.err.println("Le fichier " + nomFichier + "n'a pas pu être lu car " + e.getCause());
		} finally {
			if (bf != null) {
				bf.close();
			}
		}
	}

	public Joueur creerJoueur(Scanner sc) {
		System.out.println("Quel sera le prénom de ce joueur ?");
		String prenom = sc.next();

		System.out.println("Quel sera le nom de ce joueur ?");
		String nom = sc.next();

		System.out.println("Quel sera l'origine de ce joueur ?");
		String origine = sc.next();

		System.out.println("Quel sera le poste de ce joueur ?");
		String poste = sc.next();

		System.out.println("Quel sera le numéro de ce joueur ?");
		int numero = sc.nextInt();

		System.out.println("Quel sera la vitesse de ce joueur ?");
		int vitesse = sc.nextInt();

		System.out.println("Quel sera la frappe de ce joueur ?");
		int frappe = sc.nextInt();

		System.out.println("Quel sera la passe de ce joueur ?");
		int passe = sc.nextInt();

		System.out.println("Quel sera la défense de ce joueur ?");
		int defense = sc.nextInt();

		return new Joueur(prenom, nom, origine, poste, numero, vitesse, frappe, passe, defense);
	}

	private Equipe creerEquipe(Scanner sc) {
		System.out.println("Quel nom vas-tu donner à cette équipe ?");
		String nomEquipe = sc.next();
		System.out.println("Cette équipe vient de quel pays?");
		String paysEquipe = sc.next();
		System.out.println("De quelle ville vient cette équipe ?");
		String villeEquipe = sc.next();
		return new Equipe(nomEquipe, paysEquipe, villeEquipe);
	}

	private void listeEquipes() {
		for (int i = 0; i < equipes.size(); i++) {
			System.out.println(equipes.get(i));
		}
	}

	private void listeEquipesTournoi() {
		if (!equipes.isEmpty()) {
			System.out.println("Quelle équipe choisis-tu parmi ces équipes ?");
			listeEquipes();
		} else {
			System.out.println("Il n'y a pas encore d'équipes qui ont été créés pour ce tournoi.");
		}
	}

	private void afficherChoixEquipe(int numChoixEquipe) {
		System.out.println("Tu joueras avec : " + equipes.get(numChoixEquipe) + " durant l'intégralité du tournoi.");
	}

	private void quitterPartie() {
		System.out.println("A bientôt sur Simufoot");
		System.exit(0);
	}

	public void chargerMenu(Scanner sc) {
		try {
			lireMenu(MENU_PRINCIPAL);
			int choixPrincipal = sc.nextInt();
			int numChoixEquipe = 0;

			if (choixPrincipal == 1) {
				lireMenu(MENU_TOURNOI);
				int choixTournoi = sc.nextInt();
				if (choixTournoi == 1) {
					listeEquipesTournoi();
					numChoixEquipe = sc.nextInt();
					afficherChoixEquipe(numChoixEquipe);
				} else if (choixTournoi == 2) {
					equipes.add(creerEquipe(sc));
					System.out.println("Maintenant que l'équipe " + equipes.get(equipes.size() - 1).toString()
							+ "a été créé, il faut lui ajouter des joueurs.");
					creerJoueur(sc);
					if (equipes.get(numChoixEquipe).size() < 11) {
						System.out.println("Il n'y a pas assez de joueurs, veux-tu en ajouter ? \n 1 - OUI \n 2 - NON");
						int choixAjoutJoueurs = sc.nextInt();
						while (choixAjoutJoueurs != 2) {
							creerJoueur(sc);
							System.out.println("Veux-tu ajouter d'autres joueurs ? \n\t 1 - OUI \n\t 2 - NON");
							choixAjoutJoueurs = sc.nextInt();
						}

					}
				}
			} else if (choixPrincipal == 2) {
				System.out.println("L'équipe a été sauvegardé");
				sauvegarde(equipes);
			} else if (choixPrincipal == 4) {
				System.out.println();
				quitterPartie();
			} else {
				System.out.println("Le numéro chosit ne fait pas parti des choix possibles");
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private void sauvegarde(List<Equipe> equipes2) {
		// TODO Auto-generated method stub
		
	}

}
