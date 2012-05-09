package ru.sngb.kote.service.Impl;

import org.hibernate.Session;
import ru.sngb.kote.dao.Impl.FilialDaoImpl;
import ru.sngb.kote.domain.Filial;
import ru.sngb.kote.service.FilialService;
import ru.sngb.kote.util.HibernateUtil;

import java.util.Collection;

/**
 * Filial service layer class.
 * <p/>
 * User: Viacheslav
 * Date: 09.05.12
 *
 * @author Tsykin V.A. (aka nektoDev), ts.slawa@gmail.com
 * @version 0.1
 */
public class FilialServiceImpl implements FilialService {
    private FilialDaoImpl filialDao = new FilialDaoImpl();

    @Override
    public void addFilial(Filial filial) {
        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            hibernateSession.beginTransaction();
            filialDao.save(filial);
            hibernateSession.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Can't add filial");
            ex.printStackTrace();
            hibernateSession.getTransaction().rollback();
        }
    }

    @Override
    public void deleteFilial(Filial filial) {
        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            hibernateSession.beginTransaction();
            filialDao.delete(filial);
            hibernateSession.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Can't delete filial");
            ex.printStackTrace();
            hibernateSession.getTransaction().rollback();
        }
    }

    @Override
    public void updateFilial(Filial filial) {
        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            hibernateSession.beginTransaction();
            filialDao.update(filial);
            hibernateSession.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Can't update filial");
            ex.printStackTrace();
            hibernateSession.getTransaction().rollback();
        }
    }

    @Override
    public Collection<Filial> getAllFilials() {
        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            hibernateSession.beginTransaction();
            Collection<Filial> filials = filialDao.getAll(Filial.class);
            hibernateSession.getTransaction().commit();
            return filials;
        } catch (Exception ex) {
            System.out.println("Can't getting all filials");
            ex.printStackTrace();
            hibernateSession.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public Filial getFilialById(Integer id) {
        Session hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            hibernateSession.beginTransaction();
            Filial filial = filialDao.getById(Filial.class, id);
            hibernateSession.getTransaction().commit();
            return filial;
        } catch (Exception ex) {
            System.out.println("Can't getting filial" + id);
            ex.printStackTrace();
            hibernateSession.getTransaction().rollback();
            return null;
        }
    }
}
