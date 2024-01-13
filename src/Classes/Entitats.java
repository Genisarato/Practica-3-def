package Classes;
/*Classe entitat que crea una entitat a parti de uns paràmetres */
/*Authors: Genís Aragonès Torralbo */
public class Entitats {
    private String nom;
    private int telef;
    private String mail;

    /**
     * Constructor
     * @param n
     * @param telef
     * @param mail
     */
    public Entitats(String n, int telef, String mail){
        nom = n;
        this.telef = telef;
        this.mail = mail;
    }

    /**
     * Getter
     * @return nom
     */
    public String getNom(){
        return nom;
    }

    /**
     * Getter
     * @return telefon
     */
    public int getTelef(){
        return telef;
    }
    
    /**
     * Getter
     * @return mail
     */
    public String getMail(){
        return mail;
    }
    
    /**
     * Setter
     * @param nom
     */
    public void SetNom(String nom){
        this.nom = nom;
    }
    
    /**
     * Setter
     * @param telef
     */
    public void SetTelef(int telef){
        this.telef = telef;
    }
    
    /**
     * Setter
     * @param mail
     */
    public void SetMail(String mail){
        this.mail = mail;
    }

    /**
     * Mètode copia
     * @return copia d'una instància d'entitats
     */
    public Entitats copia(){
        return (new Entitats(this.getNom(), this.getTelef(), this.getMail()));
    }

    /**
     * Mètode que comprova si dues instàncies d'entitats són iguals
     * @param n
     * @return true en el cas de siguin iguals i false quan no ho siguin
     */
    public boolean esIgual(Entitats n){
        return(this.getNom().equals(n.getNom()) && this.telef == n.telef && this.getMail().equals(n.getMail()));
    }

    /**
     * toString
     */
    public String toString(){
        String text;
        text = "La entitat en nom: " +nom+ ", amb numero de telefon: " +telef+ " i amb mail: " +mail;
        return text;
    }
}
