package Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*Classe de llista usuaris, amb el seu constructor, com que no tinc decidit fer la excepcio del nickname, que suposo que al main, he fet
 * un mètode auxiliar per controlar que no hi ha cap nicnkame igual a la llista. S'hauria de implementar una excepcio, més endevant ho
 * intentaré :)
 */
/*Authors: Genís Aragonès Torralbo */
public class LlistaUsuaris extends Llista<Usuaris>{
    
    private Usuaris[] llista;
    /*Constructor*/
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
    /*Es podria borrar el mètode, pero encara no. */
    public void agregar(String nom, String mail, int codi){
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
                    System.out.println("Introdueix un altre nickname");
                    /*Implementar llegir un altre nickname i el setNickname*/
                }
            }
        }
    }

    /*Mètode auxiliar per afegir un usuari de l'arxiu llista_usuaris.txt a la llista sense copiar al arxiu per no tenir duplicats.
     * També es podria fer dins al bucle de llegirfitxer, era per fer-ho més elegant :) 
     */
    private void afegirsensecopiar(Usuaris usuari){
                llista[nElem] = usuari.copia();
                nElem++;
    }

    /* Mètode que llegeix el contingut del fitxer llista_usuaris.txt 
    *  ATENCIO: AQUEST MÈTODE SEMPRE S'HA DE FER ABANS DE COMENÇAR AMB EL PROGAMA
     * JA QUE ES DONA PER SUPOSAT QUE NO DONA MAI MÉS GRAN QUE LA LENGTH 
     * NI HI HA CAP NICKNAME IGUAL(JA QUE TOT EL QUE HI HA A L'ARXIU JA ESTA CORRECTE).
     * AL MAIN S'HA DE FER A LES PRIMERES LINIES.
     * SI NO POT OCASIONAR PROBLEMES A LA LLISTA
     * 
     */
    public void llegirfitxer(){
        String nomarxiu= "Llista_usuaris.txt";
        File file = new File("src", nomarxiu);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String llegit = scanner.nextLine();
                //pasaallista();
                String[] parts = llegit.split(",");
                String nom = parts[0].trim();
                String mail = parts[1].trim();
                int codi = Integer.parseInt(parts[2].trim());
                Usuaris usuari = new Usuaris(nom, mail, codi);
                this.afegirsensecopiar(usuari);
                
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error 404 not found");
        }

    }
    

    /*Mètode afegir pasant un usuari directament que també comprova que no hi ha cap nickname igual,
     * més endavant s'ha d'implementar el escriure al fitxer cada entitat quan es fiqui a la llista
     * @param usuari
     */
    public void agregar(Usuaris n){
        if(nElem < llista.length){
            boolean afegit = false;
            while (!afegit){
                try{
                    nicknameigual(n.getNickname());
                    llista[nElem] = n.copia();
                    nElem++;
                    guardarArxiu(n);
                    afegit = true;
                }catch(RuntimeException e){
                    System.out.println(e.getMessage());
                    System.out.println("Introdueix un altre nickname");
                    /*Implementar llegir un altre nickname i el setNickname*/
                }
            }
    }
}

    public int tamano(){
        return nElem;
    }

    public void eliminar(Usuaris n){
        int j = -1;
        int i;
        for(i = 0; i < nElem && j == -1; i++){
            if(llista[i].igual(n))  j = i;
        }
        if(j != -1){
            while(j<nElem-1){
                llista[j] = llista[j+1];
                j++;
            }
            nElem--;
        }
    }


    /*Mètdoe per guardar un usuari al arxiu Llista_usuaris.txt */
    public void guardarArxiu(Usuaris n){
        String nomarxiu = "Llista_usuaris.txt";

        String rutaAbsoluta = new File("src", nomarxiu).getAbsolutePath();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaAbsoluta, true))){
            bw.write(n.getNickname() + "," + n.getMail() + "," + n.getCodiPostal());
            bw.newLine();
            System.out.println("Guardat\n");
            bw.flush();
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
            if(llista[i].getNickname().equalsIgnoreCase(nom)) throw new RuntimeException("El nickname está usat.");
        }
       return trobat;   
    }

    public void vaciar(){
        nElem = 0;
        String nomarxiu = "Llista_usuaris.txt";

        String rutaAbsoluta = new File("src", nomarxiu).getAbsolutePath();
        try (PrintWriter writer = new PrintWriter(rutaAbsoluta)) {
            // Simplemente cierra el archivo sin escribir nada, lo que borra su contenido.
        } catch (IOException e) {
            System.out.println("Error al intentar vaciar el archivo: " + e.getMessage());
        }
    }



    public void imprimir() {
        System.out.println(toString());
    }

    @Override
    public boolean contiene(Usuaris elemento) {
        boolean conte = false;
        for(int i = 0; i<nElem; i++){
            if(llista[i].igual(elemento)) conte= true;
        }
        return conte;
    }
    
}
