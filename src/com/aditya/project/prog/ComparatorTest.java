package com.aditya.project.prog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {

    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.age < o2.age) {
            return 1;
        } else if (o1.age > o2.age) {
            return -1;
        }
        return o1.name.compareTo(o2.name);
    }
}

// TC : O(N)
// SC : O(N)
public class ComparatorTest {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Aditya", 24));
        persons.add(new Person("Adi", 24));
        persons.add(new Person("Aditya", 25));
        persons.add(new Person("Adi", 25));
        Collections.sort(persons, new PersonComparator());
        persons.forEach(person -> System.out.println(person.name + " " + person.age));
    }
}
