package guia_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author localuser
 */
public class ClaseEjerciciosIO {
    FlujoDeDatos fdd = new FlujoDeDatos();
    
    //constructor
    public ClaseEjerciciosIO() {
    }
    
    //metodos (un metodo por ejercicio)
    //Ejercicio 1
    public void resolucionEjercicio1a(){
        Float valorHora = parseFloat( fdd.leer() );
        Float cantHs = parseFloat( fdd.leer() );
        
        Float sueldo = valorHora * cantHs;
        
        fdd.escribir( "Valor del sueldo Bruto: "+sueldo.toString() );
    }
    public void resolucionEjercicio1b(){
        int angulo1 = parseInt( fdd.leer() );
        int angulo2 = parseInt( fdd.leer() );
        
        int anguloRestante = 180 - (angulo1 + angulo2);
        fdd.escribir( "Valor del angulo restante: "+anguloRestante );
    }
    public void resolucionEjercicio1c(){
        int m2 = parseInt( fdd.leer() );
        
        int perimetro = m2 * 4;
        fdd.escribir( "Perimetro: "+perimetro+"mts." );
    }
    public void resolucionEjercicio1d(){
        float tempF = parseFloat( fdd.leer() );
        System.out.println(tempF);
        float tempC = (tempF - 32) * parseFloat( "0.5556" );
        
        fdd.escribir( "Temperatura en Celsius: "+tempC+"C." );
    }
    
    //aun no funciona
//    public void resolucionEjercicio1e(){
//        int t = parseInt( fdd.leer() );
//        
//        int dias = t /86400;
//        int hs = t / 3600 ;
//        int min = t / 60 ;
//        
//        fdd.escribir( dias+"-"+hs+"-"+min );
//    }
    
    public void resolucionEjercicio1f(){
        float precio = parseFloat( fdd.leer() );
        fdd.escribir( "Precio Inicial: " );
        fdd.escribir( precio );
        int plan = parseInt(fdd.leer());
            
        switch(plan){
            case 1:
                double precio1= precio * 0.9;
                fdd.escribir( "Plan 1 - Precio Final" );
                fdd.escribir( precio1 );
                break;
            case 2:
                double precio2= precio * 1.1;
                fdd.escribir( precio2 );
                break;
            case 3:
                double precio3= precio * 1.15;
                fdd.escribir( precio3 );
                break;
            case 4:
                double precio4= precio * 1.25;
                fdd.escribir( precio4 );
                break;
        }
    }
    public void resolucionEjercicio1g(){
        String signo = fdd.leer();
        signo = signo.toLowerCase();
        int mes = 0;
            
        switch(signo){
            case "capricornio":
                mes = 1;
                break;
            case "acuario":
                mes = 2;
                break;
            case "piscis":
                mes = 3;
                break;
            case "aries":
                mes = 4;
                break;
            case "tauro":
                mes = 5;
                break;
            case "geminis":
                mes = 6;
                break;
            case "cancer":
                mes = 7;
                break;
            case "leo":
                mes = 8;
                break;
            case "virgo":
                mes = 9;
                break;
            case "libra":
                mes = 10;
                break;
            case "escorpio":
                mes = 11;
                break;
            case "sagitario":
                mes = 12;
                break;
        }
        fdd.escribir( "Mes de nacimiento: " );
        fdd.escribir( mes );
    }
    
