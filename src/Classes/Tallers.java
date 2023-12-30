/*
 * Programadors:
 * Judith Mateu Domingo - judith.mateu@estudiants.urv.cat
 * Jan Torres Rodriguez - jan.torres@estudiants.urv.cat
 */

package Classes;

/*Els tallers es fan en una hora concreta del dia, i tenen una durada determinada. Tenen també
una capacitat fixada, i els usuaris s’hi ha de registrar*/
public class Tallers extends Activitats {
    private int hora, dia_t, durada, capacitat, usuarisApuntats, sumaVal, nVal;

    // Otros atributos y métodos...

    public Tallers(String nom, String lloc, int dia, String entitatCrea, int codiPostal, int dia_t, int durada, int capacitat, int usuarisApuntats, int sumaVal, int nVal){
        super(nom, lloc, dia, entitatCrea, codiPostal);
        this.dia_t = dia_t;
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

    public void afegirValoracio(int valoracion) {
        sumaVal = sumaVal + valoracion;
        nVal++;
    }

    public float mitjanaValoracions() {
        return (float)(sumaVal/nVal);
    }

    public float proporcioTallers() {
        float proporcio = 0;
        proporcio = (float) usuarisApuntats / capacitat;
        return proporcio;
    }

    public boolean placesLliures(){
        return capacitat > usuarisApuntats;
    }

    public boolean igual(Activitats a){
        
    }

    public Tallers copia(){
        Activitats aux = new Tallers(nom, lloc, dia, entitatCrea, codiPostal, dia_t, durada, capacitat, usuarisApuntats, sumaVal, nVal);
        return (Tallers)aux;
    }

}
