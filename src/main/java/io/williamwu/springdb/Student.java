package io.williamwu.springdb;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Student {
    final private String id;
    private String name;
    private int age;
    private List<String> classes;
    private Enums.Gender gender;

    public Student(String name, int age, Enums.Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        classes = new LinkedList<>();
        id = Functions.toSHA256(name);
    }

    // accessors and modifiers
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * stores all class id instead of class objects
     * all class objects can be accessed in main method's hashmap
     */
    public Iterator<String> getAllClasses() {
        return classes.iterator();
    }
    public void addClasses(String currClass) {
        classes.add(currClass);
    }
    // returns true if the class presents, used for detecting a valid class is removed
    public boolean rmClasses(String currClass) {
        return classes.remove(currClass);
    }

    public Enums.Gender getGender() {
        return gender;
    }
    public void setGender(Enums.Gender gender) {
        this.gender = gender;
    }
}
