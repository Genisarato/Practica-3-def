package Classes;


public abstract class Llista<T> {

    protected int nElem;
    public  Llista(){
        nElem = 0;
    }

    // Métodos abstractos que deben ser implementados por las subclases
    public abstract void agregar(T elemento);
    public abstract void eliminar(T elemento);
    public abstract boolean contiene(T elemento);
    public abstract int tamano();
    public abstract void imprimir();
    public abstract void vaciar();
    public abstract String toString();
    /*Pou aixo dixau q son proves, pasa del tema este q ia teu asplicare :) */
    //pasaallista(String llegit);

}
