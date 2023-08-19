package Modelos;

public class ProductoRefigerado extends Producto {

    private int codigoAprobacion;

    private float temperaturaRefigeracion;

    public ProductoRefigerado(String codigo, String nombre, String descripcion, double valorUnitario, int cantidadExistencia, int codigoAprobacion, float temperaturaRefigeracion) {
        super(codigo, nombre, descripcion, valorUnitario, cantidadExistencia);
        this.codigoAprobacion = codigoAprobacion;
        this.temperaturaRefigeracion = temperaturaRefigeracion;
    }
}
