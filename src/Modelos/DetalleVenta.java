package Modelos;

public class DetalleVenta {

    private int cantidadProductoV;

    private float subTotal;

    private String productoVendido;

    public DetalleVenta(int cantidadProductoV, float subTotal, String productoVendido) {
        this.cantidadProductoV = cantidadProductoV;
        this.subTotal = subTotal;
        this.productoVendido = productoVendido;
    }
}
