package Controlador;

import Modelos.Persona;
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
import java.util.ResourceBundle;

public class ControladorCliente implements Initializable {

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
    private TableView<Persona> tblCliente;
    @FXML
    private RadioButton RdoClienteJuridico;
    @FXML
    private RadioButton RdoClienteNatural;
    @FXML
    private Button btnGuardarCliente;
    @FXML
    private Button btnLimpiarCliente;
    @FXML
    private Button btnSalirCliente;
    @FXML
    private Button btnEliminarCliente;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
