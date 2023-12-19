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
    /** Getter
	 * @return dia de la data
	 */
	public String getNom() {
		return nom;
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

    public String toString () {
        return ("\nNOM: "+nom+" LLOC: "+lloc+" AMB CODI POSTAL "+codiPostal+" EL DIA "+dia+" DE NOVEMBRE DE 2023.\nENTITAT QUE L'HA CREAT: "+entitatCrea+" AMB EL CODI "+codi);
    }

    public abstract Activitats copia();
    public abstract boolean esIgual(Activitats a);
    }

