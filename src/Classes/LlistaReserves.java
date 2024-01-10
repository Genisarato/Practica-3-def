package Classes;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*Authors: Genís Aragonès Torralbo */

public class LlistaReserves extends Llista<Reserves> {
    private Reserves[] llista;

    /*
     * Constructor
     */
    public LlistaReserves(int capacitat) {
        super();
        llista = new Reserves[capacitat];
    }

    
    /** 
     * @param n
     * @throws Excepcions
     */
    /*
     * Métode de afegir una reserva comprovant que la reserva no estigui feta sino
     * directament la descarta
     * 
     * @param Reserva
     */
    public void agregar(Reserves n) throws Excepcions{
        if (nElem < llista.length) {
            try {
                comprovaReserva(n);
                n.getUsuariOriginal().updateapuntats();
                llista[nElem] = n.copia();
                nElem++;
            } catch (Excepcions e) {
                System.out.println(e.getMessage());
                throw new Excepcions ("La reserva ja s'ha fet previament");
            }
        }
    }

    
    /** 
     * @param r
     * @return boolean
     */
    public boolean reservaExistent(Reserves r){
        boolean trobat = false;
        for (int i = 0; i < nElem && !trobat; i++){
            if (llista[i].esIgual(r)) trobat = true;
        }
        return trobat;
    }

    /*
     * Métode de afegir un usuari i un taller, que es transforma amb una reserva
     * comprovant també que la reserva no estigui feta, sinó la descarta
     * 
     * @Usuari
     * 
     * @taller
     */
    public void agregar(Usuaris u, Tallers taller) {
        if (nElem < llista.length) {
            try {
                Reserves copia = new Reserves(u, taller);
                comprovaReserva(copia);
                u.updateapuntats();
                llista[nElem] = copia;
                nElem++;
            } catch (Excepcions e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /*
     * Mètdoe per guardar la llista al arxiu Llista_reserves.ser
     * ATENCIO: S'HA DE FER UNA VEGADA S'HAN FINALITZAT LES OPERACIONS DE LA LLISTA:
     * AGREGAR, BORRAR, ETC..
     * I ABANS DE TANCAR EL PROGAMA, SINÓ ES PERDRA TOT EL CONTINUGT DE LLISTA NO
     * GUARDAT ANTERIORMENT, JA QUE
     * EL MÉTODE ELIMINAR ERA MÉS FÀCIL LA IMPLEMENTACIÓ AIXÍ I ÉS MÉS EFICIENT
     */
    public void guardarArxiu() {
        String nomarxiu = "Llista_reserves.ser";

        String rutaAbsoluta = new File("src", nomarxiu).getAbsolutePath();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaAbsoluta))) {
            for (int i = 0; i < nElem; i++) {
                oos.writeObject(llista[i]);
            }
            System.out.println("Guardat\n");
        } catch (IOException e) {
            System.out.println("Error\n");
            e.printStackTrace();
        }
    }

    /* Métode toString */
    @Override
    public String toString() {
        String text = "";
        for (int i = 0; i < nElem; i++) {
            text = text + llista[i] + "\n";
        }
        return text;
    }

    /* Métode que retorna el número d'elements */
    public int tamano() {
        return nElem;
    }

    /* Void que elimina una reserva en específic */
    public void eliminar(Reserves reserves) {
        int j = -1;
        int i;
        for (i = 0; i < nElem && j == -1; i++) {
            if (llista[i].esIgual(reserves))
                j = i;
        }
        if (j != -1) {
            while (j < nElem - 1) {
                llista[j] = llista[j + 1];
                j++;
            }
            nElem--;
        }
    }

