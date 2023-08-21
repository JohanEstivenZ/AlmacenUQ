package Modelos;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */
import java.util.Date;

public class ProductoEnvasado extends Producto {

    private Date fechaEnvasado;

    private float pesoEnvase;

    private Pais paisOrigen;

    public ProductoEnvasado(String codigo, String nombre, String descripcion, double valorUnitario, int cantidadExistencia, Date fechaEnvasado, float pesoEnvase, Pais paisOrigen) {
        super(codigo, nombre, descripcion, valorUnitario, cantidadExistencia);
        this.fechaEnvasado = fechaEnvasado;
        this.pesoEnvase = pesoEnvase;
        this.paisOrigen = paisOrigen;
    }
}
