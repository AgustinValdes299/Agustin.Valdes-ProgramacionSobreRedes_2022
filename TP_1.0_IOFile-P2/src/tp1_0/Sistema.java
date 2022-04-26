package tp1_0;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Agustin Valdes
 */
public class Sistema {
    PrintStream ps;
    FlujoDeDatos fdd;
    File archivo;
    
    
    /**
     * 
     */
    public Sistema(){
        ps = new PrintStream(System.out);
        fdd = new FlujoDeDatos();
    }
    
    
    /**
     * contiene el primer origen 
     * llama a la funcion que lo guarda en un archivo
     */
    public ArrayList primerOrigen(){
        File archivoOrigen1 = new File("primerOrigen.txt");
        FlujoDeDatos fdd = new FlujoDeDatos();
        ArrayList<Integer> aux = new ArrayList<Integer>();
        aux.add( 100 );
        aux.add( 200 );
        aux.add( 300 );
        aux.add( 400 );
        aux.add( 500 );

        fdd.printVectTxt(archivoOrigen1, aux); 
        
        return aux;
    }
    
    /**
     * almacena los datos ingresados por consola
     * muestra los datos ingresados 
     */
    public ArrayList segundoOrigen() {
        FlujoDeDatos fdd = new FlujoDeDatos();
        File archivo = new File( "segundoOrigen.txt" );
        
        ArrayList<Integer> aux = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++) {
            int n = parseInt( fdd.leer() );
            aux.add( n );
        }
        
        for ( int numero:aux ) {
            System.out.println( numero );
        }
        
        fdd.printVectTxt(archivo, aux);
        
        return aux;
    }

     
    /**
     * realiza el calculo del ejercicio 2 
     * muestra los resultados del calculo
     * @param datos 
     */
    public void calculo( ArrayList<Integer> L1, ArrayList<Integer> L2 ) {
        ArrayList<Integer> resultado = new ArrayList<Integer>();
        
        try{
            for ( int numero:L1 ) {
                int aux = numero / 3;
                resultado.add( aux );
            }
            for ( int numero:L2 ) {
                int aux = numero / 3;
                resultado.add( aux );
            }
            
            archivoResultado( L1,L2,resultado );  
        }//try
        catch (ArithmeticException | NullPointerException ex) {
            archivoError(L1,L2);
        }//catch
        
    }//calculo()
    
    public void archivoError( ArrayList<Integer> L1,ArrayList<Integer> L2 ){
       File archivoError = new File("error.txt");
       fdd.errorTxt(archivoError, L1, L2);
    }
    
    /**
     *instancia el File en el que se va a guardar el resultado
     * llama a la funcion 
     * 
     * @param resultados
     */
    public void archivoResultado( ArrayList<Integer> L1,ArrayList<Integer> L2,ArrayList<Integer> resultados ){
       File archivoResultado = new File("resultadoVec.txt");
       fdd.printVectTxt(archivoResultado, resultados);
    }
    
    
    


}
    
       
    
    
    


