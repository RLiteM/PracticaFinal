/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;

import POJOs.Provadores;
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
public class CRUDsProveedor {
// conjot para mostrar en la tabla

    public static List<Provadores> universo() {
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().getCurrentSession();
        List<Provadores> lista = null;
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Provadores.class);
            criteria.setProjection(Projections.projectionList()
                    .add(Projections.property("idProveedor"))
                    .add(Projections.property("nombreProveedor"))
                    .add(Projections.property("direccion"))
                    .add(Projections.property("telefono"))
            );
            criteria.addOrder(Order.desc("idProveedor"));
            lista = criteria.list();

        } catch (Exception e) {
            System.out.println("error" + e);
        } finally {
            session.getTransaction().commit();

        }
        return lista;
    }

    public static boolean crear(String nombreProveedor, String direccion, String telefono) {

        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        //   Criteria criteria = session.createCriteria(Provadores.class); Si no hay estado
        // Provadores insert = (Provadores) criteria.uniqueResult(); Si no hay estado
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // if (insert == null) {

            Provadores insert = new Provadores(); // si no hay if y estado se usa este

            insert = new Provadores();
            insert.setNombreProveedor(nombreProveedor);
            insert.setDireccion(direccion);
            insert.setTelefono(telefono);
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

    public static boolean actualizar(Integer idProvadores, String nombreProveedor, String direccion, String telefono) {
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Provadores.class);
        criteria.add(Restrictions.eq("idProveedor", idProvadores)); // Corregir a "idProvadores"
        Provadores insert = (Provadores) criteria.uniqueResult(); // Obtener la persona existente
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            if (insert != null) { // Si la persona existe
                insert.setNombreProveedor(nombreProveedor);   // Actualiza los campos
                insert.setDireccion(direccion);
                insert.setTelefono(telefono);
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
