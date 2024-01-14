package Aplication;

//import java.util.Scanner;

//import Classes.Activitats;
import Classes.Entitats;
import Classes.Excepcions;
import Classes.LlistaActivitats;
import Classes.LlistaEntitats;
import Classes.LlistaReserves;
import Classes.LlistaUsuaris;
import Classes.Tallers;
import Classes.Usuaris;
import Classes.Visites;
import Classes.Xerrades;

public class JocProves {
    public static void main(String[] args){
		//Scanner teclat = new Scanner(System.in);
		LlistaActivitats llisA = new LlistaActivitats(100);
		LlistaEntitats llisE = new LlistaEntitats();
		LlistaUsuaris llisU = new LlistaUsuaris();
		LlistaReserves llisR = new LlistaReserves(100);
        Entitats e1 = new Entitats("Proide", 609618168, "proide@fundacioproide.org");
        Entitats e2 = new Entitats("Ajuntament de Tarragona", 977296119, "omic@tarragona.cat");
        Entitats e3 = new Entitats("URV", 977558382, "seubaixpenedes@urv.cat");
        Tallers t1 = new Tallers("Tres en raya", "Salou", 1, "Proide", 43840, "17:00", "1:30", 3, 0, 0, 0);
        Tallers t2 = new Tallers("Fotografia durant la nit", "Tarragona", 2, "URV", 43001, "23:30", "2:00", 2, 0, 0, 0);
        Visites v1 = new Visites("Visita a la Generalitat", "Barcelona", 11, "URV", 8002, false, true);
        Visites v2 = new Visites("Museu d'Arquologia de Tarragona", "Tarragona", 21, "Ajuntament de Tarragona", 43001, true, true);
        Xerrades x1 = new Xerrades("IOT, Què és?", "Tarragona", 14, "URV", 43004, "Laura Gomes");
        Xerrades x2 = new Xerrades("Lideratge empresarial", "Tarragona", 30, "Ajuntament de Tarragona", 43007, "Carlos Puch");
        Usuaris u1 = new Usuaris("Lluis", "lluis14@gmail.com", 43001);
        Usuaris u2 = new Usuaris("Beatriz", "beagc@yahoo.es", 43007);
        Usuaris u3 = new Usuaris("Aran", "aran.garcia@estudiants.urv.cat", 43005);

        llisE.agregar(e1);
        llisE.agregar(e2);
        llisE.agregar(e3);
        llisA.agregar(t1);
        llisA.agregar(t2);
        llisA.agregar(v1);
        llisA.agregar(v2);
        llisA.agregar(x1);
        llisA.agregar(x2);

        comprovaCrearReserves(llisR, u1, u2, u3, t2);
        comprovaEliminarTaller(llisR, llisA, t1, t2, u1, u2);
        comprovaUsuaris(u1, u2, u3, llisU);
        comprovaVisites(v1, v2, v2, llisA);
    }

    private static void comprovaCrearReserves(LlistaReserves llisR, Usuaris u1, Usuaris u2, Usuaris u3, Tallers t2){
        try{
            System.out.println("\nS'intenta crear una reserva per l'usuari: " + u1);
            llisR.agregar(u1, t2);
            System.out.println(llisR);
            System.out.println("\nS'intenta crear una reserva per l'usuari: " + u2);
            llisR.agregar(u2, t2);
            System.out.println(llisR);
            System.out.println("\nS'intenta crear una reserva per l'usuari: " + u3);
            llisR.agregar(u3, t2);          //Aquest taller no té suficients places per afegir aquest usuari
            System.out.println(llisR);
        }catch (Excepcions e){
            t2.restaApuntat();
        }
        System.out.println("\nLes reserves realitzades son:" + llisR);
    }

