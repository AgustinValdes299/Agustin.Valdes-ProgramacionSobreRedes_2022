package guia_1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Agustin Valdes y Agustin Winer
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        FlujoDeDatos fdd = new FlujoDeDatos();
        ClaseEjerciciosIO ej = new ClaseEjerciciosIO();
        
        //Ejercicio 1
        fdd.escribir( "Ejercicio 1.a" );
        //ej.resolucionEjercicio1a();
        
        fdd.escribir( "Ejercicio 1.b" );
        //ej.resolucionEjercicio1b();
        
        fdd.escribir( "Ejercicio 1.c" );
        //ej.resolucionEjercicio1c();
        
        fdd.escribir( "Ejercicio 1.d" );
        //ej.resolucionEjercicio1d();
        
        fdd.escribir( "Ejercicio 1.e" );
        //ej.resolucionEjercicio1e();
        
        fdd.escribir( "Ejercicio 1.f" );
        //ej.resolucionEjercicio1f();
        
        fdd.escribir( "Ejercicio 1.g" );
        //ej.resolucionEjercicio1g();
                
        //Ejercicio 2===
        fdd.escribir( "Ejercicio 2.a" );
        //ej.resolucionEjercicio2a();
        
        fdd.escribir( "Ejercicio 2.b" );
        //ej.resolucionEjercicio2b();
        
        fdd.escribir( "Ejercicio 2.c" );
        //ej.resolucionEjercicio2c();
        
        fdd.escribir( "Ejercicio 2.d" );
        //ej.resolucionEjercicio2d();
        
        fdd.escribir( "Ejercicio 2.e" );
        //ej.resolucionEjercicio2e();
        
        fdd.escribir( "Ejercicio 2.f" );
        //ej.resolucionEjercicio2f();
        
        fdd.escribir( "Ejercicio 2.g" );
        //ej.resolucionEjercicio2g();
        
        fdd.escribir( "Ejercicio 2.h" );
        //ej.resolucionEjercicio2h();
        
        //Ejercicio 3===
        /**PRUEBAS
        String nombreArchivo = "Archivo_Ejercicio_3";
        String texto = "Holaa que onda";
        
        File archivo = fdd.crearTxt( nombreArchivo );
        fdd.escribirTxt(archivo, texto);
        **/
        
        fdd.escribir( "Ejercicio 3.a" );
        //ej.resolucionEjercicio3a();
        
        fdd.escribir( "Ejercicio 3.b" );
        //ej.resolucionEjercicio3b();
        
        //ArrayList<Integer> palabra = fdd.leerEnBytes();
        //fdd.leerEnBytes();
        //System.out.println( palabra );
        
        fdd.escribir( "Ejercicio 3.c" );
        File numerosTXT =  ej.resolucionEjercicio3c();
        
        fdd.escribir( "Ejercicio 3.d" );
        //ej.resolucionEjercicio3d( numerosTXT );
        
        fdd.escribir( "Ejercicio 3.e" );
        File nuevoTxt = ej.resolucionEjercicio3e( numerosTXT );
        
        fdd.escribir( "Ejercicio 3.f" );
        ej.resolucionEjercicio3f( nuevoTxt );
        
        fdd.escribir( "Ejercicio 3.g" );
        //ej.resolucionEjercicio3g( nuevoTxt );
    }
    
}
