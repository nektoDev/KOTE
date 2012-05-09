package ru.sngb.kote.service.Impl;

import org.hibernate.Session;
import ru.sngb.kote.dao.Impl.UserDaoImpl;
import ru.sngb.kote.dao.UserDao;
import ru.sngb.kote.domain.User;
import ru.sngb.kote.service.UserService;
import ru.sngb.kote.util.HibernateUtil;

import java.util.Collection;

import static ru.sngb.kote.util.Security.takeMd5;

/**
 * User service-layer class.
 * <p/>
 * User: Viacheslav
 * Date: 09.05.12
 *
 * @author Tsykin V.A. (aka nektoDev), ts.slawa@gmail.com
 * @version 0.2
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void addUser(User user) {
        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            hibernateSession.beginTransaction();
            userDao.save(user);
            hibernateSession.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Can't add user");
            ex.printStackTrace();
            hibernateSession.getTransaction().rollback();
        }
    }

    @Override
    public void deleteUser(User user) {
        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            hibernateSession.beginTransaction();
            userDao.delete(user);
            hibernateSession.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Can't delete user");
            ex.printStackTrace();
            hibernateSession.getTransaction().rollback();
        }
    }

    @Override
    public Collection<User> getAllUsers() {
        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            hibernateSession.beginTransaction();
            Collection<User> users = userDao.getAll(User.class);
            hibernateSession.getTransaction().commit();
            return users;
        } catch (Exception ex) {
            System.out.println("Can't getting all users");
            ex.printStackTrace();
            hibernateSession.getTransaction().rollback();
            return null;
        }

    }

    @Override
    public void updateUser(User user) {
        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            hibernateSession.beginTransaction();
            userDao.update(user);
            hibernateSession.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Can't getting all users");
            ex.printStackTrace();
            hibernateSession.getTransaction().rollback();
        }
    }

    @Override
    public User getUserById(String id) {
        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            hibernateSession.beginTransaction();
            User user = userDao.getById(User.class, id);
            hibernateSession.getTransaction().commit();
            return user;
        } catch (Exception ex) {
            System.out.println("Can't getting user with id=" + id);
            ex.printStackTrace();
            hibernateSession.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public Collection<User> getUsersByDepartment(String department) {
        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            hibernateSession.beginTransaction();
            Collection<User> usersByDepartment = userDao.getUsersByDepartment(department);
            hibernateSession.getTransaction().commit();
            return usersByDepartment;
        } catch (Exception ex) {
            System.out.println("Can't getting all users from " + department);
            ex.printStackTrace();
            hibernateSession.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public boolean autorization(String login, String password) {
        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
        User user = null;
        try {
            hibernateSession.beginTransaction();
            user = userDao.getById(User.class, login);
            hibernateSession.getTransaction().commit();
            if (user != null) {
                return user.getPassword().equals(takeMd5(password));
            } else return false;
        } catch (Exception ex) {
            System.out.println("Can't authorize you");
            ex.printStackTrace();
            hibernateSession.getTransaction().rollback();
            return false;
        }
    }
}
