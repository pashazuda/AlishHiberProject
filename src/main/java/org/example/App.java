package org.example;

import org.example.model.Item;
import org.example.model.Passport;
import org.example.model.Person;
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
                .addAnnotatedClass(Passport.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

//        Person person = new Person("PassportPerson", 23);
//        Passport passport = new Passport(1232342);
//        person.setPassport(passport);
//        session.save(person);

//        Person person = session.get(Person.class, 7);
//        System.out.println(person.getPassport().getPassportNumber());

//        Passport passport = session.get(Passport.class, 7);
//        System.out.println(passport.getPerson().getName());

        Person person = session.get(Person.class, 7);
        person.getPassport().setPassportNumber(2281337);


        session.getTransaction().commit();
    }

}
