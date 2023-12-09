package Classes;

public class LlistaActivitats extends Llista{
    private Activitats[] llista;

    
    public LlistaActivitats(int capacitat){
        super();
        llista = new Activitats[capacitat];
    }
    
    public LlistaActivitats mateixDia (int dia) {
        LlistaActivitats aux = new LlistaActivitats(nElem);
        for(int i = 0; i < nElem; i++){
             if(llista[i].diaIgual(dia)){
                aux.afegirFinal(llista[i].copia());
             }
        }
        return aux;
    }

    /**
     * Mètode que troba el taller que tenia ocupació en proporció amb les places que oferia
     * @return taller que ha tingut més èxit    
     */
    public Tallers tallerExit (){ //
        int tallerSup = 0;
        for(int i= 0; i<nElem; i++){
            if(llista[i].getClass().getName() == "Tallers"){
                if (llista[i].proporcioTallers() > llista[tallerSup].proporcioTallers()) tallerSup = i;
            }
        }
        return (Tallers)llista[tallerSup];
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }
    

}
