package Modelos;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */
import java.util.Date;

public class ClienteJudicial extends Cliente{

    private String nit;

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Override
    public String toString() {
        return "ClienteJudicial{" +
                "nit='" + nit + '\'' +
                '}';
    }

    public ClienteJudicial() {
    }

    public ClienteJudicial(String correo, Date fechaNacimiento, String nombre, String apellidos, String id, String telefono, String nit) {
        super(correo, fechaNacimiento, nombre, apellidos, id, telefono);
        this.nit = nit;
    }
}
