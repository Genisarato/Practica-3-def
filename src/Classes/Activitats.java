package Classes;

/*Totes les activitats tenen un codi que els identifica, que es genera automàticament a partir de les 3
primeres lletres del nom de l’entitat, i seguides d’un número (començant per 100). De totes les
activitats es guarda també el nom, el lloc, el codi postal, i el dia en que es fa (el mes i l’any no cal, ja
assumim que són de novembre de 2023). També haurem de poder indicar quina entitat l’ha creat. Per
a que hi hagi varietat, les activitats no es repeteixen mai, és a dir, cada activitat ha de guardar un sol
dia. */

//Crear get i set  per tal de poder obtenir els atributs de cada activitat i per si s'ha de modificar alguna dada
/*Activitat es guarda format NOM;CODI;LLOC;DIA;ENTITATCREA;CODIPOSTAL*/ 
public abstract class Activitats {
    protected String codi, nom, lloc, entitatCrea;
    protected int codiPostal, dia;
    private static int nAct = 0;

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
        codi = entitatCrea.substring(0, 3) + Integer.toString(nAct);
        incrementarAct();
        this.lloc = lloc;
        this.dia = dia;
        this.entitatCrea = entitatCrea;
        this.codiPostal = codiPostal;
    }

    //En el cas de fer una copia duna activitat, el codi entenc que no es pot tornar a generar (si es tornes a generar nAct hauria augmentat i el codi acabaria sent diferent), de manera que quan fem una copia duna activitat, li haurem de passar el codi, no?
    //el seguent constructor es nomes si acabem passant per passametre el codi de l'activitat a mes a mes de tota la info
    public Activitats(String nom, String lloc, int dia, String entitatCrea, int codiPostal, String codi){
        this.nom = nom;
        this.codi = codi;
        this.lloc = lloc;
        this.dia = dia;
        this.entitatCrea = entitatCrea;
        this.codiPostal = codiPostal;
    }
    
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

    public float proporcioTallers(){
        return 0.0f;
    }

    public boolean placesLliures(){
        return false;
    }

    public String getPersona(){
        return null;
    }

    public int getUsuarisApuntats(){
        return 0;
    }

    public String toString () {
        return ("\nNOM: "+nom+" LLOC: "+lloc+" AMB CODI POSTAL "+codiPostal+" EL DIA "+dia+" DE NOVEMBRE DE 2023.\nENTITAT QUE L'HA CREAT: "+entitatCrea+" AMB EL CODI "+codi);
    }

    public abstract Activitats copia();

}

