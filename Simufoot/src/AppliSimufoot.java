import simufoot.Equipe;
import simufoot.Joueur;
import simufoot.Match;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppliSimufoot {
	public static void main(String[] args) {
		Equipe domicile = new Equipe("PSG", "France", "Paris");
		Equipe exterieur = new Equipe("OM", "France", "Marseille");

		List<Equipe> equipes = new ArrayList<>();
		equipes.add(domicile);
		equipes.get(0).add(new Joueur("Gérard", "Leblond", "France", "Gardien", 1, 50, 50, 50, 50));
		equipes.get(0).add(new Joueur("Nicolas", "Lebrun", "France", "Attaquant", 2, 50, 50, 50, 50));
		equipes.get(0).add(new Joueur("Vincent", "Leblanc", "France", "Défenseur", 3, 50, 50, 50, 50));
		equipes.get(0).add(new Joueur("René", "Legris", "France", "Défenseur", 4, 50, 50, 50, 50));
		equipes.get(0).add(new Joueur("Théo", "Leroux", "France", "Attaquant", 5, 50, 50, 50, 50));
		equipes.get(0).add(new Joueur("Rachid", "Lebleu", "France", "Attaquant", 6, 50, 50, 50, 50));
		equipes.add(exterieur);
		equipes.get(1).add(new Joueur("Gérard", "Leblond", "France", "Gardien", 1, 50, 50, 50, 50));
		equipes.get(1).add(new Joueur("Nicolas", "Lebrun", "France", "Attaquant", 2, 50, 50, 50, 50));
		equipes.get(1).add(new Joueur("Vincent", "Leblanc", "France", "Défenseur", 3, 50, 50, 50, 50));
		equipes.get(1).add(new Joueur("René", "Legris", "France", "Défenseur", 4, 50, 50, 50, 50));
		equipes.get(1).add(new Joueur("Théo", "Leroux", "France", "Attaquant", 5, 50, 50, 50, 50));
		equipes.get(1).add(new Joueur("Rachid", "Lebleu", "France", "Attaquant", 6, 50, 50, 50, 50));

		System.out.println(
				"Bienvenue sur Simufoot ! le jeu où tu peux créer ta propre équipe pour atteindre les sommets !");
		String menu = "MENU PRINCIPAL \n" + "\t 1 - Accéder au tournoi\n" + "\t 2 - Sauvegarder la partie\n"
				+ "\t 3 - Charger une partie\n" + "\t 4 - Quitter le jeu\n";
		System.out.println(menu);
		Scanner sc = new Scanner(System.in);
		int choixMenu = sc.nextInt();

		switch (choixMenu) {
		case 1:
			System.out.println("MENU TOURNOI : \n " + "1 - Choisir une équipe \n 2 - Créer une équipe");
			int choixTournoi = sc.nextInt();
			if (choixTournoi == 1 && !equipes.isEmpty()) {
				System.out.println("Quelle équipe choisis-tu parmi ces équipes ?");
				for (int i = 0; i < equipes.size(); i++) {
					System.out.println(i + 1 + " : " + equipes.get(i).getNom());
				}
				int choixEquipe = sc.nextInt();
				System.out.println("Tu joueras avec : " + equipes.get(choixEquipe - 1).getNom()
						+ " durant l'intégralité du tournoi.");

			} else if (choixTournoi == 2) {
				System.out.println("Quel nom vas-tu donner à cette équipe ?");
				String nomEquipe = sc.next();
				System.out.println("Cette équipe vient de quel pays?");
				String paysEquipe = sc.next();
				System.out.println("De quelle ville vient cette équipe ?");
				String villeEquipe = sc.next();
				Equipe nvlEquipe = new Equipe(nomEquipe, paysEquipe, villeEquipe);
				equipes.add(nvlEquipe);

				System.out.println("Maintenant que l'équipe est crée, il faut ajouter des joueurs");

				nvlEquipe.add(creerJoueur(sc));
				System.out.println(
						"Maintenant qu'un nouveau joueur a été ajouté. Souhaites-tu ajouter d'autres joueurs ou non ?"
								+ "\n 1 - Ajouter un autre joueur\n 2 - Je le ferais plus tard");
				int choixAjoutJoueur = sc.nextInt();
				if (choixAjoutJoueur == 1) {
					nvlEquipe.add(creerJoueur(sc));
				} else {
					if (nvlEquipe.size() <= 11) {
						System.out.println(
								"Ok, mais n'oublie pas d'ajouter d'autres joueurs plus tard car il n'y a pas assez de joueurs pour lancer le tournoi ");
					}
				}

			} else {
				System.out.println(menu);
			}
			break;
		case 2:
			System.out.println("La partie a été sauvegardé");
			sauvegarde(equipes);
			break;
		case 3:
			break;
		case 4: {
			System.out.println("Es-tu sur de vouloir quitter Simufoot ?\n1-OUI \t 2-NON");
			int choixQuitter = sc.nextInt();
			if (choixQuitter == 1) {
				sc.close();
				System.exit(0);
			} else {
				System.out.println(menu);
			}
			break;
		}
		default:
			sc.close();
			throw new IllegalArgumentException(
					"Le numéro choisi ne fait pas parti des choix disponibles : " + choixMenu);

		}

	}

	private static Joueur creerJoueur(Scanner sc) {
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