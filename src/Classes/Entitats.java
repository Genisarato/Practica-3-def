package Classes;
/*Classe entitat que crea una entitat a parti de uns paràmetres */
/*Authors: Genís Aragonès Torralbo */
public class Entitats {
    private String nom;
    private int telef;
    private String mail;

    /*Constructor
     * @param nom
     * @param telefon
     * @param mail
     */
    public Entitats(String n, int telef, String mail){
        nom = n;
        this.telef = telef;
        this.mail = mail;
    }

    /*Getter del nom */
    public String getNom(){
        return nom;
    }

    /*Getter del telefon */
    public int getTelef(){
        return telef;
    }
    
    /*Getter del mail */
    public String getMail(){
        return mail;
    }
    /*Setter del nom*/
    public void SetNom(String nom){
        this.nom = nom;
    }
    /*Setter del telef*/
    public void SetTelef(int telef){
        this.telef = telef;
    }
    /*Setter del mail*/
    public void SetMail(String mail){
        this.mail = mail;
    }

    /*Mètode copia */
    public Entitats copia(){
        return (new Entitats(this.getNom(), this.getTelef(), this.getMail()));
    }

    /*Mètode implementat de esIgual per si fa falta */
    public boolean esIgual(Entitats n){
        return(this.getNom().equals(n.getNom()) && this.telef == n.telef && this.getMail().equals(n.getMail()));
    }

    /*Mètode toString */
    public String toString(){
        String text;
        text = "La entitat en nom: " +nom+ ", amb numero de telefon: " +telef+ " i amb mail: " +mail;
        return text;
    }
}
