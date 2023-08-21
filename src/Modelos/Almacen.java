package Modelos;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */
import java.util.ArrayList;
import java.util.Date;

public class Almacen {

    private ArrayList<ClienteJudicial> listaClientesJudicial = new ArrayList<ClienteJudicial>();

    private ArrayList<ClienteNatural> listaClientesNaturales = new ArrayList<ClienteNatural>();
    private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    private ArrayList<ProductoEnvasado> listaProductosEnvasados = new ArrayList<ProductoEnvasado>();
    private ArrayList<ProductoProcesado> listaProductosProcesados = new ArrayList<ProductoProcesado>();
    private ArrayList<ProductoRefrigerado> listaProductosRefrigerados =  new ArrayList<ProductoRefrigerado>();
    private ArrayList<Producto> listaProductos =  new ArrayList<Producto>();

    private  ArrayList<Venta> listaVentas = new ArrayList<Venta>();

    public Almacen() {
    }

    public Almacen(ArrayList<ClienteJudicial> listaClientesJudicial, ArrayList<ClienteNatural> listaClientesNaturales, ArrayList<Cliente> listaClientes, ArrayList<ProductoEnvasado> listaProductosEnvasados, ArrayList<ProductoProcesado> listaProductosProcesados, ArrayList<ProductoRefrigerado> listaProductosRefrigerados, ArrayList<Producto> listaProductos, ArrayList<Venta> listaVentas) {
        this.listaClientesJudicial = listaClientesJudicial;
        this.listaClientesNaturales = listaClientesNaturales;
        this.listaClientes = listaClientes;
        this.listaProductosEnvasados = listaProductosEnvasados;
        this.listaProductosProcesados = listaProductosProcesados;
        this.listaProductosRefrigerados = listaProductosRefrigerados;
        this.listaProductos = listaProductos;
        this.listaVentas = listaVentas;

        // Datos quedamos personas
        ClienteNatural cNatural = new ClienteNatural("Juan José", "Restrepo Morales", "1018224398", "3005772768", "juanj.restrepom@uqvirtual.edu.co",new Date(2004, 7, 4));
        listaClientes.add(cNatural);
        ClienteJudicial cJudicial = new ClienteJudicial("Johan Estiven", "Zapata", "1015265458", "3183137658", "126.82003.50-0");
        listaClientes.add(cJudicial);


        // Datos quemados productos

        ProductoEnvasado prodEnva = new ProductoEnvasado("1001", "Arroz", 2500, 10,new Date(2023,7,20),500, Pais.COLOMBIA);
        listaProductos.add(prodEnva);
        ProductoProcesado prodProcs = new ProductoProcesado("1002", "Atun", 6000, 10,new Date(2026,8,21));
        listaProductos.add(prodProcs);
        ProductoRefrigerado prodRefrig = new ProductoRefrigerado("1003", "Stella Artois", 5050, 10,5214,6);
        listaProductos.add(prodRefrig);
    }

    public ArrayList<ClienteJudicial> getListaClientesJudicial() {
        return listaClientesJudicial;
    }

    public void setListaClientesJudicial(ArrayList<ClienteJudicial> listaClientesJudicial) {
        this.listaClientesJudicial = listaClientesJudicial;
    }

    public ArrayList<ClienteNatural> getListaClientesNaturales() {
        return listaClientesNaturales;
    }

    public void setListaClientesNaturales(ArrayList<ClienteNatural> listaClientesNaturales) {
        this.listaClientesNaturales = listaClientesNaturales;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<ProductoEnvasado> getListaProductosEnvasados() {
        return listaProductosEnvasados;
    }

    public void setListaProductosEnvasados(ArrayList<ProductoEnvasado> listaProductosEnvasados) {
        this.listaProductosEnvasados = listaProductosEnvasados;
    }

    public ArrayList<ProductoProcesado> getListaProductosProcesados() {
        return listaProductosProcesados;
    }

    public void setListaProductosProcesados(ArrayList<ProductoProcesado> listaProductosProcesados) {
        this.listaProductosProcesados = listaProductosProcesados;
    }

    public ArrayList<ProductoRefrigerado> getListaProductosRefrigerados() {
        return listaProductosRefrigerados;
    }

    public void setListaProductosRefrigerados(ArrayList<ProductoRefrigerado> listaProductosRefrigerados) {
        this.listaProductosRefrigerados = listaProductosRefrigerados;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ArrayList<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
}
