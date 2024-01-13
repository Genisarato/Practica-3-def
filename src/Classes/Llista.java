package Classes;


public abstract class Llista<T> {
    protected int nElem;

    public Llista(){
        nElem = 0;
    }

    // Métodos abstractos que deben ser implementados por las subclases

    /**
     * Mètode que s'encarrega d'afegir instàncies a una llista
     * @param elemento
     * @throws Excepcions
     */
    public abstract void agregar(T elemento) throws Excepcions;

    /**
     * Mètode que elimina una instància en concret
     * @param elemento
     */
    public abstract void eliminar(T elemento);

    /**
     * Mètode que comprova si hi ha un cert element a la llista
     * @param elemento
     * @return true si hi és present, false si no hi és
     */
    public abstract boolean contiene(T elemento);

    /**
     * Getter de nElem
     * @return nElem
     */
    public abstract int tamano();
    
    /**
     * Crida a toString dins la classe
     */
    public abstract void imprimir();

    /**
     * Mètode que buida un fitxer
     */
    public abstract void vaciar();

    /**
     * toString
     */
    public abstract String toString();
}
