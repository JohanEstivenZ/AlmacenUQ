package Modelos;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Almacen {

    private static ArrayList<ClienteJuridico> listaClientesJuridicos = new ArrayList<ClienteJuridico>();

    private static ArrayList<ClienteNatural> listaClientesNaturales = new ArrayList<ClienteNatural>();
    private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    private static ArrayList<ProductoEnvasado> listaProductosEnvasados = new ArrayList<ProductoEnvasado>();
    private static ArrayList<ProductoProcesado> listaProductosProcesados = new ArrayList<ProductoProcesado>();
    private static ArrayList<ProductoRefrigerado> listaProductosRefrigerados =  new ArrayList<ProductoRefrigerado>();
    private ArrayList<Producto> listaProductos =  new ArrayList<Producto>();

    private  ArrayList<Venta> listaVentas = new ArrayList<Venta>();

    public Almacen() {
    }

    public Almacen(ArrayList<ClienteJuridico> listaClientesJuridicos, ArrayList<ClienteNatural> listaClientesNaturales, ArrayList<Cliente> listaClientes, ArrayList<ProductoEnvasado> listaProductosEnvasados, ArrayList<ProductoProcesado> listaProductosProcesados, ArrayList<ProductoRefrigerado> listaProductosRefrigerados, ArrayList<Producto> listaProductos, ArrayList<Venta> listaVentas) {
        this.listaClientesJuridicos = listaClientesJuridicos;
        this.listaClientesNaturales = listaClientesNaturales;
        this.listaClientes = listaClientes;
        this.listaProductosEnvasados = listaProductosEnvasados;
        this.listaProductosProcesados = listaProductosProcesados;
        this.listaProductosRefrigerados = listaProductosRefrigerados;
        this.listaProductos = listaProductos;
        this.listaVentas = listaVentas;

        // Datos quedamos
        ClienteNatural cNatural = new ClienteNatural("Juan José", "Restrepo Morales", "1018224398","Calle 101 D #82-19", "3005772768", "juanj.restrepom@uqvirtual.edu.co",new Date(2004, 7, 4));
        listaClientes.add(cNatural);
        ClienteJuridico cJuridico = new ClienteJuridico("Johan Estiven", "Zapata", "1015265458","Carrera 16 bis # 11-02 Piso 1","3183137658", "126.82003.50-0");
        listaClientes.add(cJuridico);


        // Datos quemados

        ProductoEnvasado prodEnva = new ProductoEnvasado("1001", "Arroz", 2500, 10,new Date(2023,7,20),500, Pais.COLOMBIA);
        listaProductos.add(prodEnva);
        ProductoProcesado prodProcs = new ProductoProcesado("1002", "Atun", 6000, 10,new Date(2026,8,21));
        listaProductos.add(prodProcs);
        ProductoRefrigerado prodRefrig = new ProductoRefrigerado("1003", "Stella Artois", 5050, 10,5214,6);
        listaProductos.add(prodRefrig);
    }

    public static ArrayList<ClienteJuridico> getListaClientesJuridicos() {
        return listaClientesJuridicos;
    }

    public void setListaClientesJuridicos(ArrayList<ClienteJuridico> listaClientesJuridicos) {
        this.listaClientesJuridicos = listaClientesJuridicos;
    }

    public static ArrayList<ClienteNatural> getListaClientesNaturales() {
        return listaClientesNaturales;
    }

    public void setListaClientesNaturales(ArrayList<ClienteNatural> listaClientesNaturales) {
        this.listaClientesNaturales = listaClientesNaturales;
    }

    public static ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public static ArrayList<ProductoEnvasado> getListaProductosEnvasados() {
        return listaProductosEnvasados;
    }

    public void setListaProductosEnvasados(ArrayList<ProductoEnvasado> listaProductosEnvasados) {
        this.listaProductosEnvasados = listaProductosEnvasados;
    }

    public static ArrayList<ProductoProcesado> getListaProductosProcesados() {
        return listaProductosProcesados;
    }

    public void setListaProductosProcesados(ArrayList<ProductoProcesado> listaProductosProcesados) {
        this.listaProductosProcesados = listaProductosProcesados;
    }

    public static ArrayList<ProductoRefrigerado> getListaProductosRefrigerados() {
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


    // ------------------------ CLIENTE NATURAL -----------------------------
    public static ClienteNatural crearClienteNatural(String nombre, String apellido, String identificacion, String direccion,
                                                     String telefono, String correo, Date fechaNacimeinto) {

        ClienteNatural cNatural = null;

        cNatural = obtenerClienteNatural(identificacion);
        if (cNatural == null) {

            cNatural = new ClienteNatural(nombre, apellido, identificacion, direccion, telefono, correo, fechaNacimeinto);
            getListaClientesNaturales().add(cNatural);
            return cNatural;
        } else {
            return null;
        }

    }

    public static ClienteNatural obtenerClienteNatural(String id) {
        for (ClienteNatural cNatural : listaClientesNaturales) {
            if (cNatural.getId().equalsIgnoreCase(id)) {
                return cNatural;
            }
        }
        return null;
    }

    public static boolean actualizarClienteNatural(String idActual, String nombre, String apellido, String id,
                                                   String direccion, String telefono, String correo, Date fechaNacimiento) {

        ClienteNatural cNatural = null;
        cNatural = obtenerClienteNatural(idActual);

        if (cNatural != null) {

            cNatural.setNombre(nombre);
            cNatural.setApellidos(apellido);
            cNatural.setId(id);
            cNatural.setDireccion(direccion);
            cNatural.setTelefono(telefono);
            cNatural.setCorreo(direccion);
            cNatural.setFechaNacimiento(fechaNacimiento);
            getListaClientesNaturales().add(cNatural);
            return true;
        } else {
            return false;
        }

    }

    public static boolean eliminarClienteNatural(String id) {
        ClienteNatural cNatural = null;

        cNatural = obtenerClienteNatural(id);
        if (cNatural != null) {
            getListaClientesNaturales().remove(cNatural);
            return true;

        } else {
            return false;
        }
    }


    // ------------------------------ CLIENTE JURIDICO ------------------------
    public static ClienteJuridico crearClienteJuridico(String nombre, String apellido, String id,
                                                       String direccion, String telefono, String nit) {

        ClienteJuridico cJuridico = null;

        cJuridico = obtenerClienteJuridico(nit);
        if (cJuridico == null) {

            cJuridico = new ClienteJuridico(nombre, apellido,id, direccion, telefono, nit );
            cJuridico.setNit(nit);
            cJuridico.setNit(nit);
            getListaClientesJuridicos().add(cJuridico);
            return cJuridico;
        } else {
            return null;
        }

    }

    public static ClienteJuridico obtenerClienteJuridico(String id) {
        for (ClienteJuridico cJuridico : listaClientesJuridicos) {
            if (cJuridico.getId().equalsIgnoreCase(id)) {
                return cJuridico;
            }
        }
        return null;
    }

    public static boolean actualizarClienteJuridico(String idActual, String nombre, String apellido, String id, String nit,
                                                    String direccion, String telefono) {

        ClienteJuridico cJuridico = null;
        cJuridico = obtenerClienteJuridico(idActual);

        if (cJuridico != null) {

            cJuridico.setNombre(nombre);
            cJuridico.setApellidos(apellido);
            cJuridico.setId(id);
            cJuridico.setNit(nit);
            cJuridico.setDireccion(direccion);
            cJuridico.setTelefono(telefono);
            getListaClientesJuridicos().add(cJuridico);
            return true;
        } else {
            return false;
        }

    }

    public static boolean eliminarClienteJuridico(String nit) {
        ClienteJuridico cJuridico = null;

        cJuridico = obtenerClienteJuridico(nit);
        if (cJuridico != null) {
            getListaClientesJuridicos().remove(cJuridico);
            return true;

        } else {
            return false;
        }
    }


    // ------------------------------ PRODUCTO ENVASADO ------------------------

    public static ProductoEnvasado obtenerProductoEnvasado(String codigo) {
        for (ProductoEnvasado proEnva : listaProductosEnvasados) {
            if (proEnva.getCodigo().equalsIgnoreCase(codigo)) {
                return proEnva;
            }
        }
        return null;
    }

    public static ProductoEnvasado crearProductoEnvasado(String codigo, String nombre, double valorUnitario,
                                                         int cantidadExistencia, Date fechaEnvasado, float pesoEnvase,
                                                         Pais paisOrigen) {

        ProductoEnvasado proEnva = null;

        proEnva = obtenerProductoEnvasado(codigo);
        if (proEnva == null) {

            proEnva = new ProductoEnvasado(codigo, nombre, valorUnitario, cantidadExistencia, fechaEnvasado, pesoEnvase, paisOrigen);
            getListaProductosEnvasados().add(proEnva);
            return proEnva;
        } else {
            return null;
        }
    }

    public static boolean actualizarProductoEnvasado(String codigoNuev, String codigo, String nombre, double valorUnitario,
                                                     int cantidadExistencia, Date fechaEnvasado, float pesoEnvase,
                                                     Pais paisOrigen) {

        ProductoEnvasado proEnva = null;

        proEnva = obtenerProductoEnvasado(codigo);
        if (proEnva != null) {

            proEnva.setCodigo(codigoNuev);
            proEnva.setNombre(nombre);
            proEnva.setValorUnitario(valorUnitario);
            proEnva.setCantidadExistencia(cantidadExistencia);
            proEnva.setPesoEnvase(pesoEnvase);
            proEnva.setFechaEnvasado(fechaEnvasado);
            proEnva.setPaisOrigen(paisOrigen);
            getListaProductosEnvasados().add(proEnva);
            return true;
        } else {
            return false;
        }

    }

    public static boolean eliminarProductoEnvasado(String codigo) {

        ProductoEnvasado proEnva = null;

        proEnva = obtenerProductoEnvasado(codigo);
        if (proEnva != null) {
            getListaProductosEnvasados().remove(proEnva);
            return true;

        } else {
            return false;
        }
    }

    // ------------------------------ PRODUCTO PROCESADO ------------------------

    public static ProductoProcesado obtenerProductoProcesado(String codigo) {
        for (ProductoProcesado proProcs : listaProductosProcesados) {
            if (proProcs.getCodigo().equalsIgnoreCase(codigo)) {
                return proProcs;
            }
        }
        return null;
    }

    public static ProductoProcesado crearProductoProcesado(String codigo, String nombre,
                                                           double valorUnitario, int cantidadExistencia, Date fechaVencimiento) {

        ProductoProcesado ProProcs = null;

        ProProcs = obtenerProductoProcesado(codigo);
        if (ProProcs == null) {

            ProProcs = new ProductoProcesado( codigo,  nombre,  valorUnitario,  cantidadExistencia, fechaVencimiento);
            getListaProductosProcesados().add(ProProcs);
            return ProProcs;
        } else {
            return null;
        }
    }

    public static boolean actualizarProductoProcesado(String codigoNuev, String codigo, String nombre, double valorUnitario,
                                                      int cantidadExistencia, Date fechaVencimiento) {

        ProductoProcesado ProProcs = null;
        ProProcs = obtenerProductoProcesado(codigo);
        if (ProProcs != null) {

            ProProcs.setCodigo(codigoNuev);
            ProProcs.setNombre(nombre);
            ProProcs.setValorUnitario(valorUnitario);
            ProProcs.setCantidadExistencia(cantidadExistencia);
            ProProcs.setFechaVencimiento(fechaVencimiento);
            return true;
        } else {
            return false;
        }

    }

    public static boolean eliminarProductoProcesado(String codigo) {

        ProductoProcesado ProProcs = null;

        ProProcs = obtenerProductoProcesado(codigo);
        if (ProProcs != null) {
            getListaProductosProcesados().remove(ProProcs);
            return true;

        } else {
            return false;
        }
    }

    // ------------------------------ PRODUCTO REFRIGERADO ------------------------

    public static ProductoRefrigerado obtenerProductoRefrigerado(String codigo) {
        for (ProductoRefrigerado proRefri : listaProductosRefrigerados) {
            if (proRefri.getCodigo().equalsIgnoreCase(codigo)) {
                return proRefri;
            }
        }
        return null;
    }

    public static ProductoRefrigerado crearProductoRefrigerado(String codigo, String nombre, double valorUnitario,
                                                               int cantidadExistencia, int codigoAprobacion,
                                                               float temperaturaRefrigeracion) {

        ProductoRefrigerado proRefri = null;

        proRefri = obtenerProductoRefrigerado(codigo);
        if (proRefri == null) {

            proRefri = new ProductoRefrigerado(codigo, nombre, valorUnitario, cantidadExistencia, codigoAprobacion, temperaturaRefrigeracion);
            getListaProductosRefrigerados().add(proRefri);
            return proRefri;
        } else {
            return null;
        }
    }

    public static boolean actualizarProductosRegrigerados(String codigoNuev, String codigo, String nombre,
                                                          double valorUnitario, int cantidadExistencia,
                                                          int codigoAprobacion, float temperaturaRefrigeracion) {

        ProductoRefrigerado proRefri = null;

        proRefri = obtenerProductoRefrigerado(codigo);
        if (proRefri != null) {

            proRefri.setCodigo(codigoNuev);
            proRefri.setNombre(nombre);
            proRefri.setValorUnitario(valorUnitario);
            proRefri.setCantidadExistencia(cantidadExistencia);
            proRefri.setCodigoAprobacion(codigoAprobacion);
            proRefri.setTemperaturaRefrigeracion(temperaturaRefrigeracion);
            return true;
        } else {
            return false;
        }

    }

    public static boolean eliminarProductoRefrigerado(String codigo) {

        ProductoRefrigerado proRefri = null;

        proRefri = obtenerProductoRefrigerado(codigo);
        if (proRefri != null) {
            getListaProductosRefrigerados().remove(proRefri);
            return true;

        } else {
            return false;
        }
    }


}
