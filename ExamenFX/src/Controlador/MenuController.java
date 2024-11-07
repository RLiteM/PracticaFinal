/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author IngeMayk
 */
public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnProveedor(ActionEvent event) {
// esto sirve para conectar ventanas
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/MenuProveedor.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Menu Proveedor");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuProveedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // asta aqui termina, 
    }

    @FXML
    private void btnProducto(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/MenuProducto.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Menu Producto");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnCategoria(ActionEvent event) {
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/MenuCategoria.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Menu Categoria");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuCategoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
