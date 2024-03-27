package ru.sberbank.jd.lesson07;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;


class PersonTest {
    Person personLucy = new Person("Lucy", "Volgograd", 33);
    Person personLucy2 = new Person("lucy", "volgograd", 33);
    Person personAnton = new Person("Anton", "Moscow", 20);
    Person personAlex = new Person("Alex", "Moscow", 24);
    Person personOxana = new Person("Oxana", "Volgograd", 35);

    @Test
    void testEquals() {
        Assertions.assertTrue(personLucy.equals(personLucy2));
        Assertions.assertFalse(personLucy.equals(personAnton));
    }
    @Test
    void testHashCode() {
        Assertions.assertTrue(personLucy.hashCode() == personLucy2.hashCode());
    }
    @Test
    void testToString() {
        Assertions.assertEquals("Person{name='Lucy', city='Volgograd', age=33}" + " \n", personLucy.toString());
    }
    @Test
    void compareTo() {
        ArrayList<Person> people = new ArrayList<>();
        people.add(personLucy) ;
        people.add(personAnton);
        people.add(personOxana) ;
        people.add(personLucy2);
        people.add(personAlex);
        String befSort = people.toString();
        Collections.sort(people);
        String aftSort = people.toString();
        Assertions.assertNotEquals(befSort,aftSort);
    }
}