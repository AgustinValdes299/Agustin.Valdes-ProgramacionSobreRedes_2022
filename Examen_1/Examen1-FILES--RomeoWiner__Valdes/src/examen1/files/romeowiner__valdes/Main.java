/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.files.romeowiner__valdes;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class Main {
    
    private static final Logger LOG = Logger.getLogger(Main.class.getName());
    /**
     * SOLO PREPARAR EL ARCHIVO (CON ORIENCION A OBJETOS) Y LUEGO LLAMAR AL FUNCIONAMIENTO DEL PROGRAMA
     * @param args 
     */
    public static void main(String[] args) throws IOException {
        Utilidades ut = new Utilidades();
        FlujoDeDatos fdd = new FlujoDeDatos();
        
        ut.menu();
        
        File archivo = fdd.crearTxt_sinBorrar("juegos.dat" );
        String texto = fdd.LeerFileConBuffer( archivo );
        String textoArreglado = ut.formatearRenglones(texto, archivo);
        ut.arreglarArchivo(textoArreglado);
    }
    
    
    
}
