/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_0;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.IOException;
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
    public void primerOrigen(){
        File archivoOrigen1 = new File("primerOrigen.txt");
        FlujoDeDatos fdd = new FlujoDeDatos();
        int[] aux = {1, 0, 2, 3, 0, 4, 5};
        fdd.printVectTxt(archivoOrigen1, aux); 
    }
    
    
    /**
     * almacena los datos ingresados por consola
     * muestra los datos ingresados 
     */
    public void segundoOrigen() {
        FlujoDeDatos fdd = new FlujoDeDatos();
        int datos[] = new int[5];
        String auxDato = "";
        ArrayList datosIngresados = new ArrayList();

        for (int i = 0; i < 5; i++) {
            datos[i] = Integer.parseInt(fdd.leer());
            datosIngresados.add(datos[i]);
        }
        System.out.println("");
        System.out.println("Los valores ingresados son: " + datosIngresados + '\n');
        calculo(datos);

    }

     
    /**
     * realiza el calculo del ejercicio 2 
     * muestra los resultados del calculo
     * @param datos 
     */
    public void calculo(int[] datos) {
        float numero1[] = new float[5];
        float numero2[] = new float[5];
        float resultado[] = new float[5];
        
        try{
            for (int i = 0; i < 4; i++) {
                numero1[i] = datos[i];
                numero2[i] = datos[i + 1]-3;
                if (numero2[i] == 0){
                    throw new ArithmeticException();
                }//if
                else{
                    resultado[i] = numero1[i]/numero2[i];
                    System.out.println(numero1[i] + " dividido " + numero2[i] + " es " + resultado[i]);
                    
                }//else
            }//for
            archivoResultado( numero1, numero2, resultado);  
        }//try
            catch (ArithmeticException | NullPointerException ex) {
                archivoError(numero1, numero2);
        }//catch
        
    }//calculo()
    
    
    
    /**
     * instancia el File en el que se va a guardar el error
     * llama a la funcion errorTxt
     * 
     * @param numero1
     * @param numero2 
     */
    public void archivoError(float[] numero1, float[] numero2){
       File archivoError = new File("error.txt");
       fdd.errorTxt(archivoError, numero1, numero2);
    }
    
    
    /**
     *instancia el File en el que se va a guardar el resultado
     * llama a la funcion resultadosTxt
     * 
     * @param numero1
     * @param numero2
     * @param resultado 
     */
    public void archivoResultado(float[] numero1, float[] numero2, float[] resultado){
       File archivoResultado = new File("resultado.txt");
       fdd.resultadosTxt(archivoResultado, numero1, numero2, resultado);
    }
    

}