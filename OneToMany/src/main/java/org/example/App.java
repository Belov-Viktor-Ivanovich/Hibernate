package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Film.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            /*Director director = session.get(Director.class,1);
            List<Film>films = director.getFilms();
            films.forEach(e-> System.out.println(e.getName()));*/
            /*Film film = session.get(Film.class,1);
            Director director1 = film.getDirector();
            System.out.println(director1);
            Film film1 = new Film("tartara",director1);
            session.save(film1);
            director1.getFilms().add(film1);
            Film*/


            session.getTransaction().commit();


        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            sessionFactory.close();
        }
    }
}
