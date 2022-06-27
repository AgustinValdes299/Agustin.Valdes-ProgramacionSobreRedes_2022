/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recuperatorio.examen1.files.gonzalez.harms__valdes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Acá se manipulan y leen archivos
 * @author Soft 05
 */
public class Archivos {
    
    Utilidades u = new Utilidades();
    PrintStream ps = new PrintStream(System.out);
    File archivo;
   
    public Archivos(File archivo){
        
        this.archivo = archivo;
        
    }
    
    /**
     * Se escribe en el archivo
     * @param archivo
     * @param texto 
     */
    
     public void escribir( File archivo,String texto ){
        try {
            FileWriter fw = new FileWriter(archivo, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(texto);
            
            pw.close();
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Se agregan datos en el archivo
     */
    public void agregarDatos(){
        
        String texto = "";
        ps.print("Ingresa el tipo de producto: ");
        texto += u.leerConsola() + ";";
        ps.print("Ingresa la marca: ");
        texto += u.leerConsola() + ";";
        ps.print("Ingresa el stock: ");
        texto += u.leerConsola() + ";";
        ps.print("Ingresa el precio: ");
        texto += u.leerConsola();
        ps.println(texto);
        escribir(archivo, texto);
        
        
        
    }
    
    /**
     * Se lee elcontenido del archivo
     * @return 
     */
    public String leerArchivos(){
        
        String aux = "";
        String linea = "", texto = "";
        
        if (archivo.exists()) {

            try {
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                
                
                
                while ((linea = br.readLine()) != null) {
                    texto += "\n" + linea;
                }

                br.close();
                fr.close();
                

        
            }catch (FileNotFoundException ex) {
                Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return texto;
        
    }
    
    /**
     * Se muestran los contenidos del archivo por pantalla
     */
    public void mostrarProductos(){
       
        
        ps.println(leerArchivos().replace(";", " "));
        
    }
    
    /**
     * Se calcula el stock de cada producto
     */
    public void calcularStock(){
        
        
        if(archivo.exists()){
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea = "";
            String[] aux;
            LinkedHashMap<Integer, Integer> stock = new LinkedHashMap<>();
            ArrayList<String[]> cantidad = new ArrayList<>();
            
            while((linea = br.readLine()) != null){
                
                aux = linea.split(";");
                cantidad.add(aux);
                
            }
            
                     
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 

            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
        
    }
    
    
}
