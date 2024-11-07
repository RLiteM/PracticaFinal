/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.TablaProducto;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
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
public class MenuProductoController implements Initializable {

    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TableView<TablaProducto> tblProducto;
    private ObservableList<TablaProducto> listaProducto;
    @FXML
    private TableColumn<?, ?> colIdProducto;
    @FXML
    private TableColumn<?, ?> colPrecio;
    @FXML
    private TableColumn<?, ?> colCategoria;
    @FXML
    private TableColumn<?, ?> colProveedor;
    @FXML
    private ComboBox<?> txtCategoria;
    @FXML
    private ComboBox<?> txtProveedor;
    private Integer idProductoV;
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
     /*   try {
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

        }*/

    }

    @FXML
    private void btnActualizar(ActionEvent event) {
  /*      try {
            String descripcion;
            descripcion = txtDescripcion.getText();
            if (CRUDs.CRUDsCategoria.actualizar(idProductoV, descripcion)) {
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

        }*/
    }

    public void mostrar() {
        listaProducto = FXCollections.observableArrayList();
        for (Iterator it = CRUDs.CRUDsProductos.universoProd().iterator(); it.hasNext();) {
            Object[] item = (Object[]) it.next();
            listaProducto.add(new TablaProducto(
                    (Integer) item[0], // idProducto
                    (String) item[3], // categoria
                    (String) item[4], // provadores
                    (String) item[1], // descripcion
                    (Integer) item[2] // precio
            ));
        }
        this.colIdProducto.setCellValueFactory(new PropertyValueFactory("idProducto"));
        this.colDescripcion.setCellValueFactory(new PropertyValueFactory("nombreProducto"));
        this.colPrecio.setCellValueFactory(new PropertyValueFactory("precio"));
        this.colCategoria.setCellValueFactory(new PropertyValueFactory("categoria"));
        this.colProveedor.setCellValueFactory(new PropertyValueFactory("provadores"));
        tblProducto.setItems(listaProducto);
    }

    public void limpiar() {
        txtDescripcion.setText("");

    }

    @FXML
    private void seleccionarMoficar(MouseEvent event) {
        //TablaProducto c = this.tblCategoria.getSelectionModel().getSelectedItem();
        //txtDescripcion.setText(c.getDescripcion());
        //idProductoV = c.getIdCategoria();
    }

    @FXML
    private void chCatategoria(ActionEvent event) {
    }

    @FXML
    private void chProveedor(ActionEvent event) {
    }
    
    

}
