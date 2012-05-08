package ru.sngb.kote.dao.Impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import ru.sngb.kote.dao.GenericDao;
import ru.sngb.kote.util.HibernateUtil;

import java.io.Serializable;
import java.util.Collection;

/**
 * Some class.
 * <p/>
 * User: Viacheslav
 * Date: 08.05.12
 *
 * @author Tsykin V.A. (aka nektoDev), ts.slawa@gmail.com
 * @version 0.1
 */
public class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {

    protected Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void save(T entity) {
        System.out.println("Open session");
        Session hibernateSession = this.getSession();
        System.out.println("saving");
        hibernateSession.saveOrUpdate(entity);
    }

    @Override
    public void update(T entity) {
        Session hibernateSession = this.getSession();
        hibernateSession.merge(entity);
    }

    @Override
    public void delete(T entity) {
        Session hibernateSession = this.getSession();
        hibernateSession.delete(entity);
    }

    @Override
    public Collection<T> getAll(Class clazz) {
        Session hibernateSession = this.getSession();
        Collection<T> T = null;
        Criteria criteria = hibernateSession.createCriteria(clazz);
        T = criteria.list();
        return T;
    }

    @Override
    public T getById(Class clazz, ID id) {
        Session hibernateSession = this.getSession();
        T t = null;
        t = (T) hibernateSession.get(clazz, id);
        return t;
    }
}