    //Ejercicio 2
    public void resolucionEjercicio2a(){
        List <String> apellidos = new ArrayList<String>();
        
        fdd.escribir( "Ingrese 3 nombres:" );
        
        String apellido1 = fdd.leer();
        apellido1 = apellido1.toLowerCase();
        String apellido2 = fdd.leer();
        apellido2 = apellido2.toLowerCase();
        String apellido3 = fdd.leer();
        apellido3 = apellido3.toLowerCase();
        
        apellidos.add( apellido1 );
        apellidos.add( apellido2 );
        apellidos.add( apellido3 );
        
        Collections.sort( apellidos );
        
        fdd.escribir( "Apellidos ordenados alfabeticamente: " );
        for ( String apellido:apellidos ) {
            fdd.escribir(apellido);
        }
    }
    public void resolucionEjercicio2b(){
        List <Integer> numeros = new ArrayList<Integer>();
        
        fdd.escribir( "Ingrese 4 numeros reales:" );
        
        int n1 = parseInt( fdd.leer() );
        int n2 = parseInt( fdd.leer() );
        int n3 = parseInt( fdd.leer() );
        int n4 = parseInt( fdd.leer() );
        
        numeros.add( n1 );
        numeros.add( n2 );
        numeros.add( n3 );
        numeros.add( n4 );
        
        Collections.sort( numeros );
        
        fdd.escribir( "El numero menor es: " );
        for ( int numero:numeros ) {
            fdd.escribir(numero);
            break;
        }
    }
    public void resolucionEjercicio2c(){
        fdd.escribir( "Ingrese 1 numero real:" );
        int n = parseInt( fdd.leer() );
        
        if( n%2 == 0 ){
            fdd.escribir( "El numero '"+n+"' es PAR" );
        }else{
            fdd.escribir( "El numero '"+n+"' es IMPAR" );
        }
    }
    public void resolucionEjercicio2d(){
        int mayor = -1;
        int menor = -1;
        Boolean sonIguales;
        
        fdd.escribir( "Ingrese 2 numeros reales:" );
        int n1 = parseInt( fdd.leer() );
        int n2 = parseInt( fdd.leer() );
        
        if( n1 > n2 ){
            mayor = n1;
            menor = n2;
            sonIguales = false;
        }else if( n1 < n2 ){
            mayor = n2;
            menor = n1;
            sonIguales = false;
        }else{
            sonIguales = true;
        }
        
        if( mayor % menor == 0 ){
            fdd.escribir( "El N° mayor '"+mayor+"' es divisible por el menor '"+menor+"'" );
        }else if( sonIguales ){
            fdd.escribir( "Ambos numeros son iguales" );
        }else{
            fdd.escribir( "El N° mayor '"+mayor+"' NO es divisible por el menor '"+menor+"'" );
        }
    }
    public void resolucionEjercicio2e(){
        String signo = "";
        
        fdd.escribir( "Introduzca su fecha de nacimiento en numero: " );
        fdd.escribir( "Año:" );
        int anio = parseInt( fdd.leer() );
        fdd.escribir( "Mes:" );
        int mes = parseInt( fdd.leer() );
        fdd.escribir( "Dia:" );
        int dia = parseInt( fdd.leer() );
            
        switch(mes){
            case 1:
                signo = "Capricornio";
                break;
            case 2:
                signo = "Capricornio";
                break;
            case 3:
                signo = "Capricornio";
                break;
            case 4:
                signo = "Capricornio";
                break;
            case 5:
                signo = "Capricornio";
                break;
            case 6:
                signo = "Capricornio";
                break;
            case 7:
                signo = "Capricornio";
                break;
            case 8:
                signo = "Capricornio";
                break;
            case 9:
                signo = "Capricornio";
                break;
            case 10:
                signo = "Capricornio";
                break;
            case 11:
                signo = "Capricornio";
                break;
            case 12:
                signo = "Capricornio";
                break;
        }
        fdd.escribir( "Signo: " );
        fdd.escribir( signo );
    }
    public void resolucionEjercicio2f(){
        fdd.escribir( "Ingrese 1 nombre:" );
        String nombre1 = fdd.leer();
        nombre1 = nombre1.toLowerCase();
        fdd.escribir( "Ingrese 1 apellido:" );
        String apellido1 = fdd.leer();
        apellido1 = apellido1.toLowerCase();
        
        fdd.escribir( "Ingrese otro nombre:" );
        String nombre2 = fdd.leer();
        nombre2 = nombre2.toLowerCase();
        fdd.escribir( "Ingrese otro apellido:" );
        String apellido2 = fdd.leer();
        apellido2 = apellido2.toLowerCase();
        
        if( apellido1.length() > apellido2.length() ){
            fdd.escribir( "El apellido '"+apellido1+"' es mas largo que el apellido '"+apellido2+"'" );
        }else if( apellido1.length() < apellido2.length() ){
            fdd.escribir( "El apellido '"+apellido2+"' es mas largo que el apellido '"+apellido1+"'" );
        }else{
            fdd.escribir( "Ambos apellidos tienen el mismo largo" );
        }
    }
    public void resolucionEjercicio2g(){
        fdd.escribir( "Ingrese  numero real:" );
        int n = parseInt( fdd.leer() );
        
        fdd.escribir( "Tabla de multiplicar de '"+n+"':" );
        for (int i = 1; i < 11; i++) {
            fdd.escribir( n*i );
        }
    }
    public void resolucionEjercicio2h(){
        fdd.escribir( "Ingrese  numero real:" );
        int n = parseInt( fdd.leer() );
        int a = 0;
        
        for (int i = 1; i <= n; i++) {
            if( n%i == 0 ){
                a++;
            }
        }
        
        if( a == 2 ){
            fdd.escribir( "El numero '"+n+"' ES PRIMO" );
        }else{
            fdd.escribir( "El numero '"+n+"' NO ES PRIMO" );
        }
    }
    
