package Controlador;
/*
 * @author Juan José Restrepo Morales - Johan Estiven Zapata
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorAlmacen implements Initializable {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void abrirVentanaVenta(ActionEvent actionEvent) {
    }

    public void abrirVentanaCliente(ActionEvent actionEvent) {
        cargarFXML("/Vistas/cliente.fxml");
    }

    public void abrirVentanaProducto(ActionEvent actionEvent) {
        cargarFXML("/Vistas/producto.fxml");
    }
}