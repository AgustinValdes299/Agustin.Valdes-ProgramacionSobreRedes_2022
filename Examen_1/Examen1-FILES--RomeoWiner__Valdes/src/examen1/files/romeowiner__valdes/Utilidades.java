/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.files.romeowiner__valdes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.logging.Logger;

/**
 *
 * FUNCIONALIDADES PARA LEER Y ESCRIBIR POR LA CONSOLA O POR ARCHIVOS
 * FUNCIONALADES DE VALIDADCION DE DATOS FUNCIONALIDADES EXTRAS QUE SEAAN
 * GENERALES
 *
 * @author
 */
public class Utilidades {
    FlujoDeDatos fdd = new FlujoDeDatos();

    private static final Logger LOG = Logger.getLogger(Utilidades.class.getName());
    
    public void arreglarArchivo( String textoArreglado ){
        File aux = fdd.crearTxt( "auxiliar.txt" );
        fdd.escribirTxt(aux, textoArreglado);
    }
    
    public String formatearRenglones( String texto,File f ) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        
        String textoArreglado = "";
        String linea = "";
        while ((linea = br.readLine()) != null) {
            textoArreglado += "\n" + formatearRenglon(linea);
        }

        br.close();
        fr.close();

        return textoArreglado;
    }
    //lee un String, lo formatea al formato correcto y lo retorna
    public String formatearRenglon( String texto ){
        String textoReformado = texto.replace( "+",";" );
        
        return textoReformado;
    }
    
    /**
     * 
     * @return 
     */
    public int menu() throws IOException {
        int op;
           
        do{
            fdd.escribir( "MENÚ PRINCIPAL" );
            fdd.escribir( "[1] Cargar datos en archivo estandar" );
            fdd.escribir( "[2] Mostrar datos en terminal" );
            fdd.escribir( "[3] Mostrar mes con mas victorias" );
            fdd.escribir( "[4] Cerrar programa" );
            fdd.escribir( "Elija una opcion >>>" );
            op = parseInt( fdd.leer() );

            if (op > 0 && op < 5) {
                fdd.escribir( "\nOpcion Ingresada: "+op+"\n" );
                switch(op){
                    case 1:
                        break;
                    case 2:
                        File archivo = fdd.crearTxt_sinBorrar("juegos.dat" );
                        String texto = fdd.LeerFileConBuffer( archivo );
                        String textoArreglado = formatearRenglones(texto, archivo);
                        fdd.escribir(textoArreglado);
                        break;
                    case 3:
                        break;                        
                }
            }
            else{
                fdd.escribir( "\nNUMERO INGRESADO INVALIDO" );
                fdd.escribir( "Cerrando el programa..." );
            }
        } 
        while( op > 0 && op < 4 );
            
        return op;
    }

    public static void mostrarMensaje(){
        
    }
    
    /**
     * 
     * @return 
     */
    public static int leerNumero()
    {
        
        return 0;
    }
    
    /**
     * 
     * @return 
     */
    public static String leerTexto()
    {
        
        return "";
    }
    
    /**
     * 
     * @param tipo
     * @return 
     */
    public static boolean validar(char tipo)
    {
        switch(tipo)
        {
            case 's':
                
            case 'n':
                
            case 'd':
                
            case 'c':    
        }
        
        return true;
    }
}
