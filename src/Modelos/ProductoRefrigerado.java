package Modelos;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */
public class ProductoRefrigerado extends Producto {

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

    public ProductoRefrigerado() {
    }

    public ProductoRefrigerado(String codigo, String nombre, double valorUnitario, int cantidadExistencia, int codigoAprobacion, float temperaturaRefigeracion) {
        super(codigo, nombre, valorUnitario, cantidadExistencia);
        this.codigoAprobacion = codigoAprobacion;
        this.temperaturaRefigeracion = temperaturaRefigeracion;
    }
}
