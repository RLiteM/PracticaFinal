/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;
import POJOs.Productos;
import POJOs.Categoria;
import POJOs.Provadores;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

/**
 *
 * @author IngeMayk
 */
public class CRUDsProductos {

    public static List<Productos> universoProd() {
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().getCurrentSession();
        List<Productos> lista = null;
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Productos.class);
           criteria.createAlias("categoria", "cat");
            criteria.createAlias("provadores", "prov");

            criteria.setProjection(Projections.projectionList()
                    .add(Projections.property("idProducto"))
                    .add(Projections.property("nombreProducto"))
                    .add(Projections.property("precio"))
                    .add(Projections.property("cat.nombreCategoria")) // segun el que queres traer
                    .add(Projections.property("prov.nombreProveedor")) //segun el que queres traer
            );
            criteria.addOrder(Order.desc("idProducto"));
            lista = criteria.list();

        } catch (Exception e) {
            System.out.println("error" + e);
        } finally {
            session.getTransaction().commit();

        }
        return lista;
    }

    public static boolean crear(String nombreProducto, Integer precio, Integer idCategoria, Integer idProveedores) {

        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        //Criteria criteria=session.createCriteria(Productos.class);
        // criteria.add(Restrictions.eq("estado", true));
        //        Productos insert = (Productos)criteria.uniqueResult();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            //if (insert==null) {
            Productos insert = new Productos();
            insert = new Productos();
            
            insert.setNombreProducto(nombreProducto);
            insert.setPrecio(precio);
            // aqui es donde relaciono categoria 
            Categoria categoria = new Categoria();
            categoria.setIdCategoria(idCategoria);
            insert.setCategoria(categoria);
            // aqui es donde relaciono provedores
            
            // aqui es donde relaciono la relacion 
            Provadores provadores = new Provadores();
            provadores.setIdProveedor(idProveedores);  // ESTO EST MUY IMPORANTE, 
            insert.setProvadores(provadores);
            
            
            session.save(insert);
            flag = true;

            //}
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return flag;
    }

}
