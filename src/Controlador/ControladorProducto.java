package Controlador;
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

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorProducto implements Initializable{
    @javafx.fxml.FXML
    private TextField txtNombreProducto;
    @javafx.fxml.FXML
    private TextField txtCodigoProducto;
    @javafx.fxml.FXML
    private TextField txtDescripcionProducto;
    @javafx.fxml.FXML
    private TextField txtValorUnitarioProducto;
    @javafx.fxml.FXML
    private TextField txtCantidadExistenteProducto;
    @javafx.fxml.FXML
    private RadioButton RdoClienteNatural;
    @javafx.fxml.FXML
    private RadioButton RdoClienteJuridico;
    @javafx.fxml.FXML
    private RadioButton RdoClienteNatural1;
    @javafx.fxml.FXML
    private ComboBox comboBoxPaisProducto;
    @javafx.fxml.FXML
    private TextField txtPesoEnvaseProducto;
    @javafx.fxml.FXML
    private DatePicker dateFechaEnvasado;
    @javafx.fxml.FXML
    private Label labelCodigoAprovacion;
    @javafx.fxml.FXML
    private TextField txtCodigoAprovacionProducto;
    @javafx.fxml.FXML
    private Label labelTemperatura;
    @javafx.fxml.FXML
    private TextField txtTemperaturaRefigeramientoProducto;
    @javafx.fxml.FXML
    private DatePicker dateFechaVencimiento;
    @FXML
    private Label lavelFechaEnvasado;
    @FXML
    private Label labelFechaVencimineto;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    private void handleClienteNaturalSelected(ActionEvent event) {
        boolean isSelected = RdoClienteNatural.isSelected();
        // Ocultar o mostrar las opciones relacionadas con el cliente natural según la selección
        labelCodigoAprovacion.setVisible(!isSelected);
        txtCodigoAprovacionProducto.setVisible(!isSelected);
        labelTemperatura.setVisible(!isSelected);
        txtTemperaturaRefigeramientoProducto.setVisible(!isSelected);
        dateFechaVencimiento.setVisible(!isSelected);
        labelFechaVencimineto.setVisible(!isSelected);
    }
}
