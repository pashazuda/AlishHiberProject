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
//        Person person = session.get(Person.class, 3);
//        List<Item> items = person.getItems();
//        System.out.println(items.size());

//        Person person = session.get(Person.class, 2);
//        Item item = new Item("UnitMask", person);
//        session.save(item);
//        person.getItems().add(item);

//        Person nowar = new Person("Nowar", 12);
//        Item mask228 = new Item("UnitMask228", nowar);
//        nowar.setItems(new ArrayList<>(Collections.singletonList(mask228)));
//        session.save(nowar);
//        session.save(mask228);

//        Person person = session.get(Person.class, 3);
//        List<Item> items = person.getItems();
//        for (Item item : items) {
//            session.remove(item);
//        }
//        person.getItems().clear();

//        Person person = session.get(Person.class, 2);
//        session.remove(person);
//        person.getItems().forEach(item -> item.setOwner(null));

        Person person = session.get(Person.class, 4);
        Item item = session.get(Item.class, 1);
        item.getOwner().getItems().remove(item);
        item.setOwner(person);
        person.getItems().add(item);
        session.getTransaction().commit();
    }

}
