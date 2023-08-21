package Controlador;


import Modelos.*;
import application.Aplicacion;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class ControladorCliente implements Initializable {
    private ObservableList<ClienteNatural> listaClienteNaturalData = FXCollections.observableArrayList();
    private ObservableList<ClienteJuridico> listaClienteJuridicoData = FXCollections.observableArrayList();
    private ObservableList<Cliente> listaClienteData = FXCollections.observableArrayList();
    private ObservableList<ProductoProcesado> listaProductoProcesado = FXCollections.observableArrayList();
    private ObservableList<ProductoEnvasado> listaProductoEnvasado = FXCollections.observableArrayList();
    private ObservableList<ProductoRefrigerado> listaProductoRefrigerado = FXCollections.observableArrayList();
    private ObservableList<Producto> listaProductoData = FXCollections.observableArrayList();
    private ObservableList<Producto> productosVendidos = FXCollections.observableArrayList();

    private ClienteNatural clientenaturalSeleccionado;
    private ClienteJuridico clienteJuridicaSeleccionado;

    @FXML
    private TextField txtNombreCliente;
    @FXML
    private TextField txtApellidoCliente;
    @FXML
    private TextField txtIdCliente;
    @FXML
    private TextField txtTelefonoCliente;
    @FXML
    private TextField txtDireccionCliente;
    @FXML
    private TextField txtCorreoCliente;
    @FXML
    private TextField txtNitCliente;
    @FXML
    private Button btnGuardarCliente;
    @FXML
    private Button btnLimpiarCliente;
    @FXML
    private Button btnSalirCliente;
    @FXML
    private Button btnEliminarCliente;
    @FXML
    private TableView columnNitCliente;
    @FXML
    private TableColumn columnNombreCliente;
    @FXML
    private TableColumn columnApellidoCliente;
    @FXML
    private TableColumn columnIdCliente;
    @FXML
    private TableColumn columnTelefonoCliente;
    @FXML
    private TableColumn columnDireccionCliente;
    @FXML
    private TableColumn columnCorrreoCliente;
    @FXML
    private TableColumn columnFNacimientoCliente;
    @FXML
    private Button btnActualizarCliente;
    @FXML
    private DatePicker dateFechaNacimiento;
    @FXML
    private RadioButton rdoClienteNatural;
    @FXML
    private RadioButton rdoClienteJuridico;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void guardarCliente(ActionEvent actionEvent) {
        agregarCliente();
    }

    @FXML
    public void limpiarCliente(ActionEvent actionEvent) {
        limpiarCamposCliente();
    }

    @FXML
    public void salir(ActionEvent actionEvent) {
    }

    @FXML
    public void actualizarCliente(ActionEvent actionEvent) {
    }

    @FXML
    public void eliminarCliente(ActionEvent actionEvent) {
    }

    public void limpiarCamposCliente() {
        txtNombreCliente.setText("");
        txtApellidoCliente.setText("");
        txtIdCliente.setText("");
        txtDireccionCliente.setText("");
        txtTelefonoCliente.setText("");
        txtNitCliente.setText("");
        txtCorreoCliente.setText("");
        dateFechaNacimiento.setValue(null);

    }

    public void agregarCliente() {

        if (rdoClienteNatural.isSelected()) {
            String nombre = txtNombreCliente.getText();
            String apellido = txtApellidoCliente.getText();
            String id = txtIdCliente.getText();
            String direccion = txtDireccionCliente.getText();
            String telefono = txtTelefonoCliente.getText();
            String correo = txtCorreoCliente.getText();
            LocalDate fechaNacimiento = dateFechaNacimiento.getValue();
            Date fechaUtil = Date.from(fechaNacimiento.atStartOfDay(ZoneId.systemDefault()).toInstant());


            if (validarDatosNatural(nombre, apellido, id, direccion, telefono, correo, fechaUtil)) {
                ClienteNatural cNatural = null;

                cNatural = Aplicacion.crearClienteNatural(nombre, apellido, id, direccion, telefono, correo, fechaUtil);

                if (cNatural != null) {

                    listaClienteData.add(cNatural);
                    limpiarCamposCliente();
                    mostrarMensaje("Notificacion cliente", "Cliente registrado",
                            "El cliente se ha registrado con exito.", AlertType.INFORMATION);
                } else {
                    String mensaje = "El cliente con documento: " + id + " Ya existe";
                    mostrarMensaje("Notificacion cliente", "Cliente No registrado", mensaje, AlertType.ERROR);
                }

            }
        } else if (rdoClienteJuridico.isSelected()) {

            String nombre = txtNombreCliente.getText();
            String apellido = txtApellidoCliente.getText();
            String id = txtIdCliente.getText();
            String direccion = txtDireccionCliente.getText();
            String telefono = txtTelefonoCliente.getText();
            String nit = txtNitCliente.getText();


            if (validarDatosJuridico(nombre, apellido, id, direccion, telefono, nit)) {
                ClienteJuridico cJuridica = null;

                cJuridica = Aplicacion.crearClienteJuridico(nombre, apellido, id, direccion, telefono, nit);

                if (cJuridica != null) {

                    listaClienteData.add(cJuridica);
                    limpiarCamposCliente();
                    mostrarMensaje("Notificacion cliente", "Cliente registrado",
                            "El cliente se ha registrado con exito.", AlertType.INFORMATION);

                } else {
                    String mensaje = "El cliente con documento: " + nit + " Ya existe";
                    mostrarMensaje("Notificaci�n cliente", "Cliente No registrado", mensaje, AlertType.ERROR);
                }

            }
        } else {

            mostrarMensaje("Notificaci�n cliente", "seleccione un tipo de cliente", "Seleccione un tipo de persona",
                    AlertType.ERROR);
        }
    }

    private boolean validarDatosNatural(String nombre, String apellido, String id, String correo, String direccion, String telefono, Date fechaNacimiento) {
        String mensaje = "";


        if (nombre == null || nombre.equalsIgnoreCase("")) {
            mensaje += "El nombre es invalido \n";
        }
        if (apellido == null || apellido.equalsIgnoreCase("")) {
            mensaje += "El apellido es invalido \n";
        }
        if (id == null || id.equalsIgnoreCase("")) {
            mensaje += "El id es invalido \n";
        }
        if (correo == null || correo.equalsIgnoreCase("")) {
            mensaje += "El correo es invalido \n";
        }
        if (direccion == null || direccion.equalsIgnoreCase("")) {
            mensaje += "La direccion es invalida \n";
        }
        if (telefono == null || telefono.equalsIgnoreCase("")) {
            mensaje += "El telefono es invalido \n";
        }
        if (fechaNacimiento == null || id.equalsIgnoreCase("")) {
            mensaje += "La fecha nacimiento es invalida \n";
        }
        if (mensaje.equalsIgnoreCase("")) {
            return true;
        } else {
            mostrarMensaje("Notificacion cliente", "Datos Invalidos", mensaje, AlertType.WARNING);
            return false;
        }

    }

    private boolean validarDatosJuridico(String nombre, String apellido, String id,
                                         String direccion, String telefono, String nit) {
        String mensaje = "";

        if (nombre == null || nombre.equalsIgnoreCase("")) {
            mensaje += "El nombre es invalido \n";
        }
        if (apellido == null || apellido.equalsIgnoreCase("")) {
            mensaje += "El apellido es invalido \n";
        }
        if (nit == null || nit.equalsIgnoreCase("")) {
            mensaje += "El nit es invalido \n";
        }
        if (id == null || id.equalsIgnoreCase("")) {
            mensaje += "El id es invalido \n";
        }
        if (direccion == null || direccion.equalsIgnoreCase("")) {
            mensaje += "La direccion es invalida \n";
        }
        if (telefono == null || telefono.equalsIgnoreCase("")) {
            mensaje += "El telefono es invalido \n";
        }
        if (mensaje.equalsIgnoreCase("")) {
            return true;
        } else {
            mostrarMensaje("Notificacion cliente", "Datos Invalidos", mensaje, AlertType.WARNING);
            return false;
        }

    }

    private void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

        Alert alert = new Alert(alertType);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();

    }
}
