package Classes;

public class LlistaEntitats extends Llista{
    private Entitats[] llista;
    public LlistaEntitats(int mida){
        super();
        llista = new Entitats[mida];
    }

    public void afegir(String n, int telef, String mail) {
        if(nElem < llista.length){
            Entitats copia = new Entitats(n, telef, mail);
            llista[nElem] = copia;
            nElem++;
        }
    }

    public void afegir(Entitats n){
        if(nElem < llista.length){
            llista[nElem] = n.copia();
            nElem++;
        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }


    
    
}
