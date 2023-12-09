package Classes;
/*
 * Classe constructora de la llista entitats, anira afegint entitats a una llista, no se encara si es podran emmagatzemar 2 entitats
 * iguals, ho preguntare i fare un mètode a part si escau. 
 */
public class LlistaEntitats extends Llista{
    
    private Entitats[] llista;

    /*Constructor de la classe 
     * @param mida de la llista
    */
    public LlistaEntitats(int mida){
        super();
        llista = new Entitats[mida];
    }

    /*Afegir una entitat donada per paràmetres, més endavant s'ha d'implementar el escriure al fitxer cada entitat quan es fiqui a la llista
     * @param nom de l'entitat
     * @param telefon
     * @param mail
    */
    public void afegir(String n, int telef, String mail) {
        if(nElem < llista.length){
            Entitats copia = new Entitats(n, telef, mail);
            llista[nElem] = copia;
            nElem++;
        }
    }
    /*Afegir una entitat ja en objecte */
    public void afegir(Entitats n){
        if(nElem < llista.length){
            llista[nElem] = n.copia();
            nElem++;
        }
    }

    /*toString encara no implementat */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }

    
    
}
