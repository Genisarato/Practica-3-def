/*
 * Programadors:
 * Judith Mateu Domingo - judith.mateu@estudiants.urv.cat
 * Jan Torres Rodriguez - jan.torres@estudiants.urv.cat
 */

package Classes;

public class Visites extends Activitats {
    private boolean audioguies, adaptCegues;

    /**
     * Constructor
     * @param nom
     * @param lloc
     * @param dia
     * @param entitatCrea
     * @param codiPostal
     * @param audioguies
     * @param adaptCegues
     */
    public Visites(String nom, String lloc, int dia, String entitatCrea, int codiPostal, boolean audioguies, boolean adaptCegues){
        super(nom, lloc, dia, entitatCrea, codiPostal);
        this.audioguies = audioguies;
        this.adaptCegues = adaptCegues;
    }

    /**
     * Constructor
     * @param nom
     * @param lloc
     * @param dia
     * @param entitatCrea
     * @param codiPostal
     * @param codi
     * @param audioguies
     * @param adaptCegues
     */
    public Visites(String nom, String lloc, int dia, String entitatCrea, int codiPostal, String codi, boolean audioguies, boolean adaptCegues){
        super(nom, lloc, dia, entitatCrea, codiPostal, codi);
        this.audioguies = audioguies;
        this.adaptCegues = adaptCegues;
    }

    /**
     * Getter
     * @return audioguies
     */
    public boolean getAudioG(){
        return audioguies;
    }

    /**
     * Getter
     * @return adaptacio per a persones cegues
     */
    public boolean getAdaptC(){
        return adaptCegues;
    }
    
    /**
     * Mètode que dona format als atributs de la visita per a poder afegir-los al fitxer
     * @return string amb tots els atributs separats per ";"
     */
    public String atributsExtra(){
        return (adaptarBool(audioguies) + ";" + adaptarBool(adaptCegues));
    }
    
    /** 
     * Mètode còpia
     * @return còpia de la instància
     */
    public Visites copia(){
        Activitats aux = new Visites(nom, lloc, dia, entitatCrea, codiPostal, codi, audioguies, adaptCegues);
        return (Visites)aux;
    }
    
    /**
     * Mètode que dona format a atributs booleans
     * @param b - atribut a adaptar
     * @return cadena amb l'atribut adaptat
     */
    public String adaptarBool(boolean b){
        String hoEs = "Si";
        if(!b) hoEs = "No";
        return hoEs;
    }

    /**
     * toString
     */
    public String toString () {
        return (super.toString() +"\n" + adaptarBool(audioguies) + " té audioguies, " + adaptarBool(adaptCegues) + " està adaptat per a cecs");
    }
}
