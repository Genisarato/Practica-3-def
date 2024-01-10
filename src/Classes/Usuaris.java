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

    /*Constructor
     * @param nom/nicnkame
     * @param mail
     * @param codiPostal
     */
    public Usuaris(String nom, String mail, int codiPostal, int tallerApuntats){
        nickname = nom;
        this.mail = mail;
        this.codiPostal = codiPostal;
        tallerapuntats = tallerApuntats;
    }

    public Usuaris(String nom, String mail, int codiPostal){
        nickname = nom;
        this.mail = mail;
        this.codiPostal = codiPostal;
        tallerapuntats = 0;
    }

    /*Getter del nickname */
    public String getNickname(){
        return nickname;
    }

    /*Getter del mail */
    public String getMail(){
        return mail;
    }

    /*Getter del codi postal */
    public int getCodiPostal(){
        return codiPostal;
    }

    public int getTallerApuntats(){
        return tallerapuntats;
    }

    public String getUsuari(){
        return nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public void SetMail(String mail){
        this.mail = mail;
    }

    public void SetCodiPostal(int codi){
        this.codiPostal = codi;
    }

    public void setTallerApuntats(int t){
        tallerapuntats = t;
    }
    
    /*Mètode copia */
    public Usuaris copia(){
        return new Usuaris(nickname, mail, codiPostal, tallerapuntats);
    }

    public boolean igual(Usuaris n){
        return(this.getNickname().equalsIgnoreCase(n.getNickname()) && this.getMail().equalsIgnoreCase(n.getMail()) && this.getCodiPostal() == n.getCodiPostal());
    }

    /*toString */
    public String toString(){
        String text;
        text = "El nickname de l'usuari es: " + nickname + ", el seu correu es: " + mail + " i el seu codi postal es: " + codiPostal;
        return text;
    }

    public void updateapuntats(){
        tallerapuntats = tallerapuntats + 1;
    }

    //Fer exepcio al main per nickname igual 
}
