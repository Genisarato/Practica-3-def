package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LlistaActivitats extends Llista<Activitats>{
    private Activitats[] llista;
    private int nElem;

    
    public LlistaActivitats(int capacitat){
        super();
        llista = new Activitats[capacitat];
        nElem = 0;
    }

    public int tamano(){
        return nElem;
    }

    public void agregar(Activitats a){ //acabar Exception??
        if(nElem < llista.length){
            boolean afegit = false;
            while (!afegit){
                try{
                    activitatPresent(a);
                    llista[nElem] = n.copia();
                    nElem++;
                    guardarArxiu(a);
                    afegit = true;
                }catch(RuntimeException e){
                    System.out.println(e.getMessage());
                    System.out.println("Introdueix un altre nickname");
                    /*Implementar llegir un altre nickname i el setNickname*/
                }
            }
        }
    }

    public boolean activitatPresent(Activitats a){
        boolean present = false;
        for (int i = 0; i < nElem-1 && !present; i++){  
            if (llista[i] instanceof a)
            if (llista[i].esIgual(a)) present = true;
        }
        return present;
    }

    public guardarArxiu(Activitats)

    public void vaciar(){
        String nomArxiu = "Llista_usuaris.txt";
        String rutaAbsoluta = new File("src", nomArxiu).getAbsolutePath();

        try (PrintWriter writer = new PrintWriter(rutaAbsoluta)) {
            // Simplemente cierra el archivo sin escribir nada, lo que borra su contenido.
        } catch (IOException e) {
            System.out.println("Error al intentar vaciar el archivo: " + e.getMessage());
        }
        nElem = 0;
    }

    public void afegirAct(Activitats a){
        llista[nElem] = a.copia();
    }

    
    
    public LlistaActivitats mateixDia (int dia) {
        LlistaActivitats aux = new LlistaActivitats(nElem);
        for(int i = 0; i < nElem; i++){
             if(llista[i].diaIgual(dia)){
                aux.afegirFinal(llista[i].copia());
             }
        }
        return aux;
    }

    /**
     * Mètode que troba el taller que tenia ocupació en proporció amb les places que oferia
     * @return taller que ha tingut més èxit    
     */
    public Tallers tallerExit (){ //
        int tallerSup = 0;
        for(int i= 0; i<nElem; i++){
            if(llista[i] instanceof Tallers){
                if (llista[i].proporcioTallers() > llista[tallerSup].proporcioTallers()) tallerSup = i;
            }
        }
        return (Tallers)llista[tallerSup];
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }

    public void llegirfitxer(){
        String nomarxiu= "Llista_activitats.txt";
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
    

}
