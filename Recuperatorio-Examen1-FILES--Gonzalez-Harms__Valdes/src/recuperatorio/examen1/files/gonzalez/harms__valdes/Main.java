/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recuperatorio.examen1.files.gonzalez.harms__valdes;

import java.io.File;
import java.io.PrintStream;

/**
 *
 * @author Soft 05
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File productos = new File("productos.csv");
        PrintStream ps = new PrintStream(System.out);
        Utilidades u = new Utilidades();
        Archivos ar = new Archivos(productos);
        
        String op = "";
        int opNum = -1;
        
        do{
            
        ps.println("MENU\n"
                + "[1] Agregar Producto\n"
                + "[2] Mostrar productos\n"
                + "[3] Calcular stock\n"
                + "[0] Salir");  
        
        op = u.leerConsola();
        
        if(u.validar(op)){
            
            if(u.validarNum(op)){
                
                opNum = Integer.parseInt(op);
                
            }
            
        }
        
        switch(opNum){
            
            case 1:
                ps.println("Agregar producto");
                ar.agregarDatos();
                break;
            case 2:
                ps.println("Mostrar productos");
                ar.mostrarProductos();
                break;
            case 3:
                ps.println("Calcular Stock");
                break;
            case 0:
                ps.println("Salir");
                break;
                
            default:
                ps.println("Opcion no valida");
                break;
             
            
        }
            
        }while(opNum != 0);
        
        
    }
        
        
        
        
    
}
