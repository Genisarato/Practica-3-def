package Classes;

import java.util.Random;

public class Reserves {

    private int codiReserva;
    private Usuaris usuari;
    private Tallers taller;


    public Reserves(Usuaris u, Tallers taller) {
        if(!tallerple(taller)){
            Random codi = new Random();
            codiReserva = codi.nextInt();
            usuari = u.copia();
            taller = taller.copia();
            //implementar en la classe tallers el mètode public tallers copia()
        }
        //implementar excepcion taller ple

    }

    public Usuaris getUsuari(){
        return(usuari.copia());
    }

    public Tallers getTallers(){
        return(taller.copia());
    }

    public int getCodiReserva(){
        return(codiReserva);
    }

    public void setUsuari(Usuaris usuari){
        this.usuari = usuari.copia();
    }

    public void setTaller(Tallers taller){
        if(!tallerple(taller)){
            this.taller = taller.copia();
        }
        //implementar exepcion taller ple
    }

    public Reserves copia(){
    return new Reserves(this.usuari, this.taller);
    }
    private boolean tallerple(Tallers taller){
        boolean ple = false;
        //Implementar en la classe tallers el mètode public void places lliures() -> FET
        if(!taller.placesLliures()) ple = true;
        return ple;

    }

    public boolean esIgual(Reserves reserva){
            return(this.getUsuari().igual(reserva.getUsuari()) && this.getTallers().igual(reserva.getTallers()));
    }
}