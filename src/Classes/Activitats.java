/*
 * Programadors:
 * Judith Mateu Domingo - judith.mateu@estudiants.urv.cat
 * Jan Torres Rodriguez - jan.torres@estudiants.urv.cat
 */

package Classes;

//Crear get i set  per tal de poder obtenir els atributs de cada activitat i per si s'ha de modificar alguna dada

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

    //En el cas de fer una copia d'una activitat, el codi entenc que no es pot tornar a generar (si es tornes a generar nAct hauria augmentat i el codi acabaria sent diferent), de manera que quan fem una copia duna activitat, li haurem de passar el codi, no?
    //el seguent constructor es nomes si acabem passant per passametre el codi de l'activitat a mes a mes de tota la info
    public Activitats(String nom, String lloc, int dia, String entitatCrea, int codiPostal, String codi, boolean esCopia){
        this.nom = nom;
        this.codi = codi;
        this.lloc = lloc;
        this.dia = dia;
        this.entitatCrea = entitatCrea;
        this.codiPostal = codiPostal;
        if (!esCopia) incrementarAct();
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
     * Mètode que compara si dos dies són iguals
     * @param dia
     * @return 1 o 0 segons si es tracta del mateix dia o no
     */
    public boolean diaIgual (int dia){
        return this.dia == dia;
    }

    public float proporcioTallers(){         //S'implementa el mètode real en la classe Tallers
        return 0;
    }

    public boolean placesLliures(){         //S'implementa el mètode real en la classe Tallers
        return false;
    }

    public String getPersona(){             //S'implementa el mètode real en la classe Xerrades
        return null;
    }

    public int getUsuarisApuntats(){        //S'implementa el mètode real en la classe Tallers
        return 0;
    }

    public String toString () {
        return ("\nNom: "+nom+" Lloc: "+lloc+" amb codi postal "+codiPostal+" el dia "+dia+" de novembre de 2023.\nEntitat que l'ha creat: "+entitatCrea+" amb el codi "+codi);
    }

    public abstract String atributsExtra();
    public abstract Activitats copia();



}
