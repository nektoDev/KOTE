import org.hibernate.Session;
import ru.sngb.kote.domain.Filial;
import ru.sngb.kote.domain.Person;
import ru.sngb.kote.domain.Rights;
import ru.sngb.kote.domain.User;
import ru.sngb.kote.gui.Test;
import ru.sngb.kote.service.Impl.UserServiceImpl;

import javax.swing.*;

/**
 * MainForm class for testing hibernate.
 * <p/>
 * Date: 07.05.12
 *
 * @author Tsykin V.A. (aka nektoDev), ts.slawa@gmail.com
 * @version 0.1
 */
public class Main {

    public static void main(final String[] args) throws Exception {
        Session session = null;
        try {
            User user2 = new User("admin2", "admin2", "12", "12", new Person("12", "12", "12"), new Filial("11112"), new Rights("21", "21", "21", "21"));
            UserServiceImpl userService = new UserServiceImpl();
            System.out.println("Saving user1 and user2");
            userService.addUser(user2);

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (Exception ex) {
                        ex.printStackTrace();// ignore
                    }

                    JFrame test = new Test();

                    // show dialog
                    test.setVisible(true);
                }
            });

            /*Person person = new Person("tsykin", "viacheslav", "alekseevich");
            PersonServiceImpl personService = new PersonServiceImpl();
            personService.save(person);
            System.out.println(personService.getAll());
            person.setPhone("237582");
            personService.update(person);
            System.out.println(personService.getById(1));


            Filial surgut = new Filial("Surgut");*/

            /*System.out.println("querying all the managed entities...");
            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
            for (Object key : metadataMap.keySet()) {
                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
                final String entityName = classMetadata.getEntityName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }*/
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
