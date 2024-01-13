package Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class LlistaEntitats extends Llista<Entitats>{
    private Entitats[] llista;

    /**
     * Constructor
     * @param capacitat
     */
    public LlistaEntitats(int capacitat){
        super();
        llista = new Entitats[capacitat];
    }

    
    /** 
     * Mètode que afegeix la còpia d'una entitat a la última posició disponible de la llista 
     * @param n
     * @param telef
     * @param mail
     */
    public void agregar(String n, int telef, String mail) {
        if(nElem < llista.length){
            Entitats copia = new Entitats(n, telef, mail);
            llista[nElem] = copia;
            nElem++;
        }
    }

    
    /** 
     * Mètode que afegeix la còpia d'una entitat a la última posició disponible de la llista
     * @param n - instància a afegir
     */
    public void agregar(Entitats n){
        if(nElem < llista.length){
            llista[nElem] = n.copia();
            nElem++;   
        }
    }

     /*
     *  ATENCIO: AQUEST MÈTODE SEMPRE S'HA DE FER ABANS DE COMENÇAR AMB EL PROGAMA
     * JA QUE ES DONA PER SUPOSAT QUE NO DONA MAI MÉS GRAN QUE LA LENGTH.
     * SI ES FA DESPRÉS POT OCASIONAR PROBLEMES
     */
    /**
     * Mètode que llegeix el contingut del fitxer llista_entitats.txt 
     * @param nomarxiu
     */
    public void llegirfitxer(String nomarxiu){
       
        File file = new File("src", nomarxiu);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String llegit = scanner.nextLine();
                String[] parts = llegit.split(";");
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

    /**
     * Mètode auxiliar per afegir una entitat de l'arxiu llista_entitats.txt a la llista sense copiar al arxiu per no tenir duplicats.
     * @param entitats
     */
    private void afegirsensecopiar(Entitats entitats){  
        llista[nElem] = entitats.copia();
        nElem++;
    }

    /*
     * ATENCIO: S'HA DE FER UNA VEGADA S'HAN FINALITZAT LES OPERACIONS DE LA LLISTA: AGREGAR, BORRAR, ETC..
     * I ABANS DE TANCAR EL PROGAMA, SINÓ ES PERDRA TOT EL CONTINUGT DE LLISTA NO GUARDAT ANTERIORMENT, JA QUE
     * EL MÉTODE ELIMINAR ERA MÉS FÀCIL LA IMPLEMENTACIÓ AIXÍ I ÉS MÉS EFICIENT
     */
    /**
     * Mètode per guardar la llista al arxiu Llista_entitats.txt
     * @param nomarxiu
     */
    public void guardarArxiu(String nomarxiu){
        String rutaAbsoluta = new File("src", nomarxiu).getAbsolutePath();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaAbsoluta))){
            for(int i = 0; i <nElem; i++){
                bw.write(llista[i].getNom() + ";" + llista[i].getMail() + ";" +llista[i].getTelef());
                if (i != nElem - 1) bw.newLine();
            }
            System.out.println("Guardat\n");
            bw.close();
        }
        catch (IOException e){
            System.out.println("Error\n");
        }

    }

    /**
     * toString
     */
    @Override
    public String toString() {
            String text = "";
            for (int i = 0; i < nElem; i++) {
                text = text + llista[i] + "\n";
            }
        return text;
    }

    /**
     * Getter
     * @return nElem
     */
    public int tamano(){
        return nElem;
    }

    /**
     * Mètode que elimina una instància d'entitat
     * @param entitat - instància a eliminar
     */
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

    /**
     * Mètode que buida un fitxer
     */
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

    /**
     * Crida a toString
     */
    public void imprimir(){
        System.out.println(toString());
    }

    /**
     * Mètode que comprova si la llista conté una instància d'entitats específica
     * @param entitat - instància a buscar
     * @return true si sí hi és o false si no hi és
     */
    public boolean contiene(Entitats entitat){
        boolean conte = false;
        for(int i = 0; i<nElem; i++){
            if(llista[i].esIgual(entitat)) conte = true;
        }
        return conte;
    }




    
    
}
