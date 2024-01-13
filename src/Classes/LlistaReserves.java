package Classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*Authors: Genís Aragonès Torralbo */

public class LlistaReserves extends Llista<Reserves> {
    private Reserves[] llista;

    /**
     * Constructor
     * @param capacitat
     */
    public LlistaReserves(int capacitat) {
        super();
        llista = new Reserves[capacitat];
    }

    /**
     * Métode de afegir una reserva comprovant que la reserva no estigui feta sino directament la descarta
     * @param n - instància de reserves
     * @throws Excepcions
     */
    public void agregar(Reserves n) throws Excepcions {
        if (nElem < llista.length) {
            try {
                comprovaReserva(n);
                n.getUsuariOriginal().updateapuntats();
                llista[nElem] = n.copia();
                nElem++;
            } catch (Excepcions e) {
                System.out.println(e.getMessage());
                throw new Excepcions("La reserva ja s'ha fet previament");
            }
        }
        else throw new Excepcions("No queden places lliures");
    }

    /**
     * Mètode que mira si una reserva ja existeix
     * @param r - instància de reserves
     * @return true si existeix, false si no
     */
    public boolean reservaExistent(Reserves r) {
        boolean trobat = false;
        for (int i = 0; i < nElem && !trobat; i++) {
            if (llista[i].esIgual(r))
                trobat = true;
        }
        return trobat;
    }

    /**
     * Mètode que afegeix la còpia d'una entitat a la última posició disponible de la llista 
     * @param u - instància d'usuaris
     * @param taller - instància de tallers
     * @throws Excepcions
     */
    public void agregar(Usuaris u, Tallers taller) throws Excepcions {
        if (nElem < llista.length) {
            try {
                Reserves copia = new Reserves(u, taller);
                comprovaReserva(copia);
                copia.getUsuariOriginal().updateapuntats();
                llista[nElem] = copia;
                nElem++;
            } catch (Excepcions e) {
                System.out.println(e.getMessage());
                throw new Excepcions("La reserva ja s'ha fet previament");
            }
        }
    }

    /*
     * Mètode per guardar la llista al arxiu Llista_reserves.ser
     * ATENCIO: S'HA DE FER UNA VEGADA S'HAN FINALITZAT LES OPERACIONS DE LA LLISTA:
     * AGREGAR, BORRAR, ETC..
     * I ABANS DE TANCAR EL PROGAMA, SINÓ ES PERDRA TOT EL CONTINUGT DE LLISTA NO
     * GUARDAT ANTERIORMENT, JA QUE
     * EL MÉTODE ELIMINAR ERA MÉS FÀCIL LA IMPLEMENTACIÓ AIXÍ I ÉS MÉS EFICIENT
     */
    /**
     * Mètode per guardar la llista al arxiu Llista_reserves.ser
     * @param nomarxiu
     */
    public void guardarArxiu(String nomarxiu) {
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

    /**
     * toString
     */
    @Override
    public String toString() {
        String text = "";
        for (int i = 0; i < nElem; i++) {
            text = text + llista[i] + "\n";
        }
        return text;
    }

    /**
     * Getter
     */
    public int tamano() {
        return nElem;
    }

    /**
     * Mètode que elimina una instància de reserves concreta
     * @param reserva
     */
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

    /**
     * Mètode que buida l'arxiu
     */
    public void vaciar() {
        nElem = 0;
        String nomarxiu = "Llista_reserves.ser";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomarxiu))) {
        } catch (IOException e) {
            System.out.println("Error al intentar buidar l'arxiu: " + e.getMessage());
        }
    }

    /**
     * Crida a toString
     */
    public void imprimir() {
        System.out.println(toString());
    }

    /**
     * Mètode que comprova si la llista conté una instància de reserves específica
     * @param reserva - instància a buscar
     * @return true si sí hi és o false si no hi és
     */
    public boolean contiene(Reserves reserva) {
        boolean conte = false;
        for (int i = 0; i < nElem; i++) {
            if (llista[i].esIgual(reserva))
                conte = true;
        }
        return conte;
    }

    /**
     * Mètode private que comprova si una reserva ja és present
     * @param reserva
     * @throws Excepcions
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
    /**
     * Mètode que llegeix el contingut del fitxer llista_reserves.ser 
     * @param nomarxiu
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
                } catch (Exception e) {
                    fin = true; // Fin del archivo
                }
            }
            System.out.println("Cargado\n");
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo serializado\n");
            e.printStackTrace();
        }
    }

    /**
     * Mètode que troben tots els usuaris d'un taller concret
     * @param taller
     * @return subllista amb tots els usuaris apuntats
     */
    public LlistaUsuaris usuarisTaller(Tallers taller) {
        LlistaUsuaris usuaris = new LlistaUsuaris(nElem);
        for (int i = 0; i < nElem; i++) {
            if (llista[i].getCodiTaller().equalsIgnoreCase(taller.getCodi()))
                usuaris.agregar(llista[i].getUsuari());
        }
        return usuaris;
    }

    /**
     * Mètode que registra una valoració
     * @param valoracio
     * @param reserva
     * @return el codi del taller el qual s'ha valorat
     */
    public String valorarTaller(float valoracio, Reserves reserva) {
        reserva.valorar();
        return reserva.getCodiTaller();
    }

    /**
     * Mètode que troba una reserva específica
     * @param codiReserva
     * @return null si no s'ha trobat la reserva, sino retorna la instància de reserves que busquem
     */
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