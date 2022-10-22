package org.example;

import org.example.model.Item;
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
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Person person = new Person("Oleginaasv", 44);
        person.addItem(new Item("OlegItem1", person));
        person.addItem(new Item("OlegItem2", person));
        person.addItem(new Item("OlegItem3", person));

//        person.setItems(new ArrayList<>(Collections.singletonList(item)));
        session.save(person);


        session.getTransaction().commit();
    }

}
