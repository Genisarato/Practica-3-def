package Aplication;

import java.util.Scanner;

import Classes.Entitats;
import Classes.Usuaris;
import Classes.Llista;

public class Main {
	int opcio;
	Scanner teclat = new Scanner(System.in);
	do{
		printfMenu();
		do { // comprovem que no fiqui un valor fora del rang
			opcio = Integer.parseInt(teclat.nextLine());
		} while (opcio < 0 && opcio > 15);
		switch (opcio) {
			// Mostrar les dades de qualsevol llista que tingueu definida.
			case 1:
				System.out.print("\nHas escollit mostrar les dades de qualsevol llista que tingueu definida.");
				break;
			case 2:
				System.out.println("\nHas escollit obtenir i mostrar la llista d’activitats que ofereix una entitat concreta.");
				op2();
				break;

			// Obtenir i mostrar la llista de les activitats que es duen a terme en un dia
			// indicat per teclat.
			case 3:
				System.out.println("\nHas escollit obtenir i mostrar la llista de les activitats que es duen a terme en un dia indicat per teclat.");
				break;

			// Obtenir i mostrar la llista dels tallers que tenen places disponibles.
			case 4:
				System.out.println("\nHas escollit obtenir i mostrar la llista dels tallers que tenen places disponibles.");
				break;

			// Afegir una nova activitat
			case 5:
				System.out.println("\nHas escollit afegir una nova activitat");
				break;

			// Registrar la petició d’un usuari per reservar un taller.
			case 6:
				System.out.println("\nHas escollit registrar la petició d’un usuari per reservar un taller.");
				/*Genis */
				break;

			// Mostrar els usuaris que s’han apuntat a un taller.
			case 7:
				System.out.println("\nHas escollit mostrar els usuaris que s’han apuntat a un taller.");
				/*Genis */
				break;

			// Calcular l’usuari que s’ha apuntat a més tallers.
			case 8:
				System.out.println("\nHas escollit calcular l’usuari que s’ha apuntat a més tallers.");
				break;

			// Registrar la nota que un usuari que s’ha apuntat a un taller li dona un cop
			// s’ha fet.
			case 9:
				System.out.println(
						"\nHas escollit registrar la nota que un usuari que s’ha apuntat a un taller li dona un cop s’ha fet.");
				break;
			// Calcular la nota mitja que ha rebut un taller.
			case 10:
				System.out.println("\nHas escollit calcular la nota mitja que ha rebut un taller.");
				break;
			// Quin és el taller que ha tingut més èxit?
			case 11:
				System.out.println("\nHas escollit quin és el taller que ha tingut més èxit?");
				break;
			// Obtenir i mostrar les dades de la llista de visites ofertes per una entitat
			case 12:
				System.out.println(
						"\nHas escollit obtenir i mostrar les dades de la llista de visites ofertes per una entitat");
				break;
			// Mostrar les dades de les xerrades que farà una persona concreta.
			case 13:
				System.out.println("\nHas escollit mostrar les dades de les xerrades que farà una persona concreta.");
				break;
			// Donar de baixa un taller sempre que no hi hagi usuaris apuntats.
			case 14:
				System.out.println("\nHas escollit donar de baixa un taller sempre que no hi hagi usuaris apuntats.");
				break;
			// Sortir del programa
			case 15:
				break;
		}
	}while(opcio!=15);
	System.out.println("Has sortit del programa amb èxit!");
	// Obtenir i mostrar la llista d’activitats que ofereix una entitat concreta.

	// Mostrar el menú d'opcions
	private static void printfMenu() {
        System.out.println("\nIntrodueix el número de la operació que vulguis realitzar\n");
		System.out.println("\n\t1. Mostrar les dades de qualsevol llista que tingueu definida.\n");
		System.out.println("\t2. Obtenir i mostrar la llista d’activitats que ofereix una entitat concreta.");
		System.out.println("\t3. Obtenir i mostrar la llista de les activitats que es duen a terme en un dia indicat per teclat.");
		System.out.println("\t4. Obtenir i mostrar la llista dels tallers que tenen places disponibles.");
		System.out.println("\t5. Afegir una nova activitat ");
		System.out.println("\t6. Registrar la petició d’un usuari per reservar un taller.");
		System.out.println("\t7. Mostrar els usuaris que s’han apuntat a un taller.");
		System.out.println("\t8. Calcular l’usuari que s’ha apuntat a més tallers.");
		System.out.println("\t9. Registrar la nota que un usuari que s’ha apuntat a un taller li dona un cop s’ha fet.");
        System.out.println("\t10. Calcular la nota mitja que ha rebut un taller.");
        System.out.println("\t11. Quin és el taller que ha tingut més èxit?");
        System.out.println("\t12. Obtenir i mostrar les dades de la llista de visites ofertes per una entitat");
        System.out.println("\t13. Mostrar les dades de les xerrades que farà una persona concreta.");
        System.out.println("\t14. Donar de baixa un taller sempre que no hi hagi usuaris apuntats.");
		System.out.println("\t15. Sortir de l'aplicació");
		System.out.print("\n\tIndica opcio: ");
	}

	/*
	 * Mètode merament estètic per mostrar entitat, es pot esborrar.
	 * 
	 * @param entitat que es vol mostrar
	 */
	public static void mostraentitat(Entitats entitat) {
		System.out.println(entitat.toString());
	}

	/*
	 * Mètode merament estètic per mostrar un usuari, es pot esborrar.
	 * 
	 * @param usuari que es vol mostrar
	 */
	public static void mostraUsuari(Usuaris usuari) {
		System.err.println(usuari.toString());
	}

	public static void mostraLlista(Llista llista) {
		System.err.println(llista.toString());
	}

	public void op2(){
		
	}

}
