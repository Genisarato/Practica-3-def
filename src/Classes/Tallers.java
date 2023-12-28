/*
 * Programadors:
 * Judith Mateu Domingo - judith.mateu@estudiants.urv.cat
 * Jan Torres Rodriguez - jan.torres@estudiants.urv.cat
 */

package Classes;

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

    @Override
    public int getUsuarisApuntats(){
        return usuarisApuntats;
    }

    //No es mira si la valoració es fa quan ja ha passat el taller. S'hauria de fer? Suposo que no, perque no tenim manera de saber el dia actual per l'usuari, no? (punt 9 del main)
    public void afegirValoracio(int valoracion) {
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

    @Override
    public Tallers copia(){
        Activitats aux = new Tallers(nom, lloc, dia, entitatCrea, codiPostal, dia_t, durada, capacitat, usuarisApuntats, sumaVal, nVal);
        return (Tallers)aux;
    }
}
