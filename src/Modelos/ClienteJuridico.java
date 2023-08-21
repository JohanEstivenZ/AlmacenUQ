package Modelos;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */

public class ClienteJuridico extends Cliente{

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

    public ClienteJuridico() {
    }

    public ClienteJuridico(String nombre, String apellidos, String id, String direccion, String telefono, String nit) {
        super(nombre, apellidos, id, direccion, telefono);
        this.nit = nit;
    }
}
