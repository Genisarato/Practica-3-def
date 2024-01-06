/*
 * Programadors:
 * Judith Mateu Domingo - judith.mateu@estudiants.urv.cat
 * Jan Torres Rodriguez - jan.torres@estudiants.urv.cat
 */

package Classes;

/*Els tallers es fan en una hora concreta del dia, i tenen una durada determinada. Tenen també
una capacitat fixada, i els usuaris s’hi ha de registrar*/
public class Tallers extends Activitats {
    private float hora, durada, sumaVal;
    private int  capacitat, usuarisApuntats, nVal;

    public Tallers(String nom, String lloc, int dia, String entitatCrea, int codiPostal, int hora, int durada, int capacitat, int usuarisApuntats, int sumaVal, int nVal){
        super(nom, lloc, dia, entitatCrea, codiPostal);
        this.hora = hora;
        this.durada = durada;
        this.capacitat = capacitat;
        this.usuarisApuntats = usuarisApuntats;
        this.sumaVal = sumaVal;
        this.nVal = nVal;
        
    }
    public Tallers(String nom, String lloc, int dia, String entitatCrea, int codiPostal, String codi, float hora2, float durada2, int capacitat, int usuarisApuntats, float sumaVal2, int nVal){
        super(nom, lloc, dia, entitatCrea, codiPostal, codi);
        this.hora = hora2;
        this.durada = durada2;
        this.capacitat = capacitat;
        this.usuarisApuntats = usuarisApuntats;
        this.sumaVal = sumaVal2;
        this.nVal = nVal;
    }

    public float getHora() {
        return hora;
    }

    public float getDurada() {
        return durada;
    }

    public int getcapacitat(){
        return capacitat;
    }

    @Override
    public int getUsuarisApuntats(){
        return usuarisApuntats;
    }

    public void apuntarUsuari(){
        usuarisApuntats++;
    }

    public void afegirValoracio(float valoracion) {
        sumaVal = sumaVal + valoracion;
        nVal++;
    }

    public float mitjanaValoracions() {
        return (float)(sumaVal/nVal);
    }

    @Override
    public float proporcioTallers() {
        return (float)(usuarisApuntats / capacitat);
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
        Activitats aux = new Tallers(nom, lloc, dia, entitatCrea, codiPostal, codi, hora, durada, capacitat, usuarisApuntats, sumaVal, nVal);
        return (Tallers)aux;
    }

}
