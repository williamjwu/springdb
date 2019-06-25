package io.williamwu.springdb;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Student {
    private Long id;
    private String studentName;
    private Integer age;
    private List<String> subjects;
    private Enums.Gender gender;

    public Student(Long id, String studentName, Integer age, Enums.Gender gender) {
        this.id = id;
        this.studentName = studentName;
        this.age = age;
        subjects = new LinkedList<>();
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Iterator<String> getSubject() {
        return subjects.iterator();
    }

    public void addSubject(String subject) {
        subjects.add(subject);
    }

    public void rmSubject(String subject) {
        subjects.remove(subject);
    }

    public Enums.Gender getGender() {
        return gender;
    }

    public void setGender(Enums.Gender gender) {
        this.gender = gender;
    }
}
