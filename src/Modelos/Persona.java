package Modelos;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */
import java.util.Date;

public class Persona {


    private String nombre;

    private String apellidos;

    private String id;

    private String telefono;

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", id='" + id + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    public Persona() {
    }

    public Persona(String correo, Date fechaNacimiento, String nombre, String apellidos, String id, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.id = id;
        this.telefono = telefono;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
