package Classes;

import java.io.Serializable;

public class Reserves implements Serializable{
    private static final long serialVersionUID = 1L;
    private String codiReserva;
    private Usuaris usuari;
    private String codiTaller;
    public boolean valorada;


    public Reserves(Usuaris u, Tallers taller) {
        if(taller.placesLliures()){
            usuari = u.copia();
            codiTaller = taller.getCodi();
            taller.apuntarUsuari();
            u.updateapuntats();
            codiReserva = Integer.toString(taller.getUsuarisApuntats()) + codiTaller;
            valorada = false;
        }
        //implementar excepcion taller ple
    }

    public Reserves(Usuaris u, String codiTaller, String codiReserva, boolean valorada){
        usuari = u.copia();
        this.codiTaller = codiTaller;
        this.codiReserva = codiReserva;
        this.valorada = valorada;
    }

    
    /** 
     * @return Usuaris
     */
    public Usuaris getUsuari(){
        return (usuari.copia());
    }

    
    /** 
     * @return Usuaris
     */
    public Usuaris getUsuariOriginal(){
        return usuari;
    }

    public String getCodiTaller(){
        return codiTaller;
    }

    public String getNickname(){
        return usuari.getNickname();
    }

    public String getMail(){
        return usuari.getMail();
    }

    public int getCodiPostal(){
        return usuari.getCodiPostal();
    }

    public String getCodiReserva(){
        return (codiReserva);
    }

    public boolean getValorada(){
        return valorada;
    }

    public void setUsuari(Usuaris usuari){
        this.usuari = usuari.copia();
    }

    public void valorar(){
        this.valorada = true;
    }

    public boolean esIgual(Reserves reserva){
        return (this.codiReserva.equalsIgnoreCase(reserva.getCodiReserva()) || ((usuari.igual(reserva.getUsuari()) && codiTaller.equalsIgnoreCase(reserva.getCodiTaller()))));
    }

    public Reserves copia(){
        return new Reserves(this.usuari, this.codiTaller, this.codiReserva, this.valorada);
    }

    public String adaptarBool (Boolean b){
        String hoEs = "Si";
        if (!b) hoEs = "No";
        return hoEs;
    }
    
    public String toString () {
        return ("\nUsuari: " + usuari + "\nCodi taller que s'ha apuntat: " + codiTaller + " Codi Reserva: " +codiReserva+ ". Ha valorat el taller: " +adaptarBool(valorada));
    }

}
