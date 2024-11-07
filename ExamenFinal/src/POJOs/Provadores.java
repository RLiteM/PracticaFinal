package POJOs;
// Generated 7/11/2024 03:15:55 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Provadores generated by hbm2java
 */
public class Provadores  implements java.io.Serializable {


     private Integer idProveedor;
     private String nombreProveedor;
     private String direccion;
     private String telefono;
     private Set<Productos> productoses = new HashSet<Productos>(0);

    public Provadores() {
    }

    public Provadores(String nombreProveedor, String direccion, String telefono, Set<Productos> productoses) {
       this.nombreProveedor = nombreProveedor;
       this.direccion = direccion;
       this.telefono = telefono;
       this.productoses = productoses;
    }
   
    public Integer getIdProveedor() {
        return this.idProveedor;
    }
    
    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
    public String getNombreProveedor() {
        return this.nombreProveedor;
    }
    
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Set<Productos> getProductoses() {
        return this.productoses;
    }
    
    public void setProductoses(Set<Productos> productoses) {
        this.productoses = productoses;
    }




}


