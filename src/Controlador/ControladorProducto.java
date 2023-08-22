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
        RdoProcesado.setOnAction(this::handleEnvasadoSelected);
        RdoRefigerado.setOnAction(this::handleEnvasadoSelected);


    }

    private void handleEnvasadoSelected(ActionEvent actionEvent) {
        boolean isEnvasadoSelected = RdoEnvasado.isSelected();
        boolean isProcesadoSelected = RdoProcesado.isSelected();
        boolean isRefigeradoSelected = RdoRefigerado.isSelected();

        RadioButton selectedRadioButton = (RadioButton) radioButtonGroup.getSelectedToggle();

        if (selectedRadioButton != null) {
            String selectedLabel = selectedRadioButton.getText();

            if (selectedLabel.equals("Envasado")) {
                lavelFechaEnvasado.setVisible(isEnvasadoSelected);
                lavelPesoEnvase.setVisible(isEnvasadoSelected);
                lavelPaisOrigen.setVisible(isEnvasadoSelected);
                dateFechaEnvasado.setVisible(isEnvasadoSelected);
                txtPesoEnvaseProducto.setVisible(isEnvasadoSelected);
                comboBoxPaisProducto.setVisible(isEnvasadoSelected);
                labelCodigoAprovacion.setVisible(false);
                txtCodigoAprovacionProducto.setVisible(false);
                labelTemperatura.setVisible(false);
                txtTemperaturaRefigeramientoProducto.setVisible(false);
                dateFechaVencimiento.setVisible(false);
                labelFechaVencimineto.setVisible(false);
            } else if (selectedLabel.equals("Refrigerado")) {
                labelCodigoAprovacion.setVisible(isRefigeradoSelected);
                txtCodigoAprovacionProducto.setVisible(isRefigeradoSelected);
                labelTemperatura.setVisible(isRefigeradoSelected);
                txtTemperaturaRefigeramientoProducto.setVisible(isRefigeradoSelected);
                lavelFechaEnvasado.setVisible(false);
                lavelPesoEnvase.setVisible(false);
                lavelPaisOrigen.setVisible(false);
                dateFechaEnvasado.setVisible(false);
                txtPesoEnvaseProducto.setVisible(false);
                comboBoxPaisProducto.setVisible(false);
                dateFechaVencimiento.setVisible(false);
                labelFechaVencimineto.setVisible(false);
            } else if (selectedLabel.equals("Procesado")) {
                dateFechaVencimiento.setVisible(isProcesadoSelected);
                labelFechaVencimineto.setVisible(isProcesadoSelected);
                labelCodigoAprovacion.setVisible(false);
                txtCodigoAprovacionProducto.setVisible(false);
                labelTemperatura.setVisible(false);
                txtTemperaturaRefigeramientoProducto.setVisible(false);
                lavelFechaEnvasado.setVisible(false);
                lavelPesoEnvase.setVisible(false);
                lavelPaisOrigen.setVisible(false);
                dateFechaEnvasado.setVisible(false);
                txtPesoEnvaseProducto.setVisible(false);
                comboBoxPaisProducto.setVisible(false);
            }


        }
    }
}




