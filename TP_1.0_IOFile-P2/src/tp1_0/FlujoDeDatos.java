package tp1_0;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Agustin Valdes
 */
public class FlujoDeDatos {
    
    
    
    /**
     * guarda los valores del primer origen en un archivo 
     * 
     * @param archivo
     * @param aux 
     */
    public void printVectTxt(File archivoOrigen1, ArrayList<Integer> aux){
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            if(archivoOrigen1.exists()){
                archivoOrigen1.delete();
                archivoOrigen1.createNewFile();
            }

            fw = new FileWriter(archivoOrigen1, true);
            pw = new PrintWriter(fw);

            for ( int numero:aux ) {
                pw.println(numero);
            }
        } catch (IOException ex) {
            Logger.getLogger(FlujoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (pw != null) {
                    pw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(FlujoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void errorTxt(File archivoError, ArrayList<Integer> L1, ArrayList<Integer> L2){
        archivoError.delete();
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            if(archivoError.exists()){
                archivoError.createNewFile();
            }

            fw = new FileWriter(archivoError, true);
            pw = new PrintWriter(fw);

//            for (int i = 0; i < 4; i++) {
//                pw.println(numero1[i] + " / " + numero2[i] + " = error matematico");
//            }
            
            for ( int numero:L1 ) {
                pw.print( numero + " / " );
            }
            for ( int numero:L2 ) {
                pw.println( numero + " = error matematico " );
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FlujoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (pw != null) {
                    pw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(FlujoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * lee los datos ingresados 
     * 
     * @return 
     */
    String leer(){
        int Byte = -1;
        String n = "";
        try {
            while((Byte = System.in.read()) != '\n'){
                n = n + (char)Byte;
            }
        } catch (IOException ex) {
            Logger.getLogger(FlujoDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //System.out.println(n);
            return n;
     
        }
        
    }
    
    
    
    
    
    
}
