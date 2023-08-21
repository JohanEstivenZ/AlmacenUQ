package Modelos;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */
public class Producto {

    private String codigo;

    private String nombre;

    private String descripcion;

    private double valorUnitario;

    private int cantidadExistencia;

    public Producto(String codigo, String nombre, String descripcion, double valorUnitario, int cantidadExistencia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valorUnitario = valorUnitario;
        this.cantidadExistencia = cantidadExistencia;
    }
}
