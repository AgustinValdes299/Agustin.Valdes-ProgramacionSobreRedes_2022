package tp2_FileBinary;

import static tp2_FileBinary.Utilidades.mostrarPorPantalla;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 *
 * @author Agus
 */
public class Socio extends Persona {

    private float cuota;
    private TipoMembrecia membrecia; //Enum    
    // (numero hoyo , puntos)
    private ArrayList< Map<Integer, Integer>> partidasJugadas;
    private BaseDeUsuario usuarios;

    public Socio(BaseDeUsuario lista, TipoMembrecia membrecia, int DNI, Date fechaDeIngreso, String nombre, String apellido, String direccion, int edad, Genero genero, String numContacto) {
        super(DNI, fechaDeIngreso, nombre, apellido, direccion, edad, genero, numContacto);

        this.cuota = -1;
        this.membrecia = membrecia;
        this.partidasJugadas = new ArrayList<>();
        this.usuarios = lista;
    }

    /**
     * 
     */
    @Override
    public void calcular() {
        switch (this.membrecia) {
            case Bronce:
                this.cuota = 5000;
                break;
            case Plata:
                this.cuota = 10000;
                break;
            case Oro:
                this.cuota = 20000;
                break;
            case Black:
                this.cuota = 50000;
                break;
            case Platino:
                this.cuota = 100000;
                break;
        }
        
        if ( (LocalDate.now().getYear() - fechaDeIngreso.getYear()) >= 2) {
            this.cuota -= this.cuota*.5;
        }else if( (LocalDate.now().getYear() - fechaDeIngreso.getYear()) > 2 && (LocalDate.now().getYear() - fechaDeIngreso.getYear()) <= 10 ){
            this.cuota -= this.cuota*.10;
        }else if( (LocalDate.now().getYear() - fechaDeIngreso.getYear()) > 10 && (LocalDate.now().getYear() - fechaDeIngreso.getYear()) <= 15 ){
            this.cuota -= this.cuota*.20;
        }else if( (LocalDate.now().getYear() - fechaDeIngreso.getYear()) > 15 ){
            this.cuota -= this.cuota*.30;
        }
    }

    /**
     * 
     */
    public void mostrarDatos() {
        Utilidades.mostrarPorPantalla("SOCIO: \n"
                + "\t NOMBRE: " + this.nombre + "\n"
                + "\t APELLIDO: " + this.apellido + "\n"
                + "\t DIRECCION: " + this.direccion + "\n"
                + "\t GENERO: " + this.genero + "\n"
                + "\t TEL: " + this.numContacto + "\n"
                + "\t DNI: " + this.DNI + "\n"
                + "----------------------\n"
                + "\t CUOTA: " + this.cuota + "\n"
                + "\t MEMBRECIA: " + this.membrecia + "\n"
                + "....................................\n"
        );

        Utilidades.mostrarListaArray(this.partidasJugadas);
        Utilidades.mostrarPorPantalla("+ \"==================================\\n\"");
    }

