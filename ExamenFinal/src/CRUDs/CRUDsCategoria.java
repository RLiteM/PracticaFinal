/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;

import POJOs.Categoria;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author IngeMayk
 */
public class CRUDsCategoria {
// conjot para mostrar en la tabla

    public static List<Categoria> universoCat() {
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().getCurrentSession();
        List<Categoria> lista = null;
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Categoria.class);
            criteria.setProjection(Projections.projectionList()
                    .add(Projections.property("idCategoria"))
                    .add(Projections.property("descripcion"))
            );
            criteria.addOrder(Order.desc("idCategoria"));
            lista = criteria.list();

        } catch (Exception e) {
            System.out.println("error" + e);
        } finally {
            session.getTransaction().commit();

        }
        return lista;
    }

    public static boolean crear(String descripcion) {

        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        //   Criteria criteria = session.createCriteria(Categoria.class); Si no hay estado
        // Categoria insert = (Categoria) criteria.uniqueResult(); Si no hay estado
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // if (insert == null) {

            Categoria insert = new Categoria(); // si no hay if y estado se usa este

            insert = new Categoria();
            insert.setDescripcion(descripcion);
            session.save(insert);
            flag = true;
            //} es el if si no hay estado

            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return flag;
    }

    public static boolean actualizar(Integer idCategoria, String descripcion) {
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Categoria.class);
        criteria.add(Restrictions.eq("idCategoria", idCategoria)); // Corregir a "idCategoria"
        Categoria insert = (Categoria) criteria.uniqueResult(); // Obtener la persona existente
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            if (insert != null) { // Si la persona existe
                insert.setDescripcion(descripcion);   // Actualiza los campos
                session.update(insert);     // Guarda los cambios en la base de datos
                flag = true;                // Actualización exitosa
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return flag;
    }

}
