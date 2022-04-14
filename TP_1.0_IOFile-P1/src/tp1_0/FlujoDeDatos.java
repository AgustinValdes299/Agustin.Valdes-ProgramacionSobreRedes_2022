/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_0;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    public void printVectTxt(File archivoOrigen1, int[] aux){
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            if(archivoOrigen1.exists()){
                archivoOrigen1.createNewFile();
            }

            fw = new FileWriter(archivoOrigen1, true);
            pw = new PrintWriter(fw);

            for (int i = 0; i < aux.length; i++) {
                pw.println(aux[i]);
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
     * NO FUNCIONA
     * 
     * Crea el archivo donde se guardan los resultados y los guarda 
     * 
     * @param archivoResultado
     * @param numero1
     * @param numero2
     * @param resultado 
     */
    public void resultadosTxt(File archivoResultado, int[] numero1, int[] numero2, int[] resultado){
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            if(archivoResultado.exists()){
                archivoResultado.createNewFile();
            }

            fw = new FileWriter(archivoResultado, true);
            pw = new PrintWriter(fw);

            for (int i = 0; i < 4; i++) {
                pw.println(numero1[i] + " dividido " + numero2[i] + " es " + resultado[i]);
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
