package ru.sngb.kote.dao.Impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ru.sngb.kote.dao.UserDao;
import ru.sngb.kote.domain.User;

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
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {
    @Override
    public Collection<User> getUsersByDepartment(String department) {
        Session hibernateSession = this.getSession();
        Collection<User> userCollection = null;
        Criteria criteria = hibernateSession.createCriteria(User.class)
                .add(Restrictions.eq("k10_department", department));
        userCollection = (Collection<User>) criteria.list();
        return userCollection;
    }
}

