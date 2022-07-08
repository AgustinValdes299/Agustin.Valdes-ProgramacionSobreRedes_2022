package tp2_FileBinary;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Agus
 */
public class BaseDeUsuario implements Serializable {

    private static final long serialVersionUID = -1000L;

    List<Persona> bUsuario;
    
    
    /**
     * 
     */
    public BaseDeUsuario() {
        bUsuario = new LinkedList<>();
    }
    
    /**
     * 
     * @param p 
     */
    public void agregarUsuario(Persona p) {
        if (p != null) {
            bUsuario.add(p);
        }
    }
    
    /**
     * 
     * @param i
     * @return 
     */
    public Persona devolverUsurio(int i) {
        Persona auxP = bUsuario.get(i);
        return auxP;
    }

    //COMPLETAR USTEDES
    //
    // el metodo mostrar empleados modificarlo para que 
    // no este repetido y sea Orientado a Objetos y Abstracto
    // si es necesario.
    // realizar todas las documetaciones de JavaDoc de todo el proyecto.
    //
    //COMPLETAR USTEDES
    /**
     * 
     */
    public void mostrarEmpleados() {
        for (Persona p : bUsuario.subList(2, bUsuario.size())) {
            if (p instanceof Empleado) {
                p.mostrarDatos();
            }
        }
    }
    
    /**
     * 
     */
    public void mostrarSocios() {
        for (Persona p : bUsuario.subList(2, bUsuario.size())) {
            if (p instanceof Socio) {
                p.mostrarDatos();
            }
        }
    }
    
    /**
     * 
     */
    public void actualizarSueldosCoutas() {
        for (Persona p : bUsuario) {
            if (p instanceof Empleado) {
                ((Empleado) p).calcular();
            }
        }
    }
    
    /**
     * 
     * @param codigo 
     */
    public void actualizarPuestos( int codigo ) {
        for (Persona p : bUsuario) {
            if (p instanceof Empleado) {
                if ( ((Empleado) p).codigo == codigo ) {
                    ((Empleado) p).puesto = Utilidades.elegirPuesto();
                }
            }
        }
    }
}
