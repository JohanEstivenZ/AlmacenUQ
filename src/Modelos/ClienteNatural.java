package Modelos;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */
import java.util.Date;

public class ClienteNatural extends Cliente {
    public String correo;

    private Date fechaNacimiento;


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "ClienteNatural{" +
                "correo='" + correo + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }

    public ClienteNatural() {
    }

    public ClienteNatural(String nombre, String apellidos, String id, String direccion, String telefono, String correo, Date fechaNacimiento) {
        super(nombre, apellidos, id, direccion, telefono);
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }
}
