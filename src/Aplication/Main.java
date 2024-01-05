/*
 * Programadors:
 * Judith Mateu Domingo - judith.mateu@estudiants.urv.cat
 * Jan Torres Rodriguez - jan.torres@estudiants.urv.cat
 */

package Aplication;

import java.util.Scanner;

import Classes.Activitats;
import Classes.Entitats;
import Classes.Usuaris;
import Classes.Visites;
import Classes.Xerrades;
import GraphicInterface.Finestra;
import Classes.Llista;
import Classes.LlistaActivitats;
import Classes.LlistaEntitats;
import Classes.LlistaReserves;
import Classes.LlistaUsuaris;
import Classes.Reserves;
import Classes.Tallers;

public class Main {
	public static void main(String[] args) {
		Finestra finestra1 = new Finestra("Jaumeburro");
		finestra1.setVisible(true);
		int opcio = 0;
		Scanner teclat = new Scanner(System.in);
		LlistaActivitats llisA = new LlistaActivitats(100);
		LlistaEntitats llisE = new LlistaEntitats(100);
		LlistaUsuaris llisU = new LlistaUsuaris(100);
		LlistaReserves llisR = new LlistaReserves(100);
		llisA.llegirfitxer("Llista_activitats.txt");
		llisE.llegirfitxer("Llista_entitats.txt");
		llisU.llegirfitxer("Llista_usuaris.txt");
		llisR.llegirfitxer("Llista_reserves.ser");
		/**
		 * Mtodes comprovats
		 */
		System.out.println("\neippp");
		do {
			printfMenu();
			do { // comprovem que no fiqui un valor fora del rang
				opcio = Integer.parseInt(teclat.nextLine());
			} while (opcio < 0 && opcio > 15);
			switch (opcio) {
				// Mostrar les dades de qualsevol llista que tingueu definida.
				case 1:
					System.out.print("\nHas escollit mostrar les dades de qualsevol llista que tingueu definida.");
					op1(llisU, llisE, llisA, llisR, teclat);
					break;
				// Obtenir i mostrar la llista d’activitats que ofereix una entitat concreta.
				case 2:
					System.out.println(
							"\nHas escollit obtenir i mostrar la llista d’activitats que ofereix una entitat concreta.");
					op2(llisA, teclat);
					break;

				// Obtenir i mostrar la llista de les activitats que es duen a terme en un dia
				// indicat per teclat.
				case 3:
					System.out.println(
							"\nHas escollit obtenir i mostrar la llista de les activitats que es duen a terme en un dia indicat per teclat.");
					op3(llisA, teclat);
					break;

				// Obtenir i mostrar la llista dels tallers que tenen places disponibles.
				case 4:
					System.out.println(
							"\nHas escollit obtenir i mostrar la llista dels tallers que tenen places disponibles.");
					op4(llisA);
					break;

				// Afegir una nova activitat
				case 5:
					System.out.println("\nHas escollit afegir una nova activitat");
					op5(llisA, teclat);
					break;

				// Registrar la petició d’un usuari per reservar un taller.
				case 6:
					System.out.println("\nHas escollit registrar la petició d’un usuari per reservar un taller.");
					op6(llisA, llisR, teclat);
					// fet
					/* Crea una reserva */
					break;

				// Mostrar els usuaris que s’han apuntat a un taller.
				case 7:
					System.out.println("\nHas escollit mostrar els usuaris que s’han apuntat a un taller.");
					op7(llisA, llisR, teclat);
					// genis
					// fet
					break;

				// Calcular l’usuari que s’ha apuntat a més tallers.
				case 8:
					System.out.println("\nHas escollit calcular l’usuari que s’ha apuntat a més tallers.");
					op8(llisR, teclat);
					// genis
					// fet
					break;

				// Registrar la nota que un usuari que s’ha apuntat a un taller li dona un cop
				// s’ha fet.
				case 9:
					System.out.println(
							"\nHas escollit registrar la nota que un usuari que s’ha apuntat a un taller li dona un cop s’ha fet.");
					op9(llisR, teclat);
					break;
				// Calcular la nota mitja que ha rebut un taller.
				case 10:
					System.out.println("\nHas escollit calcular la nota mitja que ha rebut un taller.");
					op10(llisA, teclat);
					break;
				// Quin és el taller que ha tingut més èxit?
				case 11:
					System.out.println("\nHas escollit quin és el taller que ha tingut més èxit?");
					op11(llisA);
					break;
				// Obtenir i mostrar les dades de la llista de visites ofertes per una entitat
				case 12:
					System.out.println(
							"\nHas escollit obtenir i mostrar les dades de la llista de visites ofertes per una entitat");
					op12(llisA, teclat);
					break;
				// Mostrar les dades de les xerrades que farà una persona concreta.
				case 13:
					System.out
							.println("\nHas escollit mostrar les dades de les xerrades que farà una persona concreta.");
					op13(llisA, teclat);
					break;
				// Donar de baixa un taller sempre que no hi hagi usuaris apuntats.
				case 14:
					System.out
							.println("\nHas escollit donar de baixa un taller sempre que no hi hagi usuaris apuntats.");
					op14(llisA, teclat);
					break;
				// Sortir del programa
			}
		} while (opcio != 15);
		System.out.println("Has sortit del programa amb èxit!");
	}
	// Obtenir i mostrar la llista d’activitats que ofereix una entitat concreta.

