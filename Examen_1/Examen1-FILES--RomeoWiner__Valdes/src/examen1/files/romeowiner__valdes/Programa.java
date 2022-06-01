/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.files.romeowiner__valdes;

import java.util.logging.Logger;

/**
 * REALIZAR EL MENU INFINITO CON LAS OPCIONES PARA EL USUARIO QUE LLEVEN A CADA ACCION 
 * 
 * @author 
 */
public class Programa {
    
    private static final Logger LOG = Logger.getLogger(Programa.class.getName());
    
    /**
     * 
     */
    public Programa() {
    }
    
    /**
     * 
     */
    public void iniciar()
    {        
            char op = Utilidades.menu();    
            switch (op) {
                case '1':
                    
                case '2':

                case '3':
                    //SALIR
                    System.exit( 0 );
                    break;
                default:
                   Utilidades.menu(); 
            }         
        
    }
    
    
    
}
