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

public class LlistaUsuaris extends Llista<Usuaris>{
    
    private Usuaris[] llista;
    /*Constructor*/
    public LlistaUsuaris(int capacitat){
        super();
        llista = new Usuaris[capacitat];
    }

    
    /** 
     * @param nom
     * @param mail
     * @param codi
     */
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
     *
    private void afegirsensecopiar(Usuaris usuari){
                llista[nElem] = usuari.copia();
                nElem++;
    }*/

    /* Mètode que llegeix el contingut del fitxer llista_usuaris.txt 
    *  ATENCIO: AQUEST MÈTODE SEMPRE S'HA DE FER ABANS DE COMENÇAR AMB EL PROGAMA
     * JA QUE ES DONA PER SUPOSAT QUE NO DONA MAI MÉS GRAN QUE LA LENGTH 
     * NI HI HA CAP NICKNAME IGUAL(JA QUE TOT EL QUE HI HA A L'ARXIU JA ESTA CORRECTE).
     * AL MAIN S'HA DE FER A LES PRIMERES LINIES.
     * SI NO POT OCASIONAR PROBLEMES A LA LLISTA
     * 
     */
    public void llegirfitxer(String nomarxiu){
        File file = new File("src", nomarxiu);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String llegit = scanner.nextLine();
                //pasaallista();
                String[] parts = llegit.split(";");
                String nom = parts[0].trim();
                String mail = parts[1].trim();
                int codi = Integer.parseInt(parts[2].trim());
                int tallerApuntats = Integer.parseInt(parts[3].trim());
                Usuaris usuari = new Usuaris(nom, mail, codi, tallerApuntats);
                this.agregar(usuari);
                
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error 404 not found");
        }

    }
    

    
    /** 
     * @param n
     */
    /*Mètode afegir pasant un usuari directament que també comprova que no hi ha cap nickname igual,
     * més endavant s'ha d'implementar el escriure al fitxer cada entitat quan es fiqui a la llista
     * @param usuari
     */
    public void agregar(Usuaris n){
        if(nElem < llista.length){
            boolean afegit = false;
            while (!afegit){
                if (!nicknameigual(n.getNickname())){
                    llista[nElem] = n.copia();
                    nElem++;
                    afegit = true;
                }

                /*try{
                    nicknameigual(n.getNickname());
                    llista[nElem] = n.copia();
                    nElem++;
                    afegit = true;
                }catch(RuntimeException e){
                    System.out.println(e.getMessage());
                    System.out.println("Introdueix un altre nickname");
                    //Implementar llegir un altre nickname i el setNickname
                }*/
            }
        }
    }

    public int tamano(){
        return nElem;
    }

    public void eliminar(Usuaris n){
        int j = 0;
        boolean trobat = false;
        int i;
        for(i = 0; i < nElem && !trobat; i++){
            if(llista[i].igual(n)){
                j = i;
                trobat = true;
            }  
        }
        if(j != -1){
            while(j<nElem-1){
                llista[j] = llista[j+1];
                j++;
            }
            nElem--;
        }
    }


    /*Mètdoe per guardar la llista al arxiu Llista_usuaris.txt
     * ATENCIO: S'HA DE FER UNA VEGADA S'HAN FINALITZAT LES OPERACIONS DE LA LLISTA: AGREGAR, BORRAR, ETC..
     * I ABANS DE TANCAR EL PROGAMA, SINÓ ES PERDRA TOT EL CONTINUGT DE LLISTA NO GUARDAT ANTERIORMENT, JA QUE
     * EL MÉTODE ELIMINAR ERA MÉS FÀCIL LA IMPLEMENTACIÓ AIXÍ I ÉS MÉS EFICIENT
     */
    public void guardarArxiu(){
        String nomarxiu = "Llista_usuaris.txt";

        String rutaAbsoluta = new File("src", nomarxiu).getAbsolutePath();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaAbsoluta))){
            for(int i = 0; i <nElem; i++){
                bw.write(llista[i].getNickname() + ";" + llista[i].getMail() + ";" +llista[i].getCodiPostal() + ";" + llista[i].getTallerApuntats());
                if (i != nElem - 1) bw.newLine();
            }
            System.out.println("Guardat\n");
            bw.close();
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
    public boolean nicknameigual(String nom){
        boolean trobat = false;
        for(int i = 0; i<nElem; i++){
            if(llista[i].getNickname().equalsIgnoreCase(nom)) trobat = true; //throw new RuntimeException("El nickname está usat.");
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

    public Usuaris trobaUsuari(String nom, String mail, int codiPostal){
        boolean trobat = false;
        int i;
        Usuaris u = null;
        for (i = 0; i < nElem && !trobat; i++){
            if ((llista[i].getNickname().equalsIgnoreCase(nom)) && (llista[i].getMail().equalsIgnoreCase(mail)) && (llista[i].getCodiPostal() == codiPostal)){
                trobat = true;
                u = llista[i];
            }
        }
        return u;
    }

    public void actualitzarApuntats(Usuaris u){
        boolean trobat = false;
        for (int i = 0; i < nElem && !trobat; i++){
            if (llista[i].igual(u)){
                if (llista[i].getTallerApuntats() != u.getTallerApuntats()) llista[i].setTallerApuntats(u.getTallerApuntats());
                trobat = true;
            }
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
