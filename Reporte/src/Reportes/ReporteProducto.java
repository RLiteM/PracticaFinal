/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

/**
 *
 * @author vicen
 */
public class ReporteProducto {

    private String nombreProducto;
    private Integer precio;
    private String categoria;
    private String provadores;

    public ReporteProducto(String nombreProducto, Integer precio, String categoria, String provadores) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.categoria = categoria;
        this.provadores = provadores;
    }
    

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the precio
     */
    public Integer getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the provadores
     */
    public String getProvadores() {
        return provadores;
    }

    /**
     * @param provadores the provadores to set
     */
    public void setProvadores(String provadores) {
        this.provadores = provadores;
    }

    
}
