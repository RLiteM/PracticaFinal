/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportespractica;

import Reportes.ReporteProducto;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author vicen
 */
public class ReportesPractica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
   public static List ReporteProducto() throws ParseException {
        List<ReporteProducto> list = new ArrayList<ReporteProducto>();
        for (Iterator it = CRUDs.CRUDsProductos.universoProd().iterator(); it.hasNext();) {
            Object[] item = (Object[]) it.next();
            list.add(new ReporteProducto((Integer) item[0],(String) item[1], (Integer) item[2], (String) item[3], (String) item[4]));
            factory comp = new factory();
            comp.setReporteproducto((ArrayList<ReporteProducto>) list);
        }
        return list;
    }
    
}
