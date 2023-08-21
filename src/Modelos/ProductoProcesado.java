package Modelos;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */
import java.util.Date;

public class ProductoProcesado extends Producto{

    private Date fechaVencimiento;

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "ProductoProcesado{" +
                "fechaVencimiento=" + fechaVencimiento +
                '}';
    }

    public ProductoProcesado() {
    }

    public ProductoProcesado(String codigo, String nombre, double valorUnitario, int cantidadExistencia, Date fechaVencimiento) {
        super(codigo, nombre, valorUnitario, cantidadExistencia);
        this.fechaVencimiento = fechaVencimiento;
    }
}
