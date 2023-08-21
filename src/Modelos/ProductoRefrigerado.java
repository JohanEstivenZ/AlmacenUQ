package Modelos;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */
public class ProductoRefrigerado extends Producto {

    private int codigoAprobacion;

    private float temperaturaRefrigeracion;

    public int getCodigoAprobacion() {
        return codigoAprobacion;
    }

    public void setCodigoAprobacion(int codigoAprobacion) {
        this.codigoAprobacion = codigoAprobacion;
    }

    public float getTemperaturaRefrigeracion() {
        return temperaturaRefrigeracion;
    }

    public void setTemperaturaRefrigeracion(float temperaturaRefrigeracion) {
        this.temperaturaRefrigeracion = temperaturaRefrigeracion;
    }

    @Override
    public String toString() {
        return "ProductoRefigerado{" +
                "codigoAprobacion=" + codigoAprobacion +
                ", temperaturaRefigeracion=" + temperaturaRefrigeracion +
                '}';
    }

    public ProductoRefrigerado() {
    }

    public ProductoRefrigerado(String codigo, String nombre, double valorUnitario, int cantidadExistencia, int codigoAprobacion, float temperaturaRefrigeracion) {
        super(codigo, nombre, valorUnitario, cantidadExistencia);
        this.codigoAprobacion = codigoAprobacion;
        this.temperaturaRefrigeracion = temperaturaRefrigeracion;
    }
}
