package Classes;
/*Els tallers es fan en una hora concreta del dia, i tenen una durada determinada. Tenen també
una capacitat fixada, i els usuaris s’hi ha de registrar*/
public class Tallers extends Activitats {
    private int hora, dia_t, durada, capacitat, usuarisApuntats;
    private int[] valoracions, usuariosValor;

    public float mitjanaValoracions(){
        int i;
        float sumaValoracions = 0.0f;
        if(usuarisApuntats == 0){
            return 0.0f;
        }
        for(i = 0; i<usuarisApuntats; i++){ //mirar si valoracio obligatoria o no
            /*mira quin taller et demanen*/
            sumaValoracions = sumaValoracions + valoracions[i];
        }
        sumaValoracions = sumaValoracions/usuarisApuntats;
        return sumaValoracions;
    }
    public float proporcioTallers(){
        float proporcio = 0;
        proporcio = usuarisApuntats/capacitat;
        return proporcio;
    }



    
}
