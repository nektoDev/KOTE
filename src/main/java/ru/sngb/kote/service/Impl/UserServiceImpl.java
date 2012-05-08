package ru.sngb.kote.service.Impl;

import org.hibernate.Session;
import ru.sngb.kote.dao.Impl.UserDaoImpl;
import ru.sngb.kote.dao.UserDao;
import ru.sngb.kote.domain.User;
import ru.sngb.kote.service.UserService;
import ru.sngb.kote.util.HibernateUtil;

/**
 * Some class.
 * <p/>
 * User: Viacheslav
 * Date: 09.05.12
 *
 * @author Tsykin V.A. (aka nektoDev), ts.slawa@gmail.com
 * @version 0.1
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void addUser(User user) {
        System.out.println("Start session");
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        try {
            System.out.println("begin transaction");
            hibernateSession.getTransaction().begin();
            System.out.println("saving");
            userDao.save(user);
            System.out.println("commiting");
            hibernateSession.getTransaction().commit();
            System.out.println("Done");
            hibernateSession.flush();
        } catch (Exception ex) {
            System.out.println("Can't add user");
            ex.printStackTrace();

            hibernateSession.getTransaction().rollback();
        }
    }

    @Override
    public void deleteUser(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void getAllUsers() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateUser(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void getUserById() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void getUsersByDepartment() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void autorization() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
