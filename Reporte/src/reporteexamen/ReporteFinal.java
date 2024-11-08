/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporteexamen;
import Reportes.ReporteProducto;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author vicen
 */
public class ReporteFinal {
        public static List ReporteProducto() throws ParseException {
        List<ReporteProducto> list = new ArrayList<ReporteProducto>();
        for (Iterator it = CRUDs.CRUDsProductos.universoProd().iterator(); it.hasNext();) {
            Object[] item = (Object[]) it.next();
            list.add(new ReporteProducto((String) item[0], (Integer) item[1], (String) item[2], (String) item[3]));
            factory comp = new factory();
            comp.setReporteproducto((ArrayList<ReporteProducto>) list);
        }
        return list;
    }
    
}
