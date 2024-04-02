package org.example;

import org.example.models.Actor;
import org.example.models.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            /*Movie movie = new Movie("One Home");
            Actor actor = new Actor("Hyrry");
            Actor actor2 = new Actor("Reppu");
            movie.setActors(new ArrayList<>(List.of(actor,actor2)));
            actor.setMovies(new ArrayList<>(Collections.singletonList(movie)));
            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
            session.save(movie);
            session.save(actor);
            session.save(actor2);*/
            /*System.out.println(session.get(Movie.class,1).getActors());
            System.out.println(session.get(Actor.class,1).getMovies());
            System.out.println(session.get(Actor.class,2).getMovies());*/

            /*Movie movie = new Movie("Dog");
            movie.setActors(new ArrayList<>(Arrays.asList(session.get(Actor.class,1))));
            session.get(Actor.class,1).getMovies().add(movie);
            session.save(movie);*/
            Actor actor = session.get(Actor.class,1);
            Movie movie = actor.getMovies().get(0);
            actor.getMovies().remove(0);
            movie.getActors().remove(actor);




            session.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println("Error");
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }
        finally {
            sessionFactory.close();
        }
    }
}
