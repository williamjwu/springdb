package io.williamwu.springdb;

import io.williamwu.springdb.Enums;

import java.util.Date;

public class Teacher {

    private Integer id;
    private String teacherName;
    private Integer age;
    private Enums.Gender gender;
    private Date createTime;
    private Date modifyTime;

    public Teacher() {
    }

    public Teacher(Integer id, String teacherName, Integer age, Enums.Gender gender) {
        this.id = id;
        this.teacherName = teacherName;
        this.age = age;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
