package Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*Classe de llista usuaris, amb el seu constructor, com que no tinc decidit fer la excepcio del nickname, que suposo que al main, he fet
 * un mètode auxiliar per controlar que no hi ha cap nicnkame igual a la llista. S'hauria de implementar una excepcio, més endevant ho
 * intentaré :)
 */
public class LlistaUsuaris extends Llista{
    
    private Usuaris[] llista;
    /*Constructor
     * @param mida de la llista
     */
    public LlistaUsuaris(int mida){
        super();
        llista = new Usuaris[mida];
    }
    
    /*Mètode afegir pasant tot per paràmetre i comprovant que no hi ha cap nickname igual,
     * més endavant s'ha d'implementar el escriure al fitxer cada entitat quan es fiqui a la llista
     * @param nom/nickanme
     * @param mail
     * @param codi Postal
     */
    public void afegir(String nom, String mail, int codi){
        if(nElem<llista.length){
            if(nicknameigual(nom)){
                System.out.println("El nickname ja esta utilitzat.");
            }
            else {
                Usuaris usuari = new Usuaris(nom, mail, codi);
                llista[nElem] = usuari.copia();
                nElem++;
                guardarArxiu(usuari);
            }
        }
    }

    /*Mètode afegir pasant un usuari directament que també comprova que no hi ha cap nickname igual,
     * més endavant s'ha d'implementar el escriure al fitxer cada entitat quan es fiqui a la llista
     * @param usuari
     */
    public void afegir(Usuaris n){
        if(nElem < llista.length){
            if(nicknameigual(n.getNickname())){
                System.out.println("El nickname ja esta utilitzat.");
            }
            else{
                llista[nElem] = n.copia();
                nElem++;
                guardarArxiu(n);
            }
        }
    }

    public void guardarArxiu(Usuaris n){
         String nombreArchivo = "Llista_usuaris.txt";

        // Obtener la ruta absoluta del archivo
        String rutaAbsoluta = new File("src", nombreArchivo).getAbsolutePath();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaAbsoluta, true))){
            bw.write(n.toString());
            bw.newLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    /*Mètode toString no implementat */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }

    /*Mètode que comprova que el nickname no està a la llista*/
    private boolean nicknameigual(String nom){
        boolean trobat = false;
        for(int i = 0; i<nElem; i++){
            if(llista[i].getNickname().equalsIgnoreCase(nom)) trobat =  true;
        }
       return trobat;   
    }

    
}
