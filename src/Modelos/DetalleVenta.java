package Modelos;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */
public class DetalleVenta {

    private int cantidadProductoV;

    private float subTotal;

    private String productoVendido;

    public int getCantidadProductoV() {
        return cantidadProductoV;
    }

    public void setCantidadProductoV(int cantidadProductoV) {
        this.cantidadProductoV = cantidadProductoV;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public String getProductoVendido() {
        return productoVendido;
    }

    public void setProductoVendido(String productoVendido) {
        this.productoVendido = productoVendido;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" +
                "cantidadProductoV=" + cantidadProductoV +
                ", subTotal=" + subTotal +
                ", productoVendido='" + productoVendido + '\'' +
                '}';
    }

    public DetalleVenta() {
    }

    public DetalleVenta(int cantidadProductoV, float subTotal, String productoVendido) {
        this.cantidadProductoV = cantidadProductoV;
        this.subTotal = subTotal;
        this.productoVendido = productoVendido;
    }
}
