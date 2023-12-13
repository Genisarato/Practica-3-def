package Classes;

/*Els tallers es fan en una hora concreta del dia, i tenen una durada determinada. Tenen també
una capacitat fixada, i els usuaris s’hi ha de registrar*/
public class Tallers extends Activitats {
    private int hora, dia_t, durada, capacitat, usuarisApuntats;
    private int[] valoracions, usuariosValor;

    // Otros atributos y métodos...

    public int getHora() {
        return hora;
    }

    public getDurada() {
        return durada;
    }

    public void agregarValoracion(int valoracion) {
        // Verificar si hay espacio para más valoraciones
        if (usuarisApuntats < valoracions.length) {
            // Añadir la valoración al arreglo
            valoracions[usuarisApuntats] = valoracion;
            // Incrementar el contador de usuarios apuntados
            usuarisApuntats++;
        } else {
            System.out.println("No hay espacio para más valoraciones.");
        }
    }

    public float mitjanaValoracions() {
        int i;
        float sumaValoracions = 0.0f;
        if (usuarisApuntats == 0) {
            return 0.0f;
        }
        for (i = 0; i < usuarisApuntats; i++) {
            sumaValoracions = sumaValoracions + valoracions[i];
        }
        sumaValoracions = sumaValoracions / usuarisApuntats;
        return sumaValoracions;
    }

    public float proporcioTallers() {
        float proporcio = 0;
        proporcio = (float) usuarisApuntats / capacitat;
        return proporcio;
    }
}
