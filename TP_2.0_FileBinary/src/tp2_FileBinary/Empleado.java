package tp2_FileBinary;

import java.util.Date;
import static tp2_FileBinary.Utilidades.mostrarPorPantalla;
import static java.lang.Integer.parseInt;

/**
 *
 * @author Agus
 */
public class Empleado extends Persona {

    int codigo;
    Puestos puesto;
    private float sueldo;
    private BaseDeUsuario usuarios;

    /**
     *
     * @param codigo
     * @param puesto
     * @param sueldo
     * @param DNI
     * @param fechaDeIngreso
     * @param nombre
     * @param apellido
     * @param direccion
     * @param edad
     * @param genero
     * @param numContacto
     */
    public Empleado(BaseDeUsuario lista, int codigo, Puestos puesto, int DNI, Date fechaDeIngreso, String nombre, String apellido, String direccion, int edad, Genero genero, String numContacto) {
        super(DNI, fechaDeIngreso, nombre, apellido, direccion, edad, genero, numContacto);

        this.codigo = codigo;
        this.puesto = puesto;
        this.sueldo = -1;
        this.usuarios = lista;
    }
    
    /**
     * 
     * @param fechaDeIngreso
     * @return 
     */
    public int calcularAntiguedad( Date fechaDeIngreso ){
        Date fechaDeHoy = new Date();
        
        //calcula la antiguedad en años
        String aux = String.valueOf( ( (fechaDeHoy.getTime() - fechaDeIngreso.getTime() ) / ( 3600000*24 )) / 365 );
        //mostrarPorPantalla( "Antiguedad en años: "+aux );
        
        int antiguedad = parseInt( aux );
        
        return antiguedad;
    }
    
    /**
     * 
     */
    public void cambiarPuesto(){
        Utilidades.mostrarPorPantalla( "- CAMBIAR PUESTO -" );
        Utilidades.mostrarPorPantalla( "Ingrese el codigo del empleado" );
        int auxCodigo = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla( "Elija el nuevo puesto:" );
        usuarios.actualizarPuestos(auxCodigo);
    }
 
    /**
     *Calcula el sueldo
     */
    @Override
    public void calcular() {
        //COMPLETAR USTEDES CHECKED
        // cambia segun la antiguedad
        // 2 - 5% | 10 - 10% | 15 - 20% | >15 - 30%

        double sueldoBase = 0;
        int antiguedad = this.calcularAntiguedad(this.fechaDeIngreso);
        
        switch (this.puesto) {
            case Administrativo:
                sueldoBase = 50000;
                break;
            case Caddy:
                sueldoBase = 30000;
                break;
            case Gerente:
                sueldoBase = 100000;
                break;
            case Limpieza:
                sueldoBase = 40000;
                break;
            case RecogedorDePelotas:
                sueldoBase = 5000;
                break;
        }
        if ( antiguedad > 2 && antiguedad < 10 ) {
            sueldoBase = sueldoBase * 1.05;
        }
        else if ( antiguedad > 10 && antiguedad < 15 ) {
            sueldoBase = sueldoBase * 1.2;
        }
        else if ( antiguedad > 15 ) {
            sueldoBase = sueldoBase * 1.3;
        }
        
        this.sueldo = (float) sueldoBase;
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
                //agregar opcion para cambiar de puesto.
                //verificar que que no explote las cargas de datos nuevos
                //ni los pedidos de mostrar datos far falta de ellos.
                //
                //COMPLETAR USTEDES
                mostrarPorPantalla(
                          "\t    ---MENÚ EMPLEADO---\n"
                        + "\t- [1] Cargar un Empleado -\n"
                        + "\t- [2] Calcular Sueldos   -\n"
                        + "\t- [3] Mostrar Empleados  -\n"
                        + "\t- [4] Cambiar Puesto     -\n"
                        + "\t- [5] Volver             -\n"
                        + "\t--------------------------\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '5');

            switch (op) {
                case '1':
                    this.cargarNuevoEmpleado();
                    break;
                case '2':
                    usuarios.actualizarSueldosCoutas();
                    Utilidades.mostrarPorPantalla( "\n##############################" );
                    Utilidades.mostrarPorPantalla( "#### SUELDOS ACTUALIZADOS ####" );
                    Utilidades.mostrarPorPantalla( "##############################\n" );
                    usuarios.mostrarEmpleados();
                    break;
                case '3':
                    usuarios.mostrarEmpleados();
                    break;
                case '4':
                    this.cambiarPuesto();
                    break;
                case '5':
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
    public void mostrarDatos() {
        usuarios.actualizarSueldosCoutas();
        Utilidades.mostrarPorPantalla(
                "\t=== EMPLEADO ===\n"
                + "\t NOMBRE: " + this.nombre + "\n"
                + "\t APELLIDO: " + this.apellido + "\n"
                + "\t DIRECCION: " + this.direccion + "\n"
                + "\t GENERO: " + this.genero + "\n"
                + "\t TEL: " + this.numContacto + "\n"
                + "\t DNI: " + this.DNI + "\n"
                + "\t Fecha de Ingreso: " + this.fechaDeIngreso.toLocaleString() + "\n"
                + "\t Antiguedad (años): " + this.calcularAntiguedad(fechaDeIngreso) + "\n"
                + "\t----------------------\n"
                + "\t CODIGO: " + this.codigo + "\n"
                + "\t PUESTO: " + this.puesto + "\n"
                + "\t SUELDO: " + this.sueldo + "\n"
                + "\t==================================\n"
        );
    }
    
    /**
     * 
     */
    @Override
    public void proceder() {
        mostrarMenu();
    }
    
    /**
     * 
     */
    public void cargarNuevoEmpleado() {
        //aca deberiamos hacer un Do While para verificar si ingreso datos el usuario 
        Utilidades.mostrarPorPantalla("Ingrese el codigo: ");
        int cod = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla("Ingrese el puesto: ");
        Puestos pue = Utilidades.elegirPuesto();
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

        Empleado e = new Empleado(usuarios, cod, pue, dni, fecha, nombre, apellido, direccion, edad, gen, tel);
        usuarios.agregarUsuario(e);
    }
}