	// Mostrar el menú d'opcions
	private static void printfMenu() {
		System.out.println("\nIntrodueix el número de la operació que vulguis realitzar\n");
		System.out.println("\n\t1. Mostrar les dades de qualsevol llista que tingueu definida.\n");
		System.out.println("\t2. Obtenir i mostrar la llista d’activitats que ofereix una entitat concreta.");
		System.out.println(
				"\t3. Obtenir i mostrar la llista de les activitats que es duen a terme en un dia indicat per teclat.");
		System.out.println("\t4. Obtenir i mostrar la llista dels tallers que tenen places disponibles.");
		System.out.println("\t5. Afegir una nova activitat ");
		System.out.println("\t6. Registrar la petició d’un usuari per reservar un taller.");
		System.out.println("\t7. Mostrar els usuaris que s’han apuntat a un taller.");
		System.out.println("\t8. Calcular l’usuari que s’ha apuntat a més tallers.");
		System.out
				.println("\t9. Registrar la nota que un usuari que s’ha apuntat a un taller li dona un cop s’ha fet.");
		System.out.println("\t10. Calcular la nota mitja que ha rebut un taller.");
		System.out.println("\t11. Quin és el taller que ha tingut més èxit? C");
		System.out.println("\t12. Obtenir i mostrar les dades de la llista de visites ofertes per una entitat");
		System.out.println("\t13. Mostrar les dades de les xerrades que farà una persona concreta.");
		System.out.println("\t14. Donar de baixa un taller sempre que no hi hagi usuaris apuntats.");
		System.out.println("\t15. Sortir de l'aplicació");
		System.out.print("\n\tIndica opcio: ");
	}

	// FETS: 1, 2, 3, 4, 5, 10, 11, 12, 13, 14
	// FALTEN: 6, 7, 8, 9

	private static void op1(LlistaUsuaris llisU, LlistaEntitats llisE, LlistaActivitats llisA, LlistaReserves llisR,
			Scanner teclat) {
		System.out.println(
				"Introdueix el número de la llista que vols veure.\n\t1- Usuaris\n\t2- Entitats\n\t3- Activitats\n\t4- Reserves");
		switch (Integer.parseInt(teclat.nextLine())) {
			case 1:
				System.out.println(llisU);
				break;
			case 2:
				System.out.println(llisE);
				break;

			case 3:
				System.out.println(llisA);
				break;
			case 4:
				System.out.println(llisR);
				break;
			default:
				System.out.println("Introdueix un número vàlid");
				op1(llisU, llisE, llisA, llisR, teclat);
		}
	}

	private static void op2(LlistaActivitats llisA, Scanner teclat) {
		// String nomE;
		System.out.println("Introdueix el nom de la entitat: ");
		System.out.println(llisA.mateixaEntitat(teclat.nextLine())); // S'imprimeix la subllista resultant
	}

	private static void op3(LlistaActivitats llisA, Scanner teclat) {
		System.out.println("Introdueix el dia");
		System.out.println(llisA.mateixDia(Integer.parseInt(teclat.nextLine())));
	}

	private static void op4(LlistaActivitats llisA) {
		System.out.println(llisA.tallersDisp());
	}

	private static void op5(LlistaActivitats llisA, Scanner teclat) {
		String tipus, nom, lloc, entitatCrea;
		int dia, codiPostal;
		Activitats aux;

		do {
			System.out.println("Quin tipus d'activitat vols afegir?");
			tipus = teclat.nextLine();
		} while (!(tipus.equalsIgnoreCase("Xerrada")) && !(tipus.equalsIgnoreCase("Xerrades"))
				&& !(tipus.equalsIgnoreCase("Visita")) && !(tipus.equalsIgnoreCase("Visites"))
				&& !(tipus.equalsIgnoreCase("Taller")) && !(tipus.equalsIgnoreCase("Tallers")));

		System.out.println("Introdueix les dades de l'activitat que vols afegir.\n\tNom: ");
		nom = teclat.nextLine();
		System.out.println("\n\tLloc: ");
		lloc = teclat.nextLine();
		System.out.println("\n\tDia: ");
		dia = Integer.parseInt(teclat.nextLine());
		System.out.println("\n\tNom de l'entitat que l'ha creat: ");
		entitatCrea = teclat.nextLine();
		System.out.println("\n\tCodi Postal: ");
		codiPostal = Integer.parseInt(teclat.nextLine());
		if (tipus.equalsIgnoreCase("Xerrada") || tipus.equalsIgnoreCase("Xerrades")) {
			System.out.println("\n\tNom de la persona que fa la xerrada: ");
			String nomPersona = teclat.nextLine();
			aux = new Xerrades(nom, lloc, dia, entitatCrea, codiPostal, nomPersona);
		} else if (tipus.equalsIgnoreCase("Visita") || tipus.equalsIgnoreCase("Visites")) {
			boolean audioguies, adaptCegues;

			System.out.println("\n\tTé audioguies? Contesta si o no: ");
			if (teclat.nextLine().equalsIgnoreCase("No"))
				audioguies = false;
			else
				audioguies = true;
			System.out.println("\n\tEstà adaptat per a persones cegues? Contesta si o no: ");
			if (teclat.nextLine().equalsIgnoreCase("No"))
				adaptCegues = false;
			else
				adaptCegues = true;

			aux = new Visites(nom, lloc, dia, entitatCrea, codiPostal, audioguies, adaptCegues);
		} else {
			System.out.println("\n\tA quina hora és?: ");
			int hora = Integer.parseInt(teclat.nextLine());
			System.out.println("\n\tQuina durada té?: ");
			int durada = Integer.parseInt(teclat.nextLine());
			System.out.println("\n\tQuantes persones s'hi poden inscriure?: ");
			int capacitat = Integer.parseInt(teclat.nextLine());

			aux = new Tallers(nom, lloc, dia, entitatCrea, codiPostal, hora, durada, capacitat, 0, 0, 0);
		}
		llisA.agregar(aux);
	}