    /*
     * Métode que buida la llista i l'arxiu
     * ATENCIÓ: BORRA TOT L'ARXIU, EN CUIDADO QUAN ES CRIDA AL MÉTODE
     */
    public void vaciar() {
        nElem = 0;
        String nomarxiu = "Llista_reserves.ser";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomarxiu))) {
        } catch (IOException e) {
            System.out.println("Error al intentar buidar l'arxiu: " + e.getMessage());
        }
    }

    /* Métode que mostra la llista per pantalla */
    public void imprimir() {
        System.out.println(toString());
    }

    /*
     * Métode que retorna un boolea comforme una reserva está dins la llista o no
     * 
     * @param Reserva
     */
    public boolean contiene(Reserves reserva) {
        boolean conte = false;
        for (int i = 0; i < nElem; i++) {
            if (llista[i].esIgual(reserva))
                conte = true;
        }
        return conte;
    }

    /*
     * Métode privat que comprova que la reserva no estigui feta
     * 
     * @param Reserva
     */
    private void comprovaReserva(Reserves reserva) throws Excepcions {
        for (int i = 0; i < nElem; i++) {
            if (llista[i].esIgual(reserva) && llista[i].getValorada() == reserva.getValorada())
                throw new Excepcions("La reserva ja està feta");
        }
    }

    /*
     * Mètode que llegeix el contingut del fitxer llista_usuaris.ser
     * ATENCIO: AQUEST MÈTODE SEMPRE S'HA DE FER ABANS DE COMENÇAR AMB EL PROGAMA
     * JA QUE ES DONA PER SUPOSAT QUE NO DONA MAI MÉS GRAN QUE LA LENGTH
     * NI HI HA CAP NICKNAME IGUAL(JA QUE TOT EL QUE HI HA A L'ARXIU JA ESTA
     * CORRECTE).
     * AL MAIN S'HA DE FER A LES PRIMERES LINIES.
     * SI NO POT OCASIONAR PROBLEMES A LA LLISTA
     * 
     */
    public void llegirfitxer(String nomarxiu) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomarxiu))) {
            boolean fin = false;
            while (!fin) {
                try {
                    Object obj = ois.readObject();

                    if (obj instanceof Reserves) {
                        Reserves reserva = (Reserves) obj;
                        agregar(reserva);
                    }
                } catch (EOFException e) {
                    fin = true; // Fin del archivo
                }
            }
            System.out.println("Cargado\n");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar el archivo serializado\n");
            e.printStackTrace();
        }
    }

    /*
     * Mètode auxiliar per afegir un usuari de l'arxiu llista_usuaris.txt a la
     * llista sense copiar al arxiu per no tenir duplicats.
     * També es podria fer dins al bucle de llegirfitxer, era per fer-ho més elegant
     * :)
     *
     * private void afegirsensecopiar(Reserves reserva){
     * llista[nElem] = reserva.copia();
     * nElem++;
     * }
     */

    // Métode que retorna una llista de usuaris que estan apuntats a un taller en
    // específic
    // @param taller
    public LlistaUsuaris usuarisTaller(Tallers taller) {
        LlistaUsuaris usuaris = new LlistaUsuaris(nElem);
        for (int i = 0; i < nElem; i++) {
            if (llista[i].getCodiTaller().equalsIgnoreCase(taller.getCodi()))
                usuaris.agregar(llista[i].getUsuari());
        }
        return usuaris;
    }

    public Usuaris usuarimesapuntat() {
        int max = 0;
        Usuaris usuarimesapuntat = null;
        for (int i = 0; i < nElem; i++) {
            if (llista[i].getUsuari().getTallerApuntats() > max) {
                max = llista[i].getUsuari().getTallerApuntats();
                usuarimesapuntat = llista[i].getUsuari().copia();
            }
        }
        return usuarimesapuntat;
    }

    public String valorarTaller(float valoracio, Reserves reserva) {
        reserva.valorar();
        return reserva.getCodiTaller();
    }

    public Reserves trobaReserva(String codiReserva) {
        boolean trobat = false;
        Reserves r = null;
        for (int i = 0; i < nElem && !trobat; i++) {
            if (llista[i].getCodiReserva().equalsIgnoreCase(codiReserva)) {
                trobat = true;
                r = llista[i];
            }
        }
        return r; // No es fa servir copia() perque ens interessa retornar la reserva que hi ha
                  // dins la llista i modificar-la, no modificar una còpia aliena
    }

}