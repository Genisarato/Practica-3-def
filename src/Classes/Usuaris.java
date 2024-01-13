package Classes;

import java.io.Serializable;

/*Classe usuaris amb el seu constructor que li passen uns certs paràmetres, s'hauria de mirar tema excepcions ja que 2 nicknames no poden
 * ser iguals però no tinc molt clar com fer-ho
*/
/*Authors: Genís Aragonès Torralbo */
public class Usuaris implements Serializable{
    private String nickname;
    private String mail;
    private int codiPostal;
    private int tallerapuntats;

    /**
     * Constructor
     * @param nom
     * @param mail
     * @param codiPostal
     * @param tallerApuntats
     */
    public Usuaris(String nom, String mail, int codiPostal, int tallerApuntats){
        nickname = nom;
        this.mail = mail;
        this.codiPostal = codiPostal;
        tallerapuntats = tallerApuntats;
    }

    /**
     * Constructor
     * @param nom
     * @param mail
     * @param codiPostal
     */
    public Usuaris(String nom, String mail, int codiPostal){
        nickname = nom;
        this.mail = mail;
        this.codiPostal = codiPostal;
        tallerapuntats = 0;
    }

    /** 
     * Getter
     * @return nickname
     */
    /*Getter del nickname */
    public String getNickname(){
        return nickname;
    }

    /** 
     * Getter
     * @return mail
     */
    /*Getter del mail */
    public String getMail(){
        return mail;
    }

    /**
     * Getter
     * @return codi postal de l'usuari
     */
    public int getCodiPostal(){
        return codiPostal;
    }

    /**
     * Getter
     * @return tallers als que s'ha apuntat l'usuari
     */
    public int getTallerApuntats(){
        return tallerapuntats;
    }

    /**
     * Getter
     * @return nickname
     */
    public String getUsuari(){
        return nickname;
    }

    /**
     * Setter
     * @param nickname
     */
    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    /**
     * Setter
     * @param mail
     */
    public void SetMail(String mail){
        this.mail = mail;
    }

    /**
     * Setter
     * @param codi
     */
    public void SetCodiPostal(int codi){
        this.codiPostal = codi;
    }

    /**
     * Setter
     * @param t
     */
    public void setTallerApuntats(int t){
        tallerapuntats = t;
    }
    
    /**
     * Mètode còpia
     * @return
     */
    public Usuaris copia(){
        return new Usuaris(nickname, mail, codiPostal, tallerapuntats);
    }

    /**
     * Mètode que comprova si dues instàncies d'usuaris son iguals
     * @param n -instància d'usuaris
     * @return true si son iguals, false si son diferents
     */
    public boolean igual(Usuaris n){
        return(this.getNickname().equalsIgnoreCase(n.getNickname()) && this.getMail().equalsIgnoreCase(n.getMail()) && this.getCodiPostal() == n.getCodiPostal());
    }

    /**
     * toString
     */
    public String toString(){
        String text;
        text = "El nickname de l'usuari es: " + nickname + ", el seu correu es: " + mail + " i el seu codi postal es: " + codiPostal;
        return text;
    }

    /**
     * Mètode que suma un als tallers als que s'ha apuntat l'usuari
     */
    public void updateapuntats(){
        tallerapuntats = tallerapuntats + 1;
    }
}
