package flight.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import flight.hibernate.HibernateUtil;

public class HibernateTemplate {
    private SessionFactory sessionFactory = null;
    
    public HibernateTemplate() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    public Serializable save(Object entity) {
        Serializable id = null;
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            id = session.save(entity);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return id;
    }
    
    public Object update(Object entity) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return entity;
    }
    
    public Object findById(Serializable id, Class<?> clas) {
        Session session = sessionFactory.openSession();
        return session.get(clas, id);
    }
    
    public void delete(Serializable id, Class<?> clas ) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {              
            transaction = session.beginTransaction();
            Object data = findById(id, clas); 
            session.delete(data);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public List<?> findAll(Class<?> clas) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery( "from " + clas.getName());       
        return query.list();
    }
}