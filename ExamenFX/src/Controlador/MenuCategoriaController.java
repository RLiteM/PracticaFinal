/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.TablaCategoria;
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

/**
 * FXML Controller class
 *
 * @author IngeMayk
 */
public class MenuCategoriaController implements Initializable {

    @FXML
    private TextField txtDescripcion;
    @FXML
    private TableView<TablaCategoria> tblCategoria;
    private ObservableList<TablaCategoria> listaCategoria;
    @FXML
    private TableColumn<?, ?> colCategoria;
    @FXML
    private TableColumn<?, ?> colDescripcion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrar();
    }

    @FXML
    private void btnGuardar(ActionEvent event) {
        try {
            String descripcion;
            descripcion = txtDescripcion.getText();
            if (CRUDs.CRUDsCategoria.crear(descripcion)) {
                mostrar();
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Informacion");
                alerta.setHeaderText(null);
                alerta.setContentText("Operacion Exitosa");
                alerta.showAndWait();
                limpiar();
            } else {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Informacion IMPORTANTE");
                alerta.setHeaderText(null);
                alerta.setContentText("No eres un papulince :'v");
                alerta.showAndWait();
            }
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Informacion Importante");
            alerta.setHeaderText(null);
            alerta.setContentText("Error en: " + e);
            alerta.showAndWait();

        }
    }

    @FXML
    private void btnActualizar(ActionEvent event) {
    }

    public void mostrar() {
        listaCategoria = FXCollections.observableArrayList();
        for (Iterator it = CRUDs.CRUDsCategoria.universoCat().iterator(); it.hasNext();) {
            Object[] item = (Object[]) it.next();
            listaCategoria.add(new TablaCategoria((Integer) item[0], (String) item[1]));

        }
        this.colCategoria.setCellValueFactory(new PropertyValueFactory("idCategoria"));
        this.colDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        tblCategoria.setItems(listaCategoria);
    }

    public void limpiar() {
        txtDescripcion.setText("");

    }

}
