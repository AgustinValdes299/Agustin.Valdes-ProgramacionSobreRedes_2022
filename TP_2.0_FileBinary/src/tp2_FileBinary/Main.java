/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_FileBinary;

import java.io.IOException;

/**
 *
 * @author Agus
 */
public class Main {

    public static void main(String[] args) {
        
        Sistemita s = new Sistemita();
        String archivo = "datos.bin";
        
        try
        {
            s = s.deSerializar( archivo );
            Utilidades.mostrarPorPantalla("VIEJO");
        }catch( IOException | ClassNotFoundException ex ){
            s.creacion();
            Utilidades.mostrarPorPantalla("NUEVO");
        }finally{
            s.prender();
        }
        
        try
        {
            s.serializar( archivo );
        }catch(IOException ex){
            Utilidades.mensajeError( ex.getMessage() , "ERROR: No se pudo Serializar." );
        }
        
    }
    
}

