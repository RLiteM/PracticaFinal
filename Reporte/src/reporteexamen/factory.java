/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporteexamen;
import Reportes.ReporteProducto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vicen
 */
public class factory {
    //cada uno tendra su get y set y reporte 
    private static ArrayList<ReporteProducto> reporteproducto = new ArrayList<ReporteProducto>();
 
    public static List reporteProducto() {
        return getReporteproducto();
    }
    /**
     * @return the reporteproducto
     *///////////////////////////////////////la de abajo copie/////////////
    public static ArrayList<ReporteProducto> getReporteproducto() {
        return reporteproducto;
    }

    /**
     * @param aReporteproducto the reporteproducto to set
     */
    public static void setReporteproducto(ArrayList<ReporteProducto> aReporteproducto) {
        reporteproducto = aReporteproducto;
    }

    

 
    
}
