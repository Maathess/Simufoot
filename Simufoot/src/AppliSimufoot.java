import simufoot.Equipe;
import simufoot.Joueur;
import simufoot.Match;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppliSimufoot {
	static Joueur creerJoueur(Scanner sc) {
		System.out.println("Tout d'abord, quel sera le pr�nom de ce joueur ?");
		String prenomJoueur = sc.next();
		System.out.println("Le nom de ce joueur ?");
		String nomJoueur = sc.next();
		System.out.println("La nationalit� de ce joueur ?");
		String paysJoueur = sc.next();
		System.out.println("Son poste ?");
		String posteJoueur = sc.next();
		System.out.println("Son num�ro ?");
		int numeroJoueur = sc.nextInt();
		System.out.println("Sa vitesse ?");
		int vitesse = sc.nextInt();
		System.out.println("Son niveau en frappe ?");
		int frappe = sc.nextInt();
		System.out.println("Son niveau en passe ?");
		int passe = sc.nextInt();
		System.out.println("Son niveau d�fensif ?");
		int defense = sc.nextInt();
		return new Joueur(prenomJoueur, nomJoueur, paysJoueur, posteJoueur, numeroJoueur, vitesse, frappe, passe, defense);
	}

	public static void main(String[] args) {
		Equipe domicile = new Equipe("PSG", "France", "Paris");
		Equipe exterieur = new Equipe("OL", "France", "Lyon");

		List<Equipe> equipes = new ArrayList<>();
		
		/*
		 * List<Joueur> joueursParisiens = new ArrayList<>(); joueursParisiens.add(new
		 * Joueur("Kylian", "Mbapp�", "France", "Ailier", 7, 80, 80, 65, 40));
		 * joueursParisiens.add(new Joueur("Marco", "Verratti", "Italie", "Milieu", 6,
		 * 70, 30, 85, 75));
		 * 
		 * List<Joueur> joueursLyonnais = new ArrayList<>(); joueursLyonnais.add(new
		 * Joueur("Lopes","Anthony", "Portugal", "Gardien", 1, 35, 75, 70, 5));
		 * domicile.add(joueursParisiens.get(0)); domicile.add(joueursParisiens.get(1));
		 * 
		 * exterieur.add(joueursLyonnais.get(0));
		 */
		equipes.add(exterieur);
		equipes.add(domicile);

		Match m = new Match("France", "Parc des Princes", LocalDateTime.now(), domicile, exterieur);

		System.out.println(
				"Bienvenue sur Simufoot ! le jeu o� tu peux cr�er ta propre �quipe pour atteindre les sommets !");
		String menu = "MENU PRINCIPAL \n" + "\t 1 - Acc�der au tournoi\n" + "\t 2 - Sauvegarder la partie\n"
				+ "\t 3 - Charger une partie\n" + "\t 4 - Quitter le jeu\n";
		System.out.println(menu);
		Scanner sc = new Scanner(System.in);
		int choixMenu = sc.nextInt();

		switch (choixMenu) {
		case 1:
			System.out.println("MENU TOURNOI : \n " + "1 - Choisir une �quipe \n 2 - Cr�er une �quipe");
			int choixTournoi = sc.nextInt();
			if (choixTournoi == 1 && !equipes.isEmpty()) {
				System.out.println("Quelle �quipe choisis-tu parmi ces �quipes ?");
				for (int i = 0; i < equipes.size(); i++) {
					System.out.println(i + 1 + " : " + equipes.get(i).getNom());
				}
				int choixEquipe = sc.nextInt();
				System.out.println("Tu joueras avec : " + equipes.get(choixEquipe - 1).getNom()
						+ " durant l'int�gralit� du tournoi.");

			} else if (choixTournoi == 2) {
				System.out.println("Quel nom vas-tu donner � cette �quipe ?");
				String nomEquipe = sc.next();
				System.out.println("Cette �quipe vient de quel pays?");
				String paysEquipe = sc.next();
				System.out.println("De quelle ville vient cette �quipe ?");
				String villeEquipe = sc.next();
				Equipe nvlEquipe = new Equipe(nomEquipe, paysEquipe, villeEquipe);
				equipes.add(nvlEquipe);
				System.out.println("Maintenant que l'�quipe est cr�e, il faut ajouter des joueurs");

				nvlEquipe.add(creerJoueur(sc));
				System.out.println("Maintenant qu'un nouveau joueur a �t� ajout�. Souhaites-tu ajouter d'autres joueurs ou non ?"
						+ "\n 1 - Ajouter un autre joueur\n 2 - Je le ferais plus tard");
				int choixAjoutJoueur = sc.nextInt();
				if (choixAjoutJoueur == 1) {
					nvlEquipe.add(creerJoueur(sc));
				}else {
					if (nvlEquipe.size() <= 11) {
						System.out.println("Ok, mais n'oublie pas d'ajouter d'autres joueurs plus tard car il n'y a pas assez de joueurs pour lancer le tournoi ");
					}
				}

			} else {
				System.out.println(menu);
			}
			break;
		case 2:
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
					"Le num�ro choisi ne fait pas parti des choix disponibles : " + choixMenu);

		}

	}
	

}