package io.williamwu.springdb;

public class Teacher {

    private Integer id;
    private String studentName;
    private Integer age;
    private Enums.Gender gender;

    public Teacher() {
    }

    public Teacher(Integer id, String studentName, Integer age, Enums.Gender gender) {
        this.id = id;
        this.studentName = studentName;
        this.age = age;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Enums.Gender getGender() {
        return gender;
    }

    public void setGender(Enums.Gender gender) {
        this.gender = gender;
    }
}
