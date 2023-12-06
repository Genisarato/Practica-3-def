package Classes;

public class Entitats {
    private String nom;
    private int telef;
    private String mail;

    public Entitats(String n, int telef, String mail){
        nom = n;
        this.telef = telef;
        this.mail = mail;
    }

    public String getNom(){
        return nom;
    }

    public int getTelef(){
        return telef;
    }

    public String getMail(){
        return mail;
    }
    public Entitats copia(){
        return (new Entitats(this.getNom(), this.getTelef(), this.getMail()));
    }

    public boolean esIgual(Entitats n){
        return(this.getNom().equals(n.getNom()) && this.telef == n.telef && this.getMail().equals(n.getMail()));
    }
}
