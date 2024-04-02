package org.example;

import org.example.models.Dir;
import org.example.models.Scool;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Dir.class)
                .addAnnotatedClass(Scool.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            /*Dir dir = new Dir("Poper");
            dir.setScool(new Scool("765"));
            session.save(dir)*/;
            /*System.out.println(session.get(Dir.class,1).getScool().getName());*/
            Dir dirNew = session.get(Dir.class,3);
            dirNew.setScool(new Scool("4598095"));





            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error");
            session.getTransaction().rollback();

        }
        finally {
            sessionFactory.close();
        }


    }
}
