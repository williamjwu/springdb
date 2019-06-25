package io.williamwu.springdb;

public class Subject {

    private String id;
    private String subjectName;
    // days and periods are 1 to 1 on same digits
    // ex: classDays[0] = WEDNESDAY, classPeriods[0] = SECOND
    // this means there is a class on Wednesday second period
    // a class can have multiple meeting periods
    private Enums.Days[] classDays;
    private Enums.Periods[] classPeriods;

    public Subject(String id, String subjectName, Enums.Days[] classDays, Enums.Periods[] classPeriods) {
        this.id = id;
        this.subjectName = subjectName;
        this.classDays = classDays;
        this.classPeriods = classPeriods;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Enums.Days[] getClassDays() {
        return classDays;
    }

    public void setClassDays(Enums.Days[] classDays) {
        this.classDays = classDays;
    }

    public Enums.Periods[] getClassPeriods() {
        return classPeriods;
    }

    public void setClassPeriods(Enums.Periods[] classPeriods) {
        this.classPeriods = classPeriods;
    }
}