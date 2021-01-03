import simufoot.Equipe;
import simufoot.Joueur;
import simufoot.Match;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppliSimufoot {

	public static void main(String[] args) {
		Equipe domicile = new Equipe("PSG", "France", "Paris");
		Equipe exterieur = new Equipe("OL", "France", "Lyon");
		List<Joueur> joueursParisiens = new ArrayList<>();
		joueursParisiens.add(new Joueur("Kylian", "Mbappé", "France", "Ailier", 7, 80, 80, 65, 40));
		joueursParisiens.add(new Joueur("Marco", "Verratti", "Italie", "Milieu", 6, 70, 30, 85, 75));
		
		List<Joueur> joueursLyonnais = new ArrayList<>();
		joueursLyonnais.add(new Joueur("Lopes","Anthony", "Portugal", "Gardien", 1, 35, 75, 70, 5));
		domicile.add(joueursParisiens.get(0));
		domicile.add(joueursParisiens.get(1));
		
		exterieur.add(joueursLyonnais.get(0));
		Match m = new Match("France", "Parc des Princes", LocalDateTime.now(), domicile, exterieur);
		
		System.out.println("Bienvenue sur Simufoot ! le jeu où vous pouvez créer votre propre équipe pour atteindre les sommets.");
		String menu = "MENU PRINCIPAL \n"
				+ "\t 1-Accéder au tournoi\n"
				+ "\t 2-Sauvegarder la partie\n"
				+ "\t 3- Charger une partie\n"
				+ "\t 4- Quitter le jeu\n";
		System.out.println(menu);
		Scanner sc = new Scanner(System.in);
		int choixMenu = sc.nextInt();
		
		switch (choixMenu) {
		case 1:
			System.out.println("MENU TOURNOI : \n "
					+ "1 - Choisir une équipe \n 2 - Créer une équipe");
			int choixTournoi = sc.nextInt();
			if (choixTournoi == 1) {
				
			}
			else if(choixTournoi == 2) {
				System.out.println("Quel nom vas-tu donner à cette équipe ?");
				String nomEquipe = sc.next();
				System.out.println("Cette équipe vient de quel pays?");
				String paysEquipe = sc.next();
				System.out.println("De quelle ville vient cette équipe ?");
				String villeEquipe = sc.next();
				Equipe nvlEquipe = new Equipe(nomEquipe, paysEquipe, villeEquipe);
				System.out.println("Maintenant que l'équipe est crée, il faut ajouter des joueurs");
				
				
			}
			else {
				System.out.println(menu);
			}
			break;
		case 2:
			break;
		case 3:
			break;
		case 4: {
			System.out.println("Êtes-vous sur de vouloir quitter Simufoot ?\n1-OUI \t 2-NON");
			int choixQuitter = sc.nextInt();
			if (choixQuitter == 1) {
				sc.close();
				System.exit(0);
			}
			else {
				System.out.println(menu);
			}
			break;
		}
		default:
			sc.close();
			throw new IllegalArgumentException("Le numéro choisi ne fait pas parti des choix disponibles : " + choixMenu);
			
		}
		
	}
}