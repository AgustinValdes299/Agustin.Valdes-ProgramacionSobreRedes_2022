package TP_1_1;

import java.io.IOException;
import static java.lang.Integer.parseInt;

/**
 *
 * @author Agustin Valdes
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        FlujoDeDatos fdd = new FlujoDeDatos();
        Ejercicio ej = new Ejercicio();
        
        int ciclo = -1;
        while( ciclo != 0 ){
            ej.OperacionArit();
            fdd.escribir( "\nIngrese 0 si ya no quiere realizar mas operaciones" );
            ciclo = parseInt( fdd.leer() );
        }
    }
    
}
