package ru.sngb.kote.service;

import java.io.Serializable;
import java.util.Collection;

/**
 * Generic service layer.
 * <p/>
 * User: Viacheslav
 * Date: 09.05.12
 *
 * @author Tsykin V.A. (aka nektoDev), ts.slawa@gmail.com
 * @version 0.1
 */
public interface GenericService<T, ID extends Serializable> {
    void save(T entity);

    void update(T entity);

    void delete(T entity);

    Collection<T> getAll();

    T getById(ID id);
}
