package io.williamwu.springdb;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Student {
    final private String id;
    private String studentName;
    private int age;
    private List<String> classes;
    private Enums.Gender gender;

    public Student(String studentName, int age, Enums.Gender gender) {
        this.studentName = studentName;
        this.age = age;
        this.gender = gender;
        classes = new LinkedList<>();
        id = Functions.toSHA256(studentName);
    }

    // accessors and modifiers
    public String getId() {
        return id;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
    public Iterator<String> getClasses() {
        return classes.iterator();
    }
    public void addClass(String currClass) {
        classes.add(currClass);
    }
    // returns true if the class presents, used for detecting a valid class is removed
    public boolean rmClass(String currClass) {
        return classes.remove(currClass);
    }

    public Enums.Gender getGender() {
        return gender;
    }
    public void setGender(Enums.Gender gender) {
        this.gender = gender;
    }
}
