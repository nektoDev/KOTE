package ru.sngb.kote.dao;

import ru.sngb.kote.domain.User;

import java.util.Collection;

/**
 * User Dao Interface.
 * <p/>
 * User: Viacheslav
 * Date: 08.05.12
 *
 * @author Tsykin V.A. (aka nektoDev), ts.slawa@gmail.com
 * @version 0.1
 */
public interface UserDao extends GenericDao<User, String> {
    Collection<User> getUsersByDepartment(String department);
}
