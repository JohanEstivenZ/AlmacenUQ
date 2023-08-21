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

public class ControladorProducto implements Initializable {
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
    @FXML
    private RadioButton RdoEnvasado;
    @FXML
    private RadioButton RdoRefigerado;
    @FXML
    private RadioButton RdoProcesado;
    @FXML
    private Label lavelPesoEnvase;
    @FXML
    private Label lavelPaisOrigen;
    private ToggleGroup radioButtonGroup;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        labelCodigoAprovacion.setVisible(false);
        txtCodigoAprovacionProducto.setVisible(false);
        labelTemperatura.setVisible(false);
        txtTemperaturaRefigeramientoProducto.setVisible(false);
        dateFechaVencimiento.setVisible(false);
        labelFechaVencimineto.setVisible(false);
        lavelFechaEnvasado.setVisible(false);
        lavelPesoEnvase.setVisible(false);
        lavelPaisOrigen.setVisible(false);
        dateFechaEnvasado.setVisible(false);
        txtPesoEnvaseProducto.setVisible(false);
        comboBoxPaisProducto.setVisible(false);

        radioButtonGroup = new ToggleGroup();
        RdoEnvasado.setToggleGroup(radioButtonGroup);
        RdoRefigerado.setToggleGroup(radioButtonGroup);
        RdoProcesado.setToggleGroup(radioButtonGroup);


        RdoEnvasado.setOnAction(this::handleEnvasadoSelected);



    }

    private void handleEnvasadoSelected(ActionEvent actionEvent) {
        boolean isSelected = RdoEnvasado.isSelected();
        // Mostrar u ocultar las opciones relacionadas con el cliente natural según la selección
        lavelFechaEnvasado.setVisible(isSelected);
        lavelPesoEnvase.setVisible(isSelected);
        lavelPaisOrigen.setVisible(isSelected);
        dateFechaEnvasado.setVisible(isSelected);
        txtPesoEnvaseProducto.setVisible(isSelected);
        comboBoxPaisProducto.setVisible(isSelected);
    }

}


