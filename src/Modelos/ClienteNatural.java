package Modelos;

import java.util.Date;

public class ClienteNatural extends Cliente {

    public String correo;

    private Date fechaNacimiento;

    public ClienteNatural(String correo, Date fechaNacimiento, String nombre, String apellidos, String id, String telefono, String correo1, Date fechaNacimiento1) {
        super(correo, fechaNacimiento, nombre, apellidos, id, telefono);
        this.correo = correo1;
        this.fechaNacimiento = fechaNacimiento1;
    }
}
