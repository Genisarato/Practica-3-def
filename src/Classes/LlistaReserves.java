package Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*Authors: Genís Aragonès Torralbo */

public class LlistaReserves extends Llista<Reserves>{
    private Reserves[] llista;

    /*Constructor
     */
    public LlistaReserves(){
        super();
        llista = new Reserves[1000];
    }

    /*Métode de afegir una reserva comprovant que la reserva no estigui feta sino directament la descarta
     * @param Reserva
     */
    public void agregar(Reserves n){
        if(nElem < llista.length){
            try{
                comprovaReserva(n);
                llista[nElem] = n.copia();
                nElem++;
            }catch(Excepcions e){
                System.out.println(e.getMessage());
            }
        }
    }

    /*Métode de afegir un usuari i un taller, que es transforma amb una reserva  comprovant també que la reserva no estigui feta, sinó la descarta
     * @Usuari
     * @taller
    */
    public void agregar(Usuaris u, Tallers taller) {
        if(nElem < llista.length){
            try{
                Reserves copia = new Reserves(u, taller);
                comprovaReserva(copia);
                llista[nElem] = copia;
                nElem++;
            } catch(Excepcions e){
                System.out.println(e.getMessage());
            }
        }
    }

    /*Mètdoe per guardar la llista al arxiu Llista_reserves.txt
     * ATENCIO: S'HA DE FER UNA VEGADA S'HAN FINALITZAT LES OPERACIONS DE LA LLISTA: AGREGAR, BORRAR, ETC..
     * I ABANS DE TANCAR EL PROGAMA, SINÓ ES PERDRA TOT EL CONTINUGT DE LLISTA NO GUARDAT ANTERIORMENT, JA QUE
     * EL MÉTODE ELIMINAR ERA MÉS FÀCIL LA IMPLEMENTACIÓ AIXÍ I ÉS MÉS EFICIENT
     */
    public void guardarArxiu(){
        String nomarxiu = "Llista_reserves.txt";

        String rutaAbsoluta = new File("src", nomarxiu).getAbsolutePath();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaAbsoluta))){
            for(int i = 0; i <nElem; i++){
                bw.write(llista[i].getCodiReserva() + "," + llista[i].getUsuari() + "," +llista[i].getTallers());
                bw.newLine();
                System.out.println("Guardat\n");
            }
            bw.close();
        }
        catch (IOException e){
            System.out.println("Error\n");
        }
    }
    
    /*Métode toString */
    @Override
    public String toString() {
        String text = "";
        for (int i = 0; i < nElem; i++) {
            text = text + llista[i] + "\n";
        }
        return text;
    }

    /*Métode que retorna el número d'elements */
    public int tamano(){
        return nElem;
    }

    /*Void que elimina una reserva en específic */
    public void eliminar(Reserves reserves){
        int j = 0;
        boolean trobat = false;
        int i;
        for(i = 0; i<nElem && !trobat; i++){
            if(llista[i].esIgual(reserves)){
              j = i; 
              trobat = true; 
            } 
        }
        if(j != -1){
            while (j<nElem-1){
                llista[j] = llista[j+1];
                j++;
            }
            nElem--;
        }
    }

    /*Métode que buida la llista i l'arxiu
     * ATENCIÓ: BORRA TOT L'ARXIU, EN CUIDADO QUAN ES CRIDA AL MÉTODE
     */
    public void vaciar(){
        nElem = 0;
        String nomarxiu = "Llista_reserves.txt";

        String rutaAbsoluta = new File("src", nomarxiu).getAbsolutePath();
        try (PrintWriter writer = new PrintWriter(rutaAbsoluta)) {
            // Simplemente cierra el archivo sin escribir nada, lo que borra su contenido.
        } catch (IOException e) {
            System.out.println("Error al intentar vaciar el archivo: " + e.getMessage());
        }
    }
    /*Métode que mostra la llista per pantalla */
    public void imprimir(){
        System.out.println(toString());
    }

    /*Métode que retorna un boolea comforme una reserva está dins la llista o no
     * @param Reserva
     */
    public boolean contiene(Reserves reserva){
        boolean conte = false;
        for(int i = 0; i<nElem; i++){
            if(llista[i].esIgual(reserva)) conte = true;
        }
        return conte;
    }

    /*Métode privat que comprova que la reserva no estigui feta
     * @param Reserva
     */
    private void comprovaReserva(Reserves reserva) throws Excepcions{
        for(int i = 0; i< nElem; i++){
            if(llista[i].esIgual(reserva)) throw new Excepcions("La reserva ja està feta");
        }
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
        String nomarxiu= "Llista_reserves.txt";
        File file = new File("src", nomarxiu);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String llegit = scanner.nextLine();
                //pasaallista();
                String[] parts = llegit.split(",");
                int codi = Integer.parseInt(parts[0].trim());
                String  usuari = parts[1].trim();
                String taller = parts[2].trim();
                Reserves reserva = new Reserves(codi, usuari, taller);
                this.afegirsensecopiar(reserva);
                
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error 404 not found");
        }
    }

    /*Mètode auxiliar per afegir un usuari de l'arxiu llista_usuaris.txt a la llista sense copiar al arxiu per no tenir duplicats.
     * També es podria fer dins al bucle de llegirfitxer, era per fer-ho més elegant :) 
     */
    private void afegirsensecopiar(Reserves reserva){
                llista[nElem] = reserva.copia();
                nElem++;
    }

    }
   
