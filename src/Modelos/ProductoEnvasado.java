package Modelos;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */
import java.util.Date;

public class ProductoEnvasado extends Producto {

    private Date fechaEnvasado;

    private float pesoEnvase;

    private Pais paisOrigen;

    public Date getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(Date fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public float getPesoEnvase() {
        return pesoEnvase;
    }

    public void setPesoEnvase(float pesoEnvase) {
        this.pesoEnvase = pesoEnvase;
    }

    public Pais getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(Pais paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    @Override
    public String toString() {
        return "ProductoEnvasado{" +
                "fechaEnvasado=" + fechaEnvasado +
                ", pesoEnvase=" + pesoEnvase +
                ", paisOrigen=" + paisOrigen +
                '}';
    }

    public ProductoEnvasado() {
    }

    public ProductoEnvasado(String codigo, String nombre, double valorUnitario, int cantidadExistencia, Date fechaEnvasado, float pesoEnvase, Pais paisOrigen) {
        super(codigo, nombre, valorUnitario, cantidadExistencia);
        this.fechaEnvasado = fechaEnvasado;
        this.pesoEnvase = pesoEnvase;
        this.paisOrigen = paisOrigen;
    }
}
