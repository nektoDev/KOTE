import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;

import java.util.Map;

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
            session = ru.sngb.kote.util.HibernateUtil.getSessionFactory().openSession();
            System.out.println("querying all the managed entities...");
            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
            for (Object key : metadataMap.keySet()) {
                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
                final String entityName = classMetadata.getEntityName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }
}
