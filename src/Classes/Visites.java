package Classes;

public class Visites extends Activitats {
    private boolean audioguies, adaptCegues;

    public Visites(String nom, String lloc, int dia, String entitatCrea, int codiPostal, boolean audioguies, boolean adaptCegues){
        super(nom, lloc, dia, entitatCrea, codiPostal);
        this.audioguies = audioguies;
        this.adaptCegues = adaptCegues;
    }

    public Visites copia(){
        Activitats aux = new Visites(nom, lloc, dia, entitatCrea, codiPostal, audioguies, adaptCegues);
        return (Visites)aux;
    }
}