    private static void comprovaEliminarTaller(LlistaReserves llisR, LlistaActivitats llisA, Tallers t1, Tallers t2, Usuaris u1, Usuaris u2){
        try{
            llisR.agregar(u1, t2);
            llisR.agregar(u2, t2);      //Es fan reserves per a que el taller estigui ple
        }catch (Excepcions e){
            t2.restaApuntat();
        }

        System.out.println("\nComencem amb les següents activitats" + llisA);
        System.out.println("\nS'intenta eliminar el taller 2:" + t2);
        if (llisA.eliminarTaller(t2.getCodi())) System.out.print("S'ha eliminat correctament. Les activitats actuals son:" + llisA);   //Es tracta d'un taller que té usuaris apuntats, de manera que no és possible eliminar-lo
        else System.out.println("No s'ha pogut eliminar. Les activitats actuals són:" + llisA);

        System.out.println("\nS'intenta eliminar el taller 1:" + t1);
        if (llisA.eliminarTaller(t1.getCodi())) System.out.print("S'ha eliminat correctament. Les activitats actuals son:" + llisA);   //Com que no hi ha usuaris apuntats al taller, se'ns permet eliminar-lo
        else System.out.println("No s'ha pogut eliminar. Les activitats actuals són:" + llisA);
    }

    private static void comprovaUsuaris(Usuaris u1, Usuaris u2, Usuaris u3, LlistaUsuaris llistau){

        try{
            llistau.agregar(u1);
        }
        catch(Excepcions e){
            System.err.println(e.getMessage());
        }
        try{
            llistau.agregar(u2);
        }
        catch(Excepcions e){
            System.out.println(e.getMessage());
        }
        try{
            llistau.agregar(u3);
        }
        catch(Excepcions e){
            System.out.println(e.getLocalizedMessage());
        }

        System.out.println("La llista d'usuaris queda:" +llistau);
        System.out.println("Es vol eliminar l'usuari 3 \n");
        llistau.eliminar(u3);
        System.out.println("La llista queda com:" +llistau + "\n");
        System.out.println("Es vol eliminar un usuari que no esta dins la llista:" +llistau+ "\n");
        Usuaris usuariprova = new Usuaris("Alberto", "mail.com", 43582);
        llistau.eliminar(usuariprova);
        System.out.println("La llista queda com:" +llistau+ "\n");
    }


    private static void comprovaEntitats(Entitats e1, Entitats e2, Entitats e3, LlistaEntitats llistae){
        System.out.println("Com que en la classa Llista entitats no hi ha cap excepcio els qual haguem de controlar agreguem directe.\n");
        llistae.agregar(e1);
        llistae.agregar(e2);
        llistae.agregar(e3);
        System.out.println("La llista queda com:" + llistae + "\n");
        System.out.println("Borrem entitat 1\n");
        llistae.eliminar(e1);
        System.out.println("La llista queda com:" + llistae+ "\n");
        System.out.println("Provem de borra una entitat que no esta en la llista");
        Entitats entitatprova = new Entitats("Aigua SL", 0, "aigua@gmail.com");
        llistae.eliminar(entitatprova);
        System.out.println("La llista queda com:" + llistae + "\n");

    }


    private static void comprovaVisites(Visites v1, Visites v2, Visites v3, LlistaActivitats llistaA){
        System.out.println("Métode per provar d'agregar visites a la llista tallers\n");
        llistaA.agregar(v1);
        llistaA.agregar(v2);
        llistaA.agregar(v3);

        System.out.println("La llista queda com:" + llistaA + "\n");
        System.out.println("Provem a eliminar la visita 2");
        llistaA.eliminar(v2);
        System.out.println("La llista queda com:" + llistaA + "\n");
        System.out.println("Provem a eliminar una visita que no esta dins la llista");
        Visites visitaprova = new Visites("Visita a la desembocadura", "La cava", 13, "La Cava SL",80, false, false);
        llistaA.eliminar(visitaprova);
        System.out.println("La llista queda com:" + llistaA + "\n");
    }
}