package Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//Authors: Genís Aragonès Torralbo

public class LlistaUsuaris extends Llista<Usuaris>{
    private Usuaris[] llista;

    /**
     * Constructor
     * @param capacitat
     */
    public LlistaUsuaris(){
        super();
        llista = new Usuaris[1000];
    }

    /** 
     * Métode de afegir un usuari comprovant que l'usuari no existeixi sino directament la descarta
     * @param nom
     * @param mail
     * @param codi
     */
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

    /* Mètode que llegeix el contingut del fitxer llista_usuaris.txt 
    *  ATENCIO: AQUEST MÈTODE SEMPRE S'HA DE FER ABANS DE COMENÇAR AMB EL PROGAMA
     * JA QUE ES DONA PER SUPOSAT QUE NO DONA MAI MÉS GRAN QUE LA LENGTH 
     * NI HI HA CAP NICKNAME IGUAL(JA QUE TOT EL QUE HI HA A L'ARXIU JA ESTA CORRECTE).
     * AL MAIN S'HA DE FER A LES PRIMERES LINIES.
     * SI NO POT OCASIONAR PROBLEMES A LA LLISTA
     */
    /**
     * Mètode que llegeix el contingut del fitxer llista_usuaris.txt
     * @param nomarxiu
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
                try{
                    this.agregar(usuari);
                }
                catch(Excepcions e){
                    System.out.println("M'ha saltal la línea");
                }
                
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error 404 not found");
        }

    }
    
    /** 
     * Métode de afegir un usuari comprovant que l'usuari no existeixi sino directament la descarta
     * @param n - instància d'usuaris
     */
    public void agregar(Usuaris n) throws Excepcions{
        if(nElem < llista.length){{
                try{
                    nicknameigual(n.getNickname());
                    llista[nElem] = n.copia();
                    nElem++;
                }catch(RuntimeException e){
                    throw new Excepcions("El nickname ja està ficat");
                }
            }
        }
    }

    /**
     * Getter de nElem
     * @return nElem
     */
    public int tamano(){
        return nElem;
    }

    /**
     * Mètode que elimina una instància d'usuaris
     * @param n - instància d'usuaris
     */
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
    /**
     * Mètode per guardar la llista al arxiu Llista_usuaris.txt
     * @param nomarxiu
     */
    public void guardarArxiu(String nomarxiu){
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
     * Mètode que comprova que el nickname no està a la llista
     * @param nom
     * @return true si hi és, false si no hi es
     */
    public boolean nicknameigual(String nom) throws RuntimeException{
        Boolean trobat = false;
        for(int i = 0; i<nElem; i++){
            if(llista[i].getNickname().equalsIgnoreCase(nom)){
                trobat = true;
                throw new RuntimeException("El nickname está usat.");
            } 
        }
        return trobat;  
    }

    /**
     * Mètode que buida l'arxiu
     */
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

    /**
     * Mètode que troba un usuari determinat a través dels seus atributs
     * @param nom
     * @param mail
     * @param codiPostal
     * @return null si no s'ha trobat, sino es retorna l'usuari
     */
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

    /**
     * Mètode actualitza el nombre de tallers als que està apuntat un usuari
     * @param u - instància d'usuaris
     */
    public void actualitzarApuntats(Usuaris u){
        boolean trobat = false;
        for (int i = 0; i < nElem && !trobat; i++){
            if (llista[i].igual(u)){
                if (llista[i].getTallerApuntats() != u.getTallerApuntats()) llista[i].setTallerApuntats(u.getTallerApuntats());
                trobat = true;
            }
        }
    }

    /**
     * Mètode que busca quin usuari s'ha apuntat a més tallers
     * @return usuari que s'ha apuntat a més tallers
     */
    public Usuaris usuarimesapuntat() {
        int max = 0;
        Usuaris usuarimesapuntat = null;
        for (int i = 0; i < nElem; i++) {
            if (llista[i].getTallerApuntats() > max) {
                max = llista[i].getTallerApuntats();
                usuarimesapuntat = llista[i].copia();
            }
        }
        return usuarimesapuntat.copia();
    }

    /**
     * Crida a toString
     */
    public void imprimir() {
        System.out.println(toString());
    }

    /**
     * Mètode que comprova si la llista conté un usuari concret
     * @param elemento - instància d'usuaris
     * @return true si ja existeix, false si no existeix
     */
    @Override
    public boolean contiene(Usuaris elemento) {
        boolean conte = false;
        for(int i = 0; i<nElem; i++){
            if(llista[i].igual(elemento)) conte= true;
        }
        return conte;
    }
    
}
