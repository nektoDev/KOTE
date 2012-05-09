package ru.sngb.kote.service.Impl;

import org.hibernate.Session;
import ru.sngb.kote.dao.Impl.GenericDaoImpl;
import ru.sngb.kote.service.GenericService;
import ru.sngb.kote.util.HibernateUtil;
import ru.sngb.kote.util.ReflectionUtils;

import java.io.Serializable;
import java.util.Collection;

/**
 * GEneric service layer interface implementation
 * <p/>
 * User: Viacheslav
 * Date: 09.05.12
 *
 * @author Tsykin V.A. (aka nektoDev), ts.slawa@gmail.com
 * @version 0.1
 */
public class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {
    private GenericDaoImpl<T, ID> genericDao = new GenericDaoImpl<T, ID>();

    protected Class getEntityClass() {
        return ReflectionUtils.getGenericParameterClass(this.getClass(), GenericServiceImpl.class, 0);
    }

    @Override
    public void save(T entity) {
        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            hibernateSession.beginTransaction();
            genericDao.save(entity);
            hibernateSession.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Can't add " + entity.getClass());
            ex.printStackTrace();
            hibernateSession.getTransaction().rollback();
        }
    }

    @Override
    public void update(T entity) {
        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            hibernateSession.beginTransaction();
            genericDao.update(entity);
            hibernateSession.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Can't update" + entity.getClass());
            ex.printStackTrace();
            hibernateSession.getTransaction().rollback();
        }
    }

    @Override
    public void delete(T entity) {
        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            hibernateSession.beginTransaction();
            genericDao.delete(entity);
            hibernateSession.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Can't delete" + entity.getClass());
            ex.printStackTrace();
            hibernateSession.getTransaction().rollback();
        }
    }

    @Override
    public Collection<T> getAll() {
        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            hibernateSession.beginTransaction();
            Collection<T> entities;
            entities = genericDao.getAll(getEntityClass());
            hibernateSession.getTransaction().commit();
            return entities;
        } catch (Exception ex) {
            System.out.println("Can't getting all " + getEntityClass());
            ex.printStackTrace();
            hibernateSession.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public T getById(ID id) {
        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            hibernateSession.beginTransaction();
            T t = genericDao.getById(getEntityClass(), id);
            hibernateSession.getTransaction().commit();
            return t;
        } catch (Exception ex) {
            System.out.println("Can't getting " + getEntityClass() + " with id=" + id);
            ex.printStackTrace();
            hibernateSession.getTransaction().rollback();
            return null;
        }
    }
}
