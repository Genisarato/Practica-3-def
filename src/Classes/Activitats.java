/*
 * Programadors:
 * Judith Mateu Domingo - judith.mateu@estudiants.urv.cat
 * Jan Torres Rodriguez - jan.torres@estudiants.urv.cat
 */

package Classes;

public abstract class Activitats {
    protected String codi, nom, lloc, entitatCrea;
    protected int codiPostal, dia;
    public Object getCodi;
    private static int nAct = 100;

    /**
     * Constructor
     * @param nom
     * @param lloc
     * @param dia
     * @param entitatCrea
     * @param codiPostal
     */
    public Activitats(String nom, String lloc, int dia, String entitatCrea, int codiPostal){
        this.nom = nom;
        codi = entitatCrea.substring(0, 3) + Integer.toString(nAct); //ens permet crear el codi
        incrementarAct();
        this.lloc = lloc;
        this.dia = dia;
        this.entitatCrea = entitatCrea;
        this.codiPostal = codiPostal;
    }

    /**
     * Constructor amb codi generat previament
     * @param nom
     * @param lloc
     * @param dia
     * @param entitatCrea
     * @param codiPostal
     * @param codi
     */
    public Activitats(String nom, String lloc, int dia, String entitatCrea, int codiPostal, String codi){
        this.nom = nom;
        this.codi = codi;
        this.lloc = lloc;
        this.dia = dia;
        this.entitatCrea = entitatCrea;
        this.codiPostal = codiPostal;
    }
    
    /**
    * Incrementa el valor de la variable nAct.
    * Aquest mètode s'encarrega d'augmentar en 1 la quantitat d'activitats (nAct). Cmoençant desde 100.
     */
    public static void incrementarAct(){
       nAct++;
    }

    /**
	 * Getter
	 * @return dia de la data
	 */
	public int getDia() {
		return dia;
	}

    /**
     *  Getter
	 * @return dia de la data
	 */
	public String getNom() {
		return nom;
	}

    /**
     * Getter
     * @return codi
     */
    public String getCodi() {
        return codi;
    }
    /**
     * Getter
     * @return nAct
     */
    public static int getnAct(){
        return nAct;
    }

    /**
     * Getter
     * @return lloc
     */
    public String getLloc() {
        return lloc;
    }

    /**
     * Getter
     * @return entitat que crea l'activitat
     */
    public String getEntitatCrea() {
        return entitatCrea;
    }

    /**
     * Getter
     * @return codi postal de l'activitat
     */
    public int getCodiPostal() {
        return codiPostal;
    }

    /**
     * Setter del comptador estàtic
     * @param n
     */
    public static void setnAct(int n){
        nAct = n;
        incrementarAct();
    }

    /**
     * Mètode que compara si dos dies són iguals
     * @param dia
     * @return 1 o 0 segons si es tracta del mateix dia o no
     */
    public boolean diaIgual (int dia){
        return this.dia == dia;
    }
    
    /** 
     * Mètode que s'implementa en Tallers
     * @return 0 en el cas que l'activitat no sigui un taller
     */
    public float proporcioTallers(){         //S'implementa el mètode real en la classe Tallers
        return 0;
    }

    /**
     * Mètode que s'implementa en Tallers
     * @return false en el cas que l'activitat no sigui un taller
     */
    public boolean placesLliures(){         //S'implementa el mètode real en la classe Tallers
        return false;
    }

    /**
     * Getter de xerrades
     * @return null en el cas que l'activitat no sigui una xerrada
     */
    public String getPersona(){             
        return null;
    }

    /**
     * Getter de tallers
     * @return 0 en el cas que l'activitat no sigui un taller
     */
    public int getUsuarisApuntats(){        //S'implementa el mètode real en la classe Tallers
        return 0;
    }

    /**
     * Getter de visites
     * @return false si l'activitat no es una visita
     */
    public boolean getAudioG() {
        return false;
    }
    
    /**
     * Getter de visites
     * @return false si l'activitat no es una visita
     */
    public boolean getAdaptC() {
        return false;
    }

    /**
     * toString
     */
    public String toString () {
        return ("\nNom: "+nom+" Lloc: "+lloc+" amb codi postal "+codiPostal+" el dia "+dia+" de novembre de 2023.\nEntitat que l'ha creat: "+entitatCrea+" amb el codi "+codi);
    }

    /**
     * Mètode abstracte que s'utilitza per a guardar els atributs de cada tipus d'activitat particular
     * @return string amb el contingut dels atributs
     */
    public abstract String atributsExtra();

    /**
     * Mètode abstracte que copia una instància
     * @return instància copiada
     */
    public abstract Activitats copia();
}
