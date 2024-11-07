/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author wissegt
 */
public class TablaProducto {

     private Integer idProducto;
     private String categoria;
     private String provadores;
     private String nombreProducto;
     private Integer precio;

    public TablaProducto(Integer idProducto, String categoria, String provadores, String nombreProducto, Integer precio) {
        this.idProducto = idProducto;
        this.categoria = categoria;
        this.provadores = provadores;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
    }

    /**
     * @return the idProducto
     */
    public Integer getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
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
     


}
