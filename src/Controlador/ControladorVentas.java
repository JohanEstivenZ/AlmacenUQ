package Controlador;

import Modelos.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import application.Aplicacion;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorVentas implements Initializable {


    @FXML
    private ComboBox comboBoxCliente;
    @FXML
    private TableView tbvwVenta;
    @FXML
    private TableColumn columVentaProducto;
    @FXML
    private TableColumn columVentaValor;
    @FXML
    private TableColumn columVentaDisponibilidad;
    @FXML
    private TableView tbvwVentaCliente;
    @FXML
    private TableColumn columVentaClienteProducto;
    @FXML
    private TableColumn columVentaClienteValor;
    @FXML
    private TableColumn columVentaClienteCantidad;
    @FXML
    private Button botonVender;

    public void seleccionarCliente() {

    }

    public void vender() {

    }

//  private ObservableList<Producto> productosVendidos = FXCollections.observableArrayList();
//
//    public void venderProducto() {
//
//        if (productoSeleccionado2 == null) {
//            mostrarMensaje("Notificación cliente", "Producto No Seleccionado", "El producto no ha sido seleccionado.",
//                    AlertType.ERROR);
//        } else {
//            //int cantidad = Integer.parseInt(productoSeleccionado2.getCantidadExistencia());
//
//            productoSeleccionado2.setCantidadExistencia("" + 1);
//            //productoSeleccionado2.setCantidadExistencia(""+cantidad);
//            //	productosVendidos.add(productoSeleccionado2);
//            //cantidad++;
//
//            for (int i = 0; i < productosVendidos.size(); i++) {
//                //productosVendidos.get(i).getNombre().equalsIgnoreCase(productoSeleccionado2.getNombre());
//                int cantidadNueva = Integer.parseInt(productosVendidos.get(i).getCantidadExistencia());
//                cantidadNueva++;
//                productosVendidos.get(i).setCantidadExistencia("" + cantidadNueva);
//                cantidadNueva = 0;
//                tbvwVentaCliente.getItems().clear();
//                tbvwVentaCliente.setItems(productosVendidos);
//
//            }
//            productosVendidos.add(productoSeleccionado2);
//
//        }
//    }
//
//    @Deprecated
//    void cambioProductos(ActionEvent event) {
//
//        if (rdoProductoEnvasado.isSelected()) {
//
//            txtCodigoAprobacionProductos.setDisable(true);
//            txtTemperaturaRefrigeradoProductos.setDisable(true);
//            dateFechaVencimiento.setDisable(true);
//
//            txtPesoEnvaseProducto.setDisable(false);
//            dateFechaEnvase.setDisable(false);
//            comboPais.setDisable(false);
//
//            mylabel.setText(rdoProductoEnvasado.getText());
//
//        }
//        if (rdoProductoPerecedero.isSelected()) {
//
//            txtCodigoAprobacionProductos.setDisable(true);
//            txtTemperaturaRefrigeradoProductos.setDisable(true);
//            txtPesoEnvaseProducto.setDisable(true);
//            dateFechaEnvase.setDisable(true);
//            comboPais.setDisable(true);
//
//            dateFechaVencimiento.setDisable(false);
//            mylabel.setText(rdoProductoEnvasado.getText());
//        }
//
//        if (rdoProductoRefrigerado.isSelected()) {
//
//            dateFechaVencimiento.setDisable(true);
//            dateFechaEnvase.setDisable(true);
//            txtPesoEnvaseProducto.setDisable(true);
//            comboPais.setDisable(true);
//
//            txtCodigoAprobacionProductos.setDisable(false);
//            txtTemperaturaRefrigeradoProductos.setDisable(false);
//
//        }
//    }
//
//    @Deprecated
//    void cambioPersona(ActionEvent event) {
//
//        if (rdoPersonaNatural.isSelected()) {
//
//            txtIdTribuCliente.setDisable(true);
//            txtNitCliente.setDisable(true);
//            txtIdCliente.setDisable(false);
//            mylabel.setText(rdoPersonaNatural.getText());
//
//        } else if (RdoPersonaJuridica.isSelected()) {
//
//            txtIdCliente.setDisable(true);
//            txtIdTribuCliente.setDisable(false);
//
//
//            txtNitCliente.setDisable(false);
//            mylabel.setText(rdoPersonaNatural.getText());
//
//        }
//
//    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        configurarColumnasTablaVenta();
//        configurarColumnasTablaVentaCliente();
//        configurarColumnasTablaDetalleVenta();
//    }
//
//    private void configurarColumnasTablaVenta() {
//        columVentaProducto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
//        columVentaValor.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
//        columVentaDisponibilidad.setCellValueFactory(new PropertyValueFactory<>("cantidadExistencia"));
//    }
//
//    private void configurarColumnasTablaVentaCliente() {
//        columVentaClienteProducto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
//        columVentaClienteValor.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
//        columVentaClienteCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidadExistencia"));
//    }
//
//    private void configurarColumnasTablaDetalleVenta() {
//        columDetalleProducto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
//        columDetalleCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidadExistencia"));
//        columDetalleSubtotal.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
//    }
//
//    private void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {
//        Alert alert = new Alert(alertType);
//        alert.setTitle(titulo);
//        alert.setHeaderText(header);
//        alert.setContentText(contenido);
//        alert.showAndWait();
//    }

    @FXML
    public void seleccionarCliente(ActionEvent actionEvent) {
    }

    @FXML
    public void vender(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

