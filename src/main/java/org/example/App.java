package org.example;

import org.example.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class)
                .addAnnotatedClass(Passport.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

//        Movie movie = new Movie("Smeshariki", 1994);
//        Actor krosh = new Actor("Krosh", 12);
//        Actor pin = new Actor("Pin", 34);
//        movie.setActors(new ArrayList<>(List.of(krosh, pin)));
//        krosh.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//        pin.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//        session.save(movie);
//        session.save(krosh);
//        session.save(pin);

//        Movie movie = session.get(Movie.class, 1);
//        System.out.println(movie.getActors());

//        Movie madDogs = new Movie("MadDogs", 2001);
//        Actor actor = session.get(Actor.class, 1);
//        actor.getMovies().add(madDogs);
//        madDogs.setActors(new ArrayList<>(Collections.singletonList(actor)));
//        session.save(madDogs);

        Actor actor = session.get(Actor.class, 2);
        Movie movie = actor.getMovies().get(0);
        actor.getMovies().remove(movie);
        movie.getActors().remove(actor);



        session.getTransaction().commit();
    }

}
