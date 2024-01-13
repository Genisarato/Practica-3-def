
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

    /**
     * Constructor
     * @param capacitat
     */
    public LlistaActivitats(int capacitat){
        super();
        llista = new Activitats[capacitat];
    }
    
    /**
     * Getter
     */
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

        for (int i = 0; i < nElem; i++){
            if (llista[i].getEntitatCrea().equalsIgnoreCase(ent)) aux.agregar(llista[i]);
        }
        return aux;
    }
    
    
    /** 
     * Mètode que busca si hi ha una activitat específica a la llista
     * @param a instància
     * @throws Excepcions
     */
    public void mateixaActivitat(Activitats a) throws Excepcions{
        for (int i = 0; i < nElem; i++){
            if (llista[i].getNom().equalsIgnoreCase(a.getNom()) && llista[i].getEntitatCrea().equalsIgnoreCase(a.getEntitatCrea())) throw new Excepcions("L'activitat ja existeix"); //Comprovem que el nom no estigui ja a la llista
            
        }
    }

    /**
     * Mètode que troba totes les visites que ha fet una entitat
     * @param ent - entitat de la que en volem sabes les visites
     * @return llista amb totes les visites que ha creat una entitat concreta
     */
    public LlistaActivitats visitesMateixaEntitat(String ent, boolean audioG, boolean adaptC){
        LlistaActivitats aux = new LlistaActivitats(nElem);
        for (int i = 0; i < nElem; i++){
            if (llista[i] instanceof Visites){
                if (llista[i].getEntitatCrea().equalsIgnoreCase(ent) && llista[i].getAudioG() == audioG && llista[i].getAdaptC() == adaptC) aux.agregar(llista[i]);
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
        for (int i = 0; i < nElem; i++){
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
        
        for (int i = 0; i < nElem; i++){
            if (llista[i].placesLliures()) aux.agregar(llista[i]);
        }
        return aux;
    }

    /**
     * Mètode que troba el taller que tenia ocupació en proporció amb les places que oferia
     * @return taller que ha tingut més èxit    
     */
    public Tallers tallerExit (){
        int tallerSup = -1;
        for(int i = 0; i < nElem; i++){
            if(llista[i] instanceof Tallers){
                if (tallerSup == -1) tallerSup = i;
                else if (llista[i].proporcioTallers() > llista[tallerSup].proporcioTallers())tallerSup = i;
            }
        }
        return (Tallers)llista[tallerSup];
    }

    /**
     * Mètode que troba totes les xerrades que fa una mateixa persona
     * @param nom - nom de la persona de la que en volem saber les xerrades
     * @return llista amb totes les xerrades d'una persona en concret
     */
    public LlistaActivitats xerradesMateixaPersona(String nom){
        LlistaActivitats aux = new LlistaActivitats(nElem);
        for (int i = 0; i < nElem; i++){
            if (llista[i] instanceof Xerrades){
                if (llista[i].getPersona().equalsIgnoreCase(nom)) aux.agregar(llista[i]);
            }
        }
        return aux;
    }
    
    /** 
     * Mètode que comprova que hi hagi visites en la llista
     * @return true si hi ha visites, false si no n'hi ha
     */
    public boolean hiHaVisites(){
        boolean trobat = false;
        for (int i = 0; i < nElem && !trobat; i++){
            if (llista[i] instanceof Visites) trobat = true;
        }
        return trobat;
    }

    /**
     * Mètode que comprova que hi hagi tallers en la llista
     * @return true si hi ha tallers, false si no n'hi ha
     */
    public boolean hiHaTallers(){
        boolean trobat = false;
        for (int i = 0; i < nElem && !trobat; i++){
            if (llista[i] instanceof Tallers) trobat = true;
        }
        return trobat;
    }

    /**
     * Mètode que comprova que hi hagi xerrades en la llista
     * @return true si hi ha xerrades, false si no n'hi ha
     */
    public boolean hiHaXerrades(){
        boolean trobat = false;
        for (int i = 0; i < nElem && !trobat; i++){
            if (llista[i] instanceof Xerrades) trobat = true;
        }
        return trobat;
    }

    /**
     * Mètode que calcula la nota mitjana d'un taller
     * @param codi codi del taller
     * @return nota ja calculada
     */
    public float notaMitjanaTaller(String codi){ 
        Boolean trobat = false;
        float resultat = (float) 0.0;
        for (int i = 0; i < nElem && !trobat; i++){
            if (llista[i].getCodi().equalsIgnoreCase(codi)){ 
                trobat = true;
                resultat = ((Tallers) llista[i]).mitjanaValoracions();
            }
        }
        return resultat;
    }

    /**
     * Mètode que troba un taller obtenint el seu codi per paràmetre
     * @param codi codi del taller
     * @return instància del taller si el trona, sino retorna null
     */
   public Tallers trobaTaller(String codi) {
        Tallers t = null; // Inicializamos t a null
        boolean trobat = false;
    
        for (int i = 0; i < nElem && !trobat; i++) {
            if (((String) llista[i].getCodi()).equalsIgnoreCase(codi) && llista[i] instanceof Tallers) {
                trobat = true;
                t = (Tallers) llista[i];    //No es fa servir copia() perquè ens interessa tenir la instància original en el cas que s'hagi de modificar 
                // Terminamos el bucle al encontrar el taller
            }
        }
    
        return t;
    }
    
    /**
     * Mètode que elimina un taller en el cas que no tingui apuntats
     * @param codi codi del taller
     * @return true si s'ha pogut eliminar, false si no s'ha pogut eliminar
     */
    public boolean eliminarTaller(String codi){
        boolean trobat = false;
        for (int i = 0; i < nElem && !trobat; i++){
            if (llista[i].getCodi().equalsIgnoreCase(codi)){
                if (llista[i].getUsuarisApuntats() == 0){
                    for (int j = i; j < nElem; j++){
                        llista[j] = llista[j+1];
                    }
                    nElem--;
                    trobat = true;
                }
            }
        }
        return trobat;
    }

     /*
     * ATENCIO: AQUEST MÈTODE SEMPRE S'HA DE FER ABANS DE COMENÇAR AMB EL PROGAMA
     * JA QUE ES DONA PER SUPOSAT QUE NO DONA MAI MÉS GRAN QUE LA LENGTH.
     * SI ES FA DESPRÉS POT OCASIONAR PROBLEMES
     */
    /**
     * Mètode que llegeix el contingut del fitxer llista_activitats.txt 
     * @param nomarxiu
     */
     public void llegirfitxer(String nomarxiu){
        File file = new File("src", nomarxiu);
        Activitats aux;
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
                String[] codiSeparat = codi.split("(?!^)");
                String codiNumStr = codiSeparat[3]+codiSeparat[4]+codiSeparat[5];
                int codiNumInt = Integer.parseInt(codiNumStr);
                if (Activitats.getnAct() < codiNumInt) Activitats.setnAct(codiNumInt);  //Es va actualitzant el comptador d'activitats segons els codis que es va trobant
                 //Els atributs comuns acaben aqui

                if (parts[7].equalsIgnoreCase("-1")){
                    String nomPersona = parts[6].trim();                                    //Xerrades acaba aqui
                    aux = new Xerrades(nom, lloc, dia, entitatCrea, codiPostal, codi, nomPersona);
                }
                else if (parts[8].equalsIgnoreCase("-1")){
                    boolean audioguies = Boolean.parseBoolean(parts[6].trim());            
                    boolean adaptCegues = Boolean.parseBoolean(parts[7].trim());            //Visites acaba aqui   
                    aux = new Visites(nom, lloc, dia, entitatCrea, codiPostal, codi, audioguies, adaptCegues); 
                }
                else{
                    String hora = parts[6].trim();            
                    String durada = parts[7].trim(); 
                    int capacitat = Integer.parseInt(parts[8].trim());
                    int usuarisApuntats = Integer.parseInt(parts[9].trim());
                    float sumaVal = Float.parseFloat(parts[10].trim());
                    int nVal = Integer.parseInt(parts[11].trim());                          //Tallers acaba aqui
                    aux = new Tallers(nom, lloc, dia, entitatCrea, codiPostal, codi, hora, durada, capacitat, usuarisApuntats, sumaVal, nVal);
                }
                this.agregar(aux);
            }
        scanner.close();
        } catch (FileNotFoundException e) {
           System.out.println("Archivo no encontrado: " + nomarxiu);
        }  
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Fora de Rang: " + e);
        }
    }

    /**
     * Mètode que afegeix la còpia d'una activitat a la última posició disponible de la llista 
     * @param a - activitat a afegir
     */
    public void agregar(Activitats a){
        try{
            mateixaActivitat(a);
            if(nElem < llista.length){
                llista[nElem] = a.copia();
                nElem++;
            }
        }
        catch (Excepcions e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Mètode que comprova si una activitat determinada es troba en la llista o no
     * @param a - activitat que s'ha de comprovar
     * @return fals en el cas que no estigui present i cert en el cas que sí hi sigui
     */
    public boolean contiene(Activitats a){
        boolean present = false;
        for (int i = 0; i < nElem && !present; i++){  
            if (llista[i].getCodi().equalsIgnoreCase(a.getCodi())) present = true;

        }
        return present;
    }

    /**
     * Mètode per guardar una activitat a l'arxiu Llista_activitats.txt
     * @param a activitat a guardar
     */
    public void guardarArxiu(String nomarxiu){
        String rutaAbsoluta = new File("src", nomarxiu).getAbsolutePath();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaAbsoluta))){
            for(int i = 0; i < nElem; i++){
                bw.write(llista[i].getNom() + ";" + llista[i].getLloc() + ";" + llista[i].getDia() + ";" + llista[i].getEntitatCrea() + ";" + llista[i].getCodiPostal() + ";" + llista[i].getCodi() + ";" +  llista[i].atributsExtra() + ";-1"); //-1 és el sentinella
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
     * Mètode que buida l'arxiu
     */
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
        for (int i = 0; i < nElem && !trobat; i++){
            if(llista[i].getCodi().equalsIgnoreCase(a.getCodi())){
                for (int j = i; j < nElem; j++){
                    llista[j] = llista[j+1];
                }
                nElem--;
                trobat = true;
                System.out.println("S'ha eliminat l'activitat correctament");
            }
        }
    }

    /**
     * toString
     */
    @Override
    public String toString() {
        String text = "";
        for (int i = 0; i < nElem; i++){
            text = text + llista[i] + "\n";
        }
        return text;
    }
    
    /**
     * Crida al toString
     */
    public void imprimir(){
        System.out.println(toString());
    }
}