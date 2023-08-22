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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
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
    private Label labelFechaVencimineto;
    private ToggleGroup radioButtonGroup;
    @FXML
    private Label lavelFechaEnvasado;
    @FXML
    private Label lavelPesoEnvase;
    @FXML
    private Label lavelPaisOrigen;
    @FXML
    private RadioButton rdoEnvasado;
    @FXML
    private RadioButton rdoRefigerado;
    @FXML
    private RadioButton rdoProcesado;

    private ObservableList<Producto> listaProductosData = FXCollections.observableArrayList();
    private ObservableList<ProductoProcesado> listaProductosProcesadosData = FXCollections.observableArrayList();
    private ObservableList<ProductoRefrigerado> listaProductosRefrigeradosData = FXCollections.observableArrayList();
    private ObservableList<ProductoEnvasado> listaProductosEnvasadosData = FXCollections.observableArrayList();

    private ProductoRefrigerado productoRefrigeradoSeleccionado;
    private ProductoEnvasado productoEnvasadoSeleccionado;
    private ProductoProcesado productoProcesadoSeleccionado;

    private Producto productoSeleccionado;
    @FXML
    private TableView tblProductos;
    @FXML
    private Button btnGuardarProducto;
    @FXML
    private Button btnLimpiarProducto;
    @FXML
    private Button btnActualizarProducto;
    @FXML
    private Button btnEliminarProducto;

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

        // Configurar las columnas de la tabla para productos
        TableColumn<Producto, String> codigoColumn = new TableColumn<>("Código");
        codigoColumn.setCellValueFactory(new PropertyValueFactory<>("codigo"));

        TableColumn<Producto, String> nombreColumn = new TableColumn<>("Nombre");
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Producto, Double> valorUnitarioColumn = new TableColumn<>("Valor Unitario");
        valorUnitarioColumn.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));

        TableColumn<Producto, Integer> cantidadExistenteColumn = new TableColumn<>("Cantidad Existente");
        cantidadExistenteColumn.setCellValueFactory(new PropertyValueFactory<>("cantidadExistente"));

        // Agregar las columnas a la tabla
        tblProductos.getColumns().addAll(codigoColumn, nombreColumn, valorUnitarioColumn, cantidadExistenteColumn);

        // Configura la tabla para usar la lista de datos
        tblProductos.setItems(listaProductosData);

        // Agregar un listener para manejar la selección de productos
        tblProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            productoSeleccionado = (Producto) newSelection;
            mostrarInformacionProductos(); // Debes implementar este método para mostrar la información del producto seleccionado.
        });

    }

    private void mostrarInformacionProductos() {
        if (productoSeleccionado != null) {
            txtCodigoProducto.setText(productoSeleccionado.getCodigo());
            txtNombreProducto.setText(productoSeleccionado.getNombre());
            txtCantidadExistenteProducto.setText(String.valueOf(productoSeleccionado.getCantidadExistencia()));
            txtValorUnitarioProducto.setText(String.valueOf(productoSeleccionado.getValorUnitario()));

        }
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

                    listaProductosData.add(proProcs);
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

                    listaProductosData.add(proEnva);
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

                    listaProductosData.add(proRefri);
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

        if (rdoProcesado.isSelected()) {
            String codigo = txtCodigoProducto.getText();
            String nombre = txtNombreProducto.getText();
            double valorUnitario = Double.parseDouble(txtValorUnitarioProducto.getText());
            String cantidadExistente = txtCantidadExistenteProducto.getText();
            LocalDate fechaVencimiento = dateFechaVencimiento.getValue();
            Date fechaVencimientoDate = Date.from(fechaVencimiento.atStartOfDay(ZoneId.systemDefault()).toInstant());

            boolean bandera = false;
            int cantEx = Integer.parseInt(cantidadExistente);
            if (productoSeleccionado != null) {
                if (validarDatosProProcs(codigo, nombre, String.valueOf(valorUnitario), cantidadExistente, fechaVencimiento))

                    bandera = Aplicacion.actualizarProductoProcesado(productoSeleccionado.getCodigo(), codigo, nombre,
                            valorUnitario, cantEx, fechaVencimientoDate);

                if (bandera) {

                    tblProductos.refresh();
                    mostrarMensaje("Notificación Producto", "Producto Actualizado",
                            "El producto se ha actualizado con éxito.", AlertType.INFORMATION);

                } else {
                    mostrarMensaje("Notificación Producto", "Producto No Actualizado",
                            "El producto no se ha actualizado.", AlertType.ERROR);
                }
            } else {
                mostrarMensaje("Notificación Producto", "Producto No Seleccionado", "El producto no se ha seleccionado.",
                        AlertType.ERROR);
            }
        } else if (rdoEnvasado.isSelected()) {
            String codigo = txtCodigoProducto.getText();
            String nombre = txtNombreProducto.getText();
            double valorUnitario = Double.parseDouble(txtValorUnitarioProducto.getText());
            String cantidadExistente = txtCantidadExistenteProducto.getText();
            String pesoEnvase = txtPesoEnvaseProducto.getText();
            LocalDate fechaEnvasado = dateFechaEnvasado.getValue();
            Date fechaEnvasadoDate = Date.from(fechaEnvasado.atStartOfDay(ZoneId.systemDefault()).toInstant());
            int cantEx = Integer.parseInt(cantidadExistente);
            float pesoEnv = Float.parseFloat(pesoEnvase);
            String paisOrigen = (String) comboBoxPaisProducto.getValue();

            boolean bandera = false;

            if (productoSeleccionado != null) {

                if (validarDatosProEnva(codigo, nombre, String.valueOf(valorUnitario), cantidadExistente, pesoEnvase, fechaEnvasado))
                    ;

                bandera = Aplicacion.actualizarProductoEnvasado(productoSeleccionado.getCodigo(), codigo, nombre,
                        valorUnitario, cantEx, fechaEnvasadoDate, pesoEnv, Pais.valueOf(paisOrigen));

                if (bandera) {

                    tblProductos.refresh();
                    mostrarMensaje("Notificación Producto", "Producto Actualizado",
                            "El producto se ha actualizado con éxito.", AlertType.INFORMATION);

                } else {
                    mostrarMensaje("Notificación Producto", "Producto No Actualizado",
                            "El producto no se ha actualizado.", AlertType.ERROR);
                }

            }

        } else if (rdoRefigerado.isSelected()) {
            String codigo = txtCodigoProducto.getText();
            String nombre = txtNombreProducto.getText();
            double valorUnitario = Double.parseDouble(txtValorUnitarioProducto.getText());
            String cantidadExistente = txtCantidadExistenteProducto.getText();
            String codigoAprobacion = txtCodigoAprovacionProducto.getText();
            String temperaturaRefrigerado = txtTemperaturaRefigeramientoProducto.getText();

            boolean bandera = false;

            if (productoSeleccionado != null) {
                if (validarDatosProRefri(codigo, nombre, String.valueOf(valorUnitario), cantidadExistente, codigoAprobacion,
                        temperaturaRefrigerado)) {

                    // Aquí necesitas obtener el valor seleccionado del ComboBox de país, asumiendo que es un ComboBox<String>.

                    // Luego, llama a Aplicacion.actualizarProductoRefrigerado pasando todos los parámetros.
                    bandera = Aplicacion.actualizarProductoRefrigerado(productoSeleccionado.getCodigo(), codigo, nombre,
                            valorUnitario, Integer.parseInt(cantidadExistente), Integer.parseInt(codigoAprobacion),
                            Float.parseFloat(temperaturaRefrigerado));

                if (bandera) {

                    tblProductos.refresh();
                    mostrarMensaje("Notificación Producto", "Producto Actualizado",
                            "El producto se ha actualizado con éxito.", AlertType.INFORMATION);

                } else {
                    mostrarMensaje("Notificación Producto", "Producto No Actualizado",
                            "El producto no se ha actualizado.", AlertType.ERROR);
                }

            } else {
                mostrarMensaje("Notificación cliente", "Cliente No Seleccionado", "El cliente no ha sido seleccionado.",
                        AlertType.ERROR);
            }
        }
    }
}
    public void eliminarProducto() {

        if (rdoProcesado.isSelected()) {

            boolean bandera = false;

            if (productoSeleccionado != null) {
                if (mostrarMensajeConfirmacion("¿Está seguro de eliminar el producto?") == true) {

                    bandera = Aplicacion.eliminarProductoProcesado(productoSeleccionado.getCodigo());
                    if (bandera) {
                        listaProductosData.remove(productoSeleccionado);
                        productoSeleccionado = null;
                        tblProductos.getSelectionModel().clearSelection();
                        mostrarMensaje("Notificación Producto", "Producto Eliminado",
                                "El Producto se ha eliminado con éxito.", AlertType.INFORMATION);
                    } else {
                        mostrarMensaje("Notificación Producto", "Producto No Eliminado",
                                "El Producto no se ha eliminado.", AlertType.ERROR);
                    }
                }
            } else {
                mostrarMensaje("Notificación Producto", "Producto No Seleccionado",
                        "El Producto no ha sido seleccionado.", AlertType.ERROR);
            }

        } else if (rdoEnvasado.isSelected()) {
            boolean bandera = false;

            if (productoSeleccionado != null) {
                if (mostrarMensajeConfirmacion("¿Está seguro de eliminar el Producto?") == true) {

                    bandera = Aplicacion.eliminarProductoEnvasado(productoSeleccionado.getCodigo());
                    if (bandera) {
                        listaProductosData.remove(productoSeleccionado);
                        productoSeleccionado = null;
                        tblProductos.getSelectionModel().clearSelection();
                        mostrarMensaje("Notificación Producto", "Cliente Producto",
                                "El Producto se ha eliminado con éxito.", AlertType.INFORMATION);
                    } else {
                        mostrarMensaje("Notificación Producto", "Cliente No Eliminado",
                                "El Producto no se ha eliminado.", AlertType.ERROR);
                    }
                }
            } else {
                mostrarMensaje("Notificación Producto", "Producto No Seleccionado",
                        "El Producto no ha sido seleccionado.", AlertType.ERROR);
            }

        } else if (rdoRefigerado.isSelected()) {
            boolean bandera = false;

            if (productoSeleccionado != null) {
                if (mostrarMensajeConfirmacion("¿Está seguro de eliminar el Producto?") == true) {

                    bandera = Aplicacion.eliminarProductoRefrigerado(productoSeleccionado.getCodigo());
                    if (bandera) {
                        listaProductosData.remove(productoSeleccionado);
                        productoSeleccionado = null;
                        tblProductos.getSelectionModel().clearSelection();
                        mostrarMensaje("Notificación Producto", "Cliente Producto",
                                "El Producto se ha eliminado con éxito.", AlertType.INFORMATION);
                    } else {
                        mostrarMensaje("Notificación Producto", "Cliente No Eliminado",
                                "El Producto no se ha eliminado.", AlertType.ERROR);
                    }
                }
            } else {
                mostrarMensaje("Notificación Producto", "Producto No Seleccionado",
                        "El Producto no ha sido seleccionado.", AlertType.ERROR);
            }
        }
    }
    public void limpiarCamposProductos() {
        txtCodigoProducto.setText("");
        txtNombreProducto.setText("");
        txtValorUnitarioProducto.setText("");
        txtDescripcionProducto.setText("");
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

    private void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

        Alert alert = new Alert(alertType);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();

    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmaci�n");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK) {
            return true;
        } else {
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

    @FXML
    public void guardarCliente(ActionEvent actionEvent) {
        agregarProducto();
    }

    @FXML
    public void limpiarProductos(ActionEvent actionEvent) {
        limpiarCamposProductos();
    }

    @FXML
    public void actualizarProductos(ActionEvent actionEvent) {
        actualizarProducto();
    }

    @FXML
    public void eliminarProducto(ActionEvent actionEvent) {
        eliminarProducto();
    }
}




