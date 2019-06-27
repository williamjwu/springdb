package io.williamwu.springdb.subject;

import io.williamwu.springdb.Enums;

public class Subject {

    private Integer id;
    private String subjectName;
    // days and periods are 1 to 1 on same digits
    // ex: classDays[0] = WEDNESDAY, classPeriods[0] = SECOND
    // this means there is a class on Wednesday second period
    // a class can have multiple meeting periods
    private Enums.Day[] classDays;
    private Enums.Period[] classPeriods;

    public Subject(Integer id, String subjectName, Enums.Day[] classDays, Enums.Period[] classPeriods) {
        this.id = id;
        this.subjectName = subjectName;
        this.classDays = classDays;
        this.classPeriods = classPeriods;
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

    public Enums.Day[] getClassDays() {
        return classDays;
    }

    public void setClassDays(Enums.Day[] classDays) {
        this.classDays = classDays;
    }

    public Enums.Period[] getClassPeriods() {
        return classPeriods;
    }

    public void setClassPeriods(Enums.Period[] classPeriods) {
        this.classPeriods = classPeriods;
    }
}