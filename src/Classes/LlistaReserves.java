package Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LlistaReserves extends Llista<Reserves>{
    private Reserves[] llista;

    public LlistaReserves(){
        super();
        llista = new Reserves[1000];
    }

    public void agregar(Reserves n){
        if(nElem < llista.length){
            llista[nElem] = n.copia();
            nElem++;
            guardarArxiu(n);
        }
    }

    public void agregar(Usuaris u, Tallers taller) {
        if(nElem < llista.length){
            Reserves copia = new Reserves(u, taller);
            llista[nElem] = copia;
            nElem++;
            guardarArxiu(copia);
        }
    }

    public void guardarArxiu(Reserves n){
        String nomarxiu = "Llista_reserves.txt";

        String rutaAbsoluta = new File("src", nomarxiu).getAbsolutePath();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaAbsoluta, true))){
            bw.write(n.getCodiReserva() + "," + n.getTallers() + "," + n.getUsuari());
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

    public int tamano(){
        return nElem;
    }

    public void eliminar(Reserves reserves){
        int j = -1;
        int i;
        for(i = 0; i<nElem && j == -1; i++){
            if(llista[i].esIgual(reserves)) j = i;
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
        String nomarxiu = "Llista_reserves.txt";

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

    public boolean contiene(Reserves reserva){
        boolean conte = false;
        for(int i = 0; i<nElem; i++){
            if(llista[i].esIgual(reserva)) conte = true;
        }
        return conte;
    }

    /*Mètode que comprova que el nickname no està a la llista*/
   // private boolean nicknameigual(String nom){
     //   boolean trobat = false;
       // for(int i = 0; i<nElem; i++){
         //   if(llista[i].getNickname().equalsIgnoreCase(nom)) throw new RuntimeException("El nickname está usat.");
        //}
        //return trobat;   
    //}
    
}
