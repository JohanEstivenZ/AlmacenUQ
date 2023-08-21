package Modelos;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */
import java.util.Date;

public class Venta extends DetalleVenta {

    private int codigo;

    private Date fecha;

    private String detallesDeVenta;

    private Cliente cliente;

    private float total;

    private float iva;

    public Venta(int cantidadProductoV, float subTotal, String productoVendido, int codigo, Date fecha, String detallesDeVenta, Cliente cliente, float total, float iva) {
        super(cantidadProductoV, subTotal, productoVendido);
        this.codigo = codigo;
        this.fecha = fecha;
        this.detallesDeVenta = detallesDeVenta;
        this.cliente = cliente;
        this.total = total;
        this.iva = iva;
    }
}
