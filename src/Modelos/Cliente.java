package Modelos;

import java.util.Date;

public class Cliente extends Persona {

    public Cliente(String correo, Date fechaNacimiento, String nombre, String apellidos, String id, String telefono) {
        super(correo, fechaNacimiento, nombre, apellidos, id, telefono);
    }
}
