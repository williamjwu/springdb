package io.williamwu.springdb;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Class {
    final private String id;
    final private String className;
    // there is only one class
    private List<String> students;
    // days and periods are 1 to 1 on same digits
    // ex: classDays[0] = WEDNESDAY, classPeriods[0] = SECOND
    // this means there is a class on Wednesday second period
    // a class can have multiple meeting periods
    private Enums.Days[] classDays;
    private Enums.Periods[] classPeriods;

    public Class(String className, Enums.Days[] classDays, Enums.Periods[] classPeriods) {
        this.className = className;
        this.classDays = classDays;
        this.classPeriods = classPeriods;
        students = new LinkedList<>();
        id = Functions.toSHA256(className);
    }

    // accessors and modifiers
    public String getId() {
        return id;
    }
    public String getName() {
        return className;
    }
    public Iterator<String> getStudents() {
        return students.iterator();
    }
    public void addStudent(String currStudent) {
        students.add(currStudent);
    }
    public boolean rmStudent(String currStudent) {
        return students.remove(currStudent);
    }
}