package Modelos;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */
import java.util.Date;

public class Cliente extends Persona {

    public Cliente() {
    }

    public Cliente(String correo, Date fechaNacimiento, String nombre, String apellidos, String id, String telefono) {
        super(correo, fechaNacimiento, nombre, apellidos, id, telefono);
    }
}
