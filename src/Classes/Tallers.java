/*
 * Programadors:
 * Judith Mateu Domingo - judith.mateu@estudiants.urv.cat
 * Jan Torres Rodriguez - jan.torres@estudiants.urv.cat
 */

package Classes;

/*Els tallers es fan en una hora concreta del dia, i tenen una durada determinada. Tenen també
una capacitat fixada, i els usuaris s’hi ha de registrar*/
public class Tallers extends Activitats {
    private int hora, hora, durada, capacitat, usuarisApuntats, nVal;
    float sumaVal;

    // Otros atributos y métodos...

    public Tallers(String nom, String lloc, int dia, String entitatCrea, int codiPostal, int hora, int durada, int capacitat, int usuarisApuntats, int sumaVal, int nVal){
        super(nom, lloc, dia, entitatCrea, codiPostal);
        this.hora = hora;
        this.durada = durada;
        this.capacitat = capacitat;
        this.usuarisApuntats = usuarisApuntats;
        this.sumaVal = sumaVal;
        this.nVal = nVal;
        
    }
    public Tallers(String nom, String lloc, int dia, String entitatCrea, int codiPostal, String codi, boolean esCopia, int hora, int durada, int capacitat, int usuarisApuntats, int sumaVal, int nVal){
        super(nom, lloc, dia, entitatCrea, codiPostal, codi, esCopia);
        this.hora = hora;
        this.durada = durada;
        this.capacitat = capacitat;
        this.usuarisApuntats = usuarisApuntats;
        this.sumaVal = sumaVal;
        this.nVal = nVal;
        
    }

    public int getHora() {
        return hora;
    }

    public int getDurada() {
        return durada;
    }

    public int getcapacitat(){
        return capacitat;
    }

    @Override
    public int getUsuarisApuntats(){
        return usuarisApuntats;
    }

    //No es mira si la valoració es fa quan ja ha passat el taller. S'hauria de fer? Suposo que no, perque no tenim manera de saber el dia actual per l'usuari, no? (punt 9 del main)

    public void afegirValoracio(float valoracion) {
        sumaVal = sumaVal + valoracion;
        nVal++;
    }

    public float mitjanaValoracions() {
        return (float)(sumaVal/nVal);
    }

    @Override
    public float proporcioTallers() {
        float proporcio = 0;
        proporcio = (float) usuarisApuntats / capacitat;
        return proporcio;
    }

    @Override
    public boolean placesLliures(){
        return capacitat > usuarisApuntats;
    }

    
    public String atributsExtra(){
        return (hora + "," + "," + durada + "," + capacitat + "," + usuarisApuntats + "," + sumaVal + "," + nVal);
    }
    
    @Override
    public Tallers copia(){
        Activitats aux = new Tallers(nom, lloc, dia, entitatCrea, codiPostal, codi, true, hora, dia_t, durada, capacitat, usuarisApuntats, sumaVal, nVal);
        return (Tallers)aux;
    }

    public boolean igual(Tallers tallers) {
        
        return false;
    }

}
