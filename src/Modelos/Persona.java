package Modelos;

import java.util.Date;

public class Persona {

    private String nombre;

    private String apellidos;

    private String id;

    private String telefono;

    public Persona(String correo, Date fechaNacimiento, String nombre, String apellidos, String id, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.id = id;
        this.telefono = telefono;
    }
}
