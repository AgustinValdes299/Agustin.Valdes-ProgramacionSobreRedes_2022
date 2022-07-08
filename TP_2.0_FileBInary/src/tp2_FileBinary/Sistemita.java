package tp2_FileBinary;

import static tp2_FileBinary.Utilidades.mostrarPorPantalla;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Agus
 */
public class Sistemita implements Serializable {

    private static final long serialVersionUID = -1000L;
    private BaseDeUsuario usuarios;
    

    /**
     * 
     */
    public Sistemita() {
        usuarios = new BaseDeUsuario();
    }

    /**
     * 
     * @param archivo
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public Sistemita deSerializar(String archivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(archivo);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Sistemita s = (Sistemita) ois.readObject();
        return s;
    }

    /**
     * 
     */
    public void creacion() {
        Utilidades.mostrarPorPantalla(" EL SISTEMA SE HA ARRANCADO. ");
        
        Empleado e = new Empleado( usuarios , 0, Puestos.Gerente, 0, new Date(0000, 00, 00), "empleado", "empleado", "", 0, Genero.SG, "0000-0000");
        Socio s = new Socio( usuarios , TipoMembrecia.Bronce, 0, new Date(0000,00,00), "socio", "socio", "", 0, Genero.SG, "0000-0000");
        
        Empleado e1 = new Empleado( usuarios,1,Puestos.Caddy,44352584,new Date(115,4,7),"Juan","Perez","Palestina 34",34,Genero.Masculino,"1154673245" );
        Empleado e2 = new Empleado( usuarios,2,Puestos.Limpieza,40322384,new Date(110,2,11),"Paula","Garcia","Crrientes 233",45,Genero.Femenino,"1158322534" );
        Empleado e3 = new Empleado( usuarios,3,Puestos.Administrativo,4547865,new Date(112,4,2),"August","Rmero","Diaz Velez 746",23,Genero.Masculino,"112342345" );

        usuarios.agregarUsuario( e );
        usuarios.agregarUsuario( s );
        usuarios.agregarUsuario( e1 );
        usuarios.agregarUsuario( e2 );
        usuarios.agregarUsuario( e3 );
    }

    /**
     * 
     * @param archivo
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void serializar(String archivo) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(archivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(this);
        oos.close();
    }

    /**
     * 
     */
    public void prender() {
        // aca vamos a hacer un menu
        boolean corriendo = true;
        
        while( corriendo )
        {
            //Utilidades.mostrarMenu();
            corriendo = mostrarMenu();    
        }
        Utilidades.mostrarPorPantalla("\n.\n.\n.\nGRACIAS POR USAR MI PROGRAMA.");          
    }

    /**
     * 
     * @return 
     */
    public boolean mostrarMenu() {
        boolean cerrar = false, continuar = true;
        while (!cerrar) {
            char op;
            do {
                mostrarPorPantalla(
                        "MENÚ PRINCIPAL\n\n"
                        + "[1] Menu de Empleados\n"
                        + "[2] Menu de Socios\n"
                        + "[3] Salir\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '3');

            switch (op) {
                case '1':
                    continuar = usuarios.devolverUsurio(0).mostrarMenu() ;
                    break;
                case '2':
                    continuar = usuarios.devolverUsurio(1).mostrarMenu() ;
                    break;
                case '3':
                    cerrar = true;
                    continuar = false;
                    break;
            }
        }
        return continuar;
    }     
    
}
