package Classes;

import java.io.Serializable;

public class Reserves implements Serializable{
    private static final long serialVersionUID = 1L;
    private String codiReserva;
    private Usuaris usuari;
    private String codiTaller;
    public boolean valorada;

    /**
     * Constructor
     * @param u - instància d'usuaris
     * @param taller
     */
    public Reserves(Usuaris u, Tallers taller) {
        if(taller.placesLliures()){
            usuari = u.copia();
            codiTaller = taller.getCodi();
            taller.apuntarUsuari();
            u.updateapuntats();
            codiReserva = Integer.toString(taller.getUsuarisApuntats()) + codiTaller;
            valorada = false;
        }
    }

    /**
     * Constructor
     * @param u - instància d'usuaris
     * @param codiTaller
     * @param codiReserva
     * @param valorada
     */
    public Reserves(Usuaris u, String codiTaller, String codiReserva, boolean valorada){
        usuari = u.copia();
        this.codiTaller = codiTaller;
        this.codiReserva = codiReserva;
        this.valorada = valorada;
    }

    /** 
     * Getter
     * @return instància d'usuaris
     */
    public Usuaris getUsuari(){
        return (usuari.copia());
    }

    /** 
     * Getter
     * @return instància original d'usuaris
     */
    public Usuaris getUsuariOriginal(){
        return usuari;
    }

    /**
     * Getter
     * @return codi del taller
     */
    public String getCodiTaller(){
        return codiTaller;
    }

    /**
     * Getter
     * @return nickname de l'usuari
     */
    public String getNickname(){
        return usuari.getNickname();
    }

    /**
     * Getter
     * @return mail de l'usuari
     */
    public String getMail(){
        return usuari.getMail();
    }

    /**
     * Getter
     * @return codi postal de l'usuari
     */
    public int getCodiPostal(){
        return usuari.getCodiPostal();
    }

    /**
     * Getter
     * @return codi de reserva
     */
    public String getCodiReserva(){
        return (codiReserva);
    }

    /**
     * Getter
     * @return true si ja s'ha valorat el taller i false si no s'ha valorat encara
     */
    public boolean getValorada(){
        return valorada;
    }

    /**
     * Setter
     * @param usuari
     */
    public void setUsuari(Usuaris usuari){
        this.usuari = usuari.copia();
    }

    /**
     * Mètode que estableix la reserva com a valorada
     */
    public void valorar(){
        this.valorada = true;
    }

    /**
     * Mètode que comprova si dues reserves son iguals o no
     * @param reserva instància a comparar
     * @return true si són iguals, false si son diferents
     */
    public boolean esIgual(Reserves reserva){
        return (this.codiReserva.equalsIgnoreCase(reserva.getCodiReserva()) || ((usuari.igual(reserva.getUsuari()) && codiTaller.equalsIgnoreCase(reserva.getCodiTaller()))));
    }

    /**
     * Mètode copia
     * @return copia de la instància original
     */
    public Reserves copia(){
        return new Reserves(this.usuari, this.codiTaller, this.codiReserva, this.valorada);
    }

    /**
     * Mètode que dona format a un atribut booleà
     */
    private String adaptarBool (Boolean b){
        String hoEs = "Si";
        if (!b) hoEs = "No";
        return hoEs;
    }
    
    /**
     * toString
     */
    public String toString () {
        return ("\nUsuari: " + usuari + "\nCodi taller que s'ha apuntat: " + codiTaller + " Codi Reserva: " +codiReserva+ ". Ha valorat el taller: " +adaptarBool(valorada));
    }

}
