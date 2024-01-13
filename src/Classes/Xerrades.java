/*
 * Programadors:
 * Judith Mateu Domingo - judith.mateu@estudiants.urv.cat
 * Jan Torres Rodriguez - jan.torres@estudiants.urv.cat
 */

package Classes;

public class Xerrades extends Activitats {
    String nomPersona;

    /**
     * Constructor
     * @param nom
     * @param lloc
     * @param dia
     * @param entitatCrea
     * @param codiPostal
     * @param nomPersona
     */
    public Xerrades(String nom, String lloc, int dia, String entitatCrea, int codiPostal, String nomPersona){
        super(nom, lloc, dia, entitatCrea, codiPostal);
        this.nomPersona = nomPersona;
    }

    /**
     * Constructor
     * @param nom
     * @param lloc
     * @param dia
     * @param entitatCrea
     * @param codiPostal
     * @param codi
     * @param nomPersona
     */
    public Xerrades(String nom, String lloc, int dia, String entitatCrea, int codiPostal, String codi, String nomPersona){
        super(nom, lloc, dia, entitatCrea, codiPostal, codi);
        this.nomPersona = nomPersona;
    }

    /** 
     * Getter
     * @return nom de la persona que fa la xerrada
     */
    public String getPersona(){
        return nomPersona;
    }

    /**
     * Mètode que dona format als atributs de la xerrada per a poder afegir-los al fitxer
     * @return string amb tots els atributs separats per ";"
     */
    public String atributsExtra(){
        return (nomPersona);
    }
    
    /**
     * Mètode còpia
     * @return còpia de la instància
     */
    public Xerrades copia(){
        Activitats aux = new Xerrades(nom, lloc, dia, entitatCrea, codiPostal, codi, nomPersona);
        return (Xerrades)aux;
    }

    /**
     * toString
     */
    public String toString () {
        return (super.toString() + "\nLa persona que farà la xerrada és: " + nomPersona);
    }
}
