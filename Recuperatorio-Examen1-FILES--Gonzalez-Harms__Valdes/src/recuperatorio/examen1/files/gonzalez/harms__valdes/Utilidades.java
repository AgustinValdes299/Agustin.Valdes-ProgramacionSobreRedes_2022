/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recuperatorio.examen1.files.gonzalez.harms__valdes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Métodos útiles
 * @author Soft 05
 */
public class Utilidades {
    
    PrintStream ps = new PrintStream(System.out);
    
    /**
     * Se lee por consola
     * @return 
     */
    public String leerConsola(){
        String texto = "";
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        boolean val = false;
        
        do{
            try {
                texto = br.readLine();
                val = validar(texto);
            } catch (IOException ex) {
                Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while(!val);
            
       
        return texto;
    }
    
    /**
     * Se valida un dato ingresado
     * @param a
     * @return 
     */
    public boolean validar(String a){
        
        boolean val = false;
        
        
        if(a != ""){
            
            val = true;
            
        }else{
            
            val = false;
            ps.println("Dato ingresado no válido");
            
        }
        
        return val;
    }
    
    /**
     * Se valida si un dato ingresado es un número
     * @param a
     * @return 
     */
    public boolean validarNum(String a){
        
        boolean val = false;
        
        try{
            
            Integer.parseInt(a);
            val = true;
            
        }catch(NumberFormatException e){
            
            ps.println("Dato ingresado no valido");
            
        }
        
        
        return val;
    }
    
    
     
    
    
}
