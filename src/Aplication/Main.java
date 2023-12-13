package Aplication;

import Classes.Entitats;
import Classes.Usuaris;
import Classes.Llista;

public class Main {
    /*Mètode merament estètic per mostrar entitat, es pot esborrar.  
     * @param entitat que es vol mostrar
    */
    public static void mostraentitat(Entitats entitat){
        System.out.println(entitat.toString());
    }
    /*Mètode merament estètic per mostrar un usuari, es pot esborrar.
     * @param usuari que es vol mostrar
     */
    public static void mostraUsuari(Usuaris usuari){
        System.err.println(usuari.toString());
    }

    public static void mostraLlista(Llista llista){
        System.err.println(llista.toString());
    }
    
}
