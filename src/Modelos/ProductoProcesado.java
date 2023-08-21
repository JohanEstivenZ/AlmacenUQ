package Modelos;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */
import java.util.Date;

public class ProductoProcesado extends Producto{

    private Date fechaVencimiento;

    public ProductoProcesado(String codigo, String nombre, String descripcion, double valorUnitario, int cantidadExistencia, Date fechaVencimiento) {
        super(codigo, nombre, descripcion, valorUnitario, cantidadExistencia);
        this.fechaVencimiento = fechaVencimiento;
    }
}
