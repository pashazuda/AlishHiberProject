package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

//        Person personSave1 = new Person("PersonSave1", 32);
//        Person personSave2 = new Person("PersonSave2", 345);
//        Person personSave3 = new Person("PersonSave3", 228);
//
//        session.save(personSave1);
//        session.save(personSave2);
//        session.save(personSave3);

//        Person personGet = session.get(Person.class, 1);
//        personGet.setName("Personally228");
//        session.delete(personGet);
//        System.out.println(personGet.toString());

//        List<Person> resultList = session.createQuery("FROM Person").getResultList();
//        for (Person person : resultList
//             ) {
//            System.out.println(person.toString());
//        }

        session.createQuery("update Person set name = 'Haha' where age > 100").executeUpdate();
        session.getTransaction().commit();
//        personSave3.getId();
    }

}
