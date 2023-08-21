package Modelos;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */
public class ProductoRefigerado extends Producto {

    private int codigoAprobacion;

    private float temperaturaRefigeracion;

    public int getCodigoAprobacion() {
        return codigoAprobacion;
    }

    public void setCodigoAprobacion(int codigoAprobacion) {
        this.codigoAprobacion = codigoAprobacion;
    }

    public float getTemperaturaRefigeracion() {
        return temperaturaRefigeracion;
    }

    public void setTemperaturaRefigeracion(float temperaturaRefigeracion) {
        this.temperaturaRefigeracion = temperaturaRefigeracion;
    }

    @Override
    public String toString() {
        return "ProductoRefigerado{" +
                "codigoAprobacion=" + codigoAprobacion +
                ", temperaturaRefigeracion=" + temperaturaRefigeracion +
                '}';
    }

    public ProductoRefigerado() {
    }

    public ProductoRefigerado(String codigo, String nombre, String descripcion, double valorUnitario, int cantidadExistencia, int codigoAprobacion, float temperaturaRefigeracion) {
        super(codigo, nombre, descripcion, valorUnitario, cantidadExistencia);
        this.codigoAprobacion = codigoAprobacion;
        this.temperaturaRefigeracion = temperaturaRefigeracion;
    }
}
