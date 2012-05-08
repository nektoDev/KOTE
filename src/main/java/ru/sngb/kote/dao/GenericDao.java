package ru.sngb.kote.dao;

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
public interface GenericDao<T, ID extends Serializable> {
    void save(T entity);

    void update(T entity);

    void delete(T entity);

    Collection<T> getAll(Class clazz);

    T getById(Class clazz, ID id);
}
