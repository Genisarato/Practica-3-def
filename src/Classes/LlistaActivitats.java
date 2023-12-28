package Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

    /**
     * Mètode que afegeix la còpia d'una activitat a la última posició disponible
     * @param a - activitat a afegir
     */
    public void afegirAct(Activitats a){
        llista[nElem] = a.copia();
    }

    /**
     * Mètode que troba totes les activitats que ha fet una entitat
     * @param ent - entitat de la que en volem saber les activitats
     * @return llista amb totes les activitats que ha creat una entitat concreta
     */
    public LlistaActivitats mateixaEntitat(String ent){
        LlistaActivitats aux = new LlistaActivitats(nElem);

        for (int i = 0; i < nElem-1; i++){
            if (llista[i].getEntitatCrea().equalsIgnoreCase(ent)) aux.afegirAct(llista[i]);
        }
        return aux;
    }

    /**
     * Mètode que troba totes les visites que ha fet una entitat
     * @param ent - entitat de la que en volem sabes les visites
     * @return llista amb totes les visites que ha creat una entitat concreta
     */
    public LlistaActivitats visitesMateixaEntitat(String ent){
        LlistaActivitats aux = new LlistaActivitats(nElem);
        for (int i = 0; i < nElem-1; i++){
            if (llista[i] instanceof Visites){
                if (llista[i].getEntitatCrea().equalsIgnoreCase(ent)) aux.afegirAct(llista[i]);
            }
        }
        return aux;
    }

    /**
     * Mètode que troba totes les activitats que es fan en un dia determinat
     * @param dia - dia del que es volen veure les activitats
     * @return llista amb les activitats que es fan el dia passat per paràmetre
     */
    public LlistaActivitats mateixDia(int dia){
        LlistaActivitats aux = new LlistaActivitats(nElem);
        for (int i = 0; i < nElem-1; i++){
            if (llista[i].diaIgual(dia)) aux.afegirAct(llista[i]);
        }
        return aux;
    }

    /**
     * Mètode que troba tots els tallers amb places lliures
     * @return llista amb els tallers disponibles
     */
    public LlistaActivitats tallersDisp(){
        LlistaActivitats aux = new LlistaActivitats(nElem);
        
        for (int i = 0; i < nElem-1; i++){
            if (llista[i].placesLliures()) aux.afegirAct(llista[i]);
        }
        return aux;
    }

    /**
     * Mètode que troba el taller que tenia ocupació en proporció amb les places que oferia
     * @return taller que ha tingut més èxit    
     */
    public Tallers tallerExit (){ //
        int tallerSup = 0;
        for(int i= 0; i<nElem-1; i++){
            if(llista[i] instanceof Tallers){ //Es innecesari?? al ja haver un metode declarat a activitats, si aixo no es fes diria que funcionaria igual, simplement que, com retornaria 0, no s'afegiria a tallerSup
                if (llista[i].proporcioTallers() > llista[tallerSup].proporcioTallers()) tallerSup = i;
            }
        }
        return (Tallers)llista[tallerSup];
    }

    //FALTA QUE EN EL MAIN ES MOSTRI EN UN BUCLE LES DADES DE TOTES LES XERRADES
    /**
     * Mètode que troba totes les xerrades que fa una mateixa persona
     * @param nom - nom de la persona de la que en volem saber les xerrades
     * @return llista amb totes les xerrades d'una persona en concret
     */
    public LlistaActivitats xerradesMateixaPersona(String nom){
        LlistaActivitats aux = new LlistaActivitats(nElem);
        for (int i = 0; i < nElem-1; i++){
            if (llista[i] instanceof Xerrades){
                if (llista[i].getPersona().equalsIgnoreCase(nom)) aux.afegirAct(llista[i]);
            }
        }
        return aux;
    }
    
    //CONVERTIR A BOOLEAN PER A RETORNAR ALGO PER A SABER SI S'HA POGUT ELIMINAR O NO?
    /**
     * Mètode que elimina un taller determinat només en el cas que no hi hagi ningú apuntat
     * @param codi - codi del taller a eliminar
     */
    public void eliminarTaller(String codi){
        boolean trobat = false;
        for (int i = 0; i < nElem-1 && !trobat; i++){
            if (llista[i].getCodi().equalsIgnoreCase(codi)){
                if (llista[i].getUsuarisApuntats() != 0){
                    for (int j = i; j < nElem-1; j++){
                        llista[j] = llista[j+1];
                    }
                    nElem--;
                    trobat = true;
                }
            }
        }
    }
    /*Versió amb boolean per a saber si s'ha eliminat o no. QUEDA A ESCOLLIR 
    public boolean eliminarTaller(String codi){
        boolean trobat = false;
        for (int i = 0; i < nElem-1 && !trobat; i++){
            if (llista[i].getCodi().equalsIgnoreCase(codi)){
                if (llista[i].getUsuarisApuntats() != 0){
                    for (int j = i; j < nElem-1; j++){
                        llista[j] = llista[j+1];
                    }
                    nElem--;
                    trobat = true;
                }
            }
        }
        return trobat;
    }
    */

    /**
     * Mètode que afegeix una activitat a la llista i alhora la guarda en l'arxiu
     * @param a - activitat a afegir
     */
    public void agregar(Activitats a){
        if(nElem < llista.length){
            boolean afegit = false;
            while (!afegit){
                try{
                    if(!contiene(a) && llista.length > nElem){
                        llista[nElem] = a.copia();
                        nElem++;
                        guardarArxiu(a);
                        afegit = true;
                    }
                }catch(RuntimeException e){
                    System.out.println(e.getMessage());
                    System.out.println("Aquesta activitat ja hi és");
                    /*Implementar llegir una altra activitat (comentari genis)*/
                    //SERIA NECESSARI DEMANAR UNA ALTRA VEGADA UNA ACTIVITAT? L'USUARI POT TORNAR A CRIDAR I JA ESTA, NO?
                }
            }
        }
    }

    /**
     * Mètode que comprova si una activitat determinada es troba en la llista o no
     * @param a - activitat que s'ha de comprovar
     * @return fals en el cas que no estigui present i cert en el cas que sí hi sigui
     */
    public boolean contiene(Activitats a){
        boolean present = false;
        for (int i = 0; i < nElem-1 && !present; i++){  
            if (llista[i].getCodi().equalsIgnoreCase(a.getCodi())) present = true;
        }
        return present;
    }

    //CONVERTIR EN BOOLEAN PER A SABER SI HI HA HAGUT ERROR?
    /**
     * Mètode per guardar una activitat a l'arxiu Llista_activitats.txt
     * @param a activitat a guardar
     */
    public void guardarArxiu(Activitats a){
        String nomArxiu = "Llista_activitats.txt";
        String rutaAbsoluta = new File("src", nomArxiu).getAbsolutePath();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaAbsoluta, true))){
            bw.write(a.getCodi() + "," + a.getNom() + "," + a.getLloc() + "," + a.getDia() + "," + a.getEntitatCrea() + "," + a.getCodiPostal());
            bw.newLine();
            System.out.println("Guardat!\n");
            bw.flush();
            bw.close();
        }
        catch (IOException e){
            System.out.println("Error\n");
        }
        
    }

    //DE VERITAT ES TANCA L'ARXIU? NO ES FA SERVIR .close() ENLLOC. S'HAURIA DE DESCOMENTAR EL NOU try?
    public void vaciar(){
        String nomArxiu = "Llista_activitats.txt";
        String rutaAbsoluta = new File("src", nomArxiu).getAbsolutePath();

        try (PrintWriter writer = new PrintWriter(rutaAbsoluta)) {

        //try (new FileWriter(rutaAbsoluta, false).close())

            // Simplemente cierra el archivo sin escribir nada, lo que borra su contenido.
        } catch (IOException e) {
            System.out.println("Error al intentar vaciar el archivo: " + e.getMessage());
        }
        nElem = 0;
    }

    /**
     * Mètode que elimina una activitat en concret. Si l'activitat no hi és en la llista, no fa res
     * @param a - activitat a eliminar
     */
    public void eliminar(Activitats a){
        boolean trobat = false;
        for (int i = 0; i < nElem-1 && !trobat; i++){
            if(llista[i].getCodi().equalsIgnoreCase(a.getCodi())){
                for (int j = i; j < nElem-1; j++){
                    llista[j] = llista[j+1];
                }
                nElem--;
                trobat = true;
            }
        }
    }

    @Override
    public String toString() {
        String text = "";
        for (int i = 0; i < nElem-1; i++){
            text = text + llista[i] + "\n";
        }
        return text;
    }

    public void imprimir(){
        System.out.println(toString());
    }


    

}
