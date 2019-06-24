package io.williamwu.springdb;

import java.util.LinkedList;

public class Student {
    private String id;
    private String name;
    private int age;
    private LinkedList classes;
    Enums.Days date;
    Enums.Gender gender;

    public Student(String name, int age, Enums.Days date, Enums.Gender gender) {
        this.name = name;
        this.age = age;
        this.date = date;
        this.gender = gender;
    }

}
