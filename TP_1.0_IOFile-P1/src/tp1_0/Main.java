/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_0;

import java.io.File;
import java.io.IOException;
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
        
        s.primerOrigen();
        s.segundoOrigen();
        
        
        
        //fdd.leer();
        
        
        
    }
    
}
