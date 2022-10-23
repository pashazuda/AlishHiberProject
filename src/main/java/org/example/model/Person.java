package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.security.Permissions;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;

@Data
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToOne(mappedBy = "person")
    @Cascade(SAVE_UPDATE)
    private Passport passport;


    @OneToMany(mappedBy = "owner")
    @Cascade(SAVE_UPDATE)
    private List<Item> items;

    public Person(Passport passport) {
        this.passport = passport;
        passport.setPerson(this);
    }

    public void addItem(Item item) {
        if (this.items == null) {
            this.items = new ArrayList<Item>();
        }
        this.items.add(item);
        item.setOwner(this);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