    /**
     * 
     * @return 
     */
    @Override
    public boolean mostrarMenu() {
        boolean cerrar = false, continuar = true;
        while (!cerrar) {
            char op;
            do {
                //COMPLETAR USTEDES
                //
                // agregar opcion para cambiar membresia.
                // verificar que que no explote las cargas de datos nuevos
                // ni los pedidos de mostrar datos far falta de ellos.
                //
                //COMPLETAR USTEDES
                mostrarPorPantalla(
                        "\tMENÚ SOCIO\n\n"
                        + "\t[1] Cargar un Socio\n"
                        + "\t[2] Cargar un Partidas de un Socio\n"
                        + "\t[3] Calcular Cuota\n"
                        + "\t[4] Mostrar Socios\n"
                        + "\t[5] Mostrar Partidas por socios\n"
                        + "\t[6] Cambiar Membresia\n"
                        + "\t[7] Volver\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '7');

            switch (op) {
                case '1':
                    this.cargarNuevoSocio();
                    break;
                case '2':
                    this.cargarPartida();
                    break;
                case '3':
                    usuarios.actualizarSueldosCoutas();
                    break;
                case '4':
                    usuarios.mostrarSocios();
                    break;
                case '5':
                    this.mostrarPartidaxSocio();
                    break;
                case '6':
                    this.cambiarMembresia();
                    break;
                case '7':
                    cerrar = true;
                    continuar = false;
                    break;
            }
        }
        return continuar;
    }

    /**
     * 
     */
    @Override
    public void proceder() {
        Utilidades.mostrarPorPantalla("JUEGA PLACIDAMENTE");
    }

    /**
     *
     */
    private void cargarNuevoSocio() {
        //COMPLETAR USTEDES
        
        
        //aca deberiamos hacer un Do While para verificar si ingreso datos el usuario 
        Utilidades.mostrarPorPantalla("Ingrese el tipo de membresia: ");
        char membrecia = Utilidades.obtenerOpcion(); //switch para membresia en base a char
        Utilidades.mostrarPorPantalla("Ingrese el dni: ");
        int dni = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla("Ingrese el Fecha de Ingreso: ");
        Date fecha = Utilidades.leerFecha();
        Utilidades.mostrarPorPantalla("Ingrese el Nombre: ");
        String nombre = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese el Apellido: ");
        String apellido = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese el Direcion: ");
        String direccion = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese el Edad: ");
        int edad = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla("Ingrese el Genero: ");
        Genero gen = Utilidades.leerGenero();
        Utilidades.mostrarPorPantalla("Ingrese el Telefono: ");
        String tel = Utilidades.leerTexto();

        Socio s = new Socio(usuarios, this.membrecia, dni, fecha, nombre, apellido,  direccion,  edad,  gen,  tel);

        usuarios.agregarUsuario(s);

    }

    /**
     *
     */
    public void cargarPartida() {
        //COMPLETAR USTEDES
        //HECHO
        Map<Integer, Integer> partida = new HashMap<>();
        
        Utilidades.mostrarPorPantalla("Ingrese la cantidad de hoyos jugados");
        int hoyos = Utilidades.leerNumero();
        
        for(int i = 1; i <= hoyos; i++){
            Utilidades.mostrarPorPantalla("Hoyos jugados: " + i );
            Utilidades.mostrarPorPantalla("Puntuacion" );
            partida.put(i, Utilidades.leerNumero());
        }
        partidasJugadas.add(partida);
    }
    
    /**
     * 
     */
    private void mostrarPartidaxSocio() {
        for (Persona p : usuarios.bUsuario.subList(2, usuarios.bUsuario.size())) {
            if (p instanceof Socio) {
                Utilidades.mostrarPorPantalla("Socio: " + ((Socio) p).nombre);
                for (int i = 0; i < ((Socio) p).partidasJugadas.size(); i++) {
                    Utilidades.mostrarPorPantalla("\tPartida N°: " + i);
                    for (Map.Entry<Integer, Integer> partida : partidasJugadas.get(i).entrySet()) {
                        Utilidades.mostrarPorPantalla("\t\tHoyo N°: " + partida.getKey() + "\t\tPuntaje: " + partida.getValue());
                    }
                }
            }
        }
    }
    
    /**
     * 
     */
    private void cambiarMembresia() {
        boolean continuar = false;
        do {
            Utilidades.mostrarPorPantalla(
                "\t\t\tSeleccione el nuevo puesto:\n"
                +"\t\t\t\t1. Bronce\n"
                +"\t\t\t\t2. Plata\n"
                +"\t\t\t\t3. Oro\n"
                +"\t\t\t\t4. Black\n"
                +"\t\t\t\t5. Platino\n"
                +"\t\t\t\t6. Volver\n"
            );
            switch(Utilidades.obtenerOpcion()){
                case '1':
                    this.membrecia = membrecia.Bronce;
                    break;
                case '2':
                    this.membrecia = membrecia.Plata;
                    break;
                case '3':
                    this.membrecia = membrecia.Oro;
                    break;
                case '4':
                    this.membrecia = membrecia.Black;
                    break;
                case '5':
                    this.membrecia = membrecia.Platino;
                    break;
                case '6':
                    continuar = true;
                    break;
                default:
                    Utilidades.mostrarPorPantalla("Opcion incorrecta!");
                    break;
            }
        } while (!continuar);
    }
}
