
package Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LlistaActivitats extends Llista<Activitats>{
    private Activitats[] llista;

    
    public LlistaActivitats(int capacitat){
        super();
        llista = new Activitats[capacitat];
    }
    
    /**
    * Retorna el tamaño actual de la estructura de datos.
    **/
    public int tamano(){
        return nElem;
    }


    /**
     * Mètode que troba totes les activitats que ha fet una entitat
     * @param ent - entitat de la que en volem saber les activitats
     * @return llista amb totes les activitats que ha creat una entitat concreta
     */
    public LlistaActivitats mateixaEntitat(String ent){
        LlistaActivitats aux = new LlistaActivitats(nElem);

        for (int i = 0; i < nElem-1; i++){
            if (llista[i].getEntitatCrea().equalsIgnoreCase(ent)) aux.agregar(llista[i]);
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
                if (llista[i].getEntitatCrea().equalsIgnoreCase(ent)) aux.agregar(llista[i]);
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
            if (llista[i].diaIgual(dia)) aux.agregar(llista[i]);
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
            if (llista[i].placesLliures()) aux.agregar(llista[i]);
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
            if(llista[i] instanceof Tallers){ 
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
                if (llista[i].getPersona().equalsIgnoreCase(nom)) aux.agregar(llista[i]);
            }
        }
        return aux;
    }

    public float notaMitjanaTaller(String nom){ //identificar taller pel nom????
        Boolean trobat = false;
        int i;
        float resultat = (float) 0.0;
        for (i = 0; i < nElem-1 && !trobat; i++){
            if (llista[i].getNom().equalsIgnoreCase(nom)){ 
                trobat = true;
                resultat = ((Tallers) llista[i]).mitjanaValoracions();
            }
        }
        return resultat;
    }

    /*public Tallers trobaTaller(String codi){
        Tallers t;
        Boolean trobat = false;
        
        for (int i = 0; i < nElem-1; i++){
            if (((String) llista[i].getCodi).equalsIgnoreCase(codi)){
                trobat = true;
                t = (Tallers) llista[i].copia();
            }
        }
        return t;
    }*/
   public Tallers trobaTaller(String codi) {
        Tallers t = null; // Inicializamos t a null
        boolean trobat = false;
    
        for (int i = 0; i < nElem-1 && !trobat; i++) {
            // Corregimos getCodi a getCodi()
            if (((String) llista[i].getCodi()).equalsIgnoreCase(codi)) {
                trobat = true;
                t = (Tallers) llista[i].copia(); // Asumiendo que la clase Tallers tiene un método copia()
                // Terminamos el bucle al encontrar el taller
            }
        }
    
        return t;
    }
    
    
    //CONVERTIR A BOOLEAN PER A RETORNAR ALGO PER A SABER SI S'HA POGUT ELIMINAR O NO?
    /**
     * Mètode que elimina un taller determinat només en el cas que no hi hagi ningú apuntat
     * @param codi - codi del taller a eliminar
     */
    /*public void eliminarTaller(String codi){
        boolean trobat = false;
        for (int i = 0; i < nElem-1 && !trobat; i++){
            if (llista[i].getCodi().equalsIgnoreCase(codi)){
                if (llista[i].getUsuarisApuntats() == 0){
                    for (int j = i; j < nElem-1; j++){
                        llista[j] = llista[j+1];
                    }
                    nElem--;
                    trobat = true;
                }
            }
        }
    }*/
    /*Versió amb boolean per a saber si s'ha eliminat o no.*/ 
    public boolean eliminarTaller(String codi){
        boolean trobat = false;
        for (int i = 0; i < nElem-1 && !trobat; i++){
            if (llista[i].getCodi().equalsIgnoreCase(codi)){
                if (llista[i].getUsuarisApuntats() == 0){
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

     /* Mètode que llegeix el contingut del fitxer llista_entitats.txt 
    *  ATENCIO: AQUEST MÈTODE SEMPRE S'HA DE FER ABANS DE COMENÇAR AMB EL PROGAMA
     * JA QUE ES DONA PER SUPOSAT QUE NO DONA MAI MÉS GRAN QUE LA LENGTH.
     * SI ES FA DESPRÉS POT OCASIONAR PROBLEMES
     */
     public void llegirfitxer(String nomarxiu){
        File file = new File("src", nomarxiu);
        Activitats aux;
        //Scanner scanner = new Scanner(file);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String linia = scanner.nextLine();
                String[] parts = linia.split(";");
                String nom = parts[0].trim();
                String lloc = parts[1].trim();
                int dia = Integer.parseInt(parts[2].trim());
                String entitatCrea = parts[3].trim();  
                int codiPostal = Integer.parseInt(parts[4].trim());   
                String codi = parts[5].trim();
                 //Els atributs comuns acaben aqui

                if (parts[7].equalsIgnoreCase("-1")){
                    String nomPersona = parts[6].trim();                                    //Xerrades acaba aqui
                    aux = new Xerrades(nom, lloc, dia, entitatCrea, codiPostal, codi, false, nomPersona);
                }
                else if (parts[8].equalsIgnoreCase("-1")){
                    boolean audioguies = Boolean.parseBoolean(parts[6].trim());            
                    boolean adaptCegues = Boolean.parseBoolean(parts[7].trim());            //Visites acaba aqui   
                    aux = new Visites(nom, lloc, dia, entitatCrea, codiPostal, codi, false, audioguies, adaptCegues); 
                }
                else{
                    float hora = Float.parseFloat(parts[6].trim());            
                    float durada = Float.parseFloat(parts[7].trim()); 
                    int capacitat = Integer.parseInt(parts[8].trim());
                    int usuarisApuntats = Integer.parseInt(parts[9].trim());
                    float sumaVal = Float.parseFloat(parts[10].trim());
                    int nVal = Integer.parseInt(parts[11].trim());                          //Tallers acaba aqui
                    aux = new Tallers(nom, lloc, dia, entitatCrea, codiPostal, codi, false, hora, durada, capacitat, usuarisApuntats, sumaVal, nVal);
                }

                this.agregar(aux);
            }
        scanner.close();
        } catch (FileNotFoundException e) {
           System.out.println("Archivo no encontrado: " + nomarxiu);
        }  
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("error" + e);
        }
        

    }

    /**
     * Mètode que afegeix la còpia d'una activitat a la última posició disponible de la llista 
     * @param a - activitat a afegir
     */
    public void agregar(Activitats a){
        if(nElem < llista.length){
            llista[nElem] = a.copia();
            nElem++;
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

    /**
     * Mètode per guardar una activitat a l'arxiu Llista_activitats.txt
     * @param a activitat a guardar
     */
    public void guardarArxiu(){
        String nomarxiu = "Llista_activitats.txt";
        String rutaAbsoluta = new File("src", nomarxiu).getAbsolutePath();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaAbsoluta))){
            for(int i = 0; i <nElem-1; i++){
                bw.write(llista[i].getCodi() + "," + llista[i].getNom() + "," + llista[i].getLloc() + "," + llista[i].getDia() + "," + llista[i].getEntitatCrea() + "," + llista[i].getCodiPostal() + "," + llista[i].atributsExtra());
                bw.newLine();
                System.out.println("Guardat\n");
            }
            bw.close();
        }
        catch (IOException e){
            System.out.println("Error\n");
        }

    }

    //es necessari aquest mètode??
    //DE VERITAT ES TANCA L'ARXIU? NO ES FA SERVIR .close() ENLLOC. S'HAURIA DE DESCOMENTAR EL NOU try?
    public void vaciar(){
        String nomArxiu = "Llista_activitats.txt";
        String rutaAbsoluta = new File("src", nomArxiu).getAbsolutePath();

        try (PrintWriter writer = new PrintWriter(rutaAbsoluta)) {

        //try (new FileWriter(rutaAbsoluta, false).close()){

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
                System.out.println("S'ha eliminat l'activitat correctament");
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
    /**
    * Imprimeix la representació en cadena de l'objecte, toString.
    **/
    public void imprimir(){
        System.out.println(toString());
    }
}