package Classes;

public class Xerrades extends Activitats {
    String nomPersona;

    public Xerrades(String nom, String lloc, int dia, String entitatCrea, int codiPostal, String nomPersona){
        super(nom, lloc, dia, entitatCrea, codiPostal);
        this.nomPersona = nomPersona;
    }

    public String getPersona(){
        return nomPersona;
    }

    public String atributsExtra(){
        return (nomPersona);
    }
    
    public Xerrades copia(){
        Activitats aux = new Xerrades(nom, lloc, dia, entitatCrea, codiPostal, nomPersona);
        return (Xerrades)aux;
    }
}
