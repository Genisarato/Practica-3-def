/*
 * Programadors:
 * Judith Mateu Domingo - judith.mateu@estudiants.urv.cat
 * Jan Torres Rodriguez - jan.torres@estudiants.urv.cat
 */

package Classes;

public class Tallers extends Activitats {
    private float sumaVal;
    private int capacitat, usuarisApuntats, nVal;
    private String hora, durada;

    /**
     * Constructor
     * @param nom
     * @param lloc
     * @param dia
     * @param entitatCrea
     * @param codiPostal
     * @param hora
     * @param durada
     * @param capacitat
     * @param usuarisApuntats
     * @param sumaVal
     * @param nVal
     */
    public Tallers(String nom, String lloc, int dia, String entitatCrea, int codiPostal, String hora, String durada,
            int capacitat, int usuarisApuntats, float sumaVal, int nVal) {
        super(nom, lloc, dia, entitatCrea, codiPostal);
        this.hora = hora;
        this.durada = durada;
        this.capacitat = capacitat;
        this.usuarisApuntats = usuarisApuntats;
        this.sumaVal = sumaVal;
        this.nVal = nVal;

    }

    /**
     * Constructor amb codi d'activitat ja generat
     * @param nom
     * @param lloc
     * @param dia
     * @param entitatCrea
     * @param codiPostal
     * @param codi
     * @param hora2
     * @param durada2
     * @param capacitat
     * @param usuarisApuntats
     * @param sumaVal2
     * @param nVal
     */
    public Tallers(String nom, String lloc, int dia, String entitatCrea, int codiPostal, String codi,
            String hora2, String durada2, int capacitat, int usuarisApuntats, float sumaVal2, int nVal) {
        super(nom, lloc, dia, entitatCrea, codiPostal, codi);
        this.hora = hora2;
        this.durada = durada2;
        this.capacitat = capacitat;
        this.usuarisApuntats = usuarisApuntats;
        this.sumaVal = sumaVal2;
        this.nVal = nVal;
    }

    /**
     * Getter
     * @return hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * Getter
     * @return durada
     */
    public String getDurada() {
        return durada;
    }

    /**
     * Getter
     * @return capacitat
     */
    public int getcapacitat() {
        return capacitat;
    }

    /**
     * Getter
     * @return usuaris apuntats al taller
     */
    @Override
    public int getUsuarisApuntats() {
        return usuarisApuntats;
    }

    /**
     * Mètode que apunta un usuari al taller
     */
    public void apuntarUsuari() {
        usuarisApuntats++;
    }

    /**
     * Mètode que afegeix una valoració
     * @param valoracion
     */
    public void afegirValoracio(float valoracion) {
        sumaVal = sumaVal + valoracion;
        nVal++;
    }

    /**
     * Mètode que calcula la valoració mitjana del taller
     * @return valoració mitjana
     */
    public float mitjanaValoracions() {
        return (float) (sumaVal / nVal);
    }

    /**
     * Mètode que s'utilitza per a saber l'èxit del taller en proporció
     * @return proporció d'apuntats entre capacitat del taller
     */
    @Override
    public float proporcioTallers() {
        float res;
        if (usuarisApuntats == 0)
            res = 0;
        else
            res = (float) usuarisApuntats / capacitat;
        return res;
    }

    /**
     * Mètode per a saber si hi ha places lliures
     * @return true si hi ha places lliures, false si està ple
     */
    @Override
    public boolean placesLliures() {
        return capacitat > usuarisApuntats;
    }

    /**
     * Mètode que resta u a usuarisApuntats (soluciona un error concret)
     */
    public void restaApuntat(){
        usuarisApuntats--;
    }

    /**
     * Mètode que dona format als atributs del taller per a poder afegir-los al fitxer
     * @return string amb tots els atributs separats per ";"
     */
    public String atributsExtra() {
        return (hora + ";" + durada + ";" + capacitat + ";" + usuarisApuntats + ";" + sumaVal + ";" + nVal);
    }

    /**
     * Mètode còpia
     * @return còpia de la instància
     */
    @Override
    public Tallers copia() {
        Activitats aux = new Tallers(nom, lloc, dia, entitatCrea, codiPostal, codi, hora, durada, capacitat,
                usuarisApuntats, sumaVal, nVal);
        return (Tallers) aux;
    }

    /**
     * toString
     */
    public String toString() {
        return (super.toString() + "\nA les " + hora + "h, amb una durada de " + durada + "h.\nTé capacitat per a "
                + capacitat + " persones, i hi ha " + usuarisApuntats + " usuaris apuntats.");
    }

}
