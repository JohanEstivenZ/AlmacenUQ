package Controlador;
import Modelos.Producto;
import Modelos.ProductoEnvasado;
import Modelos.ProductoProcesado;
import Modelos.ProductoRefrigerado;
import application.Aplicacion;
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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
    private Label lavelPesoEnvase;
    @FXML
    private Label lavelPaisOrigen;
    private ToggleGroup radioButtonGroup;
    @FXML
    private RadioButton rdoEnvasado;
    @FXML
    private RadioButton rdoRefigerado;
    @FXML
    private RadioButton rdoProcesado;

    private ObservableList<ProductoProcesado> listaProductoProcesado = FXCollections.observableArrayList();
    private ObservableList<ProductoEnvasado> listaProductoEnvasado = FXCollections.observableArrayList();
    private ObservableList<ProductoRefrigerado> listaProductoRefrigerado = FXCollections.observableArrayList();
    private ObservableList<Producto> listaProductoData = FXCollections.observableArrayList();

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
        rdoEnvasado.setToggleGroup(radioButtonGroup);
        rdoRefigerado.setToggleGroup(radioButtonGroup);
        rdoProcesado.setToggleGroup(radioButtonGroup);


        rdoEnvasado.setOnAction(this::handleEnvasadoSelected);
        rdoProcesado.setOnAction(this::handleEnvasadoSelected);
        rdoRefigerado.setOnAction(this::handleEnvasadoSelected);


    }

    public void agregarProducto() {

        if (rdoProcesado.isSelected()) {
            String codigo = txtCodigoProducto.getText();
            String nombre = txtNombreProducto.getText();
            double valorUnitario = Double.parseDouble(txtValorUnitarioProducto.getText());
            String cantidadExistente = txtCantidadExistenteProducto.getText();
            LocalDate fechaVencimiento = dateFechaVencimiento.getValue();
            Date fechaVencimientoDate = Date.from(fechaVencimiento.atStartOfDay(ZoneId.systemDefault()).toInstant());

            if (validarDatosProProcs(codigo, nombre, String.valueOf(valorUnitario), cantidadExistente, fechaVencimiento)) {
                int cantEx = Integer.parseInt(cantidadExistente);
                ProductoProcesado proProcs = null;

                proProcs = Aplicacion.crearProductoProcesado(codigo, nombre, valorUnitario, cantEx,
                        fechaVencimientoDate);

                if (proProcs != null) {

                    listaProductoData.add(proProcs);
                    limpiarCamposProductos();
                    mostrarMensaje("Notificacion Producto", "Producto registrado",
                            "El producto se ha registrado con exito.", AlertType.INFORMATION);
                } else {
                    String mensaje = "El producto con el codigo: " + codigo + " Ya existe";
                    mostrarMensaje("Notificacion Producto", "Producto no registrado", mensaje, AlertType.ERROR);
                }

            }
        } else if (rdoEnvasado.isSelected()) {

            String codigo = txtCodigoProducto.getText();
            String nombre = txtNombreProducto.getText();
            double valorUnitario = Double.parseDouble(txtValorUnitarioProducto.getText());
            String cantidadExistente = txtCantidadExistenteProducto.getText();
            String pesoEnvase = txtPesoEnvaseProducto.getText();
            LocalDate fechaEnvasado = dateFechaEnvasado.getValue();
            Date fechaEnvasadoDate = Date.from(fechaEnvasado.atStartOfDay(ZoneId.systemDefault()).toInstant());


            if (validarDatosProEnva(codigo, nombre, String.valueOf(valorUnitario), cantidadExistente, pesoEnvase, fechaEnvasado)) {
                int cantEx = Integer.parseInt(cantidadExistente);
                float pesoEnv = Float.parseFloat(pesoEnvase);
                ProductoEnvasado proEnva = null;

                proEnva = Aplicacion.crearProductoEnvasado(codigo, nombre, valorUnitario, cantEx, fechaEnvasadoDate, pesoEnv, null);

                if (proEnva != null) {

                    listaProductoData.add(proEnva);
                    limpiarCamposProductos();
                    mostrarMensaje("Notificacion producto", "producto registrado",
                            "El producto se ha registrado con exito.", AlertType.INFORMATION);

                } else {
                    String mensaje = "El producto con codigo: " + codigo + " Ya existe";
                    mostrarMensaje("Notificacion producto", "Producto N0 registrado", mensaje, AlertType.ERROR);
                }
            }
        } else if (rdoRefigerado.isSelected()) {

            String codigo = txtCodigoProducto.getText();
            String nombre = txtNombreProducto.getText();
            double valorUnitario = Double.parseDouble(txtValorUnitarioProducto.getText());
            String cantidadExistente = txtCantidadExistenteProducto.getText();
            String codigoAprobacion = txtCodigoAprovacionProducto.getText();
            String temperaturaRefrigerado = txtTemperaturaRefigeramientoProducto.getText();

            if (validarDatosProRefri(codigo, nombre, String.valueOf(valorUnitario), cantidadExistente, codigoAprobacion,
                    temperaturaRefrigerado)) {
                int cantEx = Integer.parseInt(cantidadExistente);
                int codApr = Integer.parseInt(cantidadExistente);
                float tempRef = Float.parseFloat(temperaturaRefrigerado);

                ProductoRefrigerado proRefri = null;

                proRefri = Aplicacion.crearProductoRefrigerado(codigo, nombre, valorUnitario, cantEx,
                        codApr, tempRef);

                if (proRefri != null) {

                    listaProductoData.add(proRefri);
                    limpiarCamposProductos();
                    mostrarMensaje("Notificacion producto", "producto registrado",
                            "El producto se ha registrado con exito.", AlertType.INFORMATION);
                } else {
                    String mensaje = "El producto con codigo: " + codigo + " Ya existe";
                    mostrarMensaje("Notificacion producto", "Producto N0 registrado", mensaje, AlertType.ERROR);
                }
            }
        } else {

            mostrarMensaje("Notificacion", "seleccione un producto", "Seleccione un tipo de producto", AlertType.ERROR);
        }
    }

    public void actualizarProducto() {

        if (rdoProductoPerecedero.isSelected()) {
            String codigo = txtCodigoProducto.getText();
            String nombre = txtNombreProducto.getText();
            String valorUnitario = txtValorProducto.getText();
            String cantidadExistente = txtCantidadDisponibleProducto.getText();
            LocalDate fechaVencimiento = dateFechaVencimiento.getValue();

            boolean bandera = false;

            if (productoSeleccionado != null) {
                if (validarDatosProPere(codigo, nombre, valorUnitario, cantidadExistente, fechaVencimiento))

                    bandera = aplicacion.actualizarProductoPerecedero(productoSeleccionado.getCodigo(), codigo, nombre,
                            valorUnitario, cantidadExistente, fechaVencimiento);

                if (bandera == true) {

                    tblProductos.refresh();
                    mostrarMensaje("Notificacion Producto", "Producto Actualizado",
                            "El producto se ha Actualizado con exito.", AlertType.INFORMATION);

                } else {
                    mostrarMensaje("Notificacion Producto", "Producto No Actualizado",
                            "El producto N0 se ha Actualizado.", AlertType.ERROR);
                }
            } else {
                mostrarMensaje("Notificacion Producto", "Producto No Seleccionado", "El producto N0 se ha Actualizado.",
                        AlertType.ERROR);
            }
        } else if (rdoProductoEnvasado.isSelected()) {
            String codigo = txtCodigoProducto.getText();
            String nombre = txtNombreProducto.getText();
            String valorUnitario = txtValorProducto.getText();
            String cantidadExistente = txtCantidadDisponibleProducto.getText();
            String pesoEnvase = txtPesoEnvaseProducto.getText();
            LocalDate fechaEnvasado = dateFechaEnvase.getValue();

            boolean bandera = false;

            if (productoSeleccionado != null) {

                if (validarDatosProEnva(codigo, nombre, valorUnitario, cantidadExistente, pesoEnvase, fechaEnvasado))
                    ;

                bandera = aplicacion.actualizarProductoEnvasado(productoSeleccionado.getCodigo(), nombre, valorUnitario,
                        cantidadExistente, pesoEnvase, fechaEnvasado, pesoEnvase);

                if (bandera == true) {

                    tblProductos.refresh();
                    mostrarMensaje("Notificacion Producto", "Producto Actualizado",
                            "El producto se ha Actualizado con exito.", AlertType.INFORMATION);

                } else {
                    mostrarMensaje("Notificacion Producto", "Producto No Actualizado",
                            "El producto N0 se ha Actualizado.", AlertType.ERROR);
                }

            }

        } else if (rdoProductoRefrigerado.isSelected()) {
            String codigo = txtCodigoProducto.getText();
            String nombre = txtNombreProducto.getText();
            String valorUnitario = txtValorProducto.getText();
            String cantidadExistente = txtCantidadDisponibleProducto.getText();
            String codigoAprobacion = txtCodigoAprobacionProductos.getText();
            String temperaturaRefrigerado = txtTemperaturaRefrigeradoProductos.getText();

            boolean bandera = false;

            if (productoSeleccionado != null) {

                if (validarDatosProRefri(codigo, nombre, valorUnitario, cantidadExistente, codigoAprobacion,
                        temperaturaRefrigerado))
                    ;

                bandera = aplicacion.actualizarProductoRefrigerado(productoSeleccionado.getCodigo(), nombre,
                        valorUnitario, cantidadExistente, codigoAprobacion, temperaturaRefrigerado);

                if (bandera == true) {

                    tblProductos.refresh();
                    mostrarMensaje("Notificacion Producto", "Producto Actualizado",
                            "El producto se ha Actualizado con exito.", AlertType.INFORMATION);

                } else {
                    mostrarMensaje("Notificacion Producto", "Producto No Actualizado",
                            "El producto N0 se ha Actualizado.", AlertType.ERROR);
                }

            } else {
                mostrarMensaje("Notificacion cliente", "Cliente No Seleccionado", "El cliente No ha sido seleccionado.",
                        AlertType.ERROR);
            }
        }
    }

    public void eliminarProducto() {

        if (rdoProductoPerecedero.isSelected()) {

            boolean bandera = false;

            if (productoSeleccionado != null) {
                if (mostrarMensajeConfirmacion("�Esta seguro de eliminar el producto?") == true) {

                    bandera = aplicacion.eliminarProductoPerecedero(productoSeleccionado.getCodigo());
                    if (bandera == true) {
                        listaProductoData.remove(productoSeleccionado);
                        productoSeleccionado = null;
                        tblProductos.getSelectionModel().clearSelection();
                        mostrarMensaje("Notificacion Producto", "Producto Eliminado",
                                "El Producto se ha Eliminado con exito.", AlertType.INFORMATION);
                    } else {
                        mostrarMensaje("Notificacion Producto", "Producto No Eliminado",
                                "El Producto No se ha Eliminado.", AlertType.ERROR);
                    }
                }
            } else {
                mostrarMensaje("Notificacion Producto", "Producto No Seleccionado",
                        "El Producto No ha sido seleccionado.", AlertType.ERROR);
            }

        } else if (rdoProductoEnvasado.isSelected()) {
            boolean bandera = false;

            if (productoSeleccionado != null) {
                if (mostrarMensajeConfirmacion("Esta seguro de eliminar el Producto?") == true) {

                    bandera = aplicacion.eliminarProductoEnvasado(productoSeleccionado.getCodigo());
                    if (bandera == true) {
                        listaProductoData.remove(productoSeleccionado);
                        productoSeleccionado = null;
                        tblProductos.getSelectionModel().clearSelection();
                        mostrarMensaje("Notificacion Producto", "Cliente Producto",
                                "El Producto se ha Eliminado con exito.", AlertType.INFORMATION);
                    } else {
                        mostrarMensaje("Notificacion Producto", "Cliente No Eliminado",
                                "El Producto No se ha Eliminado.", AlertType.ERROR);
                    }
                }
            } else {
                mostrarMensaje("Notificacion Producto", "Producto No Seleccionado",
                        "El Producto No ha sido seleccionado.", AlertType.ERROR);
            }

        } else if (rdoProductoRefrigerado.isSelected()) {
            boolean bandera = false;

            if (productoSeleccionado != null) {
                if (mostrarMensajeConfirmacion("Esta seguro de eliminar el Producto?") == true) {

                    bandera = aplicacion.eliminarProductoRefrigerado(productoSeleccionado.getCodigo());
                    if (bandera == true) {
                        listaProductoData.remove(productoSeleccionado);
                        productoSeleccionado = null;
                        tblProductos.getSelectionModel().clearSelection();
                        mostrarMensaje("Notificacion Producto", "Cliente Producto",
                                "El Producto se ha Eliminado con exito.", AlertType.INFORMATION);
                    } else {
                        mostrarMensaje("Notificacion Producto", "Cliente No Eliminado",
                                "El Producto No se ha Eliminado.", AlertType.ERROR);
                    }
                }
            } else {
                mostrarMensaje("Notificacion Producto", "Producto No Seleccionado",
                        "El Producto No ha sido seleccionado.", AlertType.ERROR);
            }
        }
    }

    public void limpiarCamposProductos() {
        txtCodigoProducto.setText("");
        txtNombreProducto.setText("");
        txtValorUnitarioProducto.setText("");
        txtCantidadExistenteProducto.setText("");
        txtPesoEnvaseProducto.setText("");
        txtCodigoAprovacionProducto.setText("");
        txtTemperaturaRefigeramientoProducto.setText("");
        dateFechaEnvasado.setValue(null);
        dateFechaVencimiento.setValue(null);

    }
    private boolean validarDatosProProcs(String codigo, String nombre, String valorProducto, String cantExistente,
                                        LocalDate fechaVencimiento) {

        String mensaje = "";

        if (codigo == null || codigo.equalsIgnoreCase("")) {
            mensaje += "El codigo es invalido \n";
        }
        if (nombre == null || nombre.equalsIgnoreCase("")) {
            mensaje += "El nombre es invalido \n";
        }
        if (valorProducto == null || valorProducto.equalsIgnoreCase("")) {
            mensaje += "El valor del producto es invalido \n";
        }
        if (cantExistente == null || cantExistente.equalsIgnoreCase("")) {
            mensaje += "La cantExistente es invalida \n";
        }
        if (fechaVencimiento == null) {
            mensaje += "El fechaVencimiento es invalido \n";
        }
        if (mensaje.equalsIgnoreCase("")) {
            return true;
        } else {
            mostrarMensaje("Notificacion cliente", "Datos Invalidos", mensaje, AlertType.WARNING);
            return false;
        }

    }

    private boolean validarDatosProRefri(String codigo, String nombre, String valorProducto, String cantExistente,
                                         String codigoAprobacion, String temperaturaRefrigerado) {

        String mensaje = "";

        if (codigo == null || codigo.equalsIgnoreCase("")) {
            mensaje += "el codigo es invalido \n";
        }
        if (nombre == null || nombre.equalsIgnoreCase("")) {
            mensaje += "el nombre es invalido \n";
        }
        if (valorProducto == null || valorProducto.equalsIgnoreCase("")) {
            mensaje += "el valor del producto es invalido \n";
        }
        if (cantExistente == null || cantExistente.equalsIgnoreCase("")) {
            mensaje += "la cantExistente es invalida \n";
        }
        if (codigoAprobacion == null || codigoAprobacion.equalsIgnoreCase("")) {
            mensaje += "el codigo de aprobacion es invalido \n";
        }
        if (temperaturaRefrigerado == null || temperaturaRefrigerado.equalsIgnoreCase("")) {
            mensaje += "La temperatura es invalido \n";
        }
        if (mensaje.equalsIgnoreCase("")) {
            return true;
        } else {
            mostrarMensaje("Notificacion Producto", "Datos Invalidos", mensaje, AlertType.WARNING);
            return false;
        }

    }

    private boolean validarDatosProEnva(String codigo, String nombre, String valorProducto, String cantExistente,
                                        String pesoEnvase, LocalDate fechaEnvasado) {

        String mensaje = "";

        if (codigo == null || codigo.equalsIgnoreCase("")) {
            mensaje += "el codigo es invalido \n";
        }
        if (nombre == null || nombre.equalsIgnoreCase("")) {
            mensaje += "el nombre es invalido \n";
        }
        if (valorProducto == null || valorProducto.equalsIgnoreCase("")) {
            mensaje += "el valor del producto es invalido \n";
        }
        if (cantExistente == null || cantExistente.equalsIgnoreCase("")) {
            mensaje += "la cantExistente es invalida \n";
        }
        if (pesoEnvase == null || pesoEnvase.equalsIgnoreCase("")) {
            mensaje += "el peso del envase es invalido \n";
        }
        if (fechaEnvasado == null) {
            mensaje += "la fecha de envase  es invalida \n";
        }

        if (mensaje.equalsIgnoreCase("")) {
            return true;
        } else {
            mostrarMensaje("Notificacion Producto", "Datos Invalidos", mensaje, AlertType.WARNING);
            return false;
        }

    }



    private void handleEnvasadoSelected(ActionEvent actionEvent) {
        boolean isEnvasadoSelected = rdoEnvasado.isSelected();
        boolean isProcesadoSelected = rdoProcesado.isSelected();
        boolean isRefigeradoSelected = rdoRefigerado.isSelected();

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