    //Ejercicio 3===
    public void resolucionEjercicio3a(){
        String ultimoDato = "";
        
        int verificador = -1;
        while( verificador != 0 ){
            fdd.escribir( "Ingrese un dato:" );
            ultimoDato = fdd.leer();
            fdd.escribir( "Desea ingresar otro dato?");
            fdd.escribir( "- 0 == NO -" );
            fdd.escribir( "- 1 == SI -" );
            verificador = parseInt( fdd.leer() );
        }
        
        File archivo_3a = fdd.crearTxt( "Ejercicio_3a" );
        fdd.escribirTxt(archivo_3a, ultimoDato);
    }
    public void resolucionEjercicio3b(){
        ArrayList<Integer> ingresosList = new ArrayList<Integer>();
        ArrayList<String> ingresosValidos = new ArrayList<String>();
        
        int verificador = -1;
        //este while permite ingresar datos y devuelve un ArrayList solo con 
        //los ingresos que sean numeros
        while( verificador != 0 ){
            boolean esInt = true;
            String ingreso = "";
            
            fdd.escribir( "Ingrese un dato (de preferencia numerico jaja):" );
            ingresosList = fdd.leerEnBytes();
            
            //este for verifica si alguno de los caracteres ingresados NO es 
            //tipo 'int'
            for ( int caracter:ingresosList ) {
                if( (caracter < 48) || (caracter > 57) ){
                    esInt = false;
                }
            }
            //este if transforma el ingreso valido en codigo ascii a un numero 
            //y lo agrega a la lista
            if( esInt ){
                for ( int caracter:ingresosList ){
                    ingreso = ingreso + (char)caracter;
                }
                ingresosValidos.add(ingreso);
            }
            
            fdd.escribir( "Desea ingresar otro dato?");
            fdd.escribir( "- 0 --> NO -" );
            fdd.escribir( "- 1 --> SI -" );
            verificador = parseInt( fdd.leer() );
        }
        
        //System.out.println( "\nIngresos validos: "+ingresosValidos );
        
        //este bloque crea un .txt
        //y le agrega los ingresos validos
        File archivo_3b = fdd.crearTxt( "Ejercicio_3b" );
        for ( String ingresoValido:ingresosValidos ){
            fdd.escribirTxt(archivo_3b, ingresoValido);
        }
    }
    public File resolucionEjercicio3c(){
        ArrayList<Integer> numerosPares = new ArrayList<Integer>();
        
        numerosPares.add(0);
        for (int i = 1; i < 1001; i++) {
            if ( i%2 == 0 ) {
                numerosPares.add( i );
            }
        }
        
        File archivo_3c = fdd.crearTxt( "CarpetaFueraDelProyecto/numeros.txt" );
        for ( int numeroPar:numerosPares ){
            fdd.escribirTxt(archivo_3c, String.valueOf(numeroPar));
        }
        return archivo_3c;
    }
    public void resolucionEjercicio3d( File archivo ) throws IOException{
        String texto = fdd.LeerFileConBuffer( archivo );
        fdd.escribir( texto );
    }
    public File resolucionEjercicio3e( File archivo ) throws IOException{
        FileReader fr = new FileReader( archivo );
        BufferedReader br = new BufferedReader( fr );

        String linea = "";
        String texto = "";
        while ((linea = br.readLine()) != null) {
            if ( parseInt( linea )%2 == 0 ) {
                texto += "\n" + linea;
            }
        }
        
        br.close();
        fr.close();
        
        fdd.escribir(texto);
        File nuevoArchivo = fdd.crearTxt( "CarpetaFueraDelProyecto/numeros.txt" );
        fdd.escribirTxt(nuevoArchivo, texto);
        
        return nuevoArchivo;
    }
    public void resolucionEjercicio3f( File archivo ) throws IOException{
        FileReader fr = new FileReader( archivo );
        BufferedReader br = new BufferedReader( fr );

        String linea = "";
        String texto = "";
        while ((linea = br.readLine()) != null) {
            if ( parseInt( linea )%2 == 0 ) {
                texto += "\n" + linea;
            }
        }
        
        
        
        br.close();
        fr.close();
    }
    public void resolucionEjercicio3g( File archivo ) throws IOException{
        
    }
}
