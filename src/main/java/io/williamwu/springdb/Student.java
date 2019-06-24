package io.williamwu.springdb;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Iterator;
import java.util.LinkedList;

public class Student {
    final private String id;
    private String name;
    private int age;
    private LinkedList<String> classes;
    private Enums.Gender gender;

    public Student(String name, int age, Enums.Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        classes = new LinkedList<>();
        id = toSHA256(name);
    }

    private String toSHA256(String raw) {
        // takes last 6 digits of student name's SHA256 value
        String fullSHA256 = DigestUtils.sha256Hex(raw);
        return fullSHA256.substring(fullSHA256.length() - 6);
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
