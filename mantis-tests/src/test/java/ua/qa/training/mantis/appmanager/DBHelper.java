package ua.qa.training.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ua.qa.training.mantis.model.Users;
import ua.qa.training.mantis.tests.TestBase;


import java.util.List;

/**
 * Created by osoboleva on 11/6/2016.
 */

public class DBHelper extends HelperBase {

    private final SessionFactory sessionFactory;

    public DBHelper(ApplicationManager app) {
        super(app);
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }


    public List<Users> users() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Users> result = session.createQuery("from Users").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}