	// 6.Registrar la petició d’un usuari per reservar un taller
	private static void op6(LlistaActivitats llisA, LlistaReserves llisR, Scanner teclat) {
		Reserves r;
		Usuaris u;
		String nom, mail, codi;
		int codiPostal;

		System.out.println("\nIntrodueix les dades de l'usuari.\nNom: ");
		nom = teclat.nextLine();
		System.out.println("\nMail: ");
		mail = teclat.nextLine();
		System.out.println("\nCodi postal: ");
		codiPostal = Integer.parseInt(teclat.nextLine());

		System.out.println("\nA quin taller es vol inscriure? Introdueix el seu codi: ");
		codi = teclat.nextLine();

		u = new Usuaris(nom, mail, codiPostal);
		r = new Reserves(u, llisA.trobaTaller(codi));
		llisR.agregar(r);
		System.out.println("\nReserva realitzada!");
	}

	// 7. Mostrar els usuaris que s’han apuntat a un taller.")
	private static void op7(LlistaActivitats llisA, LlistaReserves llisR, Scanner teclat) {
		System.out.println("Quin taller vols buscar\n");
		String codi = teclat.nextLine();
		Tallers t = llisA.trobaTaller(codi);
		System.out.println("\n" + llisR.usuarisTaller(t));

	}

	// 8.Calcular l’usuari que s’ha apuntat a més tallers.")
	private static void op8(LlistaReserves llisR, Scanner teclat) {
		System.out.println("L'usuari que s'ha apuntat a més tallers és " + llisR.usuarimesapuntat());
	}

	// 9. Registrar la nota que un usuari que s’ha apuntat a un taller li dona un
	// cop s’ha fet.");
	private static void op9(LlistaReserves llisR, Scanner teclat) { // FALTA MÈTODE A RESERVES

		System.out.println("Introdueix la nota que li poses al taller: ");
		String reserva = (teclat.nextLine());
		System.out.println("Introdueix la nota que li poses al taller: ");
		float nota;
		nota = Float.parseFloat(teclat.nextLine());
		/* llisR.valorartaller(nota, reserva); */

	}

	// 10. Calcular la nota mitja que ha rebut un taller.");
	private static void op10(LlistaActivitats llisA, Scanner teclat) {
		System.out.println("Introdueix el nom del taller: ");
		String nom = teclat.nextLine();
		System.out.println("La nota mitjana del taller és de " + llisA.notaMitjanaTaller(nom));
	}

	// 11. Quin és el taller que ha tingut més èxit? C");
	private static void op11(LlistaActivitats llisA) {
		System.out.println("El taller que ha tingut més èxit ha estat:\n" + llisA.tallerExit());
	}

	// 12. Obtenir i mostrar les dades de la llista de visites ofertes per una
	// entitat");
	private static void op12(LlistaActivitats llisA, Scanner teclat) {
		String nom;
		System.out.println("Introdueix la entitat que vols buscar");
		nom = teclat.nextLine();
		System.out.println(llisA.visitesMateixaEntitat(nom));
	}

	// 13. Mostrar les dades de les xerrades que farà una persona concreta.");
	private static void op13(LlistaActivitats llisA, Scanner teclat) {
		String nom;
		System.out.println("Quina persona vols buscar");
		nom = teclat.nextLine();
		System.out.println(llisA.xerradesMateixaPersona(nom));
	}

	// 14. Donar de baixa un taller sempre que no hi hagi usuaris apuntats.");
	private static void op14(LlistaActivitats llisA, Scanner teclat) {
		System.out.println("Introdueix el codi del taller: "); // FEM SERVIR EL CODI?
		if (llisA.eliminarTaller(teclat.nextLine()))
			System.out.println("S'ha eliminat amb èxit!");
		else
			System.out.println("No s'ha pogut eliminar.");
	}
}
