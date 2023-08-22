package Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorVentas implements Initializable {

    private void cargarFXML(String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);

            // Cierra la ventana actual
            ((Stage) ((Node) root).getScene().getWindow()).close();

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @javafx.fxml.FXML
    private ComboBox comboBoxCliente;
    @javafx.fxml.FXML
    private TableView tbvwVenta;
    @javafx.fxml.FXML
    private TableColumn columVentaProducto;
    @javafx.fxml.FXML
    private TableColumn columVentaValor;
    @javafx.fxml.FXML
    private TableColumn columVentaDisponibilidad;
    @javafx.fxml.FXML
    private TableView tbvwVentaCliente;
    @javafx.fxml.FXML
    private TableColumn columVentaClienteProducto;
    @javafx.fxml.FXML
    private TableColumn columVentaClienteValor;
    @javafx.fxml.FXML
    private TableColumn columVentaClienteCantidad;
    @javafx.fxml.FXML
    private Button botonVender;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void seleccionarCliente () {

    }
    public void vender () {

    }
    public void detalleVenta (ActionEvent actionEvent) {
        cargarFXML("/Vistas/detalleVenta.fxml");
    }


}
