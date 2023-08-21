package Modelos;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */
import java.util.Date;

public class Venta {

    private int codigo;

    private Date fecha;

    private String detallesDeVenta;

    private Cliente cliente;

    private float total;

    private float iva;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetallesDeVenta() {
        return detallesDeVenta;
    }

    public void setDetallesDeVenta(String detallesDeVenta) {
        this.detallesDeVenta = detallesDeVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "codigo=" + codigo +
                ", fecha=" + fecha +
                ", detallesDeVenta='" + detallesDeVenta + '\'' +
                ", cliente=" + cliente +
                ", total=" + total +
                ", iva=" + iva +
                '}';
    }

    public Venta() {
    }

    public Venta(int codigo, Date fecha, String detallesDeVenta, Cliente cliente, float total, float iva) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.detallesDeVenta = detallesDeVenta;
        this.cliente = cliente;
        this.total = total;
        this.iva = iva;
    }
}
