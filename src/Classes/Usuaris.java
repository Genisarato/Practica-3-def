package Classes;
/*Classe usuaris amb el seu constructor que li passen uns certs paràmetres, s'hauria de mirar tema excepcions ja que 2 nicknames no poden
 * ser iguals però no tinc molt clar com fer-ho
*/
public class Usuaris {
    private String nickname;
    private String mail;
    private int codiPostal;

    /*Constructor
     * @param nom/nicnkame
     * @param mail
     * @param codiPostal
     */
    public Usuaris(String nom, String mail, int codiPostal){
        nickname = nom;
        this.mail = mail;
        this.codiPostal = codiPostal;
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

    /*Mètode copia */
    public Usuaris copia(){
        return new Usuaris(nickname, mail, codiPostal);
    }

    /*toString */
    public String toString(){
        String text;
        text = "El nickname de l'usuari es: " + nickname + ", el seu correu es: " + mail + " i el seu codi postal es: " + codiPostal;
        return text;
    }


    //Fer exepcio al main per nickname igual 
}
