package application;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */

import Modelos.*;
import Modelos.Almacen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Aplicacion extends Application {

    private ArrayList<ClienteJuridico> listaClientesJuridicos = new ArrayList<ClienteJuridico>();

    private ArrayList<ClienteNatural> listaClientesNaturales = new ArrayList<ClienteNatural>();
    private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    private ArrayList<ProductoEnvasado> listaProductosEnvasados = new ArrayList<ProductoEnvasado>();
    private ArrayList<ProductoProcesado> listaProductosProcesados = new ArrayList<ProductoProcesado>();
    private ArrayList<ProductoRefrigerado> listaProductosRefrigerados =  new ArrayList<ProductoRefrigerado>();
    private ArrayList<Producto> listaProductos =  new ArrayList<Producto>();

    private  ArrayList<Venta> listaVentas = new ArrayList<Venta>();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("/Vistas/almacen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("AlmacenUQ");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


    // ----------------------------- CLIENTE NATURAL -------------------

    public static ArrayList<ClienteNatural> obtenerListaClientesNaturales() {
        return Almacen.getListaClientesNaturales();
    }

    public static ClienteNatural crearClienteNatural(String nombre, String apellido, String identificacion, String direccion,
                                                     String telefono, String correo, Date fechaNacimeinto) {

        ClienteNatural cNatural = Almacen.crearClienteNatural(nombre, apellido, identificacion, direccion, telefono, correo, fechaNacimeinto);

        return cNatural;
    }

    public boolean actualizarPersonaNatural(String idActual, String nombre, String apellido, String id,
                                            String direccion, String telefono, String correo, Date fechaNacimiento) {

        return Almacen.actualizarClienteNatural(idActual, nombre, apellido, id, direccion, telefono, correo, fechaNacimiento);

    }

    public boolean eliminarPersonaNatural(String id) {
        return Almacen.eliminarClienteNatural(id);
    }

    // ----------------------------- CLIENTE JURIDICO -------------------
    public static ArrayList<ClienteJuridico> obtenerListaClientesJuridicos() {
        return Almacen.getListaClientesJuridicos();
    }

    public static ClienteJuridico crearClienteJuridico(String nombre, String apellido, String id,
                                                       String direccion, String telefono, String nit) {

        ClienteJuridico cJuridica = Almacen.crearClienteJuridico(nombre, apellido, id, direccion, telefono, nit);

        return cJuridica;
    }

    public boolean actualizarClienteJuridico(String idActualNit, String nombre, String apellido, String id, String nit,
                                             String direccion, String telefono) {

        return Almacen.actualizarClienteJuridico(idActualNit, nombre, apellido,id, direccion, telefono, nit);

    }

    public boolean eliminarClienteJuridico(String nit) {
        return Almacen.eliminarClienteJuridico(nit);
    }

    // -----------------------------PRODUCTO ENVASADO-------------------

    public ProductoEnvasado crearProductoEnvasado(String codigo, String nombre, double valorUnitario,
                                                  int cantidadExistencia, Date fechaEnvasado, float pesoEnvase,
                                                  Pais paisOrigen) {

        ProductoEnvasado proEnva = Almacen.crearProductoEnvasado(codigo, nombre, valorUnitario, cantidadExistencia, fechaEnvasado, pesoEnvase, null);

        return proEnva;
    }

    public boolean actualizarProductoEnvasado(String codigoNuev, String codigo, String nombre, double valorUnitario,
                                              int cantidadExistencia, Date fechaEnvasado, float pesoEnvase,
                                              Pais paisOrigen) {

        return Almacen.actualizarProductoEnvasado(codigoNuev, codigo, nombre, valorUnitario, cantidadExistencia, fechaEnvasado, pesoEnvase,
                paisOrigen);

    }

    public boolean eliminarProductoEnvasado(String codigo) {

        return Almacen.eliminarProductoEnvasado(codigo);
    }

    // ----------------------------- PRODUCTO PROCESADO -------------------

    public ProductoProcesado crearProductoProcesado(String codigo, String nombre,
                                                    double valorUnitario, int cantidadExistencia, Date fechaVencimiento) {

        ProductoProcesado proProcs = Almacen.crearProductoProcesado(codigo, nombre, valorUnitario, cantidadExistencia,
                fechaVencimiento);

        return proProcs;
    }

    public boolean actualizarProductoProcesado(String codigoNuev, String codigo, String nombre, double valorUnitario,
                                               int cantidadExistencia, Date fechaVencimiento) {

        return Almacen.actualizarProductoProcesado(codigoNuev, codigo, nombre, valorUnitario, cantidadExistencia,
                fechaVencimiento);

    }

    public boolean eliminarProductoProcesado(String codigo) {

        return Almacen.eliminarProductoProcesado(codigo);
    }

    // ----------------------------- PRODUCTO REFRIGERADO -------------------

    public ProductoRefrigerado crearProductoRefrigerado(String codigo, String nombre, double valorUnitario,
                                                        int cantidadExistencia, int codigoAprobacion,
                                                        float temperaturaRefrigeracion) {

        ProductoRefrigerado proRefri = Almacen.crearProductoRefrigerado(codigo, nombre, valorUnitario, cantidadExistencia,
                codigoAprobacion, temperaturaRefrigeracion);

        return proRefri;
    }

    public boolean actualizarProductoRefrigerado(String codigoNuev,String codigo, String nombre,
                                                 double valorUnitario, int cantidadExistencia,
                                                 int codigoAprobacion, float temperaturaRefrigeracion) {

        return Almacen.actualizarProductosRegrigerados(codigo, codigo, nombre, valorUnitario, cantidadExistencia,
                codigoAprobacion, temperaturaRefrigeracion);

    }

    public boolean eliminarProductoRefrigerado(String codigo) {

        return Almacen.eliminarProductoRefrigerado(codigo);
    }

}