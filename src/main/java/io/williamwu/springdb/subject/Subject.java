package io.williamwu.springdb.subject;

import io.williamwu.springdb.Enums;
import java.util.Date;

public class Subject {

    private Integer id;
    private String subjectName;
    private Enums.Day classDay;
    private Enums.Period classPeriod;
    private Date createTime;
    private Date modifyTime;
    private Integer teacherId;

    public Subject() {
    }

    public Subject(Integer id, String subjectName, Enums.Day classDay, Enums.Period classPeriod) {
        this.id = id;
        this.subjectName = subjectName;
        this.classDay = classDay;
        this.classPeriod = classPeriod;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Enums.Day getClassDay() {
        return classDay;
    }

    public void setClassDay(Enums.Day classDay) {
        this.classDay = classDay;
    }

    public Enums.Period getClassPeriod() {
        return classPeriod;
    }

    public void setClassPeriod(Enums.Period classPeriod) {
        this.classPeriod = classPeriod;
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