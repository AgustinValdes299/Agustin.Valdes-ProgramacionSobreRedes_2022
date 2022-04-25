package tp1_0;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Agustin Valdes
 */
public class Main {
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        Sistema s = new Sistema();
        FlujoDeDatos fdd = new FlujoDeDatos();
        
        ArrayList<Integer> lista1 = s.primerOrigen();
        ArrayList<Integer> lista2 = s.segundoOrigen();     
        
        s.calculo(lista1, lista2);
    }
    
}
