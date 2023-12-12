package Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*Classe de llista usuaris, amb el seu constructor, com que no tinc decidit fer la excepcio del nickname, que suposo que al main, he fet
 * un mètode auxiliar per controlar que no hi ha cap nicnkame igual a la llista. S'hauria de implementar una excepcio, més endevant ho
 * intentaré :)
 */

public class LlistaUsuaris extends Llista{
    
    private Usuaris[] llista;
    /*Constructor
     * @param mida de la llista
     */
    public LlistaUsuaris(){
        super();
        llista = new Usuaris[1000];
    }

    /*Mètode afegir pasant tot per paràmetre i comprovant que no hi ha cap nickname igual,
     * més endavant s'ha d'implementar el escriure al fitxer cada entitat quan es fiqui a la llista
     * @param nom/nickanme
     * @param mail
     * @param codi Postal
     */
    /*Se podria borrar el mètode, pero encara no. */
    public void afegir(String nom, String mail, int codi){
        if(nElem<llista.length){
            boolean afegit = false;
            while (!afegit) {
                try{
                    nicknameigual(nom);
                    Usuaris usuari = new Usuaris(nom, mail, codi);
                    llista[nElem] = usuari.copia();
                    nElem++;
                    guardarArxiu(usuari);
                    afegit = true;
                }catch(RuntimeException e){
                    System.out.println(e.getMessage());
                    System.out.println("Introduce otro nickname");
                    /*Leer otro nickname */
                }
            }
        }
    }

    /*Mètode auxiliar per afegir un usuari de l'arxiu llista_usuaris.txt a la llista sense copiar al arxiu per no tenir duplicats.
     * També es podria fer dins al bucle de llegirfitxer, era per fer-ho més elegant :) 
     */
    public void afegirsensecopiar(Usuaris usuari){
                llista[nElem] = usuari.copia();
                nElem++;
    }

    /* Mètode que llegeix el contingut del fitxer llista_usuaris.txt 
    *  ATENCIO: AQUEST MÈTODE SEMPRE S'HA DE FER ABANS DE COMENÇAR AMB EL PROGAMA
     * JA QUE ES DONA PER SUPOSAT QUE NO DONA MAI MÉS GRAN QUE LA LENGTH 
     * NI HI HA CAP NICKNAME IGUAL(JA QUE TOT EL QUE HI HA A L'ARXIU JA ESTA CORRECTE).
     * AL MAIN S'HA DE FER A LES PRIMERES LINIES.
     * 
     */
    public void llegirfitxer(){
        String nombreArchivo = "Llista_usuaris.txt";
        File file = new File("src", nombreArchivo);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String llegit = scanner.nextLine();
                System.out.println("Leegida: " + llegit + "\n");
                String[] parts = llegit.split(",");
                String nom = parts[0].trim();
                String mail = parts[1].trim();
                int codi = Integer.parseInt(parts[2].trim());
                Usuaris usuari = new Usuaris(nom, mail, codi);
                this.afegirsensecopiar(usuari);
                
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + nombreArchivo);
        }

    }

    /*Mètode afegir pasant un usuari directament que també comprova que no hi ha cap nickname igual,
     * més endavant s'ha d'implementar el escriure al fitxer cada entitat quan es fiqui a la llista
     * @param usuari
     */
    public void afegir(Usuaris n){
        if(nElem < llista.length){
            boolean afegit = false;
            while (!afegit) {
                try{
                    nicknameigual(n.getNickname());
                    llista[nElem] = n.copia();
                    nElem++;
                    guardarArxiu(n);
                    afegit = true;
                }catch(RuntimeException e){
                    System.out.println(e.getMessage());
                    System.out.println("Introduce otro nickname");
                    /*Leer otro nickname */
                }
            }
    }
}


    /*Mètdoe per guardar un usuari al arxiu Llista_usuaris.txt */
    public void guardarArxiu(Usuaris n){
        String nombreArchivo = "Llista_usuaris.txt";

        // Obtener la ruta absoluta del archivo
        String rutaAbsoluta = new File("src", nombreArchivo).getAbsolutePath();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaAbsoluta, true))){
            bw.write(n.getNickname() + "," + n.getMail() + "," + n.getCodiPostal());
            bw.newLine();
            System.out.println("Guardat\n");
        }
        catch (IOException e){
            System.out.println("Error\n");
        }

    }

    @Override
    public String toString() {
            String text = "";
            for (int i = 0; i < nElem; i++) {
                text = text + llista[i] + "\n";
            }
            return text;
    }

    /*Mètode que comprova que el nickname no està a la llista*/
    private boolean nicknameigual(String nom){
        boolean trobat = false;
        for(int i = 0; i<nElem; i++){
            if(llista[i].getNickname().equalsIgnoreCase(nom)) throw new RuntimeException("El nickname ya está en uso.");
        }
       return trobat;   
    }
    
}
