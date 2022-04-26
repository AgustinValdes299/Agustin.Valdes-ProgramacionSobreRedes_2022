package TP_1_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Agustin Valdes
 */
public class FlujoDeDatos {
    PrintStream ps;
    InputStreamReader is;
    BufferedReader br;
    
    //constructor
    public FlujoDeDatos() {
        is = new InputStreamReader( System.in );
        br = new BufferedReader( is );
        ps = new PrintStream(System.out);
    }
    
    String leer() {
        try {
            String a = br.readLine();
            return a;
            
        } catch (IOException ex) {
            Logger.getLogger(FlujoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    void escribir( String str ){
        String aux = str;
        ps.println( aux );
    }
    
}
