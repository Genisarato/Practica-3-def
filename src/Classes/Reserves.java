package Classes;

import java.util.Random;

public class Reserves {
    
    private int codiReserva;
    private Usuaris usuari;
    private int codiTaller;

    public Reserves(Usuaris u,int codiTaller){
        Random codi = new Random();

        codiReserva = codi.nextInt();
        
    }
}
