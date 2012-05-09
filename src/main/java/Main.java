import org.hibernate.Session;
import ru.sngb.kote.domain.Filial;
import ru.sngb.kote.domain.Person;
import ru.sngb.kote.domain.Rights;
import ru.sngb.kote.domain.User;
import ru.sngb.kote.service.Impl.UserServiceImpl;

/**
 * Main class for testing hibernate.
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
            Filial filial = new Filial("1");
            User user1 = new User("admin", "admin", "1", "1", new Person("1", "1", "1"), filial, new Rights("1", "1", "1", "1"));
            User user2 = new User("admin2", "admin2", "12", "12", new Person("12", "12", "12"), new Filial("11112"), new Rights("21", "21", "21", "21"));
            UserServiceImpl userService = new UserServiceImpl();
            System.out.println("Saving user1 and user2");
            userService.addUser(user1);
            userService.addUser(user2);
            System.out.println("Deleting second");
            userService.deleteUser(user2);
            System.out.println("showing all users");
            System.out.println(userService.getAllUsers());
            System.out.println("Auth true " + userService.autorization("admin2", "admin2"));
            System.out.println("Auth false " + userService.autorization("admin", "hui"));
            System.out.println("Auth false " + userService.autorization("admin1", "hui"));
            System.out.println("get by id 1" + userService.getUserById("admin"));
            System.out.println("updating 1");
            user1.setDepartment("12");
            userService.updateUser(user1);
            System.out.println("getting by department" + userService.getUsersByDepartment("12"));


            Filial surgut = new Filial("Surgut");

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
