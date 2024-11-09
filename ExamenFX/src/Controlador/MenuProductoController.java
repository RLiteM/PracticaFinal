/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.TablaProducto;
import java.net.URL;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import reportespractica.factory;

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
    private ChoiceBox<String> txtProveedor;
    private Integer idProductoV;
    @FXML
    private TableColumn<?, ?> colDescripcion;
    @FXML
    private ChoiceBox<String> txtCatategoria;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrar();
        cargarCateogira();
        cargarProveedor();
        
    }
    private Map<String, Integer> categoriaMap = new HashMap<>();
private Map<String, Integer> proveedorMap = new HashMap<>();

private void cargarCateogira() {
    List<Object[]> listaCategoria = (List<Object[]>) (List<?>) CRUDs.CRUDsCategoria.universoCat();
    ObservableList<String> categorias = FXCollections.observableArrayList();
    categorias.add("Opciones");
    categoriaMap.put("Opciones", -1); // Para la opción predeterminada

    for (Object[] categoria : listaCategoria) {
        Integer idCategoria = (Integer) categoria[0];
        String nombreCategoria = (String) categoria[1];
        categorias.add(nombreCategoria);
        categoriaMap.put(nombreCategoria, idCategoria); // Agregamos al Map
    }

    txtCatategoria.setItems(categorias);
    txtCatategoria.setValue("Opciones");
}

private void cargarProveedor() {
    List<Object[]> listaProveedor = (List<Object[]>) (List<?>) CRUDs.CRUDsProveedor.universo();
    ObservableList<String> proveedores = FXCollections.observableArrayList();
    proveedores.add("Opciones");
    proveedorMap.put("Opciones", -1); // Para la opción predeterminada

    for (Object[] proveedor : listaProveedor) {
        Integer idProveedor = (Integer) proveedor[0];
        String nombreProveedor = (String) proveedor[1];
        proveedores.add(nombreProveedor);
        proveedorMap.put(nombreProveedor, idProveedor); // Agregamos al Map
    }

    txtProveedor.setItems(proveedores);
    txtProveedor.setValue("Opciones");
}






@FXML
private void btnGuardar(ActionEvent event) {
    try {
        String nombreProducto = txtDescripcion.getText();
        Integer precio = Integer.parseInt(txtPrecio.getText());
        String categoriaSeleccionada = txtCatategoria.getValue();
        String proveedorSeleccionado = txtProveedor.getValue();
        
        // Obtener IDs de los mapas
        int idCategoria = categoriaMap.getOrDefault(categoriaSeleccionada, -1);
        int idProveedor = proveedorMap.getOrDefault(proveedorSeleccionado, -1);

        if (idCategoria != -1 && idProveedor != -1 && CRUDs.CRUDsProductos.crear(nombreProducto, precio, idCategoria, idProveedor)) {
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
        String nombreProducto = txtDescripcion.getText();
        Integer precio = Integer.parseInt(txtPrecio.getText());
        String categoriaSeleccionada = txtCatategoria.getValue();
        String proveedorSeleccionado = txtProveedor.getValue();
        
        // Obtener IDs de los mapas
        int idCategoria = categoriaMap.getOrDefault(categoriaSeleccionada, -1);
        int idProveedor = proveedorMap.getOrDefault(proveedorSeleccionado, -1);

        if (idCategoria != -1 && idProveedor != -1 && CRUDs.CRUDsProductos.Actualiar(idProductoV, nombreProducto, precio, idCategoria, idProveedor)) {
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
            alerta.setContentText("Error en la operación de actualización.");
            alerta.showAndWait();
        }
    } catch (Exception e) {
        // Verificar y mostrar la excepción en la consola
        System.out.println("Entrando en el bloque catch.");
        e.printStackTrace(); // Imprime la traza completa
        System.out.println("Error: " + e.getMessage()); // Mensaje adicional de error

        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Información Importante");
        alerta.setHeaderText(null);
        alerta.setContentText("Error en: " + e.getMessage());
        alerta.showAndWait();
    }
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
        txtPrecio.setText("");

    }

    @FXML
    private void seleccionarMoficar(MouseEvent event) {
        TablaProducto p = this.tblProducto.getSelectionModel().getSelectedItem();
        txtDescripcion.setText(p.getNombreProducto());
        txtPrecio.setText(p.getPrecio()+"");
        idProductoV = p.getIdProducto();
    }
    
    @FXML
       public void reporteProducto() throws ParseException, JRException {
        try {
            List lista = null;
            reportespractica.ReportesPractica.ReporteProducto();
            lista = (factory.reporteProducto());
            if (!lista.isEmpty()) {
                JasperReport jasperReport = JasperCompileManager.compileReport("src/Report/reporteProducto.jrxml");

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(lista));
                JasperViewer viewer = new JasperViewer(jasperPrint, false);
                viewer.setVisible(true);

            } else {
                System.out.println("No existe información en estas fechas");
            }
        } catch (JRException e) {
            System.out.println("Error al cargar el reporte: " + e);
        }
    }

    
    

}
