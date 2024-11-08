/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import CRUDs.CRUDsProveedor;
import Modelo.TablaProveedor;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author IngeMayk
 */
public class MenuProveedorController implements Initializable {

    @FXML
    private TextField txtNombreProv;
    @FXML
    private TextField txtDireccionProv;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TableView<TablaProveedor> tblProveedor;
    private ObservableList<TablaProveedor> listaProveedor;
    @FXML
    private TableColumn<?, ?> colidProveedor;
    @FXML
    private TableColumn<?, ?> colNombreProv;
    @FXML
    private TableColumn<?, ?> colDireccionProv;
    @FXML
    private TableColumn<?, ?> colTelefonoProv;
    private Integer idProveedorV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrar();
    }    

    @FXML
    private void btnGuardar(ActionEvent event) {
        try {
            String nombreProveedor = txtNombreProv.getText();
            String direccion = txtDireccionProv.getText();
            String telefono = txtTelefono.getText();
            if (CRUDsProveedor.crear(nombreProveedor, direccion, telefono)) {
                mostrar();
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Información");
                alerta.setHeaderText(null);
                alerta.setContentText("Operación Exitosa");
                alerta.showAndWait();
                limpiar();
            } else {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Información IMPORTANTE");
                alerta.setHeaderText(null);
                alerta.setContentText("Error en la operación.");
                alerta.showAndWait();
            }
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Información Importante");
            alerta.setHeaderText(null);
            alerta.setContentText("Error en: " + e);
            alerta.showAndWait();
        }
    }

    @FXML
    private void btnActualizar(ActionEvent event) {
        try {
            String nombreProveedor = txtNombreProv.getText();
            String direccion = txtDireccionProv.getText();
            String telefono = txtTelefono.getText();
            if (CRUDsProveedor.actualizar(idProveedorV, nombreProveedor, direccion, telefono)) {
                mostrar();
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Información");
                alerta.setHeaderText(null);
                alerta.setContentText("Operación Exitosa");
                alerta.showAndWait();
                limpiar();
            } else {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Información IMPORTANTE");
                alerta.setHeaderText(null);
                alerta.setContentText("Error en la operación.");
                alerta.showAndWait();
            }
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Información Importante");
            alerta.setHeaderText(null);
            alerta.setContentText("Error en: " + e);
            alerta.showAndWait();
        }
    }

    public void mostrar() {
        listaProveedor = FXCollections.observableArrayList();
        for (Iterator it = CRUDsProveedor.universo().iterator(); it.hasNext();) {
            Object[] item = (Object[]) it.next();
            listaProveedor.add(new TablaProveedor((Integer) item[0], (String) item[1], (String) item[2], (String) item[3]));
        }
        this.colidProveedor.setCellValueFactory(new PropertyValueFactory("idProveedor"));
        this.colNombreProv.setCellValueFactory(new PropertyValueFactory("nombreProveedor"));
        this.colDireccionProv.setCellValueFactory(new PropertyValueFactory("direccion"));
        this.colTelefonoProv.setCellValueFactory(new PropertyValueFactory("telefono"));
        tblProveedor.setItems(listaProveedor);
    }

    public void limpiar() {
        txtNombreProv.setText("");
        txtDireccionProv.setText("");
        txtTelefono.setText("");
    }

    @FXML
    private void selecionarModificar(MouseEvent event) {
        TablaProveedor p = this.tblProveedor.getSelectionModel().getSelectedItem();
        txtNombreProv.setText(p.getNombreProveedor());
        txtDireccionProv.setText(p.getDireccion());
        txtTelefono.setText(p.getTelefono());
        idProveedorV = p.getIdProveedor();
    }
}
