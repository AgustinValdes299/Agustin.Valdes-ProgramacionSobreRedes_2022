package TP_1_1;

import java.util.StringTokenizer;

/**
 *
 * @author localuser
 */
public class Ejercicio {
    FlujoDeDatos fdd = new FlujoDeDatos();
    
    /**
     * 
     */
    public Ejercicio() {
    }
    
    /**
     * al ingresar una operacion aritmetica la realiza
     * muestra la operacion por consola
     */
    public void OperacionArit(){
        fdd.escribir( "Ingrese una operacion aritmetica: " );
        String lectura = fdd.leer();
        StringTokenizer st = new StringTokenizer( lectura );
        
        double resultado;
        double numero1 = Integer.parseInt( st.nextToken() );
        String operador = st.nextToken();
        double numero2 = Integer.parseInt( st.nextToken() );
        
        switch( operador ){
            case "+":
                resultado = numero1 + numero2;
                fdd.escribir( numero1 + " + " + numero2 + " = " + resultado );
                break;
            case "-":
                resultado = numero1 - numero2;
                fdd.escribir( numero1 + " - " + numero2 + " = " + resultado );
                break;
            case "*":
                resultado = numero1 * numero2;
                fdd.escribir( numero1 + " * " + numero2 + " = " + resultado );
                break;
            case "/":
                resultado = numero1 / numero2;
                fdd.escribir( numero1 + " / " + numero2 + " = " + resultado );
                break;
        }
    }
}
