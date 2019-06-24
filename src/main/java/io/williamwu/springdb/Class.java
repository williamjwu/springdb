package io.williamwu.springdb;

import java.util.List;

public class Class {
    final private String id;
    private String name;
    private List<String> students;
    private List<Enums.Days> classDays;
    private List<Enums.Periods> classPeriods;

    public Class(String name) {
        this.name = name;
        id = Functions.toSHA256(name);
    }
}