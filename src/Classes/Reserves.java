package Classes;

public class Reserves {

    private String codiReserva;
    private Usuaris usuari;
    private String codiTaller;
    public boolean valorada;
    private static int index = 1;


    public Reserves(Usuaris u, Tallers taller) {
        if(taller.placesLliures()){
            usuari = u.copia();
            codiTaller = taller.getCodi();
            taller.apuntarUsuari();
            codiReserva = Integer.toString(index) + codiTaller;
            augmentarIndex();
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

    public static void augmentarIndex(){
        index++;
    }

    public Usuaris getUsuari(){
        return (usuari.copia());
    }

    public String getCodiTaller(){
        return codiTaller;
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
            return (this.codiReserva.equalsIgnoreCase(reserva.getCodiReserva()));
    }

    public Reserves copia(){
        return new Reserves(this.usuari, this.codiTaller, this.codiReserva, this.valorada);
    }
}
