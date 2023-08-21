package Modelos;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */
public class Producto {

    private String codigo;

    private String nombre;

    private double valorUnitario;

    private int cantidadExistencia;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getCantidadExistencia() {
        return cantidadExistencia;
    }

    public void setCantidadExistencia(int cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", valorUnitario=" + valorUnitario +
                ", cantidadExistencia=" + cantidadExistencia +
                '}';
    }

    public Producto() {
    }

    public Producto(String codigo, String nombre, double valorUnitario, int cantidadExistencia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.valorUnitario = valorUnitario;
        this.cantidadExistencia = cantidadExistencia;
    }
}
