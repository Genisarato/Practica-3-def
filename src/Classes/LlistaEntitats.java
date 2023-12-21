package Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*Authors: Genís Aragonès Torralbo */
public class LlistaEntitats extends Llista<Entitats>{
    private Entitats[] llista;

    /*Constructor*/
    public LlistaEntitats(){
        super();
        llista = new Entitats[1000];
    }

     /*Mètode afegir pasant tot per paràmetre
     * més endavant s'ha d'implementar el escriure al fitxer cada entitat quan es fiqui a la llista
     * @param nom entitat
     * @param mail
     * @param codi Telefon(TO DO fer el comprovar que el telefon es de 9 xifres)
     */
    /*Es podria borrar el mètode, pero encara no. */
    public void agregar(String n, int telef, String mail) {
        if(nElem < llista.length){
            Entitats copia = new Entitats(n, telef, mail);
            llista[nElem] = copia;
            nElem++;
            guardarArxiu(copia);
        }
    }

    /*Mètode afegir pasant una entitat directament
     * més endavant s'ha d'implementar el escriure al fitxer cada entitat quan es fiqui a la llista
     * @param entitat
     */
    public void agregar(Entitats n){
        if(nElem < llista.length){
            llista[nElem] = n.copia();
            nElem++;
            guardarArxiu(n);    
        }
    }

     /* Mètode que llegeix el contingut del fitxer llista_entitats.txt 
    *  ATENCIO: AQUEST MÈTODE SEMPRE S'HA DE FER ABANS DE COMENÇAR AMB EL PROGAMA
     * JA QUE ES DONA PER SUPOSAT QUE NO DONA MAI MÉS GRAN QUE LA LENGTH.
     * SI ES FA DESPRÉS POT OCASIONAR PROBLEMES
     */
    public void llegirfitxer(){
        String nomarxiu = "Llista_entitats.txt";
        File file = new File("src", nomarxiu);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String llegit = scanner.nextLine();
                String[] parts = llegit.split(",");
                String nom = parts[0].trim();
                String mail = parts[1].trim();
                int telef = Integer.parseInt(parts[2].trim());
                Entitats entitats = new Entitats(nom, telef, mail);
                this.afegirsensecopiar(entitats);
                
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + nomarxiu);
        }

    }

    /*Mètode auxiliar per afegir una entitat de l'arxiu llista_entitats.txt a la llista sense copiar al arxiu per no tenir duplicats.
     * També es podria fer dins al bucle de llegirfitxer, era per fer-ho més elegant :) 
     */
    private void afegirsensecopiar(Entitats entitats){
        llista[nElem] = entitats.copia();
        nElem++;
    }

    /*Mètdoe per guardar una entitat al arxiu Llista_entitats.txt */
    public void guardarArxiu(Entitats n){
        String nomarxiu = "Llista_entitats.txt";

        String rutaAbsoluta = new File("src", nomarxiu).getAbsolutePath();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaAbsoluta, true))){
            bw.write(n.getNom() + "," + n.getMail() + "," + n.getTelef());
            bw.newLine();
            System.out.println("Guardat\n");
            bw.flush();
        }
        catch (IOException e){
            System.out.println("Error\n");
        }

    }
    /*toString */
    @Override
    public String toString() {
            String text = "";
            for (int i = 0; i < nElem; i++) {
                text = text + llista[i] + "\n";
            }
            return text;
    }

    
    public int tamano(){
        return nElem;
    }

    public void eliminar(Entitats entitat){
        int j = -1;
        int i;
        for(i = 0; i<nElem && j == -1; i++){
            if(llista[i].esIgual(entitat)) j = i;
        }
        if(j != -1){
            while (j<nElem-1){
                llista[j] = llista[j+1];
                j++;
            }
            nElem--;
        }
    }

    public void vaciar(){
        nElem = 0;
        String nomarxiu = "Llista_entitats.txt";

        String rutaAbsoluta = new File("src", nomarxiu).getAbsolutePath();
        try (PrintWriter writer = new PrintWriter(rutaAbsoluta)) {
            // Simplemente cierra el archivo sin escribir nada, lo que borra su contenido.
        } catch (IOException e) {
            System.out.println("Error al intentar vaciar el archivo: " + e.getMessage());
        }
    }

    public void imprimir(){
        System.out.println(toString());
    }

    public boolean contiene(Entitats entitat){
        boolean conte = false;
        for(int i = 0; i<nElem; i++){
            if(llista[i].esIgual(entitat)) conte = true;
        }
        return conte;
    }


    
    
}
