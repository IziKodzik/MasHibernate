import com.sun.org.apache.xpath.internal.operations.Or;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            for (int i = 0; i < 3; i++) {

                Laboratory lab = new Laboratory();
                session.save(lab);
                Storage storage = new Storage(lab);
                session.save(storage);

            }
            List<Laboratory> labs = session.createQuery("from Laboratory").list();
            System.out.println(labs);

            List<Storage> storages = session.createQuery("from Storage").list();
            System.out.println(storages);

            Salesman salesman = new Salesman("jan","dan", LocalDate.now(), 30d);
            Programmer programmer = new Programmer("jan","dan", LocalDate.now(), Programmer.ProgrammingLanguage.CPLUSPLUS);
            session.save(salesman);
            session.save(programmer);

            List<Employee> employees = session.createQuery("from Employee").list();
            employees.forEach(System.out::println);

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }

    }
}
